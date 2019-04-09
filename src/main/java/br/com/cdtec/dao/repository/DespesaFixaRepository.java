package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.DespesaFixa;

@Lazy(true)
public interface DespesaFixaRepository extends GenericRepository<DespesaFixa, BigInteger>
{
   @Query("SELECT df FROM DespesaFixa df WHERE df.dsDespesaFixa = :dsDespesaFica AND df.idUsuario = :idUsuario")
   Integer quantidadePorDescricao(@Param("dsDespesaFica") String dsDespesaFica, @Param("idUsuario") BigInteger idUsuario);
   
   @Query("SELECT df FROM DespesaFixa df WHERE df.dsDespesaFixa = :dsDespesaFica AND df.idUsuario = :idUsuario AND df.idDespesaFixa <> :idDespesaFixa")
   Integer quantidadePorDescricao(@Param("dsDespesaFica") String dsDespesaFica, @Param("idUsuario") BigInteger idUsuario, @Param("idDespesaFixa") BigInteger idDespesaFixa);
}