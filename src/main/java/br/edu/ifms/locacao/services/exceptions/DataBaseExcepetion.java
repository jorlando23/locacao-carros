package br.edu.ifms.locacao.services.exceptions;

public class DataBaseExcepetion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataBaseExcepetion(String message) {
        super(message);
    }
}