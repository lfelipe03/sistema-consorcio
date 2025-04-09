package com.luizfelipe.sistema_consorcio.repository;

import com.luizfelipe.sistema_consorcio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
