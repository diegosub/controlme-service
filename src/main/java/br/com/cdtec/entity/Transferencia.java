package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import br.com.cdtec.entity.filter.FiltroTransferencia;

@Entity
@Table(name = "tb_transferencia", schema = "ngc")
@SequenceGenerator(name = "SQ_TRANSFERENCIA", sequenceName = "SQ_TRANSFERENCIA", allocationSize = 1)
@Proxy(lazy = true)
public class Transferencia implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRANSFERENCIA")
   @Column(name = "id_transferencia")
   private BigInteger idTransferencia;

   @Column(name = "id_usuario")
   private BigInteger idUsuario;

   @Column(name = "id_conta_origem")
   private BigInteger idContaOrigem;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_conta_origem", insertable = false, updatable = false)
   private Conta contaOrigem;

   @Column(name = "id_conta_destino")
   private BigInteger idContaDestino;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_conta_destino", insertable = false, updatable = false)
   private Conta contaDestino;

   @Column(name = "vl_transferencia")
   private Double vlTransferencia;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   @Column(name = "dt_transferencia")
   private Date dtTransferencia;

   @Column(name = "ds_observacao")
   private String dsObservacao;
   
   @Column(name = "dt_alteracao")
   private Date dtAlteracao;
   
   @Transient
   private FiltroTransferencia filtro;
   
   
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

   public Date getDtAlteracao()
   {
      return dtAlteracao;
   }

   public void setDtAlteracao(Date dtAlteracao)
   {
      this.dtAlteracao = dtAlteracao;
   }

   public Conta getContaOrigem()
   {
      return contaOrigem;
   }

   public void setContaOrigem(Conta contaOrigem)
   {
      this.contaOrigem = contaOrigem;
   }

   public Conta getContaDestino()
   {
      return contaDestino;
   }

   public void setContaDestino(Conta contaDestino)
   {
      this.contaDestino = contaDestino;
   }

   public FiltroTransferencia getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FiltroTransferencia filtro)
   {
      this.filtro = filtro;
   }
}