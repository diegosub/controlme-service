package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.ReceitaFixaRepository;
import br.com.cdtec.dao.specifications.ReceitaFixaSpecifications;
import br.com.cdtec.entity.ReceitaFixa;

@Service
public class ReceitaFixaService extends CrudService<ReceitaFixa, BigInteger, ReceitaFixaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idReceitaFixa";
   
   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<ReceitaFixa> implementarPesquisar(ReceitaFixa receitaFixa, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(ReceitaFixaSpecifications.fgAtivoIgual(receitaFixa.getFgAtivo()))
                                                    .and(ReceitaFixaSpecifications.fetchCategoria())
                                                    .and(ReceitaFixaSpecifications.fetchSubcategoria())
                                                    .and(ReceitaFixaSpecifications.idUsuarioIgual(receitaFixa.getIdUsuario())), sort);
   }
   
   @Override
   public void validarInserir(ReceitaFixa entity) throws Exception
   {
       Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsReceitaFixa(), entity.getIdUsuario());

       if (quantidade != null && quantidade > 0)
       {
           throw new Exception("Já existe uma receita fixa cadastrada com esta descrição.");
       }
   }

   @Override
   public void validarAlterar(ReceitaFixa entity) throws Exception
   {
       Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsReceitaFixa(), entity.getIdReceitaFixa(), entity.getIdUsuario());

       if (quantidade != null && quantidade > 0)
       {
           throw new Exception("Já existe uma receita fixa cadastrada com esta descrição.");
       }
   }
}