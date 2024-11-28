package com.vivaimoveis.imobiliaria.repository;

import com.vivaimoveis.imobiliaria.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    // Métodos personalizados podem ser adicionados aqui se necessário

    List<Imovel> findByTipo(String tipo);
}
