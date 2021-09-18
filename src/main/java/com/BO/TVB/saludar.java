package com.BO.TVB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class saludar {
	
	@RequestMapping("/saludar")
	public String saludar() {
		return "Hola mundo";
	}
}
