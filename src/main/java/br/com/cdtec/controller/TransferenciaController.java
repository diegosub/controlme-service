package br.com.cdtec.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import br.com.cdtec.util.RetirarLazy;

@RestController
@RequestMapping("/api/transferencia")
@CrossOrigin(origins = "*")
public class TransferenciaController extends CrudController<Transferencia, BigInteger, TransferenciaService>
{
   private static final long serialVersionUID = 1L;

   @Autowired
   private TransferenciaFixaService transferenciaFixaService;

   @PostMapping(path = "/pesquisarTransferenciaFixa")
   public ResponseEntity<Response<List<Object>>> pesquisarTransferenciaFixa(HttpServletRequest request, @RequestBody TransferenciaFixa transferenciaFixa)
   {
      Response<List<Object>> response = new Response<List<Object>>();
      try
      {
         List<TransferenciaFixa> lista = transferenciaFixaService.pesquisar(transferenciaFixa, sortFieldFixa());

         if (lista != null)
         {
            lista = (List<TransferenciaFixa>) new RetirarLazy<List<TransferenciaFixa>>(lista).execute();
            List<Object> listaRetorno = this.atualizarListaFixaResponse(lista);
            response.setData(listaRetorno);
         }

         return ResponseEntity.ok(response);
      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }
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
   
   @PutMapping(path="alterarTransferenciaFixa")
   public ResponseEntity<Response<TransferenciaFixa>> alterarTransferenciaFixa(HttpServletRequest request, @RequestBody TransferenciaFixa transferenciaFixa, BindingResult result)
   {
      Response<TransferenciaFixa> response = new Response<TransferenciaFixa>();
      try
      {
         //validarAlterarTransferenciaFixa(transferenciaFixa, result);
         if (result.hasErrors())
         {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
         }

         //TransferenciaFixa transferenciaFixaPersisted = (TransferenciaFixa) getService().alterar(transferenciaFixa);
         //response.setData(transferenciaFixaPersisted);
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

      if (dto.getIdContaDestino() == null || dto.getIdContaDestino().intValue() <= 0)
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
   protected void validarAlterar(Transferencia entity, BindingResult result)
   {
      if (entity.getIdTransferencia() == null || entity.getIdTransferencia().intValue() <= 0)
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

      if (entity.getDtTransferencia() == null || entity.getDtTransferencia().toString().equals(""))
      {
         result.addError(new ObjectError("Transferência", "O campo Data da Transferência é obrigatório."));
         return;
      }
   }
   
   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Response<String>> atualizarStatus(@PathVariable("id") BigInteger id)
   {
      Response<String> response = new Response<String>();
      try
      {
         if (id == null)
         {
            response.getErrors().add("Transferência não encontrada com o código: " + id);
            return ResponseEntity.badRequest().body(response);
         }

         getService().excluirDefinitivamente(id);

      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }

      return ResponseEntity.ok(new Response<String>());
   }

   @Override
   protected List<Object> atualizarListaResponse(List<Transferencia> lista)
   {
      modelMapper.getConfiguration().setAmbiguityIgnored(true);
      return lista.stream().map(transferencia -> convertToDto(transferencia)).collect(Collectors.toList());
   }
   
   protected List<Object> atualizarListaFixaResponse(List<TransferenciaFixa> lista)
   {
      modelMapper.getConfiguration().setAmbiguityIgnored(true);
      return lista.stream().map(transferenciaFixa -> convertToDto(transferenciaFixa)).collect(Collectors.toList());
   }

   private TransferenciaDTO convertToDto(Transferencia transferencia)
   {
      TransferenciaDTO dto = new TransferenciaDTO();
      modelMapper.map(transferencia, dto);

      dto.setStrVlTransferencia(new DecimalFormat("#,##0.00").format(dto.getVlTransferencia()));

      return dto;
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
   
   protected Sort sortFieldFixa()
   {
      return new Sort(Sort.Direction.ASC, transferenciaFixaService.getFieldSort());
   }
}
