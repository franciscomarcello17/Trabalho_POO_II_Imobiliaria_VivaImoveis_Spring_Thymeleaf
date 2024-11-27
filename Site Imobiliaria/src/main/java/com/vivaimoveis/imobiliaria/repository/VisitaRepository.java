package com.vivaimoveis.imobiliaria.repository;

import com.vivaimoveis.imobiliaria.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
    // Métodos personalizados podem ser adicionados aqui se necessário
}
