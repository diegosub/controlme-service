package br.com.cdtec.dao.specifications;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.ReceitaAgendamentoHeader;

public class ReceitaAgendamentoHeaderSpecifications
{

   private ReceitaAgendamentoHeaderSpecifications()
   {
   }
   
   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoHeader> idReceitaAghIgual(final BigInteger idReceitaAgh)
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<ReceitaAgendamentoHeader> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<ReceitaAgendamentoHeader> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<ReceitaAgendamentoHeader> tpReceitaIgual(final String tpReceitaAgh)
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (tpReceitaAgh != null && !tpReceitaAgh.toString().equals(""))
            {
               return cb.equal(root.get("tpReceitaAgh"), tpReceitaAgh);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoHeader> fetchCategoria()
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (query.getResultType() != Long.class)
            {
               root.fetch("categoria");
            }
            else
            {
               root.join("categoria");
            }
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoHeader> fetchSubcategoria()
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("subcategoria", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<ReceitaAgendamentoHeader> dtDespesaBetween(final Date dtInicioInicio, final Date dtInicioFim)
   {
      return new Specification<ReceitaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<ReceitaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (dtInicioInicio != null && !dtInicioInicio.toString().equals("")
                  && dtInicioFim != null && !dtInicioFim.toString().equals(""))
            {
               return cb.between(root.get("dtInicio"), dtInicioInicio, dtInicioFim); 
            }

            return null;
         }
      };
   }

}