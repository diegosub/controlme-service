package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class ContaAdapterDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private BigInteger idContaAdapter;

	private List<ContaDTO> listaConta;

	private Boolean fgPrincipal;

	public BigInteger getIdContaAdapter()
	{
		return idContaAdapter;
	}

	public void setIdContaAdapter(BigInteger idContaAdapter)
	{
		this.idContaAdapter = idContaAdapter;
	}

	public List<ContaDTO> getListaConta()
	{
		return listaConta;
	}

	public void setListaConta(List<ContaDTO> listaConta)
	{
		this.listaConta = listaConta;
	}

	public Boolean getFgPrincipal()
	{
		return fgPrincipal;
	}

	public void setFgPrincipal(Boolean fgPrincipal)
	{
		this.fgPrincipal = fgPrincipal;
	}

}