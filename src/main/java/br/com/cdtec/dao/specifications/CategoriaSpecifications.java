package br.com.cdtec.dao.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Categoria;

public class CategoriaSpecifications {
	
	private CategoriaSpecifications(){}

	@SuppressWarnings("serial")
	public static Specification<Categoria> dsCategoriaLike(final String dsCategoria){
		return new Specification<Categoria>() {
			public Predicate toPredicate(Root<Categoria> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(dsCategoria != null && !dsCategoria.trim().equals("")) {
					return cb.like(cb.lower(root.get("dsCategoria")), "%"+dsCategoria.toLowerCase()+"%");
				}
				
				return null;
			}
		};
	}
	
	@SuppressWarnings("serial")
	public static Specification<Categoria> fgAtivoIgual(final Boolean fgAtivo){
		return new Specification<Categoria>() {
			public Predicate toPredicate(Root<Categoria> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(fgAtivo != null && !fgAtivo.toString().equals("") && !fgAtivo.toString().equals("T")) {
					return cb.equal(root.get("fgAtivo"), fgAtivo);
				}
				
				return null;
			}
		};
	}
	
	@SuppressWarnings("serial")
	public static Specification<Categoria> tpCategoriaIgual(final String tpCategoria){
		return new Specification<Categoria>() {
			public Predicate toPredicate(Root<Categoria> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(tpCategoria != null && !tpCategoria.trim().equals("") && !tpCategoria.trim().equals("T")) {
					return cb.equal(root.get("tpCategoria"), tpCategoria);
				}
				
				return null;
			}
		};
	}
}