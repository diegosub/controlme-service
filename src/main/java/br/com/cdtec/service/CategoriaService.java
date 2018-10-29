package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.CategoriaRepository;
import br.com.cdtec.dao.specifications.CategoriaSpecifications;
import br.com.cdtec.entity.Categoria;

@Service
public class CategoriaService extends CrudService<Categoria, BigInteger, CategoriaRepository>
{

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Categoria> pesquisarInativos(Categoria categoria) throws Exception
	{
		List<Categoria> lista = new ArrayList<Categoria>();

		// LISTANDO CATEGORIAS INATIVAS
		List<Categoria> listaCatInv = getRepository().findAll(Specification.where(CategoriaSpecifications.fetchSubcategoria())
		                                                                     .and(CategoriaSpecifications.idUsuarioIgual(categoria.getIdUsuario()))
																			 .and(CategoriaSpecifications.tpCategoriaIgual(categoria.getTpCategoria()))
																			 .and(CategoriaSpecifications.fgAtivoIgual(false)));

		// LISTANDO SUBCATEGORIAS INATIVAS COM CATEGORIAS ATIVAS
		List<Categoria> listaCatAtvSubInv = getRepository().findAll(Specification.where(CategoriaSpecifications.fetchSubcategoriaFgAtivoIgual(false))
		                                                                           .and(CategoriaSpecifications.idUsuarioIgual(categoria.getIdUsuario()))
																				   .and(CategoriaSpecifications.tpCategoriaIgual(categoria.getTpCategoria()))
																				   .and(CategoriaSpecifications.fgAtivoIgual(true)));

		lista.addAll(listaCatInv);
		lista.addAll(listaCatAtvSubInv);

		//ORDENANDO LISTA FINAL
		Collections.sort (lista, new Comparator() {
            public int compare(Object o1, Object o2) {
                Categoria p1 = (Categoria) o1;
                Categoria p2 = (Categoria) o2;
                return p1.getDsCategoria().compareTo(p2.getDsCategoria());
            }
        });
		
		
		return lista;
	}

	@Override
	public void validarInserir(Categoria entity) throws Exception
	{
		Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsCategoria(), entity.getTpCategoria(), entity.getIdUsuario());

		if (quantidade != null && quantidade > 0)
		{
			throw new Exception("Já existe uma categoria cadastrada com esta descrição.");
		}
	}

	@Override
	public void validarAlterar(Categoria entity) throws Exception
	{
		Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsCategoria(), entity.getTpCategoria(),
				entity.getIdCategoria(), entity.getIdUsuario());

		if (quantidade != null && quantidade > 0)
		{
			throw new Exception("Já existe uma categoria cadastrada com esta descrição.");
		}
	}

	@Override
	public List<Categoria> implementarPesquisar(Categoria categoria, Sort sort) throws Exception
	{
		Filter filter = (Filter) entityManager.unwrap(Session.class).enableFilter("filtroFlgAtivoSubcategoria");
		filter.setParameter("flgAtivoSubcategoria", true);

		List<Categoria> lista = getRepository().findAll(Specification.where(CategoriaSpecifications.fetchSubcategoria())
                                                         				.and(CategoriaSpecifications.tpCategoriaIgual(categoria.getTpCategoria()))
                                                         				.and(CategoriaSpecifications.idUsuarioIgual(categoria.getIdUsuario()))
                                                         				.and(CategoriaSpecifications.fgAtivoIgual(categoria.getFgAtivo())));

		entityManager.unwrap(Session.class).disableFilter("filtroFlgAtivoSubcategoria");
		return lista;
	}

}