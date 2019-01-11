package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class DespesaDTO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private BigInteger idDespesa;

	private BigInteger idCategoria;
	
	private CategoriaDTO categoria;

	private BigInteger idSubcategoria;

	private SubcategoriaDTO subcategoria;
	
	private BigInteger idConta;
	
	private ContaDTO conta;

	private Date dtDespesa;

	private Double vlDespesa;
	
	private String strVlDespesa;

	private String dsObservacao;

	private BigInteger idUsuario;

	private Boolean fgAtivo;

	private Date dtCadastro;

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

	public BigInteger getIdConta()
	{
		return idConta;
	}

	public void setIdConta(BigInteger idConta)
	{
		this.idConta = idConta;
	}

	public ContaDTO getConta()
	{
		return conta;
	}

	public void setConta(ContaDTO conta)
	{
		this.conta = conta;
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

	public String getStrVlDespesa()
	{
		return strVlDespesa;
	}

	public void setStrVlDespesa(String strVlDespesa)
	{
		this.strVlDespesa = strVlDespesa;
	}
}