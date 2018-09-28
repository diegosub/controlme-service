package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Filter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.CategoriaRepository;
import br.com.cdtec.dao.specifications.CategoriaSpecifications;
import br.com.cdtec.entity.Categoria;


@Service
public class CategoriaService extends CrudService<Categoria, BigInteger, CategoriaRepository> {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext 
    private EntityManager entityManager;

	@Override
	public void validarInserir(Categoria entity) throws Exception {
		Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsCategoria(), entity.getTpCategoria());
		
		if(quantidade != null
				&& quantidade > 0) {
			throw new Exception("Já existe uma categoria cadastrada com esta descrição.");
		}
	}
	
	@Override
	public void validarAlterar(Categoria entity) throws Exception {
		Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsCategoria(), entity.getTpCategoria(), entity.getIdCategoria());
		
		if(quantidade != null
				&& quantidade > 0) {
			throw new Exception("Já existe uma categoria cadastrada com esta descrição.");
		}
	}
	
	@Override
	public List<Categoria> implementarPesquisar(Categoria categoria, Sort sort) throws Exception
	{	
		Filter filter = (Filter)entityManager.unwrap(Session.class).enableFilter("filtroFlgAtivoSubcategoria");
        filter.setParameter("flgAtivoSubcategoria", true);

		
		List<Categoria> lista =  getRepository().findAll(Specification.where(CategoriaSpecifications.fetchSubcategoriaAtiva())
													  .and(CategoriaSpecifications.tpCategoriaIgual(categoria.getTpCategoria()))													  
										              .and(CategoriaSpecifications.fgAtivoIgual(categoria.getFgAtivo())));
		
		entityManager.unwrap(Session.class).disableFilter("filtroFlgAtivoSubcategoria");
		return lista;
	}
	
}