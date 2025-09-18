package br.com.tabuloja.adapters.web.controller;

import br.com.tabuloja.adapters.web.dto.CadastrarClienteRequest;
import br.com.tabuloja.adapters.web.mapper.CadastrarClienteWebRequestMapper;
import br.com.tabuloja.application.service.ClienteService;
import br.com.tabuloja.domain.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final CadastrarClienteWebRequestMapper mapper;

    public ClienteController(ClienteService clienteService, CadastrarClienteWebRequestMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid CadastrarClienteRequest request) {

        var command = mapper.paraCommand(request);

        Cliente cliente = clienteService.cadastrar(command);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<Cliente> buscarClientePorCpf(@RequestParam("cpf") String cpf) {
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        return ResponseEntity.ok().body(cliente);
    }
}
