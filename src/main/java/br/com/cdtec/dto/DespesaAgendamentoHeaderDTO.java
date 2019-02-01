package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class DespesaAgendamentoHeaderDTO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private BigInteger idDespesaAgh;

	private BigInteger idCategoria;
	
	private CategoriaDTO categoria;

	private BigInteger idSubcategoria;

	private SubcategoriaDTO subcategoria;

	private Date dtInicio;

	private Double vlDespesaAgh;
	
	private String strVlDespesaAgh;

	private String dsObservacao;

	private BigInteger idUsuario;

	private Boolean fgAtivo;

	private Date dtCadastro;
	
	private Integer idPeriodo;
	
	private Integer nrPeriodo;
	

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

	public CategoriaDTO getCategoria()
	{
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria)
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

	public SubcategoriaDTO getSubcategoria()
	{
		return subcategoria;
	}

	public void setSubcategoria(SubcategoriaDTO subcategoria)
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

	public String getStrVlDespesaAgh()
	{
		return strVlDespesaAgh;
	}

	public void setStrVlDespesaAgh(String strVlDespesaAgh)
	{
		this.strVlDespesaAgh = strVlDespesaAgh;
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