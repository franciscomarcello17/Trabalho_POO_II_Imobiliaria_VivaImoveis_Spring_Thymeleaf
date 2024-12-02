package com.vivaimoveis.imobiliaria.controller;

import com.vivaimoveis.imobiliaria.core.entity.Formulario.Situacao;
import com.vivaimoveis.imobiliaria.core.entity.Formulario;
import com.vivaimoveis.imobiliaria.core.repository.FormularioRepository;
import com.vivaimoveis.imobiliaria.core.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/contato")
public class FormularioController {

    @Autowired
    private FormularioRepository formularioRepository;

    @Autowired
    private FormularioService formularioService;

    // Caminho para salvar os arquivos
    private static final String UPLOAD_DIR = "uploads/";

    // Exibir a tela de gerenciamento de formulários
    @GetMapping("/admin/formularios")
    public String listarFormularios(Model model,
                                    @RequestParam(required = false) Long id,
                                    @RequestParam(name = "nome", required = false) String nome,
                                    @RequestParam(name = "email", required = false) String email) {

        // Verifica se os parâmetros de filtro foram fornecidos
        List<Formulario> formularios;
        if (nome == null && email == null && id == null) {
            // Se não houver filtros, carrega todos os formulários
            formularios = formularioRepository.findAll();
        } else {
            // Caso contrário, filtra os formulários com base nos parâmetros
            formularios = formularioService.filtrarFormularios(nome, email, id);
        }

        model.addAttribute("formularios", formularios);
        model.addAttribute("nome", nome);
        model.addAttribute("email", email);
        return "admin/gerenciar_formularios"; // Página Thymeleaf para gerenciar formulários
    }

    // Alterar o estado de um formulário (ATIVO/INATIVO)
    @PostMapping("/admin/formulario/{id}/atualizar-situacao")
    public String atualizarSituacao(@PathVariable (name = "id", required = false) Long id, @RequestParam Situacao situacao,
                                    @RequestParam(name = "nome", required = false) String nome,
                                    @RequestParam(name = "email", required = false) String email) {

        // Atualizando o estado do formulário
        formularioService.atualizarSituacao(id, situacao);

        // Redireciona com os parâmetros de filtro para manter a filtragem
        return "redirect:/contato/admin/formularios?nome=" + nome + "&email=" + email + "&id=" + id;
    }

    // Enviar um novo formulário
    @PostMapping("/enviar")
    public String enviarFormulario(@ModelAttribute Formulario formulario,
                                   @RequestParam("attachment") MultipartFile attachment) {
        try {
            // Processar o arquivo de anexo, se houver
            if (!attachment.isEmpty()) {
                // Gerar um nome único para o arquivo
                String fileName = System.currentTimeMillis() + "_" + attachment.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + fileName);
                Files.createDirectories(path.getParent());  // Garante que o diretório exista
                Files.write(path, attachment.getBytes());  // Salva o arquivo no diretório

                // Define o nome do arquivo no formulário
                formulario.setAnexo(fileName);
            }

            // Salva o formulário no banco de dados
            formularioRepository.save(formulario);
            return "contato/sucesso"; // Página de sucesso
        } catch (IOException e) {
            e.printStackTrace();
            return "contato/erro"; // Página de erro
        }
    }
}
