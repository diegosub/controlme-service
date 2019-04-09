package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class DespesaAgendamentoDetalheDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idDespesaAgd;

   private BigInteger idDespesaAgh;

   private Integer nrParcela;

   private Double vlParcela;

   private Date dtVencimento;

   private Boolean fgDespesaPaga;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   private BigInteger idDespesa;

   public BigInteger getIdDespesaAgd()
   {
      return idDespesaAgd;
   }

   public void setIdDespesaAgd(BigInteger idDespesaAgd)
   {
      this.idDespesaAgd = idDespesaAgd;
   }

   public BigInteger getIdDespesaAgh()
   {
      return idDespesaAgh;
   }

   public void setIdDespesaAgh(BigInteger idDespesaAgh)
   {
      this.idDespesaAgh = idDespesaAgh;
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

   public Date getDtVencimento()
   {
      return dtVencimento;
   }

   public void setDtVencimento(Date dtVencimento)
   {
      this.dtVencimento = dtVencimento;
   }

   public Boolean getFgDespesaPaga()
   {
      return fgDespesaPaga;
   }

   public void setFgDespesaPaga(Boolean fgDespesaPaga)
   {
      this.fgDespesaPaga = fgDespesaPaga;
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

   public BigInteger getIdDespesa()
   {
      return idDespesa;
   }

   public void setIdDespesa(BigInteger idDespesa)
   {
      this.idDespesa = idDespesa;
   }
}