package br.com.cdtec.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.ContaAdapterDTO;
import br.com.cdtec.dto.ContaDTO;
import br.com.cdtec.entity.Conta;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.ContaService;
import br.com.cdtec.util.RetirarLazy;

@RestController
@RequestMapping("/api/conta")
@CrossOrigin(origins = "*")
public class ContaController extends CrudController<Conta, BigInteger, ContaService>
{

   private static final long serialVersionUID = 1L;

   @PostMapping(path = "/listarContas")
   public ResponseEntity<Response<List<ContaDTO>>> listarContas(HttpServletRequest request, @RequestBody Conta conta)
   {
       Response<List<ContaDTO>> response = new Response<List<ContaDTO>>();
       try
       {
           List<Conta> lista = getService().pesquisar(conta, this.sortField());
           lista = (List<Conta>) new RetirarLazy<List<Conta>>(lista).execute();           
           List<ContaDTO> listaRetorno = lista.stream().map(objeto -> convertToDto(objeto)).collect(Collectors.toList());
           
           for (ContaDTO contaDTO : listaRetorno)
		   {
        	  contaDTO.setStrVlSaldo(new DecimalFormat("#,##0.00").format(contaDTO.getVlSaldo()));
		   }
           
           response.setData(listaRetorno);
           return ResponseEntity.ok(response);
       }
       catch (Exception e)
       {
           response.getErrors().add(e.getMessage());
           return ResponseEntity.badRequest().body(response);
       }
   }
   
   @PostMapping(path = "/pesquisarInativos")
   public ResponseEntity<Response<List<Conta>>> pesquisarInativos(HttpServletRequest request, @RequestBody Conta conta)
   {
       Response<List<Conta>> response = new Response<List<Conta>>();
       try
       {
           List<Conta> lista = getService().pesquisarInativos(conta);
           lista = (List<Conta>) new RetirarLazy<List<Conta>>(lista).execute();
           response.setData(lista);
           return ResponseEntity.ok(response);
       }
       catch (Exception e)
       {
           response.getErrors().add(e.getMessage());
           return ResponseEntity.badRequest().body(response);
       }
   }
   
   @Override
   protected void completarInserir(Conta entity, HttpServletRequest request)
   {
      entity.setIdUsuario(getUsuarioFromRequest(request).getIdUsuario());
      entity.setDtCadastro(new Date());
      entity.setFgAtivo(true);
   }

   @Override
   protected void completarAlterar(Conta entity, HttpServletRequest request)
   {
      entity.setDtAlteracao(new Date());
   }

   @Override
   protected void validarInserir(Conta entity, BindingResult result)
   {
      if (entity.getDsConta() == null || entity.getDsConta().trim().equals(""))
      {
         result.addError(new ObjectError("Conta", "O campo Descrição é obrigatório."));
         return;
      }
      
      if (entity.getIdTipoConta() == null || entity.getIdTipoConta().intValue() <= 0)
      {
         result.addError(new ObjectError("Conta", "O campo Tipo de Conta é obrigatório."));
         return;
      }
   }

   @Override
   protected void validarAlterar(Conta entity, BindingResult result)
   {
      if (entity.getIdConta() == null)
      {
         result.addError(new ObjectError("Conta", "O campo Código deve ser informado"));
         return;
      }

      if (entity.getDsConta() == null || entity.getDsConta().trim().equals(""))
      {
         result.addError(new ObjectError("Conta", "O campo Descrição é obrigatório."));
         return;
      }
      
      if (entity.getIdTipoConta() == null || entity.getIdTipoConta().intValue() <= 0)
      {
         result.addError(new ObjectError("Conta", "O campo Tipo de Conta é obrigatório."));
         return;
      }
   }
   
   @GetMapping("/setarPrincipal/{id}")
   public ResponseEntity<Response<Object>> setarPrincipal(HttpServletRequest request, @PathVariable("id") Integer id)
   {
      Response<Object> response = new Response<Object>();
      try
      {
         Conta conta = this.getService().setarPrincipal(this.getUsuarioFromRequest(request).getIdUsuario(), new BigInteger(String.valueOf(id)));
         response.setData(conta);
         return ResponseEntity.ok(response);
      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }
   }

   @Override
   protected void atualizarStatusEntidade(Conta entity, Boolean status)
   {
      entity.setFgAtivo(status);
      entity.setDtAlteracao(new Date());
      entity.setFgPrincipal(false);
   }
   
   @Override
   protected List<Object> atualizarListaResponse(List<Conta> lista)
   {
      List<ContaDTO> listaContaDTO = lista.stream().map(conta -> convertToDto(conta)).collect(Collectors.toList());
      List<ContaDTO> subListaContaDTO = new ArrayList<ContaDTO>(4);
      List<Object> listaContaAdapterDTO = new ArrayList<Object>();

      int repetidor = this.retornarValorArredondado(listaContaDTO.size() + 1);

      for (int i = 1; i <= repetidor; i++)
      {
         if (i == listaContaDTO.size() + 1)
         {
            ContaDTO contaDTO = new ContaDTO();
            contaDTO.setFgControle("A");
            subListaContaDTO.add(contaDTO);
         }
         else
         {
            if (i < listaContaDTO.size() + 1)
            {
               listaContaDTO.get(i - 1).setFgControle("S");
               listaContaDTO.get(i - 1).setStrVlSaldo(new DecimalFormat("#,##0.00").format(listaContaDTO.get(i - 1).getVlSaldo()));
               subListaContaDTO.add(listaContaDTO.get(i - 1));
            }
            else
            {
               ContaDTO contaDTO = new ContaDTO();
               contaDTO.setFgControle("N");
               subListaContaDTO.add(contaDTO);
            }
         }

         if (i % 4 == 0)
         {
            ContaAdapterDTO contaAdapterDTO = new ContaAdapterDTO();
            contaAdapterDTO.setListaConta(subListaContaDTO);
            contaAdapterDTO.setIdContaAdapter(new BigInteger(String.valueOf(i)));

            listaContaAdapterDTO.add(contaAdapterDTO);

            subListaContaDTO = new ArrayList<ContaDTO>();
         }
      }

      return listaContaAdapterDTO;
   }

   private Integer retornarValorArredondado(Integer valor)
   {
      while (valor % 4 != 0)
      {
         valor++;
      }

      return valor;
   }

   private ContaDTO convertToDto(Conta conta)
   {
      ContaDTO dto = new ContaDTO();
      modelMapper.map(conta, dto);

      return dto;
   }
   
   @Override
   protected Sort sortField()
   {
      return new Sort(Sort.Direction.ASC, getService().getFieldSort());
   }
}
