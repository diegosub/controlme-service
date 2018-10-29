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
@Table(name = "tb_conta", schema = "ngc")
@SequenceGenerator(name = "SQ_CONTA", sequenceName = "SQ_CONTA", allocationSize = 1)
@Proxy(lazy = true)
public class Conta implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTA")
   @Column(name = "id_conta")
   private BigInteger idConta;

   @Column(name = "ds_conta")
   private String dsConta;

   @Column(name = "id_tipo_conta")
   private BigInteger idTipoConta;

   @Column(name = "vl_saldo")
   private Double vlSaldo;

   @Column(name = "id_usuario")
   private BigInteger idUsuario;

   @Column(name = "fg_ativo")
   private Boolean fgAtivo;

   @Column(name = "fg_principal")
   private Boolean fgPrincipal;
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_alteracao")
   private Date dtAlteracao;

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

   public BigInteger getIdTipoConta()
   {
      return idTipoConta;
   }

   public void setIdTipoConta(BigInteger idTipoConta)
   {
      this.idTipoConta = idTipoConta;
   }

   public Double getVlSaldo()
   {
      return vlSaldo;
   }

   public void setVlSaldo(Double vlSaldo)
   {
      this.vlSaldo = vlSaldo;
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

   public Boolean getFgPrincipal()
   {
      return fgPrincipal;
   }

   public void setFgPrincipal(Boolean fgPrincipal)
   {
      this.fgPrincipal = fgPrincipal;
   }
}