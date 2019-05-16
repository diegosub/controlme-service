package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class DividaDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private String idDivida;

   private String dsDespesa;
  
   private Date dtVencimento;
   
   private Integer nrDiaVencimento;
   
   private Integer nrMesVencimento;
   
   private Integer nrAnoVencimento;
   
   private Double vlDespesa;
   
   private BigInteger idUsuario;

   private Boolean fgDespesaPaga;
   
   private Boolean fgPodePagar;
   
   private String nrDiaDiferenca;
   
   private String dsTipo;

   public String getIdDivida()
   {
      return idDivida;
   }

   public void setIdDivida(String idDivida)
   {
      this.idDivida = idDivida;
   }

   public String getDsDespesa()
   {
      return dsDespesa;
   }

   public void setDsDespesa(String dsDespesa)
   {
      this.dsDespesa = dsDespesa;
   }

   public Date getDtVencimento()
   {
      return dtVencimento;
   }

   public void setDtVencimento(Date dtVencimento)
   {
      this.dtVencimento = dtVencimento;
   }

   public Integer getNrDiaVencimento()
   {
      return nrDiaVencimento;
   }

   public void setNrDiaVencimento(Integer nrDiaVencimento)
   {
      this.nrDiaVencimento = nrDiaVencimento;
   }

   public Integer getNrMesVencimento()
   {
      return nrMesVencimento;
   }

   public void setNrMesVencimento(Integer nrMesVencimento)
   {
      this.nrMesVencimento = nrMesVencimento;
   }

   public Integer getNrAnoVencimento()
   {
      return nrAnoVencimento;
   }

   public void setNrAnoVencimento(Integer nrAnoVencimento)
   {
      this.nrAnoVencimento = nrAnoVencimento;
   }

   public Double getVlDespesa()
   {
      return vlDespesa;
   }

   public void setVlDespesa(Double vlDespesa)
   {
      this.vlDespesa = vlDespesa;
   }

   public BigInteger getIdUsuario()
   {
      return idUsuario;
   }

   public void setIdUsuario(BigInteger idUsuario)
   {
      this.idUsuario = idUsuario;
   }

   public Boolean getFgDespesaPaga()
   {
      return fgDespesaPaga;
   }

   public void setFgDespesaPaga(Boolean fgDespesaPaga)
   {
      this.fgDespesaPaga = fgDespesaPaga;
   }

   public Boolean getFgPodePagar()
   {
      return fgPodePagar;
   }

   public void setFgPodePagar(Boolean fgPodePagar)
   {
      this.fgPodePagar = fgPodePagar;
   }

   public String getNrDiaDiferenca()
   {
      return nrDiaDiferenca;
   }

   public void setNrDiaDiferenca(String nrDiaDiferenca)
   {
      this.nrDiaDiferenca = nrDiaDiferenca;
   }

   public String getDsTipo()
   {
      return dsTipo;
   }

   public void setDsTipo(String dsTipo)
   {
      this.dsTipo = dsTipo;
   }
}