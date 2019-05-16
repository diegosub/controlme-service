package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "vw_divida", schema = "ngc")
@Proxy(lazy = true)
public class Divida implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id_divida")
   private String idDivida;

   @Column(name = "ds_despesa")
   private String dsDespesa;
  
   @Column(name = "dt_vencimento")
   private Date dtVencimento;
   
   @Column(name = "nr_dia_vencimento")
   private Integer nrDiaVencimento;
   
   @Column(name = "nr_mes_vencimento")
   private Integer nrMesVencimento;
   
   @Column(name = "nr_ano_vencimento")
   private Integer nrAnoVencimento;
   
   @Column(name = "vl_despesa")
   private Double vlDespesa;
   
   @Column(name = "id_usuario")
   private BigInteger idUsuario;

   @Column(name = "fg_despesa_paga")
   private Boolean fgDespesaPaga;
   
   @Column(name = "fg_pode_pagar")
   private Boolean fgPodePagar;
   
   @Column(name = "nr_dia_diferenca")
   private String nrDiaDiferenca;
   
   @Column(name = "ds_tipo")
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