package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

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

}