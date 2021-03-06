package br.com.cdtec.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.DespesaDTO;
import br.com.cdtec.entity.Despesa;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.DespesaService;

@RestController
@RequestMapping("/api/despesa")
@CrossOrigin(origins = "*")
public class DespesaController extends CrudController<Despesa, BigInteger, DespesaService>
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void validarInserir(Despesa entity, BindingResult result)
	{
		if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
			return;
		}
		
		if (entity.getIdConta() == null || entity.getIdConta().doubleValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Conta é obrigatório."));
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
	protected void validarAlterar(Despesa entity, BindingResult result)
	{
		if (entity.getIdDespesa() == null)
		{
			result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
			return;
		}

		if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
			return;
		}
		
		if (entity.getIdConta() == null || entity.getIdConta().doubleValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Conta é obrigatório."));
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
	protected List<Object> atualizarListaResponse(List<Despesa> lista)
	{
		return lista.stream().map(despesa -> convertToDto(despesa)).collect(Collectors.toList());
	}

	@Override
	protected Object atualizarEntityResponse(Despesa entity)
	{
		return this.convertToDto(entity);
	}

	private DespesaDTO convertToDto(Despesa despesa)
	{
		DespesaDTO dto = new DespesaDTO();
		modelMapper.map(despesa, dto);
		dto.setStrVlDespesa(new DecimalFormat("#,##0.00").format(dto.getVlDespesa()));

		return dto;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> inativarDespesa(@PathVariable("id") BigInteger id)
	{
		Response<String> response = new Response<String>();
		try
		{
			if (id == null)
			{
				response.getErrors().add("Despesa não encontrada com o código: " + id);
				return ResponseEntity.badRequest().body(response);
			}

			getService().inativarDespesa(id);

		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(new Response<String>());
	}

	@Override
	protected void completarInserir(Despesa entity, HttpServletRequest request)
	{
		entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
	}
	
	@Override
	protected void completarAlterar(Despesa entity, HttpServletRequest request)
	{
		entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
	}

	@Override
	protected void atualizarStatusEntidade(Despesa entity, Boolean status)
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
