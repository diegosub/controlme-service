package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.Subcategoria;


@Lazy(true)
public interface SubcategoriaRepository extends GenericRepository<Subcategoria, BigInteger>  {
	
	@Query("SELECT s FROM Subcategoria s WHERE s.dsSubcategoria = :dsSubcategoria AND s.idCategoria = :idCategoria")
	Subcategoria pesquisarPorDescricao(@Param("dsSubcategoria") String dsSubcategoria, @Param("idCategoria") BigInteger idCategoria);
	
	@Query("SELECT count(s) FROM Subcategoria s WHERE s.dsSubcategoria = :dsSubcategoria AND s.idCategoria = :idCategoria")
	Integer quantidadePorDescricao(@Param("dsSubcategoria") String dsSubcategoria, @Param("idCategoria") BigInteger idCategoria);
	
	@Query("SELECT count(s) FROM Subcategoria s WHERE s.dsSubcategoria = :dsSubcategoria AND s.idSubcategoria <> :idSubcategoria  AND s.idCategoria = :idCategoria")
	Integer quantidadePorDescricao(@Param("dsSubcategoria") String dsSubcategoria, @Param("idSubcategoria") BigInteger idSubcategoria, @Param("idCategoria") BigInteger idCategoria);
	
}