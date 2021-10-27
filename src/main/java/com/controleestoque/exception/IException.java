package com.controleestoque.exception;

@FunctionalInterface
public interface IException {

	public interface IDCException {
		String getMessage(); // mensagem padrão, em caso de não ter o .properties ainda
	}

	String getMessage();
}
