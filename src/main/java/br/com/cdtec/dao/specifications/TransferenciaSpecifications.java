package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Transferencia;

public class TransferenciaSpecifications
{

   private TransferenciaSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<Transferencia> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Transferencia>()
      {
         public Predicate toPredicate(Root<Transferencia> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Transferencia> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Transferencia>()
      {
         public Predicate toPredicate(Root<Transferencia> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (fgAtivo != null && !fgAtivo.toString().equals(""))
            {
               return cb.equal(root.get("fgAtivo"), fgAtivo);
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<Transferencia> fetchContaOrigem()
   {
      return new Specification<Transferencia>()
      {
         public Predicate toPredicate(Root<Transferencia> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Transferencia> fetchContaDestino()
   {
      return new Specification<Transferencia>()
      {
         public Predicate toPredicate(Root<Transferencia> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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