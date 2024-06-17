package com.joaopcd.design_patterns.service.impl;

import com.joaopcd.design_patterns.model.Cliente;
import com.joaopcd.design_patterns.model.ClienteRepository;
import com.joaopcd.design_patterns.model.Endereco;
import com.joaopcd.design_patterns.model.EnderecoRepository;
import com.joaopcd.design_patterns.service.ClienteService;
import com.joaopcd.design_patterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        confirmaCepEAdicionaCliente(cliente);
    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        try {
            if (clienteBd.isPresent()){
                confirmaCepEAdicionaCliente(cliente);
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Cliente não cadastrado na base de dados");
        }
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    private void confirmaCepEAdicionaCliente(Cliente cliente) {
        Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getCep()).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
