package br.com.cdtec.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.dao.repository.DespesaCartaoDetalheRepository;
import br.com.cdtec.dao.repository.DespesaCartaoHeaderRepository;
import br.com.cdtec.dao.specifications.DespesaCartaoHeaderSpecifications;
import br.com.cdtec.entity.Cartao;
import br.com.cdtec.entity.DespesaCartaoDetalhe;
import br.com.cdtec.entity.DespesaCartaoHeader;

@Service
public class DespesaCartaoHeaderService extends CrudService<DespesaCartaoHeader, BigInteger, DespesaCartaoHeaderRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idDespesaCch";
   
   @Autowired
   private DespesaCartaoDetalheRepository detalheRepository;
   
   @Autowired
   private DespesaCartaoDetalheService detalheService;
   
   @Autowired
   private CartaoService cartaoService;

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaCartaoHeader> implementarPesquisar(DespesaCartaoHeader despesaCch, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DespesaCartaoHeaderSpecifications.fgAtivoIgual(despesaCch.getFgAtivo()))
    		  										.and(DespesaCartaoHeaderSpecifications.dtDespesaBetween(despesaCch.getFiltro().getDtDespesaInicio(), despesaCch.getFiltro().getDtDespesaFim()))
    		  									    .and(DespesaCartaoHeaderSpecifications.fetchCategoria())
    		  									    .and(DespesaCartaoHeaderSpecifications.fetchSubcategoria())
    		  									    .and(DespesaCartaoHeaderSpecifications.fetchCartao())
                                                    .and(DespesaCartaoHeaderSpecifications.idUsuarioIgual(despesaCch.getIdUsuario())), sort);
   }
   
   @Override
   @Transactional
   public DespesaCartaoHeader inserir(DespesaCartaoHeader despesaCch) throws Exception
   {
      validarInserir(despesaCch);
      completarInserir(despesaCch);

      // INSERINDO DESPESA CARTAO HEADER
      getRepository().save(despesaCch);
      
      // GET DADOS CARTAO
      Cartao cartao = cartaoService.get(despesaCch.getIdCartao()).get();

      Date dataVencimento = despesaCch.getDtDespesa();
      GregorianCalendar gc = new GregorianCalendar();
      gc.setTime(dataVencimento);
      
      if(gc.get(Calendar.DAY_OF_MONTH) >= cartao.getNrDiaCorte())
      {
         gc.add(Calendar.MONTH, 1);
      }
      
      gc.set(Calendar.DAY_OF_MONTH, cartao.getNrDiaVencimento());

      
      // INSERINDO DESPESA AGENDAMENTO DETALHE
      for(int i = 0; i < despesaCch.getNrParcelas(); i++)
      {
         if(i != 0) 
         {
            gc.add(Calendar.MONTH, 1);
         }
         
         DespesaCartaoDetalhe detalhe = new DespesaCartaoDetalhe();
         detalhe.setIdDespesaCch(despesaCch.getIdDespesaCch());
         detalhe.setNrParcela(i+1);
         detalhe.setVlParcela(despesaCch.getVlDespesa().doubleValue() / despesaCch.getNrParcelas().doubleValue());
         detalhe.setFgAtivo(true);
         detalhe.setDtCadastro(despesaCch.getDtCadastro());
         detalhe.setDtVencimento(gc.getTime());
         
         detalheRepository.save(detalhe);
      }
     

      return despesaCch;
   }
   
   @Override
   @Transactional
   public DespesaCartaoHeader alterar(DespesaCartaoHeader despesaCch) throws Exception
   {
      validarAlterar(despesaCch);
      completarAlterar(despesaCch);

      // ALTERANDO DESPESA CARTAO HEADER
      getRepository().save(despesaCch);

      // DELETANDO TODOS OS DETALHES
      DespesaCartaoDetalhe detalheDel = new DespesaCartaoDetalhe();
      detalheDel.setIdDespesaCch(despesaCch.getIdDespesaCch());
      
      List<DespesaCartaoDetalhe> listaDetalhe = detalheService.pesquisar(detalheDel, null);
      
      for (DespesaCartaoDetalhe despesaCartaoDetalhe : listaDetalhe)
      {
         detalheRepository.delete(despesaCartaoDetalhe);
      }
      
      // GET DADOS CARTAO
      Cartao cartao = cartaoService.get(despesaCch.getIdCartao()).get();

      Date dataVencimento = despesaCch.getDtDespesa();
      GregorianCalendar gc = new GregorianCalendar();
      gc.setTime(dataVencimento);
      
      if(gc.get(Calendar.DAY_OF_MONTH) >= cartao.getNrDiaCorte())
      {
         gc.add(Calendar.MONTH, 1);
      }
      
      gc.set(Calendar.DAY_OF_MONTH, cartao.getNrDiaVencimento());

      
      // INSERINDO DESPESA AGENDAMENTO DETALHE
      for(int i = 0; i < despesaCch.getNrParcelas(); i++)
      {
         if(i != 0) 
         {
            gc.add(Calendar.MONTH, 1);
         }
         
         DespesaCartaoDetalhe detalhe = new DespesaCartaoDetalhe();
         detalhe.setIdDespesaCch(despesaCch.getIdDespesaCch());
         detalhe.setNrParcela(i+1);
         detalhe.setVlParcela(despesaCch.getVlDespesa().doubleValue() / despesaCch.getNrParcelas().doubleValue());
         detalhe.setFgAtivo(true);
         detalhe.setDtCadastro(despesaCch.getDtCadastro());
         detalhe.setDtVencimento(gc.getTime());
         
         detalheRepository.save(detalhe);
      }

      return despesaCch;
   }
   
   @Transactional
   public void inativarDespesaCartao(BigInteger idDespesaCartao) throws Exception
   {
      Optional<DespesaCartaoHeader> despesaOptional = this.get(idDespesaCartao);
      DespesaCartaoHeader despesaCartao = despesaOptional.get();
      
      despesaCartao.setFgAtivo(false);
      despesaCartao.setDtAlteracao(new Date());
      
      getRepository().save(despesaCartao);
   }

}