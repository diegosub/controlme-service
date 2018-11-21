package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_transferencia_fixa", schema = "ngc")
@SequenceGenerator(name = "SQ_TRANSFERENCIA_FIXA", sequenceName = "SQ_TRANSFERENCIA_FIXA", allocationSize = 1)
@Proxy(lazy = true)
public class TransferenciaFixa implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRANSFERENCIA_FIXA")
   @Column(name = "id_transferencia_fixa")
   private BigInteger idTransferenciaFixa;

   @Column(name = "id_usuario")
   private BigInteger idUsuario;

   @Column(name = "id_conta_origem")
   private BigInteger idContaOrigem;

   @Column(name = "id_conta_destino")
   private BigInteger idContaDestino;

   @Column(name = "vl_transferencia")
   private Double vlTransferencia;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   @Column(name = "nr_dia")
   private Integer nrDia;

   @Column(name = "ds_observacao")
   private String dsObservacao;
   
   @Column(name = "fg_ativo")
   private Boolean fgAtivo;
   
   @Column(name = "dt_alteracao")
   private Date dtAlteracao;

   public BigInteger getIdTransferenciaFixa()
   {
      return idTransferenciaFixa;
   }

   public void setIdTransferenciaFixa(BigInteger idTransferenciaFixa)
   {
      this.idTransferenciaFixa = idTransferenciaFixa;
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

   public Integer getNrDia()
   {
      return nrDia;
   }

   public void setNrDia(Integer nrDia)
   {
      this.nrDia = nrDia;
   }

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
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
}