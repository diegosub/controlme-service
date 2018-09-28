package br.com.cdtec.dao.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Subcategoria;

public class SubcategoriaSpecifications {
	
	private SubcategoriaSpecifications(){}

	@SuppressWarnings("serial")
	public static Specification<Subcategoria> dsSubcategoriaLike(final String dsSubcategoria){
		return new Specification<Subcategoria>() {
			public Predicate toPredicate(Root<Subcategoria> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(dsSubcategoria != null && !dsSubcategoria.trim().equals("")) {
					return cb.like(cb.lower(root.get("dsSubcategoria")), "%"+dsSubcategoria.toLowerCase()+"%");
				}
				
				return null;
			}
		};
	}
	
	@SuppressWarnings("serial")
	public static Specification<Subcategoria> fgAtivoIgual(final Boolean fgAtivo){
		return new Specification<Subcategoria>() {
			public Predicate toPredicate(Root<Subcategoria> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(fgAtivo != null && !fgAtivo.toString().equals("") && !fgAtivo.toString().equals("T")) {
					return cb.equal(root.get("fgAtivo"), fgAtivo);
				}
				
				return null;
			}
		};
	}
	
}