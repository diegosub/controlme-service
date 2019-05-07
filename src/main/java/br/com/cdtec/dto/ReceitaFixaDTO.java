package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ReceitaFixaDTO implements Serializable
{

   private static final long serialVersionUID = 1L;

   private BigInteger idReceitaFixa;

   private String dsReceitaFixa;

   private Integer nrDiaReceita;

   private Double vlReceita;

   private BigInteger idCategoria;

   private CategoriaDTO categoria;

   private BigInteger idSubcategoria;

   private SubcategoriaDTO subcategoria;

   private String dsObservacao;

   private BigInteger idUsuario;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   public BigInteger getIdReceitaFixa()
   {
      return idReceitaFixa;
   }

   public void setIdReceitaFixa(BigInteger idReceitaFixa)
   {
      this.idReceitaFixa = idReceitaFixa;
   }

   public String getDsReceitaFixa()
   {
      return dsReceitaFixa;
   }

   public void setDsReceitaFixa(String dsReceitaFixa)
   {
      this.dsReceitaFixa = dsReceitaFixa;
   }

   public Integer getNrDiaReceita()
   {
      return nrDiaReceita;
   }

   public void setNrDiaReceita(Integer nrDiaReceita)
   {
      this.nrDiaReceita = nrDiaReceita;
   }

   public Double getVlReceita()
   {
      return vlReceita;
   }

   public void setVlReceita(Double vlReceita)
   {
      this.vlReceita = vlReceita;
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
}