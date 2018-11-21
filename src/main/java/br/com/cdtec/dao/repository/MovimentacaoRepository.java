package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.Movimentacao;

@Lazy(true)
public interface MovimentacaoRepository extends GenericRepository<Movimentacao, BigInteger>
{
   @Query(value = "{call :cmdSql}", nativeQuery = true)
   void gerarMovimentacaoEntrada(@Param("cmdSql") String cmdSql);
}