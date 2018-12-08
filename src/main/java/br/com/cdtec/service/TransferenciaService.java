package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.TransferenciaRepository;
import br.com.cdtec.dao.specifications.TransferenciaSpecifications;
import br.com.cdtec.entity.Transferencia;
import br.com.cdtec.util.DataCustom;

@Service
public class TransferenciaService extends CrudService<Transferencia, BigInteger, TransferenciaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idTransferencia";
   
   @Autowired
   private MovimentacaoService movimentacaoService;

   public String getFieldSort()
   {
      return fieldSort;
   }
   
   @Override
   @Transactional
   public Transferencia inserir(Transferencia transferencia) throws Exception
   {
      validarInserir(transferencia);
      completarInserir(transferencia);
      
      // INSERINDO CONTA
      getRepository().save(transferencia);
      
      // REALIZANDO MOVIMENTACAO
      String dtMovimentacao = DataCustom.getDataSql(transferencia.getDtTransferencia(), DataCustom.SQL_DATE);
         
      movimentacaoService.gerarMovimentacaoTransferencia(transferencia.getIdUsuario(), transferencia.getVlTransferencia(), 
                                                   transferencia.getIdContaOrigem(), transferencia.getIdContaDestino(), transferencia.getIdTransferencia(),
                                                   new BigInteger(String.valueOf(2)), dtMovimentacao);
         
    
      
      return transferencia;
   }

   @Transactional
   public void excluirDefinitivamente(BigInteger idTransferencia) throws Exception
   {
      movimentacaoService.excluirMovimentacaoTransferencia(idTransferencia);
   }
   
   @Override
   @Transactional
   public Transferencia alterar(Transferencia transferencia) throws Exception
   {
      validarAlterar(transferencia);
      completarAlterar(transferencia);

      // ALTERANDO TRANSFERENCIA
      getRepository().save(transferencia);

      // ALTERANDO MOVIMENTACAO
      String dtMovimentacao = DataCustom.getDataSql(transferencia.getDtTransferencia(),
      DataCustom.SQL_DATE);
      
      movimentacaoService.alterarMovimentacaoTransferencia(transferencia.getIdUsuario(), transferencia.getVlTransferencia(),
                                                           transferencia.getIdContaOrigem(), transferencia.getIdContaDestino(), 
                                                           transferencia.getIdTransferencia(), new BigInteger(String.valueOf(2)), dtMovimentacao);

      return transferencia;
   }
   
   
   
   @Override
   public List<Transferencia> implementarPesquisar(Transferencia transferencia, Sort sort) throws Exception
   {
      List<Transferencia> lista = getRepository().findAll(Specification.where(TransferenciaSpecifications.idUsuarioIgual(transferencia.getIdUsuario()))
                                                                         .and(TransferenciaSpecifications.dtTransferenciaBetween(transferencia.getFiltro().getDtTransferenciaInicio(), transferencia.getFiltro().getDtTransferenciaFim()))
                                                                         .and(TransferenciaSpecifications.fetchContaOrigem())
                                                                         .and(TransferenciaSpecifications.fetchContaDestino()), sort);
      
      return lista;
   }

}