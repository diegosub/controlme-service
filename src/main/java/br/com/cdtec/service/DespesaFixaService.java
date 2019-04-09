package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DespesaFixaRepository;
import br.com.cdtec.dao.specifications.DespesaFixaSpecifications;
import br.com.cdtec.entity.DespesaFixa;

@Service
public class DespesaFixaService extends CrudService<DespesaFixa, BigInteger, DespesaFixaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idDespesaFixa";
   
   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaFixa> implementarPesquisar(DespesaFixa despesaFixa, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DespesaFixaSpecifications.fgAtivoIgual(despesaFixa.getFgAtivo()))
                                                    .and(DespesaFixaSpecifications.fetchCategoria())
                                                    .and(DespesaFixaSpecifications.fetchSubcategoria())
                                                    .and(DespesaFixaSpecifications.idUsuarioIgual(despesaFixa.getIdUsuario())), sort);
   }
   
   @Override
   public void validarInserir(DespesaFixa entity) throws Exception
   {
       Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsDespesaFixa(), entity.getIdUsuario());

       if (quantidade != null && quantidade > 0)
       {
           throw new Exception("Já existe uma despesa fixa cadastrada com esta descrição.");
       }
   }

   @Override
   public void validarAlterar(DespesaFixa entity) throws Exception
   {
       Integer quantidade = getRepository().quantidadePorDescricao(entity.getDsDespesaFixa(), entity.getIdDespesaFixa(), entity.getIdUsuario());

       if (quantidade != null && quantidade > 0)
       {
           throw new Exception("Já existe uma despesa fixa cadastrada com esta descrição.");
       }
   }
}