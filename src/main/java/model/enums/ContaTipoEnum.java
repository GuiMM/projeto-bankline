package model.enums;

public enum ContaTipoEnum {
	BANCO(1),
	CREDITO(2),
	;
	
	public int valorContaTipo;
	
	ContaTipoEnum(int valor) {
		valorContaTipo = valor;
	}
	
}
