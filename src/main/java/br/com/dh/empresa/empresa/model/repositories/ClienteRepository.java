package br.com.dh.empresa.empresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
