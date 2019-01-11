package br.com.cdtec.dao.specifications;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.DespesaCartao;

public class DespesaCartaoSpecifications
{

   private DespesaCartaoSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<DespesaCartao> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<DespesaCartao>()
      {
         public Predicate toPredicate(Root<DespesaCartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartao> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<DespesaCartao>()
      {
         public Predicate toPredicate(Root<DespesaCartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartao> fetchCategoria()
   {
      return new Specification<DespesaCartao>()
      {
         public Predicate toPredicate(Root<DespesaCartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartao> fetchSubcategoria()
   {
      return new Specification<DespesaCartao>()
      {
         public Predicate toPredicate(Root<DespesaCartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("subcategoria", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaCartao> fetchCartao()
   {
      return new Specification<DespesaCartao>()
      {
         public Predicate toPredicate(Root<DespesaCartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaCartao> dtDespesaBetween(final Date dtDespesaInicio, final Date dtDespesaFim)
   {
      return new Specification<DespesaCartao>()
      {
         public Predicate toPredicate(Root<DespesaCartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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