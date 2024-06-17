package com.joaopcd.design_patterns.service.impl;

import com.joaopcd.design_patterns.model.Cliente;
import com.joaopcd.design_patterns.service.ClienteService;

import java.util.UUID;

public class ClienteServiceImpl implements ClienteService {

    @Override
    public Iterable<Cliente> buscarTodosClientes() {
        return null;
    }

    @Override
    public Cliente buscarCliente(UUID id) {
        return null;
    }

    @Override
    public void inserirCliente(Cliente cliente) {

    }

    @Override
    public void atualizarCliente(UUID id, Cliente cliente) {

    }

    @Override
    public void deletarCliente(UUID id) {

    }
}
