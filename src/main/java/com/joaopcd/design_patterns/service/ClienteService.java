package com.joaopcd.design_patterns.service;

import com.joaopcd.design_patterns.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodosClientes();

    Cliente buscarCliente(Long id);

    void inserirCliente(Cliente cliente);

    void atualizarCliente(Long id, Cliente cliente);

    void deletarCliente(Long id);
}
