package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.DividaDTO;
import br.com.cdtec.entity.Divida;
import br.com.cdtec.service.DividaService;

@RestController
@RequestMapping("/api/divida")
@CrossOrigin(origins = "*")
public class DividaController extends CrudController<Divida, BigInteger, DividaService>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected List<Object> atualizarListaResponse(List<Divida> lista)
   {
      return lista.stream().map(despesa -> convertToDto(despesa)).collect(Collectors.toList());
   }

   @Override
   protected Object atualizarEntityResponse(Divida entity)
   {
      return this.convertToDto(entity);
   }

   private DividaDTO convertToDto(Divida divida)
   {
      DividaDTO dto = new DividaDTO();
      modelMapper.map(divida, dto);

      return dto;
   }

   @Override
   protected Sort sortField()
   {
      return new Sort(Sort.Direction.DESC, getService().getFieldSort());
   }
}
