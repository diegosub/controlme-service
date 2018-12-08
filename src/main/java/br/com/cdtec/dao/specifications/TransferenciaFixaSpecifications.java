package br.com.cdtec.dao.specifications;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.TransferenciaFixa;

public class TransferenciaFixaSpecifications
{

   private TransferenciaFixaSpecifications()
   {
   }
   
   @SuppressWarnings("serial")
   public static Specification<TransferenciaFixa> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<TransferenciaFixa>()
      {
         public Predicate toPredicate(Root<TransferenciaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<TransferenciaFixa> fetchContaOrigem()
   {
      return new Specification<TransferenciaFixa>()
      {
         public Predicate toPredicate(Root<TransferenciaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (query.getResultType() != Long.class)
            {
               root.fetch("contaOrigem");
            }
            else
            {
               root.join("contaOrigem");
            }
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<TransferenciaFixa> fetchContaDestino()
   {
      return new Specification<TransferenciaFixa>()
      {
         public Predicate toPredicate(Root<TransferenciaFixa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (query.getResultType() != Long.class)
            {
               root.fetch("contaDestino");
            }
            else
            {
               root.join("contaDestino");
            }
            return null;
         }
      };
   }

}