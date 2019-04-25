package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.DespesaCartaoHeader;

@Lazy(true)
public interface DespesaCartaoHeaderRepository extends GenericRepository<DespesaCartaoHeader, BigInteger>
{

}