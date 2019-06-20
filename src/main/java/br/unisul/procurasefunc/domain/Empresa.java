package br.unisul.procurasefunc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String uf;
	private String telefone;
	private String cidade;

	@JsonIgnore
	@OneToMany(mappedBy="empresa")
	private List<Departamento> pedidos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="empresa")
	private List<Vgtrabalho> vagas = new ArrayList<>();

	public List<Departamento> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Departamento> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Vgtrabalho> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vgtrabalho> vagas) {
		this.vagas = vagas;
	}

	public Empresa (Integer id, String nome, String uf, String telefone, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.telefone = telefone;
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
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