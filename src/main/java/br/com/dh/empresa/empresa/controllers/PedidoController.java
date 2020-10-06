package br.com.dh.empresa.empresa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Pedido;
import br.com.dh.empresa.empresa.model.repositories.PedidoRepository;

@RestController
@RequestMapping(path = "pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	public Iterable<Pedido> getPedido(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("{/id}")
	public Optional<Pedido> getById(@PathVariable int id) {
		return pedidoRepository.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public Pedido addPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido;
	}
	
	@PutMapping("/editar/{idPedido")
	public Pedido updatePedido(@PathVariable int idPedido, @RequestBody Pedido dadosPedido) throws Exception {
		Pedido meuPedido = pedidoRepository.findById(idPedido)
		.orElseThrow(() -> new IllegalAccessException());
		
		if(!dadosPedido.getData_pedido().isEmpty()) meuPedido.setData_pedido(dadosPedido.getData_pedido());
		if(!dadosPedido.getSituacao().isEmpty()) meuPedido.setSituacao(dadosPedido.getSituacao());
		
		pedidoRepository.save(meuPedido);
		return meuPedido;
	}
	
	@DeleteMapping("/apagar/{id}")
	public void deletePedido(@PathVariable int id) {
		pedidoRepository.deleteById(id);
	}
}
