package br.unisul.procurasefunc.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.procurasefunc.domain.Departamento;
import br.unisul.procurasefunc.domain.Empresa;
import br.unisul.procurasefunc.repositories.DepartamentoRepository;
import br.unisul.procurasefunc.repositories.EmpresaRepository;
//import br.unisul.procurasefunc.repositories.VgtrabalhoRepository;

@Service
public class DbService {
	
	@Autowired
	private EmpresaRepository empRep;
	
	@Autowired
	private DepartamentoRepository depRep;
	
	//@Autowired
	//private VgtrabalhoRepository vgtRep; 

	public void inicializaBancoDeDados() {
		Empresa e1 = new Empresa(null,"Microsoft","SC","29374987","Tubarão");
		Empresa e2 = new Empresa(null,"Apple","SC","3245345","Tubarão");
		Empresa e3 = new Empresa(null,"Disney","SC","34545632","Tubarão");
		Empresa e4 = new Empresa(null,"Tubapel","SC","45324676","Tubarão");
		
		Departamento d1 = new Departamento(null,"Setor de desenvolvimento","Augusto", e1);
		Departamento d2 = new Departamento(null,"Setor de RH","Gean", e2);
		Departamento d3 = new Departamento(null,"Setor Financeiro","Gustavo", e3);
		Departamento d4 = new Departamento(null,"Setor de Suporte","Alberto", e4);
		
		e1.getDepartamentos().addAll(Arrays.asList(d1));
		e2.getDepartamentos().addAll(Arrays.asList(d2));
		e3.getDepartamentos().addAll(Arrays.asList(d3));
		e4.getDepartamentos().addAll(Arrays.asList(d4));
		
		empRep.saveAll(Arrays.asList(e1,e2,e3,e4));
		depRep.saveAll(Arrays.asList(d1,d2,d3,d4));
		
		
		
	}

}
