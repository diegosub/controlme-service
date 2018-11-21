package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class TransferenciaDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idTransferencia;

   private BigInteger idUsuario;

   private BigInteger idContaOrigem;

   private ContaDTO contaOrigem;

   private BigInteger idContaDestino;

   private ContaDTO contaDestino;

   private Double vlTransferencia;

   private String strVlTransferencia;

   private Date dtCadastro;

   private Date dtTransferencia;

   private String dsObservacao;

   private Integer nrDia;

   private Boolean fgAtivo;

   private Boolean fgTransferenciaFixa;

   private Date dtAlteracao;

   public BigInteger getIdTransferencia()
   {
      return idTransferencia;
   }

   public void setIdTransferencia(BigInteger idTransferencia)
   {
      this.idTransferencia = idTransferencia;
   }

   public BigInteger getIdUsuario()
   {
      return idUsuario;
   }

   public void setIdUsuario(BigInteger idUsuario)
   {
      this.idUsuario = idUsuario;
   }

   public BigInteger getIdContaOrigem()
   {
      return idContaOrigem;
   }

   public void setIdContaOrigem(BigInteger idContaOrigem)
   {
      this.idContaOrigem = idContaOrigem;
   }

   public BigInteger getIdContaDestino()
   {
      return idContaDestino;
   }

   public void setIdContaDestino(BigInteger idContaDestino)
   {
      this.idContaDestino = idContaDestino;
   }

   public Double getVlTransferencia()
   {
      return vlTransferencia;
   }

   public void setVlTransferencia(Double vlTransferencia)
   {
      this.vlTransferencia = vlTransferencia;
   }

   public Date getDtCadastro()
   {
      return dtCadastro;
   }

   public void setDtCadastro(Date dtCadastro)
   {
      this.dtCadastro = dtCadastro;
   }

   public Date getDtTransferencia()
   {
      return dtTransferencia;
   }

   public void setDtTransferencia(Date dtTransferencia)
   {
      this.dtTransferencia = dtTransferencia;
   }

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
   }

   public Integer getNrDia()
   {
      return nrDia;
   }

   public void setNrDia(Integer nrDia)
   {
      this.nrDia = nrDia;
   }

   public Boolean getFgAtivo()
   {
      return fgAtivo;
   }

   public void setFgAtivo(Boolean fgAtivo)
   {
      this.fgAtivo = fgAtivo;
   }

   public Date getDtAlteracao()
   {
      return dtAlteracao;
   }

   public void setDtAlteracao(Date dtAlteracao)
   {
      this.dtAlteracao = dtAlteracao;
   }

   public Boolean getFgTransferenciaFixa()
   {
      return fgTransferenciaFixa;
   }

   public void setFgTransferenciaFixa(Boolean fgTransferenciaFixa)
   {
      this.fgTransferenciaFixa = fgTransferenciaFixa;
   }

   public ContaDTO getContaOrigem()
   {
      return contaOrigem;
   }

   public void setContaOrigem(ContaDTO contaOrigem)
   {
      this.contaOrigem = contaOrigem;
   }

   public ContaDTO getContaDestino()
   {
      return contaDestino;
   }

   public void setContaDestino(ContaDTO contaDestino)
   {
      this.contaDestino = contaDestino;
   }

   public String getStrVlTransferencia()
   {
      return strVlTransferencia;
   }

   public void setStrVlTransferencia(String strVlTransferencia)
   {
      this.strVlTransferencia = strVlTransferencia;
   }

}