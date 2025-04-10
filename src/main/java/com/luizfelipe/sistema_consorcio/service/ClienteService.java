package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.ClienteDTO;
import com.luizfelipe.sistema_consorcio.model.Cliente;
import com.luizfelipe.sistema_consorcio.model.Vendedor;
import com.luizfelipe.sistema_consorcio.repository.ClienteRepository;
import com.luizfelipe.sistema_consorcio.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public void cadastrarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();

        Vendedor vendedor = vendedorRepository.findById(dto.vendedorId()).
                orElseThrow(() -> new RuntimeException("Vendedor nao encontrado"));


        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setRg(dto.rg());
        cliente.setEmail(dto.email());
        cliente.setEndereco(dto.endereco());
        cliente.setTelefone(dto.telefone());
        cliente.setDataNascimento(dto.dataNascimento());

        cliente.setVendedor(vendedor);

        clienteRepository.save(cliente);
    }


    public List<ClienteDTO> listarCliente() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(c -> new ClienteDTO(
                        c.getNome(),
                        c.getCpf(),
                        c.getRg(),
                        c.getEmail(),
                        c.getEndereco(),
                        c.getTelefone(),
                        c.getDataNascimento(),
                        c.getVendedor().getId()
                )).collect(Collectors.toList());
    }
}
