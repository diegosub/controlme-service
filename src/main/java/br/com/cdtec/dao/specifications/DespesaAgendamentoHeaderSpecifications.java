package br.com.cdtec.dao.specifications;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.DespesaAgendamentoHeader;

public class DespesaAgendamentoHeaderSpecifications
{

   private DespesaAgendamentoHeaderSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<DespesaAgendamentoHeader> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<DespesaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaAgendamentoHeader> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<DespesaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaAgendamentoHeader> tpDespesaIgual(final String tpDespesaAgh)
   {
      return new Specification<DespesaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (tpDespesaAgh != null && !tpDespesaAgh.toString().equals(""))
            {
               return cb.equal(root.get("tpDespesaAgh"), tpDespesaAgh);
            }

            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaAgendamentoHeader> fetchCategoria()
   {
      return new Specification<DespesaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<DespesaAgendamentoHeader> fetchSubcategoria()
   {
      return new Specification<DespesaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("subcategoria", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<DespesaAgendamentoHeader> dtDespesaBetween(final Date dtInicioInicio, final Date dtInicioFim)
   {
      return new Specification<DespesaAgendamentoHeader>()
      {
         public Predicate toPredicate(Root<DespesaAgendamentoHeader> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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