package com.br.agencia.BdSpring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.agencia.BdSpring.model.Destinos;
import com.br.agencia.BdSpring.repository.DestinoRepository;



@Controller
@RequestMapping("/destino")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;	
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView page = new ModelAndView("destinos/listarDestino");
		List<Destinos> destinos = destinoRepository.findAll();
		page.addObject("destinos", destinos);
		return page;
	}	
	
	
	@GetMapping("/cadastrarDestino")
	public ModelAndView cadastrar() {
	    ModelAndView page = new ModelAndView("destinos/cadastroDestino");
	    page.addObject("destinos", new Destinos());
	    return page;
	}

	
	@PostMapping("/cadastrarDestino")
	public ModelAndView cadastrar(Destinos destinos, @RequestParam("fileDestino") MultipartFile file) 
			throws IOException {
		try {
			destinos.setImagemDestino(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
		destinoRepository.save(destinos);

		return modelAndView;
	}	
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("destinos/detalharDestino.html"); 
		Destinos destinos = destinoRepository.getReferenceById(id);
		modelAndView.addObject("destino", destinos);
 
		return modelAndView;
	}
	
	@GetMapping("/destino/reservar/{id}")
	public ModelAndView reservar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("reserva/cadastroReserva.html"); 
		Destinos destinoReserva = destinoRepository.getReferenceById(id);
		modelAndView.addObject("destino", destinoReserva);
 
		return modelAndView;
	}
	
	@GetMapping(value ="/imagem/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long id) {
		Destinos destinos = this.destinoRepository.getReferenceById(id);
		return destinos.getImagemDestino();
	}	
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("destinos/edicaoDestino"); 
		Destinos destinos = destinoRepository.getReferenceById(id);
		modelAndView.addObject("destino", destinos);
 
		return modelAndView;
	}
 
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Destinos destinos, @RequestParam("fileDestino") MultipartFile file) {		
 
		try {
			if (!file.isEmpty()) {
				destinos.setImagemDestino(file.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		destinoRepository.save(destinos);
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
 
		destinoRepository.deleteById(id);
 
		return modelAndView;
	}
	
	
	
}


