package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.entity.Despesa;
import br.com.cdtec.service.DespesaService;

@RestController
@RequestMapping("/api/despesa")
@CrossOrigin(origins = "*")
public class DespesaController extends CrudController<Despesa, BigInteger, DespesaService>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void validarInserir(Despesa entity, BindingResult result)
   {
      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
         return;
      }
      
      if (entity.getVlDespesa() == null || entity.getVlDespesa().doubleValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Valor é obrigatório."));
         return;
      }
      
      if (entity.getDtDespesa() == null || entity.getDtDespesa().toString().equals(""))
      {
         result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected void validarAlterar(Despesa entity, BindingResult result)
   {
      if (entity.getIdDespesa() == null)
      {
         result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
         return;
      }

      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
         return;
      }
      
      if (entity.getVlDespesa() == null || entity.getVlDespesa().doubleValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Valor é obrigatório."));
         return;
      }
      
      if (entity.getDtDespesa() == null || entity.getDtDespesa().toString().equals(""))
      {
         result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected void atualizarStatusEntidade(Despesa entity, Boolean status)
   {
      entity.setFgAtivo(status);
      entity.setDtAlteracao(new Date());
   }

   @Override
   protected Sort sortField()
   {
      return new Sort(Sort.Direction.DESC, getService().getFieldSort());
   }
}
