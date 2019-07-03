package br.unisul.procurasefunc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.procurasefunc.domain.Vgtrabalho;
import br.unisul.procurasefunc.repositories.VgtrabalhoRepository;

@Service
public class VgtrabalhoService {
	
	@Autowired
	private VgtrabalhoRepository rep;
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@Autowired
	private DepartamentoService departamentoService;

	public List<Vgtrabalho> findByEmpresa(Integer empresaId) {
		return rep.findVgtrabalhoEmpresas(empresaId);
	}
	
	public List<Vgtrabalho> findByDepatamento(Integer departamentoId) {
		return rep.findVgtrabalhoDepartametos(departamentoId);
	}
	
	public Vgtrabalho insert (Vgtrabalho obj) {
		obj.setId(null);
		obj.setEmpresa(empresaService.find(obj.getEmpresa().getId()));
		obj.setDepartamento(departamentoService.find(obj.getDepartamento().getId()));
		obj = rep.save(obj);
		return obj;
	}
	
	public Vgtrabalho find (Integer id) {
		Optional<Vgtrabalho> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Vgtrabalho update (Vgtrabalho obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}

	//LISTAR TODAS
	public List<Vgtrabalho> findAll(){
		return rep.findAllByOrderByNomedcargo();
	}
	
	//BUSCAR POR NOME	
	public List<Vgtrabalho> findByName(String nome){
		List<Vgtrabalho> list = rep.findLikeNomedcargo(nome);
		return list;
	}

}
