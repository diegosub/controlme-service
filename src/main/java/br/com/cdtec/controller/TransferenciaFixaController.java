package br.com.cdtec.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.TransferenciaDTO;
import br.com.cdtec.entity.TransferenciaFixa;
import br.com.cdtec.service.TransferenciaFixaService;

@RestController
@RequestMapping("/api/transferenciaFixa")
@CrossOrigin(origins = "*")
public class TransferenciaFixaController extends CrudController<TransferenciaFixa, BigInteger, TransferenciaFixaService>
{
   private static final long serialVersionUID = 1L;

   @Override
   protected void validarAlterar(TransferenciaFixa entity, BindingResult result)
   {
      if (entity.getIdTransferenciaFixa() == null || entity.getIdTransferenciaFixa().intValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Código da Transferência é obrigatório."));
         return;
      }
      
      if (entity.getIdContaOrigem() == null || entity.getIdContaOrigem().intValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Conta de Origem é obrigatório."));
         return;
      }

      if (entity.getIdContaDestino() == null || entity.getIdContaDestino().intValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Conta de Destino é obrigatório."));
         return;
      }

      if (entity.getVlTransferencia() == null || entity.getVlTransferencia().doubleValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Valor é obrigatório."));
         return;
      }

      if (entity.getNrDia() == null || entity.getNrDia().toString().equals(""))
      {
         result.addError(new ObjectError("Transferência", "O campo Dia da Transferência é obrigatório."));
         return;
      }
   }
   
	@Override
	protected void atualizarStatusEntidade(TransferenciaFixa entity, Boolean status)
	{
		entity.setFgAtivo(status);
		entity.setDtAlteracao(new Date());
	}

   @Override
   protected List<Object> atualizarListaResponse(List<TransferenciaFixa> lista)
   {
      modelMapper.getConfiguration().setAmbiguityIgnored(true);
      return lista.stream().map(transferencia -> convertToDto(transferencia)).collect(Collectors.toList());
   }

   private TransferenciaDTO convertToDto(TransferenciaFixa transferenciaFixa)
   {
      TransferenciaDTO dto = new TransferenciaDTO();
      modelMapper.map(transferenciaFixa, dto);

      dto.setStrVlTransferencia(new DecimalFormat("#,##0.00").format(dto.getVlTransferencia()));

      return dto;
   }

   @Override
   protected Sort sortField()
   {
      return new Sort(Sort.Direction.ASC, getService().getFieldSort());
   }
}
