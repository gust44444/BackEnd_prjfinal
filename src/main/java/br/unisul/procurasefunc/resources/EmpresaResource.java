package br.unisul.procurasefunc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.procurasefunc.domain.Departamento;
import br.unisul.procurasefunc.domain.Empresa;
import br.unisul.procurasefunc.dtos.DepartamentoDTO;
import br.unisul.procurasefunc.dtos.EmpresaDTO;
import br.unisul.procurasefunc.services.DepartamentoService;
import br.unisul.procurasefunc.services.EmpresaService;


@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService service;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Empresa> find(@PathVariable Integer id){
		Empresa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Empresa obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//ATUALIZAR
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Empresa obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}


	//EXCLUIR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmpresaDTO>> findAll() {
		List<Empresa> lista = service.findAll();
		List<EmpresaDTO> listaDTO = lista.stream().map(obj -> new EmpresaDTO(obj)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listaDTO);
	}
	
	//LISTAR DEPARTAMENTOS DE UMA EMPRESA
	@RequestMapping(value="/{empresaId}/departamentos", method=RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> findDepartamentos(@PathVariable Integer empresaId) {
		List<Departamento> list = departamentoService.findByEmpresa(empresaId);
		List<DepartamentoDTO> listDto = list.stream().map(obj -> new DepartamentoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}


}
