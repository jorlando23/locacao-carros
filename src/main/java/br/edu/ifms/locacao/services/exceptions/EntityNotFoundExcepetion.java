package br.edu.ifms.locacao.services.exceptions;

public class EntityNotFoundExcepetion extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundExcepetion(String message) {
		super(message);
	}
}
