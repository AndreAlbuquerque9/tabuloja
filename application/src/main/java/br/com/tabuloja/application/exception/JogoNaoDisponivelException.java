package br.com.tabuloja.application.exception;

public class JogoNaoDisponivelException extends RuntimeException {
    public JogoNaoDisponivelException(String message) {
        super(message);
    }
}
