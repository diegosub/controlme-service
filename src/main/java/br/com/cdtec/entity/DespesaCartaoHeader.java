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

import br.com.cdtec.entity.filter.FiltroDespesaCartao;

@Entity
@Table(name = "tb_despesa_cch", schema = "ngc")
@SequenceGenerator(name = "SQ_DESPESA_CCH", sequenceName = "SQ_DESPESA_CCH", allocationSize = 1)
@Proxy(lazy = true)
public class DespesaCartaoHeader implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESPESA_CCH")
   @Column(name = "id_despesa_cch")
   private BigInteger idDespesaCch;

   @Column(name = "id_categoria")
   private BigInteger idCategoria;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
   private Categoria categoria;

   @Column(name = "id_subcategoria")
   private BigInteger idSubcategoria;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_subcategoria", insertable = false, updatable = false)
   private Subcategoria subcategoria;

   @Column(name = "id_cartao")
   private BigInteger idCartao;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_cartao", insertable = false, updatable = false)
   private Cartao cartao;

   @Column(name = "dt_despesa")
   private Date dtDespesa;

   @Column(name = "vl_despesa")
   private Double vlDespesa;

   @Column(name = "ds_observacao")
   private String dsObservacao;

   @Column(name = "nr_parcelas")
   private Integer nrParcelas;

   @Column(name = "id_usuario")
   private BigInteger idUsuario;

   @Column(name = "fg_ativo")
   private Boolean fgAtivo;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_alteracao")
   private Date dtAlteracao;

   @Transient
   private FiltroDespesaCartao filtro;

   public BigInteger getIdDespesaCch()
   {
      return idDespesaCch;
   }

   public void setIdDespesaCch(BigInteger idDespesaCch)
   {
      this.idDespesaCch = idDespesaCch;
   }

   public BigInteger getIdCategoria()
   {
      return idCategoria;
   }

   public void setIdCategoria(BigInteger idCategoria)
   {
      this.idCategoria = idCategoria;
   }

   public Categoria getCategoria()
   {
      return categoria;
   }

   public void setCategoria(Categoria categoria)
   {
      this.categoria = categoria;
   }

   public BigInteger getIdSubcategoria()
   {
      return idSubcategoria;
   }

   public void setIdSubcategoria(BigInteger idSubcategoria)
   {
      this.idSubcategoria = idSubcategoria;
   }

   public Subcategoria getSubcategoria()
   {
      return subcategoria;
   }

   public void setSubcategoria(Subcategoria subcategoria)
   {
      this.subcategoria = subcategoria;
   }

   public BigInteger getIdCartao()
   {
      return idCartao;
   }

   public void setIdCartao(BigInteger idCartao)
   {
      this.idCartao = idCartao;
   }

   public Cartao getCartao()
   {
      return cartao;
   }

   public void setCartao(Cartao cartao)
   {
      this.cartao = cartao;
   }

   public Date getDtDespesa()
   {
      return dtDespesa;
   }

   public void setDtDespesa(Date dtDespesa)
   {
      this.dtDespesa = dtDespesa;
   }

   public Double getVlDespesa()
   {
      return vlDespesa;
   }

   public void setVlDespesa(Double vlDespesa)
   {
      this.vlDespesa = vlDespesa;
   }

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
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

   public FiltroDespesaCartao getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FiltroDespesaCartao filtro)
   {
      this.filtro = filtro;
   }

   public Integer getNrParcelas()
   {
      return nrParcelas;
   }

   public void setNrParcelas(Integer nrParcelas)
   {
      this.nrParcelas = nrParcelas;
   }
}