package br.com.cdtec.entity.filter;

import java.util.Date;

public class FiltroReceita
{
	private Date dtReceitaInicio;

	private Date dtReceitaFim;

   public Date getDtReceitaInicio()
   {
      return dtReceitaInicio;
   }

   public void setDtReceitaInicio(Date dtReceitaInicio)
   {
      this.dtReceitaInicio = dtReceitaInicio;
   }

   public Date getDtReceitaFim()
   {
      return dtReceitaFim;
   }

   public void setDtReceitaFim(Date dtReceitaFim)
   {
      this.dtReceitaFim = dtReceitaFim;
   }
}
