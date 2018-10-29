package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DominioRepository;
import br.com.cdtec.entity.Dominio;

@Service
public class DominioService extends CrudService<Dominio, BigInteger, DominioRepository>
{
   private static final long serialVersionUID = 1L;
   
   public List<Dominio> pesquisarPorCampo(Dominio dominio) 
   {
      List<Dominio> lista = getRepository().pesquisarPorCampo(dominio.getDsCampo());
      return lista;
   }
}