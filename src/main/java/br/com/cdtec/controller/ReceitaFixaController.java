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
import br.com.cdtec.dto.ReceitaFixaDTO;
import br.com.cdtec.entity.ReceitaFixa;
import br.com.cdtec.service.ReceitaFixaService;

@RestController
@RequestMapping("/api/receitaFixa")
@CrossOrigin(origins = "*")
public class ReceitaFixaController extends CrudController<ReceitaFixa, BigInteger, ReceitaFixaService>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void validarInserir(ReceitaFixa entity, BindingResult result)
   {
      if (entity.getDsReceitaFixa() == null || entity.getDsReceitaFixa().trim().equals(""))
      {
         result.addError(new ObjectError("ReceitaFixa", "O campo Descrição é obrigatório."));
         return;
      }

      if (entity.getNrDiaReceita() == null || entity.getNrDiaReceita().intValue() == 0)
      {
         result.addError(new ObjectError("ReceitaFixa", "O campo Dia da Receita é obrigatório."));
         return;
      }
   }
   
   @Override
   protected void completarInserir(ReceitaFixa entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void completarAlterar(ReceitaFixa entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void validarAlterar(ReceitaFixa entity, BindingResult result)
   {
      if (entity.getIdReceitaFixa() == null)
      {
         result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
         return;
      }

      this.validarInserir(entity, result);
   }

   @Override
   protected List<Object> atualizarListaResponse(List<ReceitaFixa> lista)
   {
      return lista.stream().map(receitaFixa -> convertToDto(receitaFixa)).collect(Collectors.toList());
   }

   @Override
   protected Object atualizarEntityResponse(ReceitaFixa entity)
   {
      return this.convertToDto(entity);
   }

   private ReceitaFixaDTO convertToDto(ReceitaFixa receitaFixa)
   {
      ReceitaFixaDTO dto = new ReceitaFixaDTO();
      modelMapper.map(receitaFixa, dto);

      return dto;
   }

   @Override
   protected void atualizarStatusEntidade(ReceitaFixa entity, Boolean status)
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
