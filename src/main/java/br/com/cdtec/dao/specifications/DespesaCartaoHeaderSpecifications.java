package br.com.cdtec.dao.specifications;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.DespesaCartaoHeader;

public class DespesaCartaoHeaderSpecifications
{

   private DespesaCartaoHeaderSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<DespesaCartaoHeader> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<DespesaCartaoHeader>()
      {
         public Predicate toPredicate(Root<DespesaCartaoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartaoHeader> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<DespesaCartaoHeader>()
      {
         public Predicate toPredicate(Root<DespesaCartaoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartaoHeader> fetchCategoria()
   {
      return new Specification<DespesaCartaoHeader>()
      {
         public Predicate toPredicate(Root<DespesaCartaoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartaoHeader> fetchSubcategoria()
   {
      return new Specification<DespesaCartaoHeader>()
      {
         public Predicate toPredicate(Root<DespesaCartaoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("subcategoria", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaCartaoHeader> fetchCartao()
   {
      return new Specification<DespesaCartaoHeader>()
      {
         public Predicate toPredicate(Root<DespesaCartaoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (query.getResultType() != Long.class)
            {
               root.fetch("cartao");
            }
            else
            {
               root.join("cartao");
            }
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaCartaoHeader> dtDespesaBetween(final Date dtDespesaInicio, final Date dtDespesaFim)
   {
      return new Specification<DespesaCartaoHeader>()
      {
         public Predicate toPredicate(Root<DespesaCartaoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (dtDespesaInicio != null && !dtDespesaInicio.toString().equals("")
                  && dtDespesaFim != null && !dtDespesaFim.toString().equals(""))
            {
               return cb.between(root.get("dtDespesa"), dtDespesaInicio, dtDespesaFim); 
            }

            return null;
         }
      };
   }

}