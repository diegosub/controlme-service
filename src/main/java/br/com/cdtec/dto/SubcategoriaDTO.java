package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class SubcategoriaDTO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private BigInteger idSubcategoria;

	private BigInteger idCategoria;

	private String dsSubcategoria;

	private Boolean fgAtivo;

	private Date dtCadastro;

	private Date dtAlteracao;
	

	public BigInteger getIdSubcategoria()
	{
		return idSubcategoria;
	}

	public void setIdSubcategoria(BigInteger idSubcategoria)
	{
		this.idSubcategoria = idSubcategoria;
	}

	public BigInteger getIdCategoria()
	{
		return idCategoria;
	}

	public void setIdCategoria(BigInteger idCategoria)
	{
		this.idCategoria = idCategoria;
	}

	public String getDsSubcategoria()
	{
		return dsSubcategoria;
	}

	public void setDsSubcategoria(String dsSubcategoria)
	{
		this.dsSubcategoria = dsSubcategoria;
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