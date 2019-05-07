package br.com.cdtec.service;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.MovimentacaoRepository;
import br.com.cdtec.entity.Movimentacao;

@Service
public class MovimentacaoService extends CrudService<Movimentacao, BigInteger, MovimentacaoRepository>
{
   @PersistenceContext
   private EntityManager em;

   private static final long serialVersionUID = 1L;

   public static final int TIPO_MOVIMENTACAO_CREDITO_CRIACAO_CONTA = 1;
   public static final int TIPO_MOVIMENTACAO_RECEITA = 4;
   public static final int TIPO_MOVIMENTACAO_DESPESA = 5;
   

   /**
    * Metodo que chama a rotina para gerar uma movimentacao de entrada
    * @param idUsuario
    * @param idTipoMovimentacao
    * @param qtEntrada
    * @param idConta
    * @param idNsuOrigem
    * @param idOrigem
    * @param dtMovimentacao
    * @throws Exception
    */
   @Transactional
   public void gerarMovimentacaoEntrada(BigInteger idUsuario, Integer idTipoMovimentacao, Double qtEntrada, BigInteger idConta,
                                        BigInteger idNsuOrigem, BigInteger idOrigem, String dtMovimentacao) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.gerar_movimentacao_entrada("
                      + idUsuario+ ", "
                      + idTipoMovimentacao+ ", "
                      + qtEntrada+ ", "
                      + idConta+ ", "
                      + idNsuOrigem+ ", "
                      + idOrigem+ ", "
                      + dtMovimentacao+ ")";

      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para gerar uma movimentacao de saida
    * @param idUsuario
    * @param idTipoMovimentacao
    * @param qtSaida
    * @param idConta
    * @param idNsuOrigem
    * @param idOrigem
    * @param dtMovimentacao
    * @throws Exception
    */
   @Transactional
   public void gerarMovimentacaoSaida(BigInteger idUsuario, Integer idTipoMovimentacao, Double qtSaida, BigInteger idConta,
                                        BigInteger idNsuOrigem, BigInteger idOrigem, String dtMovimentacao) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.gerar_movimentacao_saida("
                      + idUsuario+ ", "
                      + idTipoMovimentacao+ ", "
                      + qtSaida+ ", "
                      + idConta+ ", "
                      + idNsuOrigem+ ", "
                      + idOrigem+ ", "
                      + dtMovimentacao
                      + ")";

      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para gerar uma movimentacao de transferencia
    * @param idUsuario
    * @param vlTransferencia
    * @param idContaOrigem
    * @param idContaDestino
    * @param idNsuOrigem
    * @param idOrigem
    * @param dtMovimentacao
    * @throws Exception
    */
   @Transactional
   public void gerarMovimentacaoTransferencia(BigInteger idUsuario, Double vlTransferencia, BigInteger idContaOrigem, BigInteger idContaDestino,
                                        BigInteger idNsuOrigem, BigInteger idOrigem, String dtMovimentacao) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.gerar_movimentacao_transferencia("
                      + idUsuario + ", "
                      + vlTransferencia + ", "
                      + idContaOrigem + ", "
                      + idContaDestino + ", "
                      + idNsuOrigem + ", "
                      + idOrigem + ", "
                      + dtMovimentacao
                      + ")";

      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para alterar uma movimentacao de transferencia
    * @param idUsuario
    * @param vlTransferencia
    * @param idContaOrigem
    * @param idContaDestino
    * @param idNsuOrigem
    * @param idOrigem
    * @param dtMovimentacao
    * @throws Exception
    */
   @Transactional
   public void alterarMovimentacaoTransferencia(BigInteger idUsuario, Double vlTransferencia, BigInteger idContaOrigem, BigInteger idContaDestino,
                                        BigInteger idNsuOrigem, BigInteger idOrigem, String dtMovimentacao) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.alterar_movimentacao_transferencia("
                      + idUsuario + ", "
                      + vlTransferencia + ", "
                      + idContaOrigem + ", "
                      + idContaDestino + ", "
                      + idNsuOrigem + ", "
                      + idOrigem + ", "
                      + dtMovimentacao
                      + ")";

      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para alterar uma movimentacao de saida
    * @param idUsuario
    * @param idTipoMovimentacao
    * @param vlDespesa
    * @param idConta
    * @param idNsuOrigem
    * @param idOrigem
    * @param dtMovimentacao
    * @throws Exception
    */
   @Transactional
   public void alterarMovimentacaoSaida(BigInteger idUsuario, Integer idTipoMovimentacao, Double vlDespesa, BigInteger idConta,
                                        BigInteger idNsuOrigem, BigInteger idOrigem, String dtMovimentacao) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.alterar_movimentacao_saida("
                      + idUsuario + ", "
                      + idTipoMovimentacao + ", "
                      + vlDespesa + ", "
                      + idConta + ", "
                      + idNsuOrigem + ", "
                      + idOrigem + ", "
                      + dtMovimentacao
                      + ")";

      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para alterar uma movimentacao de entrada
    * @param idUsuario
    * @param idTipoMovimentacao
    * @param vlReceita
    * @param idConta
    * @param idNsuOrigem
    * @param idOrigem
    * @param dtMovimentacao
    * @throws Exception
    */
   @Transactional
   public void alterarMovimentacaoEntrada(BigInteger idUsuario, Integer idTipoMovimentacao, Double vlReceita, BigInteger idConta,
                                        BigInteger idNsuOrigem, BigInteger idOrigem, String dtMovimentacao) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.alterar_movimentacao_entrada("
                      + idUsuario + ", "
                      + idTipoMovimentacao + ", "
                      + vlReceita + ", "
                      + idConta + ", "
                      + idNsuOrigem + ", "
                      + idOrigem + ", "
                      + dtMovimentacao
                      + ")";

      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para excluir definitivamente uma movimentacao de transferencia
    * @param idTransferencia
    * @throws Exception
    */
   @Transactional
   public void excluirMovimentacaoTransferencia(BigInteger idTransferencia) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.excluir_movimentacao_transferencia(" + idTransferencia + ")";
      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para inativar uma despesa (este metodo chama a rotina que deleta o registro da movimentacao e volta o saldo da conta)
    * @param idDespesa
    * @throws Exception
    */
   @Transactional
   public void excluirMovimentacaoSaida(BigInteger idDespesa) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.excluir_movimentacao_saida(" + idDespesa + ")";
      super.executeComando(sessao, cmdSql);

   }
   
   /**
    * Metodo que chama a rotina para inativar uma receita (este metodo chama a rotina que deleta o registro da movimentacao e volta o saldo da conta)
    * @param idReceita
    * @throws Exception
    */
   @Transactional
   public void excluirMovimentacaoEntrada(BigInteger idReceita) throws Exception
   {
      Session sessao = this.em.unwrap(Session.class);
      sessao.flush();
      
      String cmdSql = "ngc.excluir_movimentacao_entrada(" + idReceita + ")";
      super.executeComando(sessao, cmdSql);
   }
   
}