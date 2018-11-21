package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_movimentacao", schema = "ngc")
@SequenceGenerator(name = "SQ_MOVIMENTACAO", sequenceName = "SQ_MOVIMENTACAO", allocationSize = 1)
@NamedStoredProcedureQuery(
      name = "oi", 
      procedureName = "oi",
      parameters = {
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "vp_usuario", type = BigInteger.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "vp_data_movimentacao", type = Date.class)
      }
  )
@Proxy(lazy = true)
public class Movimentacao implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MOVIMENTACAO")
   @Column(name = "id_movimentacao")
   private BigInteger idMovimentacao;

   @Column(name = "id_usuario")
   private BigInteger idUsuario;
   
   @Column(name = "id_tipo_movimentacao")
   private Integer idTipoMovimentacao;

   @Column(name = "qt_entrada")
   private Double qtEntrada;
   
   @Column(name = "qt_saida")
   private Double qtSaida;
   
   @Column(name = "id_conta")
   private BigInteger idConta;

   @Temporal(TemporalType.DATE)
   @Column(name = "dt_movimentacao")
   private Date dtMovimentacao;
   
   @Column(name = "id_nsu_origem")
   private BigInteger idNsuOrigem;
   
   @Column(name = "id_origem")
   private BigInteger idOrigem;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   public BigInteger getIdMovimentacao()
   {
      return idMovimentacao;
   }

   public void setIdMovimentacao(BigInteger idMovimentacao)
   {
      this.idMovimentacao = idMovimentacao;
   }

   public BigInteger getIdUsuario()
   {
      return idUsuario;
   }

   public void setIdUsuario(BigInteger idUsuario)
   {
      this.idUsuario = idUsuario;
   }

   public Integer getIdTipoMovimentacao()
   {
      return idTipoMovimentacao;
   }

   public void setIdTipoMovimentacao(Integer idTipoMovimentacao)
   {
      this.idTipoMovimentacao = idTipoMovimentacao;
   }

   public Double getQtEntrada()
   {
      return qtEntrada;
   }

   public void setQtEntrada(Double qtEntrada)
   {
      this.qtEntrada = qtEntrada;
   }

   public Double getQtSaida()
   {
      return qtSaida;
   }

   public void setQtSaida(Double qtSaida)
   {
      this.qtSaida = qtSaida;
   }

   public BigInteger getIdConta()
   {
      return idConta;
   }

   public void setIdConta(BigInteger idConta)
   {
      this.idConta = idConta;
   }

   public Date getDtMovimentacao()
   {
      return dtMovimentacao;
   }

   public void setDtMovimentacao(Date dtMovimentacao)
   {
      this.dtMovimentacao = dtMovimentacao;
   }

   public BigInteger getIdNsuOrigem()
   {
      return idNsuOrigem;
   }

   public void setIdNsuOrigem(BigInteger idNsuOrigem)
   {
      this.idNsuOrigem = idNsuOrigem;
   }

   public BigInteger getIdOrigem()
   {
      return idOrigem;
   }

   public void setIdOrigem(BigInteger idOrigem)
   {
      this.idOrigem = idOrigem;
   }

   public Date getDtCadastro()
   {
      return dtCadastro;
   }

   public void setDtCadastro(Date dtCadastro)
   {
      this.dtCadastro = dtCadastro;
   }
}