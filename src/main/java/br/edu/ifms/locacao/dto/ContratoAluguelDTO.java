package br.edu.ifms.locacao.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ifms.locacao.entities.Carro;
import br.edu.ifms.locacao.entities.ContratoAluguel;
import br.edu.ifms.locacao.entities.Cliente;
import br.edu.ifms.locacao.entities.enums.Prioridade;
import br.edu.ifms.locacao.entities.enums.Status;


public class ContratoAluguelDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String dataLocacao;
	private String dataDevolucao;
	private Status status;
	private Prioridade prioridade;
	private Cliente cliente;
	private List<CarroDTO> carros = new ArrayList<>();
	
	public ContratoAluguelDTO() {
	
	}
	
	public ContratoAluguelDTO(Long id, String dataLocacao, String dataDevolucao,
			Status status, Prioridade prioridade, Cliente cliente) {
		super();
		this.id = id;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.status = status;
		this.prioridade = prioridade;
		this.cliente = cliente;
	}

	public ContratoAluguelDTO(ContratoAluguel entity) {
		this.id = entity.getId();
		this.dataLocacao = entity.getDataLocacao();
		this.dataDevolucao = entity.getDataDevolucao();
		this.status = entity.getStatus();
		this.prioridade = entity.getPrioridade();
		this.cliente = entity.getCliente();
	}
	
	public ContratoAluguelDTO(ContratoAluguel entity, Set<Carro> carros) {
		this(entity);
		carros.forEach(Carro -> new CarroDTO(Carro));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CarroDTO> getCarros() {
		return carros;
	}

	public void setCarros(List<CarroDTO> carros) {
		this.carros = carros;
	}
	

}
