package br.com.cdtec.entity.filter;

import java.util.Date;

public class FiltroTransferencia
{
   private Date dtTransferenciaInicio;

   private Date dtTransferenciaFim;

   public Date getDtTransferenciaInicio()
   {
      return dtTransferenciaInicio;
   }

   public void setDtTransferenciaInicio(Date dtTransferenciaInicio)
   {
      this.dtTransferenciaInicio = dtTransferenciaInicio;
   }

   public Date getDtTransferenciaFim()
   {
      return dtTransferenciaFim;
   }

   public void setDtTransferenciaFim(Date dtTransferenciaFim)
   {
      this.dtTransferenciaFim = dtTransferenciaFim;
   }
}
