package br.com.tabuloja.adapters.web.controller;

import br.com.tabuloja.adapters.web.dto.CriarPedidoAluguelRequest;
import br.com.tabuloja.adapters.web.mapper.PedidoWebRequestMapper;
import br.com.tabuloja.application.service.CriarPedidoAluguelService;
import br.com.tabuloja.domain.PedidoAluguel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alugueis")
public class PedidoAluguelController {

    private final CriarPedidoAluguelService criarPedidoAluguelService;
    private final PedidoWebRequestMapper mapper;

    public PedidoAluguelController(CriarPedidoAluguelService criarPedidoAluguelService, PedidoWebRequestMapper mapper) {
        this.criarPedidoAluguelService = criarPedidoAluguelService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PedidoAluguel> criarAluguel(@RequestBody @Valid CriarPedidoAluguelRequest request) {

        var command = mapper.paraCommand(request);

        PedidoAluguel pedidoSalvo = criarPedidoAluguelService.executar(command);

        return ResponseEntity.ok(pedidoSalvo);
    }
}
