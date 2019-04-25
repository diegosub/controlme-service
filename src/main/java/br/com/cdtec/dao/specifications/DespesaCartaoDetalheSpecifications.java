package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.DespesaCartaoDetalhe;

public class DespesaCartaoDetalheSpecifications
{

   private DespesaCartaoDetalheSpecifications()
   {
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaCartaoDetalhe> idDespesaCcdIgual(final BigInteger idDespesaCcd)
   {
      return new Specification<DespesaCartaoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaCartaoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idDespesaCcd != null && !idDespesaCcd.toString().equals(""))
            {
               return cb.equal(root.get("idDespesaCcd"), idDespesaCcd);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaCartaoDetalhe> idDespesaCchIgual(final BigInteger idDespesaCch)
   {
      return new Specification<DespesaCartaoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaCartaoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idDespesaCch != null && !idDespesaCch.toString().equals(""))
            {
               return cb.equal(root.get("idDespesaCch"), idDespesaCch);
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<DespesaCartaoDetalhe> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<DespesaCartaoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaCartaoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (fgAtivo != null && !fgAtivo.toString().equals("") && !fgAtivo.toString().equals("T"))
            {
               return cb.equal(root.get("fgAtivo"), fgAtivo);
            }

            return null;
         }
      };
   }

}