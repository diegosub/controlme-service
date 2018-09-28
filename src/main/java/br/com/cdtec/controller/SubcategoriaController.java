package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.entity.Subcategoria;
import br.com.cdtec.service.SubcategoriaService;

@RestController
@RequestMapping("/api/subcategoria")
@CrossOrigin(origins = "*")
public class SubcategoriaController extends CrudController<Subcategoria, BigInteger, SubcategoriaService>
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void completarInserir(Subcategoria entity, HttpServletRequest request)
	{
		entity.setDtCadastro(new Date());
		entity.setFgAtivo(true);
	}

	@Override
	protected void completarAlterar(Subcategoria entity, HttpServletRequest request)
	{
		entity.setDtAlteracao(new Date());
	}

	@Override
	protected void validarInserir(Subcategoria entity, BindingResult result)
	{
		if (entity.getDsSubcategoria() == null || entity.getDsSubcategoria().trim().equals(""))
		{
			result.addError(new ObjectError("Subcategoria", "Descrição obrigatória."));
			return;
		}
	}

	@Override
	protected void validarAlterar(Subcategoria entity, BindingResult result)
	{
		if (entity.getIdSubcategoria() == null)
		{
			result.addError(new ObjectError("Subcategoria", "Código informado"));
			return;
		}

		if (entity.getDsSubcategoria() == null || entity.getDsSubcategoria().trim().equals(""))
		{
			result.addError(new ObjectError("Subcategoria", "Descrição obrigatória."));
			return;
		}
	}

	@Override
	protected void atualizarStatusEntidade(Subcategoria entity, Boolean status)
	{
		entity.setFgAtivo(status);
		entity.setDtAlteracao(new Date());
	}

	@Override
	protected Sort sortField()
	{
		return new Sort(Direction.ASC, getService().getFieldSort());
	}
}
