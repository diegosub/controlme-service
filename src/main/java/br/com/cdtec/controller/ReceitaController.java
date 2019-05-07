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
import br.com.cdtec.dto.ReceitaDTO;
import br.com.cdtec.entity.Receita;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.ReceitaService;

@RestController
@RequestMapping("/api/receita")
@CrossOrigin(origins = "*")
public class ReceitaController extends CrudController<Receita, BigInteger, ReceitaService>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void validarInserir(Receita entity, BindingResult result)
   {
      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Receita", "O campo Categoria é obrigatório."));
         return;
      }

      if (entity.getIdConta() == null || entity.getIdConta().doubleValue() == 0)
      {
         result.addError(new ObjectError("Receita", "O campo Conta é obrigatório."));
         return;
      }

      if (entity.getVlReceita() == null || entity.getVlReceita().doubleValue() == 0)
      {
         result.addError(new ObjectError("Receita", "O campo Valor é obrigatório."));
         return;
      }

      if (entity.getDtReceita() == null || entity.getDtReceita().toString().equals(""))
      {
         result.addError(new ObjectError("Receita", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected void validarAlterar(Receita entity, BindingResult result)
   {
      if (entity.getIdReceita() == null)
      {
         result.addError(new ObjectError("Receita", "O campo Código é obrigatório"));
         return;
      }

      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Receita", "O campo Categoria é obrigatório."));
         return;
      }

      if (entity.getIdConta() == null || entity.getIdConta().doubleValue() == 0)
      {
         result.addError(new ObjectError("Receita", "O campo Conta é obrigatório."));
         return;
      }

      if (entity.getVlReceita() == null || entity.getVlReceita().doubleValue() == 0)
      {
         result.addError(new ObjectError("Receita", "O campo Valor é obrigatório."));
         return;
      }

      if (entity.getDtReceita() == null || entity.getDtReceita().toString().equals(""))
      {
         result.addError(new ObjectError("Receita", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected List<Object> atualizarListaResponse(List<Receita> lista)
   {
      return lista.stream().map(receita -> convertToDto(receita)).collect(Collectors.toList());
   }

   @Override
   protected Object atualizarEntityResponse(Receita entity)
   {
      return this.convertToDto(entity);
   }

   private ReceitaDTO convertToDto(Receita receita)
   {
      ReceitaDTO dto = new ReceitaDTO();
      modelMapper.map(receita, dto);

      return dto;
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Response<String>> inativarReceita(@PathVariable("id") BigInteger id)
   {
      Response<String> response = new Response<String>();
      try
      {
         if (id == null)
         {
            response.getErrors().add("Receita não encontrada com o código: " + id);
            return ResponseEntity.badRequest().body(response);
         }

         getService().inativarReceita(id);

      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }

      return ResponseEntity.ok(new Response<String>());
   }

   @Override
   protected void completarInserir(Receita entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void completarAlterar(Receita entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void atualizarStatusEntidade(Receita entity, Boolean status)
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
