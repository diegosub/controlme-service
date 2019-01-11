package br.com.cdtec.controller;

import java.math.BigInteger;
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
import br.com.cdtec.dto.CartaoAdapterDTO;
import br.com.cdtec.dto.CartaoDTO;
import br.com.cdtec.entity.Cartao;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.CartaoService;
import br.com.cdtec.util.RetirarLazy;

@RestController
@RequestMapping("/api/cartao")
@CrossOrigin(origins = "*")
public class CartaoController extends CrudController<Cartao, BigInteger, CartaoService>
{

   private static final long serialVersionUID = 1L;

   @PostMapping(path = "/listarCartoes")
   public ResponseEntity<Response<List<CartaoDTO>>> listarCartoes(HttpServletRequest request, @RequestBody Cartao cartao)
   {
       Response<List<CartaoDTO>> response = new Response<List<CartaoDTO>>();
       try
       {
           List<Cartao> lista = getService().pesquisar(cartao, this.sortField());
           lista = (List<Cartao>) new RetirarLazy<List<Cartao>>(lista).execute();           
           List<CartaoDTO> listaRetorno = lista.stream().map(objeto -> convertToDto(objeto)).collect(Collectors.toList());
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
   public ResponseEntity<Response<List<Cartao>>> pesquisarInativos(HttpServletRequest request, @RequestBody Cartao cartao)
   {
       Response<List<Cartao>> response = new Response<List<Cartao>>();
       try
       {
           List<Cartao> lista = getService().pesquisarInativos(cartao);
           lista = (List<Cartao>) new RetirarLazy<List<Cartao>>(lista).execute();
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
   protected void completarInserir(Cartao entity, HttpServletRequest request)
   {
      entity.setIdUsuario(getUsuarioFromRequest(request).getIdUsuario());
      entity.setDtCadastro(new Date());
      entity.setFgAtivo(true);
   }

   @Override
   protected void completarAlterar(Cartao entity, HttpServletRequest request)
   {
      entity.setDtAlteracao(new Date());
   }

   @Override
   protected void validarInserir(Cartao entity, BindingResult result)
   {
      if (entity.getDsCartao() == null || entity.getDsCartao().trim().equals(""))
      {
         result.addError(new ObjectError("Cartao", "Descrição obrigatória."));
         return;
      }
   }

   @Override
   protected void validarAlterar(Cartao entity, BindingResult result)
   {
      if (entity.getIdCartao() == null)
      {
         result.addError(new ObjectError("Cartao", "Código informado"));
         return;
      }

      if (entity.getDsCartao() == null || entity.getDsCartao().trim().equals(""))
      {
         result.addError(new ObjectError("Cartao", "Descrição obrigatória."));
         return;
      }
   }

   @GetMapping("/setarPrincipal/{id}")
   public ResponseEntity<Response<Object>> setarPrincipal(HttpServletRequest request, @PathVariable("id") Integer id)
   {
      Response<Object> response = new Response<Object>();
      try
      {
         Cartao cartao = this.getService().setarPrincipal(this.getUsuarioFromRequest(request).getIdUsuario(), new BigInteger(String.valueOf(id)));
         response.setData(cartao);
         return ResponseEntity.ok(response);
      }
      catch (Exception e)
      {
         response.getErrors().add(e.getMessage());
         return ResponseEntity.badRequest().body(response);
      }
   }

   @Override
   protected void atualizarStatusEntidade(Cartao entity, Boolean status)
   {
      entity.setFgAtivo(status);
      entity.setDtAlteracao(new Date());
      entity.setFgPrincipal(false);
   }

   @Override
   protected List<Object> atualizarListaResponse(List<Cartao> lista)
   {
      List<CartaoDTO> listaCartaoDTO = lista.stream().map(cartao -> convertToDto(cartao)).collect(Collectors.toList());
      List<CartaoDTO> subListaCartaoDTO = new ArrayList<CartaoDTO>(4);
      List<Object> listaCartaoAdapterDTO = new ArrayList<Object>();

      int repetidor = this.retornarValorArredondado(listaCartaoDTO.size() + 1);

      for (int i = 1; i <= repetidor; i++)
      {
         if (i == listaCartaoDTO.size() + 1)
         {
            CartaoDTO cartaoDTO = new CartaoDTO();
            cartaoDTO.setFgControle("A");
            subListaCartaoDTO.add(cartaoDTO);
         }
         else
         {
            if (i < listaCartaoDTO.size() + 1)
            {
               listaCartaoDTO.get(i - 1).setFgControle("S");
               subListaCartaoDTO.add(listaCartaoDTO.get(i - 1));
            }
            else
            {
               CartaoDTO cartaoDTO = new CartaoDTO();
               cartaoDTO.setFgControle("N");
               subListaCartaoDTO.add(cartaoDTO);
            }
         }

         if (i % 4 == 0)
         {
            CartaoAdapterDTO cartaoAdapterDTO = new CartaoAdapterDTO();
            cartaoAdapterDTO.setListaCartao(subListaCartaoDTO);
            cartaoAdapterDTO.setIdCartaoAdapter(new BigInteger(String.valueOf(i)));

            listaCartaoAdapterDTO.add(cartaoAdapterDTO);

            subListaCartaoDTO = new ArrayList<CartaoDTO>();
         }
      }

      return listaCartaoAdapterDTO;
   }

   private Integer retornarValorArredondado(Integer valor)
   {
      while (valor % 4 != 0)
      {
         valor++;
      }

      return valor;
   }

   private CartaoDTO convertToDto(Cartao cartao)
   {
      CartaoDTO dto = new CartaoDTO();
      modelMapper.map(cartao, dto);

      return dto;
   }
   
   @Override
   protected Sort sortField()
   {
      return new Sort(Sort.Direction.ASC, getService().getFieldSort());
   }
}
