package com.vivaimoveis.imobiliaria.core.service;

import com.vivaimoveis.imobiliaria.core.entity.Formulario;
import com.vivaimoveis.imobiliaria.core.entity.Formulario.Situacao;
import com.vivaimoveis.imobiliaria.core.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    // Metodo para ativar ou desativar o formulário
    public void atualizarSituacao(Long id, Situacao situacao) {
        Optional<Formulario> formularioOpt = formularioRepository.findById(id);
        if (formularioOpt.isPresent()) {
            Formulario formulario = formularioOpt.get();
            formulario.setSituacao(situacao);
            formularioRepository.save(formulario);
        }
    }

    // Metodo para buscar formulários com base em filtros
    public List<Formulario> filtrarFormularios(String nome, String email, Long id) {
        return formularioRepository.findByNomeContainingAndEmailContainingAndAssuntoContaining(nome, email, id);
    }

    // Metodo para obter todos os formulários
    public List<Formulario> listarTodos() {
        return formularioRepository.findAll();
    }
}
