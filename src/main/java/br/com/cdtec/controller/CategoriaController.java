package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.CategoriaDTO;
import br.com.cdtec.entity.Categoria;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.CategoriaService;
import br.com.cdtec.util.RetirarLazy;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController extends CrudController<Categoria, BigInteger, CategoriaService>
{

	private static final long serialVersionUID = 1L;

	@PostMapping(path = "/pesquisarInativos")
	public ResponseEntity<Response<List<Object>>> pesquisarInativos(HttpServletRequest request, @RequestBody Categoria categoria)
	{
		Response<List<Object>> response = new Response<List<Object>>();
		try
		{
			List<Categoria> lista = getService().pesquisarInativos(categoria);
			lista = (List<Categoria>) new RetirarLazy<List<Categoria>>(lista).execute();
			List<Object> listaRetorno = this.atualizarListaResponse(lista);
			response.setData(listaRetorno);
			return ResponseEntity.ok(response);
		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@Override
	protected void completarInserir(Categoria entity, HttpServletRequest request)
	{
		entity.setIdUsuario(getUsuarioFromRequest(request).getIdUsuario());
		entity.setDtCadastro(new Date());
		entity.setFgAtivo(true);
	}

	@Override
	protected void completarAlterar(Categoria entity, HttpServletRequest request)
	{
		entity.setDtAlteracao(new Date());
	}

	@Override
	protected void validarInserir(Categoria entity, BindingResult result)
	{
		if (entity.getDsCategoria() == null || entity.getDsCategoria().trim().equals(""))
		{
			result.addError(new ObjectError("Categoria", "Descrição obrigatória."));
			return;
		}
	}

	@Override
	protected void validarAlterar(Categoria entity, BindingResult result)
	{
		if (entity.getIdCategoria() == null)
		{
			result.addError(new ObjectError("Categoria", "Código informado"));
			return;
		}

		if (entity.getDsCategoria() == null || entity.getDsCategoria().trim().equals(""))
		{
			result.addError(new ObjectError("Categoria", "Descrição obrigatória."));
			return;
		}
	}

	@Override
	protected void atualizarStatusEntidade(Categoria entity, Boolean status)
	{
		entity.setFgAtivo(status);
		entity.setDtAlteracao(new Date());

		if (entity.getListaSubcategoria() == null || entity.getListaSubcategoria().size() <= 0)
		{
			entity.setListaSubcategoria(null);
		}
	}

	@Override
	protected List<Object> atualizarListaResponse(List<Categoria> lista)
	{
		return lista.stream().map(categoria -> convertToDto(categoria)).collect(Collectors.toList());
	}
	
	@Override
	protected Object atualizarEntityResponse(Categoria entity)
	{		
		return this.convertToDto(entity);
	}

	private CategoriaDTO convertToDto(Categoria categoria)
	{
		CategoriaDTO dto = new CategoriaDTO();
		modelMapper.map(categoria, dto);

		return dto;
	}

}
