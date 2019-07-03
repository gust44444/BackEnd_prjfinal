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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.procurasefunc.domain.Vgtrabalho;
import br.unisul.procurasefunc.dtos.VgtrabalhoDTO;
import br.unisul.procurasefunc.resources.utils.URL;
import br.unisul.procurasefunc.services.VgtrabalhoService;

@RestController
@RequestMapping(value="/vgtrabalho")
public class VgtrabalhoResource {
	
	@Autowired
	private VgtrabalhoService service;
	
	//INSERIR
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void>insert(@RequestBody Vgtrabalho obj){
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		//BUSCAR POR ID
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<Vgtrabalho> find(@PathVariable Integer id){
			Vgtrabalho obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
		//ATUALIZAR
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Vgtrabalho obj, @PathVariable Integer id){
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
		
		/*   //RETORNA VALORES DAS EMPRESAS RELACIONADAS A VAGA DE TRABALHO
		@RequestMapping(value="/vgemp", method=RequestMethod.GET)
		public ResponseEntity<List<VgtrabalhoDTO>> findVgtrabalhoEmpresas() {
			List<Vgtrabalho> lista = service.findByEmpresa();
			List<VgtrabalhoDTO> listaDTO = lista.stream().map(obj -> new VgtrabalhoDTO(obj)).collect(Collectors.toList()); 
			return ResponseEntity.ok().body(listaDTO);
		}
 		   */
		
		//LISTAR TODAS
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<VgtrabalhoDTO>> findAll() {
			List<Vgtrabalho> lista = service.findAll();
			List<VgtrabalhoDTO> listaDTO = lista.stream().map(obj -> new VgtrabalhoDTO(obj)).collect(Collectors.toList()); 
			return ResponseEntity.ok().body(listaDTO);
		}
		
		//BUSCAR POR NOME
		@RequestMapping(value="/filtro",method=RequestMethod.GET)
		public ResponseEntity<List<Vgtrabalho>> find(@RequestParam(value="nome", defaultValue="")String nome){
		List <Vgtrabalho> list = service.findByName(URL.decodeParam(nome));
		return ResponseEntity.ok().body(list);
		}


}
