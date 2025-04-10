package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.VendedorDTO;
import com.luizfelipe.sistema_consorcio.model.Representante;
import com.luizfelipe.sistema_consorcio.model.Vendedor;
import com.luizfelipe.sistema_consorcio.repository.RepresentanteRepository;
import com.luizfelipe.sistema_consorcio.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private RepresentanteRepository representanteRepository;

    public void cadastrarVendedor(VendedorDTO dto) {
        Vendedor vendedor = new Vendedor();

        Representante representante = representanteRepository.findById(dto.representanteId())
                .orElseThrow(() -> new RuntimeException("Administradora nao encontrada"));

        vendedor.setNome(dto.nome());
        vendedor.setCpf(dto.cpf());
        vendedor.setRg(dto.rg());
        vendedor.setTelefone(dto.telefone());
        vendedor.setEmail(dto.email());

        vendedor.setRepresentante(representante);

        vendedorRepository.save(vendedor);

    }

    public List<VendedorDTO> listarVendedores() {
        List<Vendedor> vendedores = vendedorRepository.findAll();

        return vendedores.stream()
                .map(v -> new VendedorDTO(
                        v.getNome(),
                        v.getCpf(),
                        v.getRg(),
                        v.getEmail(),
                        v.getTelefone(),
                        v.getRepresentante().getId()
                ))
                .collect(Collectors.toList());
    }
}
