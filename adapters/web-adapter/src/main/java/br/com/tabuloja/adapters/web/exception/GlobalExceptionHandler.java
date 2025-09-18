package br.com.tabuloja.adapters.web.exception;

import br.com.tabuloja.application.exception.ClienteNaoEcontradoException;
import br.com.tabuloja.application.exception.JogoNaoDisponivelException;
import br.com.tabuloja.application.exception.JogoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNaoEcontradoException.class)
    public ResponseEntity<String>  handleClienteNaoEcontradoException(ClienteNaoEcontradoException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(JogoNaoEncontradoException.class)
    public ResponseEntity<String> handleJogoNaoEncontradoException(JogoNaoEncontradoException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(JogoNaoDisponivelException.class)
    public ResponseEntity<String> handleJogoNaoDisponivelException(JogoNaoDisponivelException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
