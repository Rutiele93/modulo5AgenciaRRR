package com.br.agencia.BdSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import com.br.agencia.BdSpring.model.Reservas;
import com.br.agencia.BdSpring.repository.ClienteRepository;
import com.br.agencia.BdSpring.repository.DestinoRepository;
import com.br.agencia.BdSpring.repository.PromocaoRepository;
import com.br.agencia.BdSpring.repository.ReservaRepository;


@Controller
@RequestMapping("/reserva")
public class ReservaController{
	
	@Autowired
	private ReservaRepository reservaRepository;	
	
	@Autowired
	private DestinoRepository destinoRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("reserva/listarReserva");		
		modelAndView.addObject("reservas", reservaRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("reserva/detalharReserva.html"); 
		Reservas reservas = reservaRepository.getReferenceById(id);
		modelAndView.addObject("reserva", reservas);	
		return modelAndView;
	}
	
	@GetMapping("/cadastrarReserva")
	public ModelAndView cadastrar(){
		ModelAndView page = new ModelAndView("reserva/cadastroReserva");		
		page.addObject("reserva", new Reservas());
		page.addObject("destinos", destinoRepository.findAll());
		page.addObject("clientes", clienteRepository.findAll());
		return page;
	}
	
	@GetMapping("/cadastrarReservaProm")
	public ModelAndView cadastrarProm(){
		ModelAndView page = new ModelAndView("reserva/cadastroReservaProm");		
		page.addObject("reserva", new Reservas());
		page.addObject("promocao", promocaoRepository.findAll());
		page.addObject("clientes", clienteRepository.findAll());
		return page;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("reserva/edicaoReserva.html"); 
		Reservas reservas = reservaRepository.getReferenceById(id);		
		modelAndView.addObject("reserva", reservas); 
		modelAndView.addObject("destinos", destinoRepository.findAll());
		modelAndView.addObject("clientes", clienteRepository.findAll());
		modelAndView.addObject("promocao", promocaoRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping({"/cadastrarReserva", "/{id}/editar", "/cadastrarReservaProm"})
	public ModelAndView cadastrar(@ModelAttribute Reservas reservas) {
 		ModelAndView modelAndView = new ModelAndView("redirect:/reserva"); 
 		reservaRepository.save(reservas);
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/reserva"); 
		reservaRepository.deleteById(id);
 
		return modelAndView;
	}
	
//	public void fazerReserva(int quantidade, Long destinoId) {
//        Destinos destino = destinoRepository.findById(destinoId).orElseThrow(() -> 
//        new RuntimeException("Destino não encontrado"));
//        
//        Reservas reserva = new Reservas();
//        reserva.setQtdReservada(quantidade);
//        reserva.setDestinos(destino);
//
//        reservaRepository.save(reserva);
//
//        // Atualizar a quantidade disponível no destino, subtraindo a quantidade reservada
//        destino.setQtdDisponivel(destino.getQtdDisponivel() - quantidade);
//        destinoRepository.save(destino);
//    }
    
}


