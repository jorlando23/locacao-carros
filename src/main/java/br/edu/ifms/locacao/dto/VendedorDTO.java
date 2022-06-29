package br.edu.ifms.locacao.dto;

import java.io.Serializable;
import java.util.List;
import br.edu.ifms.locacao.entities.Carro;
import br.edu.ifms.locacao.entities.Vendedor;

public class VendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String codigo;
	private String nome;
	private String email;
	private String telefone;
	//private List<Carro> Carros;
	
	public VendedorDTO() {
	}
	

	public VendedorDTO(Long id, String codigo, String nome, String email, String telefone,
			List<Carro> carros) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		//this.Carros = Carros;
	}
	
	public VendedorDTO(Vendedor entity) {
		this.id = entity.getId();
		this.codigo = entity.getCodigo();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
	//	this.Carros = entity.getCarros();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



//	public List<Carro> getCarros() {
//		return Carros;
//	}
//
//
//	public void setCarros(List<Carro> Carros) {
//		this.Carros = Carros;
//	}
	
	

}
