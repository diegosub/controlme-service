package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.DespesaAgendamentoDetalhe;

public class DespesaAgendamentoDetalheSpecifications
{

   private DespesaAgendamentoDetalheSpecifications()
   {
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaAgendamentoDetalhe> idDespesaAgdIgual(final BigInteger idDespesaAgd)
   {
      return new Specification<DespesaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idDespesaAgd != null && !idDespesaAgd.toString().equals(""))
            {
               return cb.equal(root.get("idDespesaAgd"), idDespesaAgd);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaAgendamentoDetalhe> idDespesaAghIgual(final BigInteger idDespesaAgh)
   {
      return new Specification<DespesaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idDespesaAgh != null && !idDespesaAgh.toString().equals(""))
            {
               return cb.equal(root.get("idDespesaAgh"), idDespesaAgh);
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<DespesaAgendamentoDetalhe> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<DespesaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaAgendamentoDetalhe> fetchConta()
   {
      return new Specification<DespesaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("conta", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }

}