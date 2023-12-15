package com.br.agencia.BdSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
	
	@RequestMapping("/ssa")
	public String ssa(){
		return "pac-salvador";
	}
	
	@RequestMapping("/rio")
	public String rio(){
		return "pac-rio";
	}
	
	@RequestMapping("/flori")
	public String floria(){
		return "pac-floria";
	}
	
	@RequestMapping("/ajuda")
	public String ajuda(){
		return "ajuda";
	}
	
	@RequestMapping("/loja")
	public String loja(){
		return "loja";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	

}
