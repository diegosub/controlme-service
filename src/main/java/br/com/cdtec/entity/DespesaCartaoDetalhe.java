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

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_despesa_ccd", schema = "ngc")
@SequenceGenerator(name = "SQ_DESPESA_CCD", sequenceName = "SQ_DESPESA_CCD", allocationSize = 1)
@Proxy(lazy = true)
public class DespesaCartaoDetalhe implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESPESA_CCD")
   @Column(name = "id_despesa_ccd")
   private BigInteger idDespesaCcd;

   @Column(name = "id_despesa_cch")
   private BigInteger idDespesaCch;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_despesa_cch", insertable = false, updatable = false)
   private DespesaCartaoHeader despesaCartaoHeader;

   @Column(name = "nr_parcela")
   private Integer nrParcela;

   @Column(name = "vl_parcela")
   private Double vlParcela;

   @Column(name = "dt_vencimento")
   private Date dtVencimento;

   @Column(name = "fg_ativo")
   private Boolean fgAtivo;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_alteracao")
   private Date dtAlteracao;

   public BigInteger getIdDespesaCcd()
   {
      return idDespesaCcd;
   }

   public void setIdDespesaCcd(BigInteger idDespesaCcd)
   {
      this.idDespesaCcd = idDespesaCcd;
   }

   public BigInteger getIdDespesaCch()
   {
      return idDespesaCch;
   }

   public void setIdDespesaCch(BigInteger idDespesaCch)
   {
      this.idDespesaCch = idDespesaCch;
   }

   public DespesaCartaoHeader getDespesaCartaoHeader()
   {
      return despesaCartaoHeader;
   }

   public void setDespesaCartaoHeader(DespesaCartaoHeader despesaCartaoHeader)
   {
      this.despesaCartaoHeader = despesaCartaoHeader;
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
}