package br.com.tabuloja.adapters.web.controller;

import br.com.tabuloja.adapters.web.dto.CriarPedidoAluguelRequest;
import br.com.tabuloja.adapters.web.mapper.PedidoWebRequestMapper;
import br.com.tabuloja.application.service.BuscarPedidoAluguelService;
import br.com.tabuloja.application.service.CriarPedidoAluguelService;
import br.com.tabuloja.domain.PedidoAluguel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/alugueis")
public class PedidoAluguelController {

    private final CriarPedidoAluguelService criarPedidoAluguelService;
    private final BuscarPedidoAluguelService buscarPedidoAluguelService;
    private final PedidoWebRequestMapper mapper;

    public PedidoAluguelController(CriarPedidoAluguelService criarPedidoAluguelService, BuscarPedidoAluguelService buscarPedidoAluguelService, PedidoWebRequestMapper mapper) {
        this.criarPedidoAluguelService = criarPedidoAluguelService;
        this.buscarPedidoAluguelService = buscarPedidoAluguelService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PedidoAluguel> criarAluguel(@RequestBody @Valid CriarPedidoAluguelRequest request) {

        var command = mapper.paraCommand(request);

        PedidoAluguel pedidoSalvo = criarPedidoAluguelService.executar(command);

        return ResponseEntity.ok(pedidoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoAluguel> buscarPedidoAlguelPorId(@PathVariable("id")UUID uuid) {
        PedidoAluguel pedidoAluguel = buscarPedidoAluguelService.buscarPedidoAluguelPorId(uuid);
        return ResponseEntity.ok(pedidoAluguel);
    }
}
