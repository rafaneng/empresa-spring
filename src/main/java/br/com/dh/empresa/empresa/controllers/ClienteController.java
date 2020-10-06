package br.com.dh.empresa.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Cliente;
import br.com.dh.empresa.empresa.model.repositories.ClienteRepository;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public Iterable<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@PostMapping("/cadastrar")
	public Cliente addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	
	

}
