package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DespesaCartaoDetalheRepository;
import br.com.cdtec.dao.specifications.DespesaCartaoDetalheSpecifications;
import br.com.cdtec.entity.DespesaCartaoDetalhe;

@Service
public class DespesaCartaoDetalheService extends CrudService<DespesaCartaoDetalhe, BigInteger, DespesaCartaoDetalheRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "dtVencimento";
   
   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaCartaoDetalhe> implementarPesquisar(DespesaCartaoDetalhe despesaCcd, Sort sort) throws Exception
   {
      if(sort == null) 
      {
         return getRepository().findAll(Specification.where(DespesaCartaoDetalheSpecifications.idDespesaCchIgual(despesaCcd.getIdDespesaCch())));
      }
      else
      {
         return getRepository().findAll(Specification.where(DespesaCartaoDetalheSpecifications.idDespesaCchIgual(despesaCcd.getIdDespesaCch())), sort);
      }
   }

}