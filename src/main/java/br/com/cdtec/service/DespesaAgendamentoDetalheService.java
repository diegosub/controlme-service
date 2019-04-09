package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DespesaAgendamentoDetalheRepository;
import br.com.cdtec.dao.specifications.DespesaAgendamentoDetalheSpecifications;
import br.com.cdtec.entity.DespesaAgendamentoDetalhe;

@Service
public class DespesaAgendamentoDetalheService extends CrudService<DespesaAgendamentoDetalhe, BigInteger, DespesaAgendamentoDetalheRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "dtVencimento";
   
   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaAgendamentoDetalhe> implementarPesquisar(DespesaAgendamentoDetalhe despesaAgd, Sort sort) throws Exception
   {
      if(sort == null) 
      {
         return getRepository().findAll(Specification.where(DespesaAgendamentoDetalheSpecifications.idDespesaAghIgual(despesaAgd.getIdDespesaAgh())));
      }
      else
      {
         return getRepository().findAll(Specification.where(DespesaAgendamentoDetalheSpecifications.idDespesaAghIgual(despesaAgd.getIdDespesaAgh())), sort);
      }
   }

}