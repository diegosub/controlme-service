package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.ReceitaRepository;
import br.com.cdtec.dao.specifications.ReceitaSpecifications;
import br.com.cdtec.entity.Receita;
import br.com.cdtec.util.DataCustom;

@Service
public class ReceitaService extends CrudService<Receita, BigInteger, ReceitaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idReceita";
   
   @Autowired
   private MovimentacaoService movimentacaoService;

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<Receita> implementarPesquisar(Receita receita, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(ReceitaSpecifications.fgAtivoIgual(receita.getFgAtivo()))
    		  										.and(ReceitaSpecifications.dtDespesaBetween(receita.getFiltro().getDtReceitaInicio(), receita.getFiltro().getDtReceitaFim()))
    		  									    .and(ReceitaSpecifications.fetchCategoria())
    		  									    .and(ReceitaSpecifications.fetchSubcategoria())
    		  									    .and(ReceitaSpecifications.fetchConta())
                                                    .and(ReceitaSpecifications.idUsuarioIgual(receita.getIdUsuario())), sort);
   }
   
   @Override
   @Transactional
   public Receita inserir(Receita receita) throws Exception
   {
      validarInserir(receita);
      completarInserir(receita);

      // INSERINDO CONTA
      getRepository().save(receita);

      // REALIZANDO MOVIMENTACAO
      if (receita.getVlReceita() > 0)
      {
         String dtMovimentacao = DataCustom.getDataSql(receita.getDtReceita(), DataCustom.SQL_DATE);

         movimentacaoService.gerarMovimentacaoEntrada(receita.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_RECEITA,
               receita.getVlReceita(), receita.getIdConta(), receita.getIdReceita(), new BigInteger(String.valueOf(4)), dtMovimentacao);

      }

      return receita;
   }
   
   @Override
   @Transactional
   public Receita alterar(Receita receita) throws Exception
   {
      validarAlterar(receita);
      completarAlterar(receita);

      // ALTERANDO TRANSFERENCIA
      getRepository().save(receita);

      // ALTERANDO MOVIMENTACAO
      String dtMovimentacao = DataCustom.getDataSql(receita.getDtReceita(), DataCustom.SQL_DATE);
      
      movimentacaoService.alterarMovimentacaoEntrada(receita.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_RECEITA, receita.getVlReceita(),
                                                           receita.getIdConta() ,receita.getIdReceita(), new BigInteger(String.valueOf(4)), dtMovimentacao);

      return receita;
   }
   
   @Transactional
   public void inativarReceita(BigInteger idReceita) throws Exception
   {
      movimentacaoService.excluirMovimentacaoEntrada(idReceita);
      
      Optional<Receita> receitaOptional = this.get(idReceita);
      Receita receita = receitaOptional.get();
      
      receita.setFgAtivo(false);
      receita.setDtAlteracao(new Date());
      
      getRepository().save(receita);
   }

}