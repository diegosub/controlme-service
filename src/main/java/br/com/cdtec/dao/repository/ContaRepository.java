package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.Conta;

@Lazy(true)
public interface ContaRepository extends GenericRepository<Conta, BigInteger>
{

	@Query("SELECT c FROM Conta c WHERE c.dsConta = :dsConta AND c.idUsuario = :idUsuario")
	Conta pesquisarPorDescricao(@Param("dsConta") String dsConta, @Param("idUsuario") BigInteger idUsuario);

	@Query("SELECT count(c) FROM Conta c WHERE c.dsConta = :dsConta AND c.idUsuario = :idUsuario")
	Integer quantidadePorDescricao(@Param("dsConta") String dsConta, @Param("idUsuario") BigInteger idUsuario);

	@Query("SELECT count(c) FROM Conta c WHERE c.dsConta = :dsConta AND c.idConta <> :idConta AND c.idUsuario = :idUsuario")
	Integer quantidadePorDescricao(@Param("dsConta") String dsConta, @Param("idConta") BigInteger idConta, @Param("idUsuario") BigInteger idUsuario);

}