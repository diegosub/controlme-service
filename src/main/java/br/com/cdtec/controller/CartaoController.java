package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.CartaoAdapterDTO;
import br.com.cdtec.dto.CartaoDTO;
import br.com.cdtec.entity.Cartao;
import br.com.cdtec.service.CartaoService;

@RestController
@RequestMapping("/api/cartao")
@CrossOrigin(origins = "*")
public class CartaoController extends CrudController<Cartao, BigInteger, CartaoService>
{

   private static final long serialVersionUID = 1L;

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

   @Override
   protected void atualizarStatusEntidade(Cartao entity, Boolean status)
   {
      entity.setFgAtivo(status);
      entity.setDtAlteracao(new Date());
   }

   @Override
   protected List<Object> atualizarListaResponse(List<Cartao> lista)
   {
      List<CartaoDTO> listaCartaoDTO = lista.stream().map(cartao -> convertToDto(cartao)).collect(Collectors.toList());
      List<CartaoDTO> subListaCartaoDTO = new ArrayList<CartaoDTO>(4);
      List<Object> listaCartaoAdapterDTO = new ArrayList<Object>();
      
      int repetidor = this.retornarValorArredondado(listaCartaoDTO.size()+1);
      
      for (int i = 1; i <= repetidor; i++)
      {
         if(i == listaCartaoDTO.size()+1)
         {
            CartaoDTO cartaoDTO = new CartaoDTO();
            cartaoDTO.setFgControle("A");
            subListaCartaoDTO.add(cartaoDTO);
         }
         else 
         {
            if(i < listaCartaoDTO.size()+1) 
            {
               listaCartaoDTO.get(i-1).setFgControle("S");
               subListaCartaoDTO.add(listaCartaoDTO.get(i-1));
            }
            else
            {
               CartaoDTO cartaoDTO = new CartaoDTO();
               cartaoDTO.setFgControle("N");
               subListaCartaoDTO.add(cartaoDTO);
            }
         }
         
         if(i % 4 == 0) 
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
}
