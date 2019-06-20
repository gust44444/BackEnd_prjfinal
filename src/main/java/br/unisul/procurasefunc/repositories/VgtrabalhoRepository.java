package br.unisul.procurasefunc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.unisul.procurasefunc.domain.Vgtrabalho;

@Repository
public interface VgtrabalhoRepository extends JpaRepository<Vgtrabalho, Integer> {
	
	@Transactional(readOnly=false)
	@Query("SELECT obj FROM Vgtrabalho obj WHERE obj.empresa.id = :empresaId ORDER BY obj.id")
	public List<Vgtrabalho> findVgtrabalhoEmpresas(@Param("empresaId") Integer empresa_id);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Vgtrabalho obj WHERE obj.departamento.id = :departamentoId ORDER BY obj.id")
	public List<Vgtrabalho> findVgtrabalhoDepartametos(@Param("departamentoId") Integer departamento_id);
}
