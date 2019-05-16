package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DividaRepository;
import br.com.cdtec.dao.specifications.DividaSpecifications;
import br.com.cdtec.entity.Divida;

@Service
public class DividaService extends CrudService<Divida, BigInteger, DividaRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "dtVencimento";

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<Divida> implementarPesquisar(Divida divida, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DividaSpecifications.idUsuarioIgual(divida.getIdUsuario())
                                                    .and(DividaSpecifications.nrMesIgualOrNull(divida.getNrMesVencimento()))
                                                    .and(DividaSpecifications.nrAnoIgualOrNull(divida.getNrAnoVencimento()))), Sort.by("dtVencimento","dsTipo").ascending());
   }
}