package com.luizfelipe.sistema_consorcio.service;


import com.luizfelipe.sistema_consorcio.model.Vendedor;
import com.luizfelipe.sistema_consorcio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CotaRepository cotaRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private GrupoRepository grupoRepository;


}
