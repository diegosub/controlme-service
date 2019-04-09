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
import br.com.cdtec.dao.repository.DespesaAgendamentoDetalheRepository;
import br.com.cdtec.dao.repository.DespesaAgendamentoHeaderRepository;
import br.com.cdtec.dao.specifications.DespesaAgendamentoHeaderSpecifications;
import br.com.cdtec.entity.DespesaAgendamentoDetalhe;
import br.com.cdtec.entity.DespesaAgendamentoHeader;

@Service
public class DespesaAgendamentoHeaderService extends CrudService<DespesaAgendamentoHeader, BigInteger, DespesaAgendamentoHeaderRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idDespesaAgh";
   
   private static final int TIPO_PERIODO_AGENDAMENTO_DIARIA = 1;
   private static final int TIPO_PERIODO_AGENDAMENTO_SEMANAL = 2;
   private static final int TIPO_PERIODO_AGENDAMENTO_MENSAL = 3;
   private static final int TIPO_PERIODO_AGENDAMENTO_ANUAL = 4;
   
   @Autowired
   private DespesaAgendamentoDetalheRepository detalheRepository;
   
   @Autowired
   private DespesaAgendamentoDetalheService detalheService;

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<DespesaAgendamentoHeader> implementarPesquisar(DespesaAgendamentoHeader despesaAgh, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(DespesaAgendamentoHeaderSpecifications.fgAtivoIgual(despesaAgh.getFgAtivo()))
                                                    .and(DespesaAgendamentoHeaderSpecifications.dtDespesaBetween(despesaAgh.getFiltro().getDtInicioInicio(), despesaAgh.getFiltro().getDtInicioFim()))
                                                    .and(DespesaAgendamentoHeaderSpecifications.fetchCategoria())
    		  									    .and(DespesaAgendamentoHeaderSpecifications.fetchSubcategoria())    		  									    
                                                    .and(DespesaAgendamentoHeaderSpecifications.idUsuarioIgual(despesaAgh.getIdUsuario())), sort);
   }
   
   @Override
   @Transactional
   public DespesaAgendamentoHeader inserir(DespesaAgendamentoHeader despesaAgh) throws Exception
   {
      validarInserir(despesaAgh);
      completarInserir(despesaAgh);

      // INSERINDO DESPESA AGENDAMENTO HEADER
      getRepository().save(despesaAgh);

      Date dataVencimento = despesaAgh.getDtInicio();
      GregorianCalendar gc = new GregorianCalendar();
      gc.setTime(dataVencimento);
      
      // INSERINDO DESPESA AGENDAMENTO DETALHE
      for(int i = 0; i < despesaAgh.getNrParcelas(); i++)
      {
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_DIARIA)
         {
            gc.add(Calendar.DAY_OF_MONTH, 1);
         }
         
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_SEMANAL)
         {
            gc.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
         }
         
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_MENSAL)
         {
            gc.add(Calendar.MONTH, 1);
         }
         
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_ANUAL)
         {
            gc.add(Calendar.YEAR, 1);
         }
         
         DespesaAgendamentoDetalhe detalhe = new DespesaAgendamentoDetalhe();
         detalhe.setIdDespesaAgh(despesaAgh.getIdDespesaAgh());
         detalhe.setNrParcela(i+1);
         detalhe.setVlParcela(despesaAgh.getVlDespesaAgh().doubleValue() / despesaAgh.getNrParcelas().doubleValue());
         detalhe.setFgDespesaPaga(false);
         detalhe.setFgAtivo(true);
         detalhe.setDtCadastro(despesaAgh.getDtCadastro());
         detalhe.setDtVencimento(gc.getTime());
         
         detalheRepository.save(detalhe);
      }
     

      return despesaAgh;
   }
   
   @Override
   @Transactional
   public DespesaAgendamentoHeader alterar(DespesaAgendamentoHeader despesaAgh) throws Exception
   {
      validarAlterar(despesaAgh);
      completarAlterar(despesaAgh);

      // ALTERANDO DESPESA HEADER
      getRepository().save(despesaAgh);

      // DELETANDO TODOS OS DETALHES
      DespesaAgendamentoDetalhe detalhe = new DespesaAgendamentoDetalhe();
      detalhe.setIdDespesaAgh(despesaAgh.getIdDespesaAgh());
      
      List<DespesaAgendamentoDetalhe> listaDetalhe = detalheService.pesquisar(detalhe, null);
      
      for (DespesaAgendamentoDetalhe despesaAgendamentoDetalhe : listaDetalhe)
      {
         detalheRepository.delete(despesaAgendamentoDetalhe);
      }
      
      // ADICIONANDO NOVAS DESPESA DETALHE
      Date dataVencimento = despesaAgh.getDtInicio();
      GregorianCalendar gc = new GregorianCalendar();
      gc.setTime(dataVencimento);
      
      // INSERINDO DESPESA AGENDAMENTO DETALHE
      for(int i = 0; i < despesaAgh.getNrParcelas(); i++)
      {
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_DIARIA)
         {
            gc.add(Calendar.DAY_OF_MONTH, 1);
         }
         
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_SEMANAL)
         {
            gc.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
         }
         
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_MENSAL)
         {
            gc.add(Calendar.MONTH, 1);
         }
         
         if(i != 0 && despesaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_ANUAL)
         {
            gc.add(Calendar.YEAR, 1);
         }
         
         DespesaAgendamentoDetalhe agendamentoDetalhe = new DespesaAgendamentoDetalhe();
         agendamentoDetalhe.setIdDespesaAgh(despesaAgh.getIdDespesaAgh());
         agendamentoDetalhe.setNrParcela(i+1);
         agendamentoDetalhe.setVlParcela(despesaAgh.getVlDespesaAgh().doubleValue() / despesaAgh.getNrParcelas().doubleValue());
         agendamentoDetalhe.setFgDespesaPaga(false);
         agendamentoDetalhe.setFgAtivo(true);
         agendamentoDetalhe.setDtCadastro(despesaAgh.getDtCadastro());
         agendamentoDetalhe.setDtVencimento(gc.getTime());
         
         detalheRepository.save(agendamentoDetalhe);
      }

      return despesaAgh;
   }
   
   @Transactional
   public void inativarDespesaAgendamento(BigInteger idDespesaAgendamento) throws Exception
   {
      Optional<DespesaAgendamentoHeader> despesaOptional = this.get(idDespesaAgendamento);
      DespesaAgendamentoHeader despesaAgendamento = despesaOptional.get();
      
      despesaAgendamento.setFgAtivo(false);
      despesaAgendamento.setDtAlteracao(new Date());
      
      getRepository().save(despesaAgendamento);
   }

}