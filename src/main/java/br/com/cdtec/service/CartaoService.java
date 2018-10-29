package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.CartaoRepository;
import br.com.cdtec.dao.specifications.CartaoSpecifications;
import br.com.cdtec.entity.Cartao;

@Service
public class CartaoService extends CrudService<Cartao, BigInteger, CartaoRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "dsCartao";

   public List<Cartao> pesquisarInativos(Cartao cartao) throws Exception
   {
       List<Cartao> lista = getRepository().findAll(Specification.where(CartaoSpecifications.idUsuarioIgual(cartao.getIdUsuario()))
                                                                   .and(CartaoSpecifications.fgAtivoIgual(cartao.getFgAtivo())), new Sort(Sort.Direction.ASC, getFieldSort()));
       return lista;
   }
   
   @Override
   public void completarInserir(Cartao entity) throws Exception
   {
      Integer quantidade = getRepository().quantidadePrincipal(entity.getIdUsuario());

      entity.setFgPrincipal(false);

      if (quantidade == 0)
      {
         entity.setFgPrincipal(true);
      }
   }

   @Override
   public void validarInserir(Cartao entity) throws Exception
   {
      Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsCartao(), entity.getIdUsuario());

      if (quantidade != null && quantidade > 0)
      {
         throw new Exception("Já existe um cartão cadastrado com esta descrição.");
      }
   }

   @Override
   public void validarAlterar(Cartao entity) throws Exception
   {
      Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsCartao(), entity.getIdCartao(), entity.getIdUsuario());

      if (quantidade != null && quantidade > 0)
      {
         throw new Exception("Já existe um cartão cadastrado com esta descrição.");
      }
   }

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Transactional
   public Cartao setarPrincipal(BigInteger idUsuario, BigInteger idCartao) throws Exception
   {
      // RECUPERAR TODOS OS CARTOES COM FG_PRINCIPAL = TRUE
      Cartao cartao = new Cartao();
      cartao.setFgPrincipal(true);
      cartao.setIdUsuario(idUsuario);

      List<Cartao> lista = getRepository().findAll(Specification.where(CartaoSpecifications.fgPrincipalIgual(true)
                                                                  .and(CartaoSpecifications.idUsuarioIgual(idUsuario))));

      //ATUALIZAR CARTAO PRINCIPAL ANTERIOR PARA FALSE
      for (Cartao obj : lista)
      {
         obj.setFgPrincipal(false);
         alterar(obj);
      }
      
      //ATUALIZAR NOVO CARTAO PARA TRUE
    
      Optional<Cartao> optional = this.get(idCartao);
      Cartao objAtualiza = optional.get();
      objAtualiza.setFgPrincipal(true);
      objAtualiza.setDtAlteracao(new Date());
      
      alterar(objAtualiza);

      return objAtualiza;
   }

   @Override
   public List<Cartao> implementarPesquisar(Cartao cartao, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(CartaoSpecifications.fgAtivoIgual(cartao.getFgAtivo()))
                                                    .and(CartaoSpecifications.idUsuarioIgual(cartao.getIdUsuario())), sort);
   }

}