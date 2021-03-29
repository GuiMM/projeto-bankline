/*
 * package com.example.tdd;
 * 
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.ResultActions; import
 * org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
 * 
 * import com.bankline.DemoApplication; import com.bankline.model.Usuario;
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @SpringBootTest(classes = DemoApplication.class)
 * 
 * @WebMvcTest public class UsuarioControllerTest {
 * 
 * @Autowired MockMvc mockMvc;
 * 
 * @Autowired private ObjectMapper objectMapper;
 * 
 * @Test public void salvarUsuario() throws Exception { Usuario user = new
 * Usuario(); user.setLogin("Monica"); user.setSenha("senha");
 * user.setCpf("11111111"); user.setNome("Monica");
 * 
 * ((ResultActions) ((MockHttpServletRequestBuilder)
 * mockMvc.perform(post("/usuario")))
 * .contentType("application/json").content(objectMapper.writeValueAsString(user
 * ))) .andExpect(status().isOk()); }
 * 
 * }
 */