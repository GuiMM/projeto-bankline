package com.bankline.exception;

public class SaldoInsuficienteException extends Exception{

	public SaldoInsuficienteException() {
		super("Saldo de lançamento insuficiente!");
	} 
}
