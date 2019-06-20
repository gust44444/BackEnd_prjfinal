package br.unisul.procurasefunc.dtos;

import java.io.Serializable;

import br.unisul.procurasefunc.domain.Departamento;

public class DepartamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomedep;
	private String nomeger;
	
	public DepartamentoDTO() {
		
	}
	
	public DepartamentoDTO(Departamento d) {
		id = d.getId();
		nomedep = d.getNomedep();
		nomeger = d.getNomeger();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomedep() {
		return nomedep;
	}

	public void setNomedep(String nomedep) {
		this.nomedep = nomedep;
	}

	public String getNomeger() {
		return nomeger;
	}

	public void setNomeger(String nomeger) {
		this.nomeger = nomeger;
	}
	
	
}
