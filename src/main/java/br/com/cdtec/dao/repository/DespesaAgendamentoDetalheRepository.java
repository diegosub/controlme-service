package br.com.cdtec.dao.repository;

import java.math.BigInteger;

import org.springframework.context.annotation.Lazy;

import br.com.cdtec.crud.repository.GenericRepository;
import br.com.cdtec.entity.DespesaAgendamentoDetalhe;

@Lazy(true)
public interface DespesaAgendamentoDetalheRepository extends GenericRepository<DespesaAgendamentoDetalhe, BigInteger>
{

}