package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Divida;

public class DividaSpecifications
{

   private DividaSpecifications()
   {
   }
   
   @SuppressWarnings("serial")
   public static Specification<Divida> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Divida>()
      {
         public Predicate toPredicate(Root<Divida> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Divida> nrMesIgualOrNull(final Integer nrMesVencimento)
   {
      return new Specification<Divida>()
      {
         public Predicate toPredicate(Root<Divida> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (nrMesVencimento != null && !nrMesVencimento.toString().equals(""))
            {
               return cb.or(cb.equal(root.get("nrMesVencimento"), nrMesVencimento), 
                            cb.isNull(root.get("nrMesVencimento")));
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<Divida> nrAnoIgualOrNull(final Integer nrAnoVencimento)
   {
      return new Specification<Divida>()
      {
         public Predicate toPredicate(Root<Divida> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (nrAnoVencimento != null && !nrAnoVencimento.toString().equals(""))
            {
               return cb.or(cb.equal(root.get("nrAnoVencimento"), nrAnoVencimento), 
                     cb.isNull(root.get("nrAnoVencimento")));
            }

            return null;
         }
      };
   }

}