package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class DespesaCartaoHeaderDTO implements Serializable
{

   private static final long serialVersionUID = 1L;

   private BigInteger idDespesaCch;

   private BigInteger idCategoria;

   private CategoriaDTO categoria;

   private BigInteger idSubcategoria;

   private SubcategoriaDTO subcategoria;

   private BigInteger idCartao;

   private CartaoDTO cartao;

   private Date dtDespesa;

   private Double vlDespesa;

   private String strVlDespesa;

   private String dsObservacao;

   private BigInteger idUsuario;

   private Integer nrParcelas;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   public BigInteger getIdDespesaCch()
   {
      return idDespesaCch;
   }

   public void setIdDespesaCch(BigInteger idDespesaCch)
   {
      this.idDespesaCch = idDespesaCch;
   }

   public BigInteger getIdCategoria()
   {
      return idCategoria;
   }

   public void setIdCategoria(BigInteger idCategoria)
   {
      this.idCategoria = idCategoria;
   }

   public CategoriaDTO getCategoria()
   {
      return categoria;
   }

   public void setCategoria(CategoriaDTO categoria)
   {
      this.categoria = categoria;
   }

   public BigInteger getIdSubcategoria()
   {
      return idSubcategoria;
   }

   public void setIdSubcategoria(BigInteger idSubcategoria)
   {
      this.idSubcategoria = idSubcategoria;
   }

   public SubcategoriaDTO getSubcategoria()
   {
      return subcategoria;
   }

   public void setSubcategoria(SubcategoriaDTO subcategoria)
   {
      this.subcategoria = subcategoria;
   }

   public BigInteger getIdCartao()
   {
      return idCartao;
   }

   public void setIdCartao(BigInteger idCartao)
   {
      this.idCartao = idCartao;
   }

   public CartaoDTO getCartao()
   {
      return cartao;
   }

   public void setCartao(CartaoDTO cartao)
   {
      this.cartao = cartao;
   }

   public Date getDtDespesa()
   {
      return dtDespesa;
   }

   public void setDtDespesa(Date dtDespesa)
   {
      this.dtDespesa = dtDespesa;
   }

   public Double getVlDespesa()
   {
      return vlDespesa;
   }

   public void setVlDespesa(Double vlDespesa)
   {
      this.vlDespesa = vlDespesa;
   }

   public String getStrVlDespesa()
   {
      return strVlDespesa;
   }

   public void setStrVlDespesa(String strVlDespesa)
   {
      this.strVlDespesa = strVlDespesa;
   }

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
   }

   public BigInteger getIdUsuario()
   {
      return idUsuario;
   }

   public void setIdUsuario(BigInteger idUsuario)
   {
      this.idUsuario = idUsuario;
   }

   public Boolean getFgAtivo()
   {
      return fgAtivo;
   }

   public void setFgAtivo(Boolean fgAtivo)
   {
      this.fgAtivo = fgAtivo;
   }

   public Date getDtCadastro()
   {
      return dtCadastro;
   }

   public void setDtCadastro(Date dtCadastro)
   {
      this.dtCadastro = dtCadastro;
   }

   public Date getDtAlteracao()
   {
      return dtAlteracao;
   }

   public void setDtAlteracao(Date dtAlteracao)
   {
      this.dtAlteracao = dtAlteracao;
   }

   public Integer getNrParcelas()
   {
      return nrParcelas;
   }

   public void setNrParcelas(Integer nrParcelas)
   {
      this.nrParcelas = nrParcelas;
   }
}