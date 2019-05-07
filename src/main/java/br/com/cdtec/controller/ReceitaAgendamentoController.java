package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.ReceitaAgendamentoHeaderDTO;
import br.com.cdtec.entity.ReceitaAgendamentoHeader;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.ReceitaAgendamentoHeaderService;

@RestController
@RequestMapping("/api/receitaAgendamento")
@CrossOrigin(origins = "*")
public class ReceitaAgendamentoController extends CrudController<ReceitaAgendamentoHeader, BigInteger, ReceitaAgendamentoHeaderService>
{

   private static final long serialVersionUID = 1L;

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Response<String>> inativarReceitaAgendamento(@PathVariable("id") BigInteger id)
   {
      Response<String> response = new Response<String>();
      try
      {
         if (id == null)
         {
            response.getErrors().add("Receita não encontrada com o código: " + id);
            return ResponseEntity.badRequest().body(response);
         }

         getService().inativarReceitaAgendamento(id);

      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }

      return ResponseEntity.ok(new Response<String>());
   }

   @Override
   protected void validarInserir(ReceitaAgendamentoHeader entity, BindingResult result)
   {
      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
         return;
      }

      if (entity.getVlReceitaAgh() == null || entity.getVlReceitaAgh().doubleValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Valor é obrigatório."));
         return;
      }

      if (entity.getDtInicio() == null || entity.getDtInicio().toString().equals(""))
      {
         result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected void validarAlterar(ReceitaAgendamentoHeader entity, BindingResult result)
   {
      if (entity.getIdReceitaAgh() == null)
      {
         result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
         return;
      }

      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
         return;
      }

      if (entity.getVlReceitaAgh() == null || entity.getVlReceitaAgh().doubleValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Valor é obrigatório."));
         return;
      }

      if (entity.getDtInicio() == null || entity.getDtInicio().toString().equals(""))
      {
         result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected List<Object> atualizarListaResponse(List<ReceitaAgendamentoHeader> lista)
   {
      return lista.stream().map(receitaAgendamentoHeader -> convertToDto(receitaAgendamentoHeader)).collect(Collectors.toList());
   }

   @Override
   protected Object atualizarEntityResponse(ReceitaAgendamentoHeader entity)
   {
      return this.convertToDto(entity);
   }

   private ReceitaAgendamentoHeaderDTO convertToDto(ReceitaAgendamentoHeader receita)
   {
      ReceitaAgendamentoHeaderDTO dto = new ReceitaAgendamentoHeaderDTO();
      modelMapper.map(receita, dto);

      return dto;
   }

   @Override
   protected void completarInserir(ReceitaAgendamentoHeader entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void completarAlterar(ReceitaAgendamentoHeader entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void atualizarStatusEntidade(ReceitaAgendamentoHeader entity, Boolean status)
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
