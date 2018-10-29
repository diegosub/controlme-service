package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.Categoria;


@Lazy(true)
public interface CategoriaRepository extends GenericRepository<Categoria, BigInteger>  {
	
	@Query("SELECT c FROM Categoria c WHERE c.dsCategoria = :dsCategoria AND c.idUsuario = :idUsuario")
	Categoria pesquisarPorDescricao(@Param("dsCategoria") String dsCategoria, @Param("idUsuario") BigInteger idUsuario);
	
	@Query("SELECT count(c) FROM Categoria c WHERE c.dsCategoria = :dsCategoria AND c.tpCategoria = :tpCategoria AND c.idUsuario = :idUsuario")
	Integer quantidadePorDescricao(@Param("dsCategoria") String dsCategoria, @Param("tpCategoria") String tpCategoria, @Param("idUsuario") BigInteger idUsuario);
	
	@Query("SELECT count(c) FROM Categoria c WHERE c.dsCategoria = :dsCategoria AND c.idCategoria <> :idCategoria AND c.tpCategoria = :tpCategoria AND c.idUsuario = :idUsuario")
	Integer quantidadePorDescricao(@Param("dsCategoria") String dsCategoria, @Param("tpCategoria") String tpCategoria, @Param("idCategoria") BigInteger idCategoria, @Param("idUsuario") BigInteger idUsuario);
	
}