package br.unisul.procurasefunc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomedep; //nome do departamento
	private String nomeger; // nome do gerente
	
	
	@JsonIgnore
	@OneToMany(mappedBy="departamento")
	private List<Vgtrabalho> vagas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	
	
	public List<Vgtrabalho> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vgtrabalho> vagas) {
		this.vagas = vagas;
	}

	public Departamento() {
		
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


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	


}
