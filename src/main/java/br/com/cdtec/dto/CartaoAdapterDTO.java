package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class CartaoAdapterDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idCartaoAdapter;

   private List<CartaoDTO> listaCartao;

   public BigInteger getIdCartaoAdapter()
   {
      return idCartaoAdapter;
   }

   public void setIdCartaoAdapter(BigInteger idCartaoAdapter)
   {
      this.idCartaoAdapter = idCartaoAdapter;
   }

   public List<CartaoDTO> getListaCartao()
   {
      return listaCartao;
   }

   public void setListaCartao(List<CartaoDTO> listaCartao)
   {
      this.listaCartao = listaCartao;
   }

}