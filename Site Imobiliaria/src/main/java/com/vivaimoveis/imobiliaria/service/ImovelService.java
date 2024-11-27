package com.vivaimoveis.imobiliaria.service;

import com.vivaimoveis.imobiliaria.model.Imovel;
import com.vivaimoveis.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel findById(Long id) {
        return imovelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado com ID: " + id));
    }
}
