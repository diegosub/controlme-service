package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DespesaAgendamentoHeaderRepository;
import br.com.cdtec.dao.specifications.DespesaAgendamentoHeaderSpecifications;
import br.com.cdtec.entity.DespesaAgendamentoHeader;

@Service
public class DespesaAgendamentoHeaderService extends CrudService<DespesaAgendamentoHeader, BigInteger, DespesaAgendamentoHeaderRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idDespesaAgh";

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaAgendamentoHeader> implementarPesquisar(DespesaAgendamentoHeader despesaAgh, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DespesaAgendamentoHeaderSpecifications.fgAtivoIgual(despesaAgh.getFgAtivo()))
    		  									    .and(DespesaAgendamentoHeaderSpecifications.fetchCategoria())
    		  									    .and(DespesaAgendamentoHeaderSpecifications.fetchSubcategoria())    		  									    
                                                    .and(DespesaAgendamentoHeaderSpecifications.idUsuarioIgual(despesaAgh.getIdUsuario())), sort);
   }
   
//   @Override
//   @Transactional
//   public DespesaAgendamentoHeader inserir(DespesaAgendamentoHeader despesaAgh) throws Exception
//   {
//      validarInserir(despesaAgh);
//      completarInserir(despesaAgh);
//
//      // INSERINDO CONTA
//      getRepository().save(despesaAgh);
//
//      // REALIZANDO MOVIMENTACAO
//     
//
//      return despesa;
//   }
   
//   @Override
//   @Transactional
//   public Despesa alterar(Despesa despesa) throws Exception
//   {
//      validarAlterar(despesa);
//      completarAlterar(despesa);
//
//      // ALTERANDO TRANSFERENCIA
//      getRepository().save(despesa);
//
//      // ALTERANDO MOVIMENTACAO
//      String dtMovimentacao = DataCustom.getDataSql(despesa.getDtDespesa(),
//      DataCustom.SQL_DATE);
//      
//      movimentacaoService.alterarMovimentacaoSaida(despesa.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_DESPESA, despesa.getVlDespesa(),
//                                                           despesa.getIdConta() ,despesa.getIdDespesa(), new BigInteger(String.valueOf(3)), dtMovimentacao);
//
//      return despesa;
//   }
   
//   @Transactional
//   public void inativarDespesa(BigInteger idDespesa) throws Exception
//   {
//      movimentacaoService.excluirMovimentacaoSaida(idDespesa);
//      
//      Optional<Despesa> despesaOptional = this.get(idDespesa);
//      Despesa despesa = despesaOptional.get();
//      
//      despesa.setFgAtivo(false);
//      despesa.setDtAlteracao(new Date());
//      
//      getRepository().save(despesa);
//   }

}