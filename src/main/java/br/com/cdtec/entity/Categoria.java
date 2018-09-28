package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_categoria", schema = "ngc")
@SequenceGenerator(name = "SQ_CATEGORIA", sequenceName = "SQ_CATEGORIA", allocationSize = 1)
@Proxy(lazy = true)
@FilterDefs({
		@FilterDef(name = "filtroFlgAtivoSubcategoria", parameters = @ParamDef(name = "flgAtivoSubcategoria", type = "boolean")) })
public class Categoria implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
	@Column(name = "id_categoria")
	private BigInteger idCategoria;

	@Column(name = "ds_categoria")
	private String dsCategoria;

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

	@Column(name = "tp_categoria")
	private String tpCategoria;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	@Filter(name = "filtroFlgAtivoSubcategoria", condition = "(:flgAtivoSubcategoria = fg_ativo OR fg_ativo is null)")
	private Set<Subcategoria> listaSubcategoria;

	
	public BigInteger getIdCategoria()
	{
		return idCategoria;
	}

	public void setIdCategoria(BigInteger idCategoria)
	{
		this.idCategoria = idCategoria;
	}

	public String getDsCategoria()
	{
		return dsCategoria;
	}

	public void setDsCategoria(String dsCategoria)
	{
		this.dsCategoria = dsCategoria;
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

	public BigInteger getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(BigInteger idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public Date getDtAlteracao()
	{
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao)
	{
		this.dtAlteracao = dtAlteracao;
	}

	public String getTpCategoria()
	{
		return tpCategoria;
	}

	public void setTpCategoria(String tpCategoria)
	{
		this.tpCategoria = tpCategoria;
	}

	public Set<Subcategoria> getListaSubcategoria()
	{
		return listaSubcategoria;
	}

	public void setListaSubcategoria(Set<Subcategoria> listaSubcategoria)
	{
		this.listaSubcategoria = listaSubcategoria;
	}

}