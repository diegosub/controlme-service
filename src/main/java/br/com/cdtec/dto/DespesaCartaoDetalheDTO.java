package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import br.com.cdtec.entity.DespesaCartaoHeader;

public class DespesaCartaoDetalheDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idDespesaCcd;

   private BigInteger idDespesaCch;

   private DespesaCartaoHeader despesaCartaoHeader;

   private Integer nrParcela;

   private Double vlParcela;

   private Date dtReferencia;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   public BigInteger getIdDespesaCcd()
   {
      return idDespesaCcd;
   }

   public void setIdDespesaCcd(BigInteger idDespesaCcd)
   {
      this.idDespesaCcd = idDespesaCcd;
   }

   public BigInteger getIdDespesaCch()
   {
      return idDespesaCch;
   }

   public void setIdDespesaCch(BigInteger idDespesaCch)
   {
      this.idDespesaCch = idDespesaCch;
   }

   public DespesaCartaoHeader getDespesaCartaoHeader()
   {
      return despesaCartaoHeader;
   }

   public void setDespesaCartaoHeader(DespesaCartaoHeader despesaCartaoHeader)
   {
      this.despesaCartaoHeader = despesaCartaoHeader;
   }

   public Integer getNrParcela()
   {
      return nrParcela;
   }

   public void setNrParcela(Integer nrParcela)
   {
      this.nrParcela = nrParcela;
   }

   public Double getVlParcela()
   {
      return vlParcela;
   }

   public void setVlParcela(Double vlParcela)
   {
      this.vlParcela = vlParcela;
   }

   public Date getDtReferencia()
   {
      return dtReferencia;
   }

   public void setDtReferencia(Date dtReferencia)
   {
      this.dtReferencia = dtReferencia;
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