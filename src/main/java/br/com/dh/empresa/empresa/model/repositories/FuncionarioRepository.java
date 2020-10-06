package br.com.dh.empresa.empresa.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	
	Funcionario findOneByNome(String nome);
	List<Funcionario> findByNomeContaining(String nome);

}
