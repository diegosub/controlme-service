package br.com.cdtec.dao.specifications;

import java.math.BigInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cdtec.entity.Cartao;
import br.com.cdtec.entity.Categoria;

public class CategoriaSpecifications
{

   private CategoriaSpecifications()
   {
   }

   @SuppressWarnings("serial")
   public static Specification<Categoria> fetchSubcategoria()
   {
      return new Specification<Categoria>()
      {
         @Override
         @SuppressWarnings("rawtypes")
         public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            Join listaSubcategoria = (Join) root.fetch("listaSubcategoria", JoinType.LEFT);
            query.distinct(true);
            query.orderBy(cb.asc(root.get("dsCategoria")), cb.asc(listaSubcategoria.get("dsSubcategoria")));
            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<Categoria> fetchSubcategoriaFgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Categoria>()
      {
         @Override
         @SuppressWarnings("rawtypes")
         public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            Join listaSubcategoria = (Join) root.fetch("listaSubcategoria", JoinType.LEFT);
            query.distinct(true);
            query.orderBy(cb.asc(root.get("dsCategoria")), cb.asc(listaSubcategoria.get("dsSubcategoria")));

            if (fgAtivo != null && !fgAtivo.toString().equals(""))
            {
               return cb.equal(listaSubcategoria.get("fgAtivo"), fgAtivo);
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<Categoria> fgAtivoIgual(final Boolean fgAtivo)
   {
      return new Specification<Categoria>()
      {
         public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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
   public static Specification<Categoria> tpCategoriaIgual(final String tpCategoria)
   {
      return new Specification<Categoria>()
      {
         public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder cb)
         {
            if (tpCategoria != null && !tpCategoria.trim().equals("") && !tpCategoria.trim().equals("T"))
            {
               return cb.equal(root.get("tpCategoria"), tpCategoria);
            }

            return null;
         }
      };
   }

   @SuppressWarnings("serial")
   public static Specification<Categoria> idUsuarioIgual(final BigInteger idUsuario)
   {
      return new Specification<Categoria>()
      {
         public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder cb)
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