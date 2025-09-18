package br.com.tabuloja.application.exception;

public class JogoNaoEncontradoException extends RuntimeException {
    public JogoNaoEncontradoException(String message) {
        super(message);
    }
}
