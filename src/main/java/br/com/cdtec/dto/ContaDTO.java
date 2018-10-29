package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ContaDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idConta;

   private String dsConta;

   private Double vlSaldo;
   
   private BigInteger idTipoConta;
   
   private BigInteger idUsuario;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;
   
   private String fgControle;
   
   private Boolean fgPrincipal;
   
   private String strVlSaldo;


   public BigInteger getIdConta()
   {
      return idConta;
   }

   public void setIdConta(BigInteger idConta)
   {
      this.idConta = idConta;
   }

   public String getDsConta()
   {
      return dsConta;
   }

   public void setDsConta(String dsConta)
   {
      this.dsConta = dsConta;
   }

   public Double getVlSaldo()
   {
      return vlSaldo;
   }

   public void setVlSaldo(Double vlSaldo)
   {
      this.vlSaldo = vlSaldo;
   }

   public BigInteger getIdTipoConta()
   {
      return idTipoConta;
   }

   public void setIdTipoConta(BigInteger idTipoConta)
   {
      this.idTipoConta = idTipoConta;
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

   public String getFgControle()
   {
      return fgControle;
   }

   public void setFgControle(String fgControle)
   {
      this.fgControle = fgControle;
   }

   public Boolean getFgPrincipal()
   {
      return fgPrincipal;
   }

   public void setFgPrincipal(Boolean fgPrincipal)
   {
      this.fgPrincipal = fgPrincipal;
   }

   public String getStrVlSaldo()
   {
      return strVlSaldo;
   }

   public void setStrVlSaldo(String strVlSaldo)
   {
      this.strVlSaldo = strVlSaldo;
   }
}