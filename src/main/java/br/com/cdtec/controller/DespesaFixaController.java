package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.DespesaFixaDTO;
import br.com.cdtec.entity.DespesaFixa;
import br.com.cdtec.service.DespesaFixaService;

@RestController
@RequestMapping("/api/despesaFixa")
@CrossOrigin(origins = "*")
public class DespesaFixaController extends CrudController<DespesaFixa, BigInteger, DespesaFixaService>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void validarInserir(DespesaFixa entity, BindingResult result)
   {
      if (entity.getDsDespesaFixa() == null || entity.getDsDespesaFixa().trim().equals(""))
      {
         result.addError(new ObjectError("DespesaFixa", "O campo Descrição é obrigatório."));
         return;
      }

      if (entity.getNrDiaVencimento() == null || entity.getNrDiaVencimento().intValue() == 0)
      {
         result.addError(new ObjectError("DespesaFixa", "O campo Dia do Vencimento é obrigatório."));
         return;
      }
   }
   
   @Override
   protected void completarInserir(DespesaFixa entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void completarAlterar(DespesaFixa entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void validarAlterar(DespesaFixa entity, BindingResult result)
   {
      if (entity.getIdDespesaFixa() == null)
      {
         result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
         return;
      }

      this.validarInserir(entity, result);
   }

   @Override
   protected List<Object> atualizarListaResponse(List<DespesaFixa> lista)
   {
      return lista.stream().map(despesaFixa -> convertToDto(despesaFixa)).collect(Collectors.toList());
   }

   @Override
   protected Object atualizarEntityResponse(DespesaFixa entity)
   {
      return this.convertToDto(entity);
   }

   private DespesaFixaDTO convertToDto(DespesaFixa despesaFixa)
   {
      DespesaFixaDTO dto = new DespesaFixaDTO();
      modelMapper.map(despesaFixa, dto);

      return dto;
   }

//   @DeleteMapping(value = "/{id}")
//   public ResponseEntity<Response<String>> inativarDespesa(@PathVariable("id") BigInteger id)
//   {
//      Response<String> response = new Response<String>();
//      try
//      {
//         if (id == null)
//         {
//            response.getErrors().add("Despesa não encontrada com o código: " + id);
//            return ResponseEntity.badRequest().body(response);
//         }
//
//         getService().inativarDespesa(id);
//
//      }
//      catch (Exception e)
//      {
//         response.getErrors().add(e.getMessage());
//         return ResponseEntity.badRequest().body(response);
//      }
//
//      return ResponseEntity.ok(new Response<String>());
//   }

   @Override
   protected void atualizarStatusEntidade(DespesaFixa entity, Boolean status)
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
