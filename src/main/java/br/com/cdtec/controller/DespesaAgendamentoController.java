package br.com.cdtec.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.crud.controller.CrudController;
import br.com.cdtec.dto.DespesaAgendamentoHeaderDTO;
import br.com.cdtec.entity.DespesaAgendamentoHeader;
import br.com.cdtec.service.DespesaAgendamentoHeaderService;

@RestController
@RequestMapping("/api/despesaAgendamento")
@CrossOrigin(origins = "*")
public class DespesaAgendamentoController extends CrudController<DespesaAgendamentoHeader, BigInteger, DespesaAgendamentoHeaderService>
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void validarInserir(DespesaAgendamentoHeader entity, BindingResult result)
	{
		if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
			return;
		}

		if (entity.getVlDespesaAgh() == null || entity.getVlDespesaAgh().doubleValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Valor é obrigatório."));
			return;
		}
	
		if (entity.getDtInicio() == null || entity.getDtInicio().toString().equals(""))
		{
			result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
			return;
		}
	}

	@Override
	protected void validarAlterar(DespesaAgendamentoHeader entity, BindingResult result)
	{
		if (entity.getIdDespesaAgh() == null)
		{
			result.addError(new ObjectError("Cartao", "O campo Código é obrigatório"));
			return;
		}

		if (entity.getIdCategoria() == null || entity.getIdCategoria().intValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Categoria é obrigatório."));
			return;
		}
	
		if (entity.getVlDespesaAgh() == null || entity.getVlDespesaAgh().doubleValue() == 0)
		{
			result.addError(new ObjectError("Despesa", "O campo Valor é obrigatório."));
			return;
		}

		if (entity.getDtInicio() == null || entity.getDtInicio().toString().equals(""))
		{
			result.addError(new ObjectError("Despesa", "O campo Data é obrigatório."));
			return;
		}
	}

	@Override
	protected List<Object> atualizarListaResponse(List<DespesaAgendamentoHeader> lista)
	{
		return lista.stream().map(despesaAgendamentoHeader -> convertToDto(despesaAgendamentoHeader)).collect(Collectors.toList());
	}

	@Override
	protected Object atualizarEntityResponse(DespesaAgendamentoHeader entity)
	{
		return this.convertToDto(entity);
	}

	private DespesaAgendamentoHeaderDTO convertToDto(DespesaAgendamentoHeader despesa)
	{
		DespesaAgendamentoHeaderDTO dto = new DespesaAgendamentoHeaderDTO();
		modelMapper.map(despesa, dto);

		return dto;
	}

	@Override
	protected void completarInserir(DespesaAgendamentoHeader entity, HttpServletRequest request)
	{
		entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
	}
	
	@Override
	protected void completarAlterar(DespesaAgendamentoHeader entity, HttpServletRequest request)
	{
		entity.setIdSubcategoria(entity.getIdSubcategoria().longValue() == 0L ? null : entity.getIdSubcategoria());
	}

	@Override
	protected void atualizarStatusEntidade(DespesaAgendamentoHeader entity, Boolean status)
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
