package br.unisul.procurasefunc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.procurasefunc.domain.Empresa;
public interface EmpresaRepository  extends JpaRepository<Empresa, Integer>{
	
	@Transactional(readOnly=true)
	public List<Empresa> findAllByOrderByNome();
	
	@Query("SELECT empresa FROM Empresa empresa WHERE empresa.nome LIKE %:nome%")
	List<Empresa> findLikeNome(String nome);

}
