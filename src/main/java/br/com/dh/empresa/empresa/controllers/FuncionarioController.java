package br.com.dh.empresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Funcionario;
import br.com.dh.empresa.empresa.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping(path = "funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public Iterable<Funcionario> getFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/nome")
	public Funcionario getByNome(@RequestParam String nome) {
		return funcionarioRepository.findOneByNome(nome);
	}
	
	@GetMapping("/nomelike")
	public List<Funcionario> getByNomeContaining(@RequestParam String nome){
		return funcionarioRepository.findByNomeContaining(nome);
	}
	
	
	@PostMapping("/cadastrar")
	public Funcionario setFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	@DeleteMapping("/{id}")
	public void deletarFuncionario(@PathVariable int id) {
		funcionarioRepository.deleteById(id);
	}
	
	@PutMapping("/editar/{idFuncionario}")
	public Funcionario editarFuncionario(@PathVariable int idFuncionario, @RequestBody Funcionario dadosFuncionario) throws Exception {
		Funcionario meuFuncionario = funcionarioRepository.findById(idFuncionario)
		.orElseThrow(() -> new IllegalAccessException());
		
		if(!dadosFuncionario.getNome().isEmpty()) meuFuncionario.setNome(dadosFuncionario.getNome());
		if(!dadosFuncionario.getCpf().isEmpty()) meuFuncionario.setCpf(dadosFuncionario.getCpf());
		if(!dadosFuncionario.getEmail().isEmpty()) meuFuncionario.setEmail(dadosFuncionario.getEmail());
		if(!dadosFuncionario.getRg().isEmpty()) meuFuncionario.setRg(dadosFuncionario.getRg());
		if(!dadosFuncionario.getTelefone().isEmpty()) meuFuncionario.setTelefone(dadosFuncionario.getTelefone());
		if(!dadosFuncionario.getEndereco().isEmpty()) meuFuncionario.setEndereco(dadosFuncionario.getEndereco());
		if(!dadosFuncionario.getCargo().isEmpty()) meuFuncionario.setCargo(dadosFuncionario.getEndereco());
		if(!dadosFuncionario.getSalario().isNaN()) meuFuncionario.setSalario(dadosFuncionario.getSalario());
		
		funcionarioRepository.save(meuFuncionario);
		return meuFuncionario;
		
	}
	
	@PutMapping("/demitir/{idFuncionario}")
	public Funcionario demitirFuncionario(@PathVariable int idFuncionario) throws Exception {
		Funcionario meuFuncionario = funcionarioRepository.findById(idFuncionario)
		.orElseThrow(() -> new IllegalAccessException());
		
		if(meuFuncionario.getHabilitado() == true) {
			meuFuncionario.setHabilitado(false);			
		}
		funcionarioRepository.save(meuFuncionario);
		return meuFuncionario;
	}
	
	@PutMapping("/reajuste/{idFuncionario}")
	public Funcionario reajustarFuncionario(@PathVariable int idFuncionario, @RequestBody Funcionario dadosFuncionario) throws Exception {
		Funcionario meuFuncionario = funcionarioRepository.findById(idFuncionario)
		.orElseThrow(() -> new IllegalAccessException());
		
		if(meuFuncionario.getSalario() < dadosFuncionario.getSalario()) {
			meuFuncionario.setSalario(dadosFuncionario.getSalario());			
		}
		
		funcionarioRepository.save(meuFuncionario);
		return meuFuncionario;
		
	}
	
	
	

}
