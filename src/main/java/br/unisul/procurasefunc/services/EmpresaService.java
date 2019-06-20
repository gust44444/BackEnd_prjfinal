package br.unisul.procurasefunc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.procurasefunc.domain.Empresa;
import br.unisul.procurasefunc.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository rep;

	//BUSCAR POR ID
		public Empresa find (Integer id) {
			Optional<Empresa> obj = rep.findById(id);
			return obj.orElse(null);
		}

		//INSERIR
		public Empresa insert (Empresa obj) {
			obj.setId(null);
			return rep.save(obj);
		}

		//ATUALIZAR
		public Empresa update (Empresa obj) {
			find(obj.getId());
			return rep.save(obj);
		}

		//DELETAR
		public void delete (Integer id) {
			find(id);
			rep.deleteById(id);
		}

		//LISTAR TODAS
		public List<Empresa> findAll(){
			return rep.findAllByOrderByNome();
		}

}
