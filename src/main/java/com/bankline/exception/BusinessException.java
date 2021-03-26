package com.bankline.exception;

public class BusinessException extends RuntimeException{
	public final static Integer ERROR_ID = 500;
	private Integer httpStatus;
	private String mensagem;
	
	public BusinessException(Integer httpStatus, String msg, Object ... params) {
		super(String.format(msg,params));
		this.httpStatus = httpStatus;
		this.mensagem = String.format(msg,params);
	}
	
	public BusinessException(String mensagem) {
		this(ERROR_ID,mensagem);
	}
	
	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMensagem() {
		return mensagem;
	}
}
