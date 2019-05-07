package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.ReceitaAgendamentoDetalheRepository;
import br.com.cdtec.dao.specifications.ReceitaAgendamentoDetalheSpecifications;
import br.com.cdtec.entity.ReceitaAgendamentoDetalhe;

@Service
public class ReceitaAgendamentoDetalheService extends CrudService<ReceitaAgendamentoDetalhe, BigInteger, ReceitaAgendamentoDetalheRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "dtVencimento";
   
   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<ReceitaAgendamentoDetalhe> implementarPesquisar(ReceitaAgendamentoDetalhe receitaAgd, Sort sort) throws Exception
   {
      if(sort == null) 
      {
         return getRepository().findAll(Specification.where(ReceitaAgendamentoDetalheSpecifications.idReceitaAghIgual(receitaAgd.getIdReceitaAgh())));
      }
      else
      {
         return getRepository().findAll(Specification.where(ReceitaAgendamentoDetalheSpecifications.idReceitaAghIgual(receitaAgd.getIdReceitaAgh())), sort);
      }
   }

}