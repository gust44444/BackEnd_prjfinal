package br.unisul.procurasefunc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.procurasefunc.domain.Departamento;
import br.unisul.procurasefunc.services.DepartamentoService;

public class DepartamentoResource {
	
	@Autowired
	private DepartamentoService service;
	
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void>insert(@RequestBody Departamento obj){
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

}
