package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Cartao;

public class CartaoSpecifications
{

   private CartaoSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<Cartao> dsCartaoLike(final String dsCartao)
   {
      return new Specification<Cartao>()
      {
         public Predicate toPredicate(Root<Cartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (dsCartao != null && !dsCartao.trim().equals(""))
            {
               return cb.like(cb.lower(root.get("dsCartao")), "%" + dsCartao.toLowerCase() + "%");
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<Cartao> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Cartao>()
      {
         public Predicate toPredicate(Root<Cartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Cartao> fgPrincipalIgual(final Boolean fgPrincipal)
   {
      return new Specification<Cartao>()
      {
         public Predicate toPredicate(Root<Cartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Cartao> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Cartao>()
      {
         public Predicate toPredicate(Root<Cartao> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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