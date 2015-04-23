package br.com.CRUDSpringHibernateMaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioLogado")
public class MenuController {

	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menuPrincipal(){
		return "menu/Menu";
	}
}
