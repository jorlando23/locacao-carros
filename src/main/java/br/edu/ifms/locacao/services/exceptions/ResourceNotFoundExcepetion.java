package br.edu.ifms.locacao.services.exceptions;

public class ResourceNotFoundExcepetion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundExcepetion(String message) {
        super(message);
    }
}