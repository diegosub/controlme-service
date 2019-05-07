package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.ReceitaAgendamentoDetalhe;

public class ReceitaAgendamentoDetalheSpecifications
{

   private ReceitaAgendamentoDetalheSpecifications()
   {
   }
   
   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoDetalhe> idReceitaAgdIgual(final BigInteger idReceitaAgd)
   {
      return new Specification<ReceitaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idReceitaAgd != null && !idReceitaAgd.toString().equals(""))
            {
               return cb.equal(root.get("idReceitaAgd"), idReceitaAgd);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoDetalhe> idReceitaAghIgual(final BigInteger idReceitaAgh)
   {
      return new Specification<ReceitaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (idReceitaAgh != null && !idReceitaAgh.toString().equals(""))
            {
               return cb.equal(root.get("idReceitaAgh"), idReceitaAgh);
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoDetalhe> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<ReceitaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<ReceitaAgendamentoDetalhe> fetchConta()
   {
      return new Specification<ReceitaAgendamentoDetalhe>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoDetalhe> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("conta", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }

}