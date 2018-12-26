package br.com.cdtec.dto;

import java.io.Serializable;

public class CategoriaAdapterDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String dsIdentificador;

	private String dsNome;

	private String dsTipo;

	public String getDsIdentificador()
	{
		return dsIdentificador;
	}

	public void setDsIdentificador(String dsIdentificador)
	{
		this.dsIdentificador = dsIdentificador;
	}

	public String getDsNome()
	{
		return dsNome;
	}

	public void setDsNome(String dsNome)
	{
		this.dsNome = dsNome;
	}

	public String getDsTipo()
	{
		return dsTipo;
	}

	public void setDsTipo(String dsTipo)
	{
		this.dsTipo = dsTipo;
	}

}