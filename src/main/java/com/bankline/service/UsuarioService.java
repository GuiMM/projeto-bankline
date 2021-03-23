package com.bankline.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankline.dto.LoginDto;
import com.bankline.dto.Sessao;
import com.bankline.exception.CampoDuplicadoException;
import com.bankline.exception.CampoInvalidoException;
import com.bankline.model.Conta;
import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;
import com.bankline.model.enums.TipoMovimentoEnum;
import com.bankline.repository.PlanoContaRepository;
import com.bankline.repository.UsuarioRepository;
import com.bankline.security.jwt.JWTConstants;
import com.bankline.utils.CpfUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Autowired
	private PlanoContaRepository planoContaRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private CpfUtils cpfUtils;

	@Bean
	public CpfUtils cpUtils() {
		return new CpfUtils();
	}
	
	@Bean
	PasswordEncoder getEncode() {
	    return new BCryptPasswordEncoder();
	}
	
	public Sessao Login(LoginDto login) throws Exception {
		
		if (login == null || login.getUsuario().isEmpty() || login.getSenha().isEmpty()) {
			throw new RuntimeException("Login e senha são requeridos");
		}

		Optional<Usuario> optuser = usuarioRepository.findByLogin(login.getUsuario());

		Usuario usuario = optuser.get();

		boolean senhaOk = encoder.matches(login.getSenha(),usuario.getSenha());

		if (!senhaOk) {
			throw new CampoInvalidoException("Senha Inválida para o Login " + login.getUsuario());
		}

		// tempo do token = 1 horas
		long tempoToken = 1 * 60 * 60 * 1000;
		Sessao sessao = new Sessao();
		sessao.setDataInicio(new Date(System.currentTimeMillis()));
		sessao.setDataFim(new Date(System.currentTimeMillis() + tempoToken));
		
		sessao.setLogin(usuario.getLogin());

		sessao.setToken(JWTConstants.PREFIX + getJWTToken(sessao));

		return sessao;
	}
	
	//como vc gerenciaria a nivel de banco o role de um usuario
	private String getJWTToken(Sessao sessao) {
		String role = "ROLE_ADMIN";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);

		String token = Jwts.builder().setSubject(sessao.getLogin())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(sessao.getDataInicio()).setExpiration(sessao.getDataFim())
				.signWith(SignatureAlgorithm.HS512, JWTConstants.KEY.getBytes()).compact();

		return token;
	}
	
	@Transactional
	public void CriaUsuario(Usuario usuario) throws Exception {
		
		usuario.setCpf(cpfUtils.formatarCpf(usuario.getCpf()));
		String SenhaEncoded = encoder.encode(usuario.getSenha());
		usuario.setSenha(SenhaEncoded);
		validateUser(usuario);
		
		usuario.addContas(new Conta(usuario.getLogin()));
		salvaPlanoContasDefault(usuario);
		usuarioRepository.save(usuario);
	}

	@Transactional
	private void salvaPlanoContasDefault(Usuario usuario) {
		PlanoConta planoContaR = new PlanoConta();
		PlanoConta planoContaD = new PlanoConta();
		PlanoConta planoContaTU = new PlanoConta();

		planoContaD.setPadrao(true);
		planoContaD.setUsuario(usuario);
		planoContaD.setNome("Despesas");
		planoContaD.setTipoMovimento(TipoMovimentoEnum.D);

		planoContaR.setPadrao(true);
		planoContaR.setUsuario(usuario);
		planoContaR.setNome("Receitas");
		planoContaR.setTipoMovimento(TipoMovimentoEnum.R);

		planoContaTU.setPadrao(true);
		planoContaTU.setUsuario(usuario);
		planoContaTU.setNome("Transferencias entre usuarios");
		planoContaTU.setTipoMovimento(TipoMovimentoEnum.TU);

		planoContaRepository.save(planoContaR);
		planoContaRepository.save(planoContaD);
		planoContaRepository.save(planoContaTU);

	}

	private void validateUser(Usuario usuario) throws Exception{
		validateUserName(usuario);
		validateCpf(usuario); 
	}

	private void validateUserName(Usuario usuario) throws Exception{
		if(usuario.getLogin().length() > 20)
			throw new CampoInvalidoException("login inválido!");
		if(usuarioRepository.existsByLogin(usuario.getLogin()))
			throw new CampoDuplicadoException("login já existe na base de dados!");
				
	}

	private void validateCpf(Usuario usuario) throws Exception{
		if (cpfUtils.validarCPF(usuario.getCpf()))
			throw new CampoInvalidoException("CPF inválido!");
		if (usuarioRepository.existsByCpf(usuario.getCpf()))
			throw new CampoDuplicadoException("CPF já existe na base de dados!");


	}
	
	public void atualizarSenha(Usuario usuarioObj, String login) {
		 Usuario usuario = usuarioRepository.findByLogin(login).get();
			usuario.setSenha(usuarioObj.getSenha());
			usuarioRepository.save(usuario);
	}
}
