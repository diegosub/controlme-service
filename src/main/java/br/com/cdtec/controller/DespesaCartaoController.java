package br.com.cdtec.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
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
import br.com.cdtec.dto.DespesaCartaoHeaderDTO;
import br.com.cdtec.entity.DespesaCartaoHeader;
import br.com.cdtec.service.DespesaCartaoHeaderService;

@RestController
@RequestMapping("/api/despesaCartao")
@CrossOrigin(origins = "*")
public class DespesaCartaoController extends CrudController<DespesaCartaoHeader, BigInteger, DespesaCartaoHeaderService>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void validarInserir(DespesaCartaoHeader entity, BindingResult result)
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

      if (entity.getIdCartao() == null || entity.getIdCartao().doubleValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Cartão é obrigatório."));
         return;
      }

      if (entity.getDtDespesa() == null || entity.getDtDespesa().toString().equals(""))
      {
         result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
         return;
      }
   }

   @Override
   protected void validarAlterar(DespesaCartaoHeader entity, BindingResult result)
   {
      if (entity.getIdDespesaCch() == null)
      {
         result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
         return;
      }

      if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
         return;
      }

      if (entity.getIdCartao() == null || entity.getIdCartao().doubleValue() == 0)
      {
         result.addError(new ObjectError("Despesa", "O campo Cartão é obrigatório."));
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
   protected List<Object> atualizarListaResponse(List<DespesaCartaoHeader> lista)
   {
      return lista.stream().map(despesaCartao -> convertToDto(despesaCartao)).collect(Collectors.toList());
   }

   @Override
   protected Object atualizarEntityResponse(DespesaCartaoHeader entity)
   {
      return this.convertToDto(entity);
   }

   private DespesaCartaoHeaderDTO convertToDto(DespesaCartaoHeader despesa)
   {
      DespesaCartaoHeaderDTO dto = new DespesaCartaoHeaderDTO();
      modelMapper.map(despesa, dto);
      dto.setStrVlDespesa(new DecimalFormat("#,##0.00").format(dto.getVlDespesa()));

      return dto;
   }

   @Override
   protected void completarInserir(DespesaCartaoHeader entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void completarAlterar(DespesaCartaoHeader entity, HttpServletRequest request)
   {
      entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
   }

   @Override
   protected void atualizarStatusEntidade(DespesaCartaoHeader entity, Boolean status)
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
