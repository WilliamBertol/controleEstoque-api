package com.controleestoque.exception;

public enum EnumExceptions implements IException {
	
	CAMPOINVALIDONFE("Campo inv\u00E1lido na NFe: {0}. \n Motivo: {1}."),
	;
	
	private String mensage;

	private EnumExceptions(String mensage){
		this.mensage = mensage;
	}

	@Override
	public String getMessage() {
		return mensage;
	}
}
