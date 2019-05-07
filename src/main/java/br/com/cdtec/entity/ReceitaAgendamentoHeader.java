package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import br.com.cdtec.entity.filter.FiltroReceitaAgendamentoHeader;

@Entity
@Table(name = "tb_receita_agh", schema = "ngc")
@SequenceGenerator(name = "SQ_RECEITA_AGH", sequenceName = "SQ_RECEITA_AGH", allocationSize = 1)
@Proxy(lazy = true)
public class ReceitaAgendamentoHeader implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECEITA_AGH")
   @Column(name = "id_receita_agh")
   private BigInteger idReceitaAgh;

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
   
   @Column(name = "id_conta")
   private BigInteger idConta;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_conta", insertable = false, updatable = false)
   private Conta conta;   

   @Column(name = "dt_inicio")
   private Date dtInicio;

   @Column(name = "vl_receita_agh")
   private Double vlReceitaAgh;

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

   @Column(name = "ds_observacao")
   private String dsObservacao;

   @Column(name = "id_periodo_agh")
   private Integer idPeriodoAgh;

   @OneToMany(mappedBy = "receitaAgendamentoHeader", fetch = FetchType.LAZY)
   private List<ReceitaAgendamentoDetalhe> listaReceitaAgendamentoDetalhe;

   @Transient
   private FiltroReceitaAgendamentoHeader filtro;

   public BigInteger getIdReceitaAgh()
   {
      return idReceitaAgh;
   }

   public void setIdReceitaAgh(BigInteger idReceitaAgh)
   {
      this.idReceitaAgh = idReceitaAgh;
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

   public BigInteger getIdConta()
   {
      return idConta;
   }

   public void setIdConta(BigInteger idConta)
   {
      this.idConta = idConta;
   }

   public Conta getConta()
   {
      return conta;
   }

   public void setConta(Conta conta)
   {
      this.conta = conta;
   }

   public Date getDtInicio()
   {
      return dtInicio;
   }

   public void setDtInicio(Date dtInicio)
   {
      this.dtInicio = dtInicio;
   }

   public Double getVlReceitaAgh()
   {
      return vlReceitaAgh;
   }

   public void setVlReceitaAgh(Double vlReceitaAgh)
   {
      this.vlReceitaAgh = vlReceitaAgh;
   }

   public Integer getNrParcelas()
   {
      return nrParcelas;
   }

   public void setNrParcelas(Integer nrParcelas)
   {
      this.nrParcelas = nrParcelas;
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

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
   }

   public Integer getIdPeriodoAgh()
   {
      return idPeriodoAgh;
   }

   public void setIdPeriodoAgh(Integer idPeriodoAgh)
   {
      this.idPeriodoAgh = idPeriodoAgh;
   }

   public List<ReceitaAgendamentoDetalhe> getListaReceitaAgendamentoDetalhe()
   {
      return listaReceitaAgendamentoDetalhe;
   }

   public void setListaReceitaAgendamentoDetalhe(List<ReceitaAgendamentoDetalhe> listaReceitaAgendamentoDetalhe)
   {
      this.listaReceitaAgendamentoDetalhe = listaReceitaAgendamentoDetalhe;
   }

   public FiltroReceitaAgendamentoHeader getFiltro()
   {
      return filtro;
   }

   public void setFiltro(FiltroReceitaAgendamentoHeader filtro)
   {
      this.filtro = filtro;
   }
}