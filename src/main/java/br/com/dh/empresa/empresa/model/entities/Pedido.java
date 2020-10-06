package br.com.dh.empresa.empresa.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
	private String data_pedido;
	private String situacao;
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	@JsonIgnoreProperties("pedidos")
	private Cliente cliente;
	
	public String getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Integer getId_pedido() {
		return id_pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
}
