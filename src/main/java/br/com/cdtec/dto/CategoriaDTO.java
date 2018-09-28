package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class CategoriaDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private BigInteger idCategoria;
	
	private String dsCategoria;

	private BigInteger idUsuario;

	private Boolean fgAtivo;

	private Date dtCadastro;

	private Date dtAlteracao;

	private String tpCategoria;

	private List<SubcategoriaDTO> listaSubcategoria;

	
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

	public String getTpCategoria()
	{
		return tpCategoria;
	}

	public void setTpCategoria(String tpCategoria)
	{
		this.tpCategoria = tpCategoria;
	}

	public List<SubcategoriaDTO> getListaSubcategoria()
	{
		return listaSubcategoria;
	}

	public void setListaSubcategoria(List<SubcategoriaDTO> listaSubcategoria)
	{
		this.listaSubcategoria = listaSubcategoria;
	}
}