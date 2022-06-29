package br.edu.ifms.locacao.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.edu.ifms.locacao.dto.ClienteDTO;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	@OneToMany(mappedBy = "cliente")
	private List<ContratoAluguel> contratoAluguel;
	
	/**
	 * audit information
	 */
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	

	public Cliente() {

	}

	public Cliente(Long id, String nome, String telefone, String email, String endereco,
			List<ContratoAluguel> contratoAluguel) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.contratoAluguel = contratoAluguel;
	}



	public void setData(ClienteDTO dto) {
		this.nome = dto.getNome();
		this.telefone = dto.getTelefone();
		this.email = dto.getEmail();
		this.endereco = dto.getEndereco();
		this.contratoAluguel = dto.getContratoAluguel();
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<ContratoAluguel> getContratoAluguel() {
		return contratoAluguel;
	}

	public void setContratoAluguel(List<ContratoAluguel> contratoAluguel) {
		this.contratoAluguel = contratoAluguel;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
