package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Despesa;

public class DespesaSpecifications
{

   private DespesaSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<Despesa> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Despesa>()
      {
         public Predicate toPredicate(Root<Despesa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Despesa> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Despesa>()
      {
         public Predicate toPredicate(Root<Despesa> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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