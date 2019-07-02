package br.unisul.procurasefunc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.procurasefunc.domain.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	
	
	@Transactional(readOnly=true)
	public List<Departamento> findAllByOrderByNomedep();
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Departamento obj WHERE obj.empresa.id = :empresaId ORDER BY obj.id")
	public List<Departamento> findDepartamentos(@Param("empresaId") Integer empresa_id);
	
	@Query("SELECT departamento FROM Departamento departamento WHERE departamento.nomedep LIKE %:nome%")
	List<Departamento> findLikeNome(String nome);

}
