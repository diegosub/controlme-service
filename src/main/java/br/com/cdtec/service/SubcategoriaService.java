package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.SubcategoriaRepository;
import br.com.cdtec.dao.specifications.SubcategoriaSpecifications;
import br.com.cdtec.entity.Subcategoria;


@Service
public class SubcategoriaService extends CrudService<Subcategoria, BigInteger, SubcategoriaRepository> {

	private static final long serialVersionUID = 1L;	
	private final String fieldSort = "dsCategoria";

	@Override
	public void validarInserir(Subcategoria entity) throws Exception {
		Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsSubcategoria());
		
		if(quantidade != null
				&& quantidade > 0) {
			throw new Exception("Já existe uma subategoria cadastrada com esta descrição.");
		}
	}
	
	@Override
	public void validarAlterar(Subcategoria entity) throws Exception {
		Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsSubcategoria(), entity.getIdSubcategoria());
		
		if(quantidade != null
				&& quantidade > 0) {
			throw new Exception("Já existe uma subcategoria cadastrada com esta descrição.");
		}
	}

	public String getFieldSort() {
		return fieldSort;
	}
	
	@Override
	public List<Subcategoria> implementarPesquisar(Subcategoria subcategoria, Sort sort) throws Exception {		
		return getRepository().findAll(Specification.where(SubcategoriaSpecifications.dsSubcategoriaLike(subcategoria.getDsSubcategoria())											  	
										              .and(SubcategoriaSpecifications.fgAtivoIgual(subcategoria.getFgAtivo()))), sort);
	}
	
}