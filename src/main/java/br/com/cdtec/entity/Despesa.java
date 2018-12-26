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
@Table(name = "tb_despesa", schema = "ngc")
@SequenceGenerator(name = "SQ_DESPESA", sequenceName = "SQ_DESPESA", allocationSize = 1)
@Proxy(lazy = true)
public class Despesa implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESPESA")
	@Column(name = "id_despesa")
	private BigInteger idDespesa;

	@Column(name = "id_categoria")
	private BigInteger idCategoria;

	@Column(name = "id_subcategoria")
	private BigInteger idSubcategoria;

	@Column(name = "id_conta")
	private BigInteger idConta;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_despesa")
	private Date dtDespesa;

	@Column(name = "vl_despesa")
	private Double vlDespesa;

	@Column(name = "ds_observacao")
	private BigInteger dsObsrvacao;

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

	public BigInteger getIdDespesa()
	{
		return idDespesa;
	}

	public void setIdDespesa(BigInteger idDespesa)
	{
		this.idDespesa = idDespesa;
	}

	public BigInteger getIdCategoria()
	{
		return idCategoria;
	}

	public void setIdCategoria(BigInteger idCategoria)
	{
		this.idCategoria = idCategoria;
	}

	public BigInteger getIdSubcategoria()
	{
		return idSubcategoria;
	}

	public void setIdSubcategoria(BigInteger idSubcategoria)
	{
		this.idSubcategoria = idSubcategoria;
	}

	public BigInteger getIdConta()
	{
		return idConta;
	}

	public void setIdConta(BigInteger idConta)
	{
		this.idConta = idConta;
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

	public BigInteger getDsObsrvacao()
	{
		return dsObsrvacao;
	}

	public void setDsObsrvacao(BigInteger dsObsrvacao)
	{
		this.dsObsrvacao = dsObsrvacao;
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