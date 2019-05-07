package br.com.cdtec.dao.specifications;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Receita;

public class ReceitaSpecifications
{

   private ReceitaSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<Receita> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Receita>()
      {
         public Predicate toPredicate(Root<Receita> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Receita> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Receita>()
      {
         public Predicate toPredicate(Root<Receita> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Receita> fetchCategoria()
   {
      return new Specification<Receita>()
      {
         public Predicate toPredicate(Root<Receita> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Receita> fetchSubcategoria()
   {
      return new Specification<Receita>()
      {
         public Predicate toPredicate(Root<Receita> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            root.fetch("subcategoria", JoinType.LEFT);
            query.distinct(true);
           
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<Receita> fetchConta()
   {
      return new Specification<Receita>()
      {
         public Predicate toPredicate(Root<Receita> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (query.getResultType() != Long.class)
            {
               root.fetch("conta");
            }
            else
            {
               root.join("conta");
            }
            return null;
         }
      };
   }
   
   @SuppressWarnings("serial")
   public static Specification<Receita> dtDespesaBetween(final Date dtReceitaInicio, final Date dtReceitaFim)
   {
      return new Specification<Receita>()
      {
         public Predicate toPredicate(Root<Receita> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (dtReceitaInicio != null && !dtReceitaInicio.toString().equals("")
                  && dtReceitaFim != null && !dtReceitaFim.toString().equals(""))
            {
               return cb.between(root.get("dtReceita"), dtReceitaInicio, dtReceitaFim); 
            }

            return null;
         }
      };
   }

}