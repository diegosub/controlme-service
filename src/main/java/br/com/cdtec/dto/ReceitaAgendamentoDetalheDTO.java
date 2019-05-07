package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ReceitaAgendamentoDetalheDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idReceitaAgd;

   private BigInteger idReceitaAgh;

   private Integer nrParcela;

   private Double vlParcela;

   private Date dtVencimento;

   private Boolean fgReceitaPaga;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   private BigInteger idReceita;

   public BigInteger getIdReceitaAgd()
   {
      return idReceitaAgd;
   }

   public void setIdReceitaAgd(BigInteger idReceitaAgd)
   {
      this.idReceitaAgd = idReceitaAgd;
   }

   public BigInteger getIdReceitaAgh()
   {
      return idReceitaAgh;
   }

   public void setIdReceitaAgh(BigInteger idReceitaAgh)
   {
      this.idReceitaAgh = idReceitaAgh;
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

   public Boolean getFgReceitaPaga()
   {
      return fgReceitaPaga;
   }

   public void setFgReceitaPaga(Boolean fgReceitaPaga)
   {
      this.fgReceitaPaga = fgReceitaPaga;
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

   public BigInteger getIdReceita()
   {
      return idReceita;
   }

   public void setIdReceita(BigInteger idReceita)
   {
      this.idReceita = idReceita;
   }
}