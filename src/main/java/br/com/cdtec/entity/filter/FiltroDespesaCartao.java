package br.com.cdtec.entity.filter;

import java.util.Date;

public class FiltroDespesaCartao
{
	private Date dtDespesaInicio;

	private Date dtDespesaFim;

	public Date getDtDespesaInicio()
	{
		return dtDespesaInicio;
	}

	public void setDtDespesaInicio(Date dtDespesaInicio)
	{
		this.dtDespesaInicio = dtDespesaInicio;
	}

	public Date getDtDespesaFim()
	{
		return dtDespesaFim;
	}

	public void setDtDespesaFim(Date dtDespesaFim)
	{
		this.dtDespesaFim = dtDespesaFim;
	}

}
