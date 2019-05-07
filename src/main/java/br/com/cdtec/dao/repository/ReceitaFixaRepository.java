package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.ReceitaFixa;

@Lazy(true)
public interface ReceitaFixaRepository extends GenericRepository<ReceitaFixa, BigInteger>
{
   @Query("SELECT rf FROM ReceitaFixa rf WHERE rf.dsReceitaFixa = :dsReceitaFixa AND rf.idUsuario = :idUsuario")
   Integer quantidadePorDescricao(@Param("dsReceitaFixa") String dsReceitaFixa, @Param("idUsuario") BigInteger idUsuario);
   
   @Query("SELECT rf FROM ReceitaFixa rf WHERE rf.dsReceitaFixa = :dsReceitaFixa AND rf.idUsuario = :idUsuario AND rf.idReceitaFixa <> :idReceitaFixa")
   Integer quantidadePorDescricao(@Param("dsReceitaFixa") String dsReceitaFixa, @Param("idUsuario") BigInteger idUsuario, @Param("idReceitaFixa") BigInteger idReceitaFixa);
}