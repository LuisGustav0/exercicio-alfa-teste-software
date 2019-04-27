package br.com.gilmar;

public class ValoresInvalidosException extends Exception{
	private static final long serialVersionUID = 1L;

	public ValoresInvalidosException(){
		super("Valores Inválidos.");
	}
}
