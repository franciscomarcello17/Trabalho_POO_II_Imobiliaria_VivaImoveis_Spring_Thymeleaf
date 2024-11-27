package com.vivaimoveis.imobiliaria.repository;

import com.vivaimoveis.imobiliaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados podem ser adicionados aqui se necessário
}
