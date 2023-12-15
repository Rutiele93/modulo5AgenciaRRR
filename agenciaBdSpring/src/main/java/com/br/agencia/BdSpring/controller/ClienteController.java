package com.br.agencia.BdSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.agencia.BdSpring.model.Clientes;
import com.br.agencia.BdSpring.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping 
	public ModelAndView listar() {
		ModelAndView page = new ModelAndView("cliente/listarCliente");
		List<Clientes> clientes = clienteRepository.findAll();
		page.addObject("clientes", clientes);
		return page;
	}
	
	@GetMapping("/cadastrarCliente")
	public ModelAndView cadastrar() {
		ModelAndView page = new ModelAndView("cliente/cadastroCliente");
		page.addObject("cliente", new Clientes());
		return page;
	}
	
	@PostMapping({"/cadastrarCliente", "/{id}/editar"})
	public ModelAndView cadastrar(@ModelAttribute Clientes clientes) {
 		ModelAndView modelAndView = new ModelAndView("redirect:/cliente"); 
		clienteRepository.save(clientes);
 
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/detalharCliente.html"); 
		Clientes clientes = clienteRepository.getReferenceById(id);
		modelAndView.addObject("cliente", clientes); 
		return modelAndView;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/edicaoCliente.html"); 
		Clientes clientes = clienteRepository.getReferenceById(id);
		modelAndView.addObject("cliente", clientes); 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente"); 
		clienteRepository.deleteById(id);
 
		return modelAndView;
	}
}


