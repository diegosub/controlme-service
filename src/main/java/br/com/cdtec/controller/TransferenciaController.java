package br.com.cdtec.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.TransferenciaDTO;
import br.com.cdtec.entity.Transferencia;
import br.com.cdtec.entity.TransferenciaFixa;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.TransferenciaFixaService;
import br.com.cdtec.service.TransferenciaService;

@RestController
@RequestMapping("/api/transferencia")
@CrossOrigin(origins = "*")
public class TransferenciaController extends CrudController<Transferencia, BigInteger, TransferenciaService>
{
   private static final long serialVersionUID = 1L;

   @Autowired
   private TransferenciaFixaService transferenciaFixaService;

   @Override
   protected void completarInserir(Transferencia entity, HttpServletRequest request)
   {
      entity.setIdUsuario(getUsuarioFromRequest(request).getIdUsuario());
      entity.setDtCadastro(new Date());
   }

   @PostMapping(path = "/inserirTransferencia")
   public ResponseEntity<Response<TransferenciaDTO>> inserir(HttpServletRequest request, @RequestBody TransferenciaDTO dto,
         BindingResult result)
   {
      Response<TransferenciaDTO> response = new Response<TransferenciaDTO>();
      try
      {
         validarInserirTransferencia(dto, result);
         if (result.hasErrors())
         {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
         }

         TransferenciaDTO retorno = null;
         modelMapper.getConfiguration().setAmbiguityIgnored(true);

         if (dto.getFgTransferenciaFixa() != null && dto.getFgTransferenciaFixa().booleanValue())
         {
            // INSERIR TRANSFERENCIA FIXA
            TransferenciaFixa transferenciaFixa = new TransferenciaFixa();
            modelMapper.map(dto, transferenciaFixa);
            transferenciaFixa = transferenciaFixaService.inserir(transferenciaFixa);

            retorno = new TransferenciaDTO();
            modelMapper.map(transferenciaFixa, retorno);
         }
         else
         {
            // INSERIR TRANSFERENCIA NORMAL
            Transferencia transferencia = new Transferencia();
            modelMapper.map(dto, transferencia);
            transferencia = getService().inserir(transferencia);

            retorno = new TransferenciaDTO();
            modelMapper.map(transferencia, retorno);
         }

         response.setData(retorno);
      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }

      return ResponseEntity.ok(response);
   }

   protected void validarInserirTransferencia(TransferenciaDTO dto, BindingResult result)
   {
      if (dto.getIdContaOrigem() == null || dto.getIdContaOrigem().intValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Conta de Origem é obrigatório."));
         return;
      }

      if (dto.getIdContaOrigem() == null || dto.getIdContaOrigem().intValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Conta de Destino é obrigatório."));
         return;
      }

      if (dto.getVlTransferencia() == null || dto.getVlTransferencia().doubleValue() <= 0)
      {
         result.addError(new ObjectError("Transferência", "O campo Valor é obrigatório."));
         return;
      }

      if (dto.getFgTransferenciaFixa() != null && dto.getFgTransferenciaFixa().booleanValue())
      {
         if (dto.getNrDia() == null || dto.getNrDia().intValue() <= 0)
         {
            result.addError(new ObjectError("Transferência", "O campo Data da Transferência é obrigatório."));
            return;
         }
      }
      else
      {
         if (dto.getDtTransferencia() == null || dto.getDtTransferencia().toString().equals(""))
         {
            result.addError(new ObjectError("Transferência", "O campo Data da Transferência é obrigatório."));
            return;
         }
      }
   }

   @Override
   protected List<Object> atualizarListaResponse(List<Transferencia> lista)
   {
      return lista.stream().map(transferencia -> convertToDto(transferencia)).collect(Collectors.toList());
   }

   private TransferenciaDTO convertToDto(Transferencia transferencia)
   {
      TransferenciaDTO dto = new TransferenciaDTO();
      modelMapper.map(transferencia, dto);

      dto.setStrVlTransferencia(new DecimalFormat("#,##0.00").format(dto.getVlTransferencia()));

      return dto;
   }

   @Override
   protected Sort sortField()
   {
      return new Sort(Sort.Direction.ASC, getService().getFieldSort());
   }
}
