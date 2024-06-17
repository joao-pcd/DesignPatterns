package com.joaopcd.design_patterns.controller;

import com.joaopcd.design_patterns.model.Cliente;
import com.joaopcd.design_patterns.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodosClientes() {
        return ResponseEntity.ok(clienteService.buscarTodosClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@RequestBody Long id) {
        return ResponseEntity.ok(clienteService.buscarCliente(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente){
        clienteService.inserirCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.ok().build();
    }
}
