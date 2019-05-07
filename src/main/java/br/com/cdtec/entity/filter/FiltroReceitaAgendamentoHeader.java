package br.com.cdtec.entity.filter;

import java.util.Date;

public class FiltroReceitaAgendamentoHeader
{
   private Date dtInicioInicio;

   private Date dtInicioFim;

   public Date getDtInicioInicio()
   {
      return dtInicioInicio;
   }

   public void setDtInicioInicio(Date dtInicioInicio)
   {
      this.dtInicioInicio = dtInicioInicio;
   }

   public Date getDtInicioFim()
   {
      return dtInicioFim;
   }

   public void setDtInicioFim(Date dtInicioFim)
   {
      this.dtInicioFim = dtInicioFim;
   }

}
