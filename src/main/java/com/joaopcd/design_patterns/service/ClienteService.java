package com.joaopcd.design_patterns.service;

import com.joaopcd.design_patterns.model.Cliente;

import java.util.UUID;

public interface ClienteService {

    Iterable<Cliente> buscarTodosClientes();

    Cliente buscarCliente(UUID id);

    void inserirCliente(Cliente cliente);

    void atualizarCliente(UUID id, Cliente cliente);

    void deletarCliente(UUID id);
}
