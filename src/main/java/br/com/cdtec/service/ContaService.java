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
import br.com.cdtec.dao.repository.ContaRepository;
import br.com.cdtec.dao.specifications.ContaSpecifications;
import br.com.cdtec.entity.Conta;
import br.com.cdtec.util.DataCustom;

@Service
public class ContaService extends CrudService<Conta, BigInteger, ContaRepository>
{
   private static final long serialVersionUID = 1L;

   private final String fieldSort = "dsConta";

   @Autowired
   private MovimentacaoService movimentacaoService;

   public List<Conta> pesquisarInativos(Conta conta) throws Exception
   {
      List<Conta> lista = getRepository().findAll(Specification.where(ContaSpecifications.idUsuarioIgual(conta.getIdUsuario()))
            .and(ContaSpecifications.fgAtivoIgual(conta.getFgAtivo())), new Sort(Sort.Direction.ASC, getFieldSort()));
      return lista;
   }

   @Override
   public void validarInserir(Conta entity) throws Exception
   {
      Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsConta(), entity.getIdUsuario());

      if (quantidade != null && quantidade > 0)
      {
         throw new Exception("Já existe uma conta cadastrada com esta descrição.");
      }
   }

   @Override
   public void validarAlterar(Conta entity) throws Exception
   {
      Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsConta(), entity.getIdConta(), entity.getIdUsuario());

      if (quantidade != null && quantidade > 0)
      {
         throw new Exception("Já existe uma conta cadastrada com esta descrição.");
      }
   }

   @Override
   public void completarInserir(Conta entity) throws Exception
   {
      Integer quantidade = getRepository().quantidadePrincipal(entity.getIdUsuario());

      entity.setFgPrincipal(false);

      if (quantidade == 0)
      {
         entity.setFgPrincipal(true);
      }
   }

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   @Transactional
   public Conta inserir(Conta conta) throws Exception
   {
      validarInserir(conta);
      completarInserir(conta);

      // INSERINDO CONTA
      getRepository().save(conta);

      // REALIZANDO MOVIMENTACAO
      if (conta.getVlSaldo() > 0)
      {
         String dtMovimentacao = DataCustom.getDataSql(conta.getDtCadastro(), DataCustom.SQL_DATE);

         movimentacaoService.gerarMovimentacaoEntrada(conta.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_CREDITO_CRIACAO_CONTA,
               conta.getVlSaldo(), conta.getIdConta(), conta.getIdConta(), new BigInteger(String.valueOf(1)), dtMovimentacao, "I");

      }

      return conta;
   }

   @Override
   @Transactional
   public Conta alterar(Conta conta) throws Exception
   {
      validarAlterar(conta);
      completarAlterar(conta);

      // ALTERANDO CONTA
      getRepository().save(conta);

      // ALTERANDO MOVIMENTACAO
      String dtMovimentacao = DataCustom.getDataSql(conta.getDtCadastro(),
      DataCustom.SQL_DATE);
      
      movimentacaoService.gerarMovimentacaoEntrada(conta.getIdUsuario(), MovimentacaoService.TIPO_MOVIMENTACAO_CREDITO_CRIACAO_CONTA,
            conta.getVlSaldo(), conta.getIdConta(), conta.getIdConta(), new BigInteger(String.valueOf(1)), dtMovimentacao, "A");

      return conta;
   }

   @Transactional
   public Conta setarPrincipal(BigInteger idUsuario, BigInteger idConta) throws Exception
   {
      // RECUPERAR TODAS AS CONTAS COM FG_PRINCIPAL = TRUE
      Conta conta = new Conta();
      conta.setFgPrincipal(true);
      conta.setIdUsuario(idUsuario);

      List<Conta> lista = getRepository()
            .findAll(Specification.where(ContaSpecifications.fgPrincipalIgual(true).and(ContaSpecifications.idUsuarioIgual(idUsuario))));

      // ATUALIZAR CONTA PRINCIPAL ANTERIOR PARA FALSE
      for (Conta obj : lista)
      {
         obj.setFgPrincipal(false);
         alterar(obj);
      }

      // ATUALIZAR NOVA CONTA PARA TRUE

      Optional<Conta> optional = this.get(idConta);
      Conta objAtualiza = optional.get();
      objAtualiza.setFgPrincipal(true);
      objAtualiza.setDtAlteracao(new Date());

      alterar(objAtualiza);

      return objAtualiza;
   }

   @Override
   public List<Conta> implementarPesquisar(Conta conta, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(ContaSpecifications.fgAtivoIgual(conta.getFgAtivo()))
            .and(ContaSpecifications.idUsuarioIgual(conta.getIdUsuario())), sort);
   }

}