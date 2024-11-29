package com.vivaimoveis.imobiliaria.controller;

import com.vivaimoveis.imobiliaria.core.entity.Cliente;
import com.vivaimoveis.imobiliaria.core.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Lista todos os clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes/lista";  // Retorna o template lista.html
    }

    // Exibe o formulário para criar um novo cliente
    @GetMapping("/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente()); // Cria um objeto vazio para o formulário
        return "clientes/form";  // Retorna o template form.html
    }

    // Processa o envio do formulário para salvar um novo cliente
    @PostMapping
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);  // Salva o cliente no banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }

    // Exibe o formulário para editar um cliente existente
    @GetMapping("/{id}/editar")
    public String editarClienteForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        model.addAttribute("cliente", cliente);  // Carrega o cliente no modelo para o formulário
        return "clientes/form";  // Retorna o template form.html para edição
    }

    // Processa o envio do formulário de edição
    @PostMapping("/{id}/editar")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);  // Garante que o ID do cliente será mantido
        clienteRepository.save(cliente);  // Atualiza o cliente no banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }

    // Exclui um cliente
    @GetMapping("/{id}/excluir")
    public String excluirCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);  // Exclui o cliente do banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }
}
