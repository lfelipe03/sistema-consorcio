package com.luizfelipe.sistema_consorcio.repository;

import com.luizfelipe.sistema_consorcio.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
