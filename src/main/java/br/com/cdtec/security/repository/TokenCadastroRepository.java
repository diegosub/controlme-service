package br.com.cdtec.security.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.security.entity.TokenCadastro;
import br.com.cdtec.security.entity.Usuario;


@Lazy(true)
public interface TokenCadastroRepository extends GenericRepository<TokenCadastro, BigInteger>  {
	
	@Query("SELECT t FROM TokenCadastro t WHERE t.idUsuario = :idUsuario")
	Usuario getToken(@Param("idUsuario") BigInteger idUsuario);

}