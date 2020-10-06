package br.com.dh.empresa.empresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
