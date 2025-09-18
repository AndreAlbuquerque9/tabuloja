package br.com.tabuloja.application.exception;

public class ClienteNaoEcontradoException extends RuntimeException {
    public ClienteNaoEcontradoException(String message) {

        super(message);
    }
}
