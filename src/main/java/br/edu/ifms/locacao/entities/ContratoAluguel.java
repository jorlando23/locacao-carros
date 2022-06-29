package br.edu.ifms.locacao.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.edu.ifms.locacao.entities.enums.Prioridade;
import br.edu.ifms.locacao.entities.enums.Status;
import br.edu.ifms.locacao.dto.ContratoAluguelDTO;


@Entity
@Table(name = "tb_contrato_aluguel")
public class ContratoAluguel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataLocacao;
	private String dataDevolucao;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Enumerated(EnumType.STRING)
	private Prioridade prioridade;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "tb_contrato_has_carro",
						joinColumns = @JoinColumn(name = "id_contrato"),
						inverseJoinColumns = @JoinColumn(name = "id_carro"))
	Set<Carro> carro = new HashSet<>();
	
	
	/**
	 * audit information
	 */
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	
	public ContratoAluguel() {
		
	}
	
	public ContratoAluguel(Long id, String dataLocacao, String dataDevolucao, Status status,
			Prioridade prioridade, Cliente cliente, Set<Carro> carro) {
		this.id = id;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.status = status;
		this.prioridade = prioridade;
		this.cliente = cliente;
		this.carro = carro;
	}
	
	public void setData(ContratoAluguelDTO dto) {
		this.id = dto.getId();
		this.dataLocacao = dto.getDataLocacao();
		this.dataDevolucao = dto.getDataDevolucao();
		this.status = dto.getStatus();
		this.prioridade = dto.getPrioridade();
		this.cliente = dto.getCliente();
		this.carro = (Set) dto.getCarros();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Carro> getCarro() {
		return carro;
	}

	public void setCarro(Set<Carro> carro) {
		this.carro = carro;
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

	public Instant getCreatedAt() {
		return createdAt;
	}
	
	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoAluguel other = (ContratoAluguel) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
