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
@Table(name = "tb_despesa_agh", schema = "ngc")
@SequenceGenerator(name = "SQ_DESPESA_AGH", sequenceName = "SQ_DESPESA_AGH", allocationSize = 1)
@Proxy(lazy = true)
public class DespesaAgendamentoHeader implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESPESA_AGH")
	@Column(name = "id_despesa_agh")
	private BigInteger idDespesaAgh;

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
	
	@Column(name = "dt_inicio")
	private Date dtInicio;

	@Column(name = "vl_despesa_agh")
	private Double vlDespesaAgh;
	
	@Column(name = "tp_despesa_agh")
	private String tpDespesaAgh;

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
	
	@Column(name = "id_periodo")
	private Integer idPeriodo;
	
	@Column(name = "nr_periodo")
	private Integer nrPeriodo;
	
	@Transient
	private FiltroDespesaCartao filtro;
	

	public BigInteger getIdDespesaAgh()
	{
		return idDespesaAgh;
	}

	public void setIdDespesaAgh(BigInteger idDespesaAgh)
	{
		this.idDespesaAgh = idDespesaAgh;
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

	public Date getDtInicio()
	{
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio)
	{
		this.dtInicio = dtInicio;
	}

	public Double getVlDespesaAgh()
	{
		return vlDespesaAgh;
	}

	public void setVlDespesaAgh(Double vlDespesaAgh)
	{
		this.vlDespesaAgh = vlDespesaAgh;
	}

	public String getTpDespesaAgh()
	{
		return tpDespesaAgh;
	}

	public void setTpDespesaAgh(String tpDespesaAgh)
	{
		this.tpDespesaAgh = tpDespesaAgh;
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

	public FiltroDespesaCartao getFiltro()
	{
		return filtro;
	}

	public void setFiltro(FiltroDespesaCartao filtro)
	{
		this.filtro = filtro;
	}

	public String getDsObservacao()
	{
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao)
	{
		this.dsObservacao = dsObservacao;
	}

	public Integer getIdPeriodo()
	{
		return idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo)
	{
		this.idPeriodo = idPeriodo;
	}

	public Integer getNrPeriodo()
	{
		return nrPeriodo;
	}

	public void setNrPeriodo(Integer nrPeriodo)
	{
		this.nrPeriodo = nrPeriodo;
	}
}