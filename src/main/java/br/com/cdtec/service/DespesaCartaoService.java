package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DespesaCartaoRepository;
import br.com.cdtec.dao.specifications.DespesaCartaoSpecifications;
import br.com.cdtec.entity.DespesaCartao;

@Service
public class DespesaCartaoService extends CrudService<DespesaCartao, BigInteger, DespesaCartaoRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idDespesaCartao";

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaCartao> implementarPesquisar(DespesaCartao despesaCartao, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DespesaCartaoSpecifications.fgAtivoIgual(despesaCartao.getFgAtivo()))
    		  										.and(DespesaCartaoSpecifications.dtDespesaBetween(despesaCartao.getFiltro().getDtDespesaInicio(), despesaCartao.getFiltro().getDtDespesaFim()))
    		  									    .and(DespesaCartaoSpecifications.fetchCategoria())
    		  									    .and(DespesaCartaoSpecifications.fetchSubcategoria())
    		  									    .and(DespesaCartaoSpecifications.fetchCartao())
                                                    .and(DespesaCartaoSpecifications.idUsuarioIgual(despesaCartao.getIdUsuario())), sort);
   }

}