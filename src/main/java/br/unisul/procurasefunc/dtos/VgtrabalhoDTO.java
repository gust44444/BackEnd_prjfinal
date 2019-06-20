package br.unisul.procurasefunc.dtos;

import java.io.Serializable;

import br.unisul.procurasefunc.domain.Vgtrabalho;

public class VgtrabalhoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomedcargo;
	private String nivelesc;
	private Double salario;
	
	public VgtrabalhoDTO() {
		
	}
	
	public VgtrabalhoDTO(Vgtrabalho v) {
		this.id = v.getId();
		this.nomedcargo = v.getNomedcargo();
		this.nivelesc = v.getNivelesc();
		this.salario = v.getSalario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomedcargo() {
		return nomedcargo;
	}

	public void setNomedcargo(String nomedcargo) {
		this.nomedcargo = nomedcargo;
	}

	public String getNivelesc() {
		return nivelesc;
	}

	public void setNivelesc(String nivelesc) {
		this.nivelesc = nivelesc;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
