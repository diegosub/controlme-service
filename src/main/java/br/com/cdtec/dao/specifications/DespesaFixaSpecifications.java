package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.DespesaFixa;

public class DespesaFixaSpecifications
{

   private DespesaFixaSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<DespesaFixa> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<DespesaFixa>()
      {
         public Predicate toPredicate(Root<DespesaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (fgAtivo != null && !fgAtivo.toString().equals("") && !fgAtivo.toString().equals("T"))
            {
               return cb.equal(root.get("fgAtivo"), fgAtivo);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaFixa> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<DespesaFixa>()
      {
         public Predicate toPredicate(Root<DespesaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idUsuario != null && !idUsuario.toString().equals(""))
            {
               return cb.equal(root.get("idUsuario"), idUsuario);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaFixa> fetchCategoria()
   {
      return new Specification<DespesaFixa>()
      {
         public Predicate toPredicate(Root<DespesaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (query.getResultType() != Long.class)
            {
               root.fetch("categoria");
            }
            else
            {
               root.join("categoria");
            }
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaFixa> fetchSubcategoria()
   {
      return new Specification<DespesaFixa>()
      {
         public Predicate toPredicate(Root<DespesaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("subcategoria", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }

}