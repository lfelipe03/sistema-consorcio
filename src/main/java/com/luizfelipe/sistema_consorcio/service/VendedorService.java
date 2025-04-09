package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.VendedorDTO;
import com.luizfelipe.sistema_consorcio.model.Vendedor;
import com.luizfelipe.sistema_consorcio.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public void cadastrarVendedor (VendedorDTO dto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(dto.nome());
        vendedor.setCpf(dto.cpf());
        vendedor.setRg(dto.rg());
        vendedor.setEmail(dto.email());
        vendedor.setTelefone(dto.telefone());
    }

    public List<VendedorDTO> listarVendedores() {
        List<Vendedor> vendedores = vendedorRepository.findAll();

        return vendedores.stream()
                .map(v -> new VendedorDTO(
                        v.getNome(),
                        v.getCpf(),
                        v.getRg(),
                        v.getEmail(),
                        v.getTelefone()
                ))
                .collect(Collectors.toList());
    }

}
