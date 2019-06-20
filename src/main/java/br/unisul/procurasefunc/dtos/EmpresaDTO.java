package br.unisul.procurasefunc.dtos;

import java.io.Serializable;

import br.unisul.procurasefunc.domain.Empresa;

public class EmpresaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String uf;
	private String telefone;
	private String cidade;
	
	public EmpresaDTO() {
		
	}
	
	public EmpresaDTO(Empresa e) {
		this.id = e.getId();
		this.nome = e.getNome();
		this.uf = e.getUf();
		this.telefone = e.getTelefone();
		this.cidade = e.getCidade();
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

}
