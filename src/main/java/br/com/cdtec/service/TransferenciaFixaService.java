package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.TransferenciaFixaRepository;
import br.com.cdtec.dao.specifications.TransferenciaFixaSpecifications;
import br.com.cdtec.entity.TransferenciaFixa;

@Service
public class TransferenciaFixaService extends CrudService<TransferenciaFixa, BigInteger, TransferenciaFixaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "nrDia";

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<TransferenciaFixa> implementarPesquisar(TransferenciaFixa transferenciaFixa, Sort sort) throws Exception
   {
      List<TransferenciaFixa> lista = getRepository().findAll(Specification.where(TransferenciaFixaSpecifications.idUsuarioIgual(transferenciaFixa.getIdUsuario()))
    		  															   .and(TransferenciaFixaSpecifications.fgAtivoIgual(true))
    		  															   .and(TransferenciaFixaSpecifications.fetchContaOrigem())
                                                                           .and(TransferenciaFixaSpecifications.fetchContaDestino()), sort);
      
      return lista;
   }

}