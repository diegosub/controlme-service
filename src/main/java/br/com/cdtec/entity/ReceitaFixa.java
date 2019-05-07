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
@Table(name = "tb_receita_fixa", schema = "ngc")
@SequenceGenerator(name = "SQ_RECEITA_FIXA", sequenceName = "SQ_RECEITA_FIXA", allocationSize = 1)
@Proxy(lazy = true)
public class ReceitaFixa implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECEITA_FIXA")
   @Column(name = "id_receita_fixa")
   private BigInteger idReceitaFixa;

   @Column(name = "ds_receita_fixa")
   private String dsReceitaFixa;

   @Column(name = "nr_dia_receita")
   private Integer nrDiaReceita;

   @Column(name = "vl_receita")
   private Double vlReceita;

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

   @Column(name = "ds_observacao")
   private String dsObservacao;

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

   public BigInteger getIdReceitaFixa()
   {
      return idReceitaFixa;
   }

   public void setIdReceitaFixa(BigInteger idReceitaFixa)
   {
      this.idReceitaFixa = idReceitaFixa;
   }

   public String getDsReceitaFixa()
   {
      return dsReceitaFixa;
   }

   public void setDsReceitaFixa(String dsReceitaFixa)
   {
      this.dsReceitaFixa = dsReceitaFixa;
   }

   public Integer getNrDiaReceita()
   {
      return nrDiaReceita;
   }

   public void setNrDiaReceita(Integer nrDiaReceita)
   {
      this.nrDiaReceita = nrDiaReceita;
   }

   public Double getVlReceita()
   {
      return vlReceita;
   }

   public void setVlReceita(Double vlReceita)
   {
      this.vlReceita = vlReceita;
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
}