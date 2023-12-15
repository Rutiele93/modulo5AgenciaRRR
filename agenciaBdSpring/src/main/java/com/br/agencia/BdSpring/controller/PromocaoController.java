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

import com.br.agencia.BdSpring.model.Promocao;
import com.br.agencia.BdSpring.repository.PromocaoRepository;


@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView page = new ModelAndView("promocao/promocao");
		List<Promocao> promocao = promocaoRepository.findAll();
		page.addObject("promocao", promocao);
		return page;
	}	
	@GetMapping("/cadastrarPromocao")
	public ModelAndView cadastrar() {
	    ModelAndView page = new ModelAndView("promocao/cadastroPromocao");
	    page.addObject("promocao", new Promocao());
	    return page;
	}
	
	@PostMapping("/cadastrarPromocao")
	public ModelAndView cadastrar(Promocao promocao, @RequestParam("fileDestinoProm") MultipartFile file) 
			throws IOException {
		try {
			promocao.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/promocao");
		promocaoRepository.save(promocao);

		return modelAndView;
	}	
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("promocao/detalharPromocao.html"); 
		Promocao promocao = promocaoRepository.getReferenceById(id);
		modelAndView.addObject("promocao", promocao);
 
		return modelAndView;
	}

	@GetMapping("/promocao/reservar/{id}")
	public ModelAndView reservar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("reserva/cadastroReserva.html"); 
		Promocao promocaoReserva = promocaoRepository.getReferenceById(id);
		modelAndView.addObject("promocao", promocaoReserva);
 
		return modelAndView;
	}
	
	@GetMapping(value ="/imagem/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long id) {
		Promocao promocao = this.promocaoRepository.getReferenceById(id);
		return promocao.getImagem();
	}	
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("promocao/edicaoPromocao"); 
		Promocao promocao = promocaoRepository.getReferenceById(id);
		modelAndView.addObject("promocao", promocao);
 
		return modelAndView;
	}
 
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Promocao promocao, @RequestParam("fileDestinoProm") MultipartFile file) {		
 
		try {
			if (!file.isEmpty()) {
				promocao.setImagem(file.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		promocaoRepository.save(promocao);
		ModelAndView modelAndView = new ModelAndView("redirect:/promocao");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/promocao");
 
		promocaoRepository.deleteById(id);
 
		return modelAndView;
	}
	
	
	
}

