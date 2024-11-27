package com.vivaimoveis.imobiliaria.repository;


import com.vivaimoveis.imobiliaria.model.Corretor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorretorRepository extends JpaRepository<Corretor, Long> {
    // Métodos personalizados podem ser adicionados aqui se necessário
}
