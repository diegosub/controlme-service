package br.com.cdtec.dao.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.Dominio;

@Lazy(true)
public interface DominioRepository extends GenericRepository<Dominio, BigInteger>
{
	@Query("SELECT d FROM Dominio d WHERE d.dsCampo = :dsCampo")
	List<Dominio> pesquisarPorCampo(@Param("dsCampo") String dsCampo);
}