package br.edu.ifms.locacao.dto;

import java.io.Serializable;
import java.util.List;

import br.edu.ifms.locacao.entities.ContratoAluguel;
import br.edu.ifms.locacao.entities.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<ContratoAluguel> contratoAluguel;

	public ClienteDTO() {

	}


	public ClienteDTO(Long id, String nome, String telefone, String email, String endereco,
			List<ContratoAluguel> contratoAluguel) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.contratoAluguel = contratoAluguel;
	}



	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.endereco = entity.getEndereco();

		
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
	

}
