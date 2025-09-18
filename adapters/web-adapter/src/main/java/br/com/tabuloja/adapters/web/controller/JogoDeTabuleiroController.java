package br.com.tabuloja.adapters.web.controller;

import br.com.tabuloja.adapters.web.dto.CadastrarJogoDeTabuleiroRequest;
import br.com.tabuloja.adapters.web.mapper.CadastrarJogoDeTabuleiroMapper;
import br.com.tabuloja.application.service.JogoDeTabuleiroService;
import br.com.tabuloja.domain.JogoDeTabuleiro;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoDeTabuleiroController {
    private final JogoDeTabuleiroService jogoDeTabuleiroService;
    private final CadastrarJogoDeTabuleiroMapper mapper;

    public JogoDeTabuleiroController(JogoDeTabuleiroService jogoDeTabuleiroService, CadastrarJogoDeTabuleiroMapper mapper) {
        this.jogoDeTabuleiroService = jogoDeTabuleiroService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<JogoDeTabuleiro> cadastrarJogoDeTabuleiro(@RequestBody @Valid CadastrarJogoDeTabuleiroRequest cadastrarJogoDeTabuleiroRequest) {
        var command = mapper.paraCommand( cadastrarJogoDeTabuleiroRequest);

        JogoDeTabuleiro novoJogo = jogoDeTabuleiroService.cadastrar(command);

        return ResponseEntity.ok(novoJogo);
    }

    @GetMapping
    public ResponseEntity<List<JogoDeTabuleiro>> buscarJogosPorTitulo(@RequestParam("titulo") String titulo){
        List<JogoDeTabuleiro> jogoDeTabuleiros = jogoDeTabuleiroService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(jogoDeTabuleiros);
    }
}
