package br.edu.ifms.locacao.dto;

import java.io.Serializable;

import br.edu.ifms.locacao.entities.Carro;
import br.edu.ifms.locacao.entities.Vendedor;

public class CarroDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String carro;
	private String patrimonio;
	private Vendedor vendedor;
	
	public CarroDTO() {
		
	}

	public CarroDTO(Long id, String carro, String patrimonio, Vendedor vendedor) {
		super();
		this.id = id;
		this.carro = carro;
		this.patrimonio = patrimonio;
		this.vendedor = vendedor;
	}
	
	public CarroDTO(Carro entity) {
		this.id = entity.getId();
		this.carro = entity.getCarro();
		this.patrimonio = entity.getPatrimonio();
		this.vendedor = entity.getVendedor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarro() {
		return carro;
	}

	public void setcarro(String carro) {
		this.carro = carro;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


}
