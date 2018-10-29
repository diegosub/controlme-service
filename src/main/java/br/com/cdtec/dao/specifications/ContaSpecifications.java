package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Cartao;
import br.com.cdtec.entity.Conta;

public class ContaSpecifications
{

   private ContaSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<Conta> dsCartaoLike(final String dsConta)
   {
      return new Specification<Conta>()
      {
         public Predicate toPredicate(Root<Conta> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (dsConta != null && !dsConta.trim().equals(""))
            {
               return cb.like(cb.lower(root.get("dsConta")), "%" + dsConta.toLowerCase() + "%");
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<Conta> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Conta>()
      {
         public Predicate toPredicate(Root<Conta> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Conta> fgPrincipalIgual(final Boolean fgPrincipal)
   {
      return new Specification<Conta>()
      {
         public Predicate toPredicate(Root<Conta> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (fgPrincipal != null && !fgPrincipal.toString().equals(""))
            {
               return cb.equal(root.get("fgPrincipal"), fgPrincipal);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<Conta> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Conta>()
      {
         public Predicate toPredicate(Root<Conta> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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