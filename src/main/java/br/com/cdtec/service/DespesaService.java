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
import br.com.cdtec.dao.repository.DespesaRepository;
import br.com.cdtec.dao.specifications.DespesaSpecifications;
import br.com.cdtec.entity.Despesa;
import br.com.cdtec.util.DataCustom;

@Service
public class DespesaService extends CrudService<Despesa, BigInteger, DespesaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idDespesa";
   
   @Autowired
   private MovimentacaoService movimentacaoService;

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<Despesa> implementarPesquisar(Despesa despesa, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DespesaSpecifications.fgAtivoIgual(despesa.getFgAtivo()))
    		  										.and(DespesaSpecifications.dtDespesaBetween(despesa.getFiltro().getDtDespesaInicio(), despesa.getFiltro().getDtDespesaFim()))
    		  									    .and(DespesaSpecifications.fetchCategoria())
    		  									    .and(DespesaSpecifications.fetchSubcategoria())
    		  									    .and(DespesaSpecifications.fetchConta())
                                                    .and(DespesaSpecifications.idUsuarioIgual(despesa.getIdUsuario())), sort);
   }
   
   @Override
   @Transactional
   public Despesa inserir(Despesa despesa) throws Exception
   {
      validarInserir(despesa);
      completarInserir(despesa);

      // INSERINDO CONTA
      getRepository().save(despesa);

      // REALIZANDO MOVIMENTACAO
      if (despesa.getVlDespesa() > 0)
      {
         String dtMovimentacao = DataCustom.getDataSql(despesa.getDtDespesa(), DataCustom.SQL_DATE);

         movimentacaoService.gerarMovimentacaoSaida(despesa.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_DESPESA,
               despesa.getVlDespesa(), despesa.getIdConta(), despesa.getIdDespesa(), new BigInteger(String.valueOf(3)), dtMovimentacao);

      }

      return despesa;
   }
   
   @Override
   @Transactional
   public Despesa alterar(Despesa despesa) throws Exception
   {
      validarAlterar(despesa);
      completarAlterar(despesa);

      // ALTERANDO TRANSFERENCIA
      getRepository().save(despesa);

      // ALTERANDO MOVIMENTACAO
      String dtMovimentacao = DataCustom.getDataSql(despesa.getDtDespesa(),
      DataCustom.SQL_DATE);
      
      movimentacaoService.alterarMovimentacaoSaida(despesa.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_DESPESA, despesa.getVlDespesa(),
                                                           despesa.getIdConta() ,despesa.getIdDespesa(), new BigInteger(String.valueOf(3)), dtMovimentacao);

      return despesa;
   }
   
   @Transactional
   public void inativarDespesa(BigInteger idDespesa) throws Exception
   {
      movimentacaoService.excluirMovimentacaoSaida(idDespesa);
      
      Optional<Despesa> despesaOptional = this.get(idDespesa);
      Despesa despesa = despesaOptional.get();
      
      despesa.setFgAtivo(false);
      despesa.setDtAlteracao(new Date());
      
      getRepository().save(despesa);
   }

}