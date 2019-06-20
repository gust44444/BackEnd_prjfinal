package br.unisul.procurasefunc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Vgtrabalho implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomedcargo;
	private String nivelesc;
	private Double salario;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
	
}
