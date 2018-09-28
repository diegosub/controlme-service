package br.com.cdtec.crud.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.response.Response;
import br.com.cdtec.security.entity.Usuario;
import br.com.cdtec.security.jwt.JwtTokenUtil;
import br.com.cdtec.security.service.UsuarioService;
import br.com.cdtec.util.RetirarLazy;

public class CrudController<Entity, IdClass extends Serializable, Service extends CrudService<Entity, IdClass, ?>>
		extends BaseController<Entity, Service> implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Autowired
	protected JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	public ModelMapper modelMapper;

	/**
	 * Class default de insert full permission Para restringir a classe, devera ser
	 * sobrescrita com o @PreAuthorize(role)
	 * 
	 * @param request
	 * @param entity
	 * @param result
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<Response<Entity>> inserir(HttpServletRequest request, @RequestBody Entity entity,
			BindingResult result)
	{
		Response<Entity> response = new Response<Entity>();
		try
		{
			validarInserir(entity, result);
			if (result.hasErrors())
			{
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			completarInserir(entity, request);
			Entity objInsert = getService().inserir(entity);
			response.setData(objInsert);
		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping()
	public ResponseEntity<Response<Entity>> alterar(HttpServletRequest request, @RequestBody Entity entity,
			BindingResult result)
	{
		Response<Entity> response = new Response<Entity>();
		try
		{
			validarAlterar(entity, result);
			if (result.hasErrors())
			{
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			completarAlterar(entity, request);
			Entity userPersisted = (Entity) getService().alterar(entity);
			response.setData(userPersisted);
		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Object>> get(HttpServletRequest request, @PathVariable("id") IdClass id)
	{
		Response<Object> response = new Response<Object>();
		try
		{
			Optional<Entity> entityOptional = getService().get(id);
			Entity entity = entityOptional.get();

			if (entity == null)
			{
				response.getErrors().add("Registro não encontrado com o código:" + id);
				return ResponseEntity.badRequest().body(response);
			}

			entity = new RetirarLazy<Entity>(entity).execute();
			Object object = this.atualizarEntityResponse(entity);

			response.setData(object);
			return ResponseEntity.ok(response);
		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PostMapping(path = "/pesquisar")
	public ResponseEntity<Response<List<Object>>> pesquisar(HttpServletRequest request, @RequestBody Entity entity)
	{
		Response<List<Object>> response = new Response<List<Object>>();
		try
		{
			List<Entity> lista = getService().pesquisar(entity, sortField());
			lista = (List<Entity>) new RetirarLazy<List<Entity>>(lista).execute();
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

	@DeleteMapping(value = "/{id}/{status}")
	public ResponseEntity<Response<String>> atualizarStatus(@PathVariable("id") IdClass id,
			@PathVariable("status") Boolean status)
	{
		Response<String> response = new Response<String>();
		try
		{
			Optional<Entity> entityOptional = getService().get(id);
			Entity entity = entityOptional.get();

			if (entity == null)
			{
				response.getErrors().add("Registro não encontrado com o código: " + id);
				return ResponseEntity.badRequest().body(response);
			}

			atualizarStatusEntidade(entity, status);
			getService().alterar(entity);

		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(new Response<String>());
	}

	protected void validarInserir(Entity entity, BindingResult result)
	{
	}

	protected void validarAlterar(Entity entity, BindingResult result)
	{
	}

	protected void completarInserir(Entity entity, HttpServletRequest request)
	{
	}

	protected void completarAlterar(Entity entity, HttpServletRequest request)
	{
	}

	protected void atualizarStatusEntidade(Entity entity, Boolean status)
	{
	}

	protected Object atualizarEntityResponse(Entity entity)
	{
		return (Object) entity;
	}

	@SuppressWarnings("unchecked")
	protected List<Object> atualizarListaResponse(List<Entity> lista)
	{
		return (List<Object>) lista;
	}

	public Usuario getUsuarioFromRequest(HttpServletRequest request)
	{
		String token = request.getHeader("Authorization");
		String login = jwtTokenUtil.getLoginFromToken(token);
		return usuarioService.pesquisarPorLogin(login);
	}

	protected Sort sortField()
	{
		return null;
	}
}