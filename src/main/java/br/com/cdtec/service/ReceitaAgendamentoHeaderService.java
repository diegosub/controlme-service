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
import br.com.cdtec.dao.repository.ReceitaAgendamentoDetalheRepository;
import br.com.cdtec.dao.repository.ReceitaAgendamentoHeaderRepository;
import br.com.cdtec.dao.specifications.ReceitaAgendamentoHeaderSpecifications;
import br.com.cdtec.entity.ReceitaAgendamentoDetalhe;
import br.com.cdtec.entity.ReceitaAgendamentoHeader;

@Service
public class ReceitaAgendamentoHeaderService extends CrudService<ReceitaAgendamentoHeader, BigInteger, ReceitaAgendamentoHeaderRepository>
{

   private static final long serialVersionUID = 1L;

   private final String fieldSort = "idReceitaAgh";
   
   private static final int TIPO_PERIODO_AGENDAMENTO_DIARIA = 1;
   private static final int TIPO_PERIODO_AGENDAMENTO_SEMANAL = 2;
   private static final int TIPO_PERIODO_AGENDAMENTO_MENSAL = 3;
   private static final int TIPO_PERIODO_AGENDAMENTO_ANUAL = 4;
   
   @Autowired
   private ReceitaAgendamentoDetalheRepository detalheRepository;
   
   @Autowired
   private ReceitaAgendamentoDetalheService detalheService;

   public String getFieldSort()
   {
      return fieldSort;
   }

   @Override
   public List<ReceitaAgendamentoHeader> implementarPesquisar(ReceitaAgendamentoHeader receitaAgh, Sort sort) throws Exception
   {
      return getRepository().findAll(Specification.where(ReceitaAgendamentoHeaderSpecifications.fgAtivoIgual(receitaAgh.getFgAtivo()))
                                                    .and(ReceitaAgendamentoHeaderSpecifications.dtDespesaBetween(receitaAgh.getFiltro().getDtInicioInicio(), receitaAgh.getFiltro().getDtInicioFim()))
                                                    .and(ReceitaAgendamentoHeaderSpecifications.fetchCategoria())
    		  									    .and(ReceitaAgendamentoHeaderSpecifications.fetchSubcategoria())    		  									    
                                                    .and(ReceitaAgendamentoHeaderSpecifications.idUsuarioIgual(receitaAgh.getIdUsuario())), sort);
   }
   
   @Override
   @Transactional
   public ReceitaAgendamentoHeader inserir(ReceitaAgendamentoHeader receitaAgh) throws Exception
   {
      validarInserir(receitaAgh);
      completarInserir(receitaAgh);

      // INSERINDO RECEITA AGENDAMENTO HEADER
      getRepository().save(receitaAgh);

      Date dataVencimento = receitaAgh.getDtInicio();
      GregorianCalendar gc = new GregorianCalendar();
      gc.setTime(dataVencimento);
      
      // INSERINDO DESPESA AGENDAMENTO DETALHE
      for(int i = 0; i < receitaAgh.getNrParcelas(); i++)
      {
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_DIARIA)
         {
            gc.add(Calendar.DAY_OF_MONTH, 1);
         }
         
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_SEMANAL)
         {
            gc.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
         }
         
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_MENSAL)
         {
            gc.add(Calendar.MONTH, 1);
         }
         
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_ANUAL)
         {
            gc.add(Calendar.YEAR, 1);
         }
         
         ReceitaAgendamentoDetalhe detalhe = new ReceitaAgendamentoDetalhe();
         detalhe.setIdReceitaAgh(receitaAgh.getIdReceitaAgh());
         detalhe.setNrParcela(i+1);
         detalhe.setVlParcela(receitaAgh.getVlReceitaAgh().doubleValue() / receitaAgh.getNrParcelas().doubleValue());
         detalhe.setFgReceitaPaga(false);
         detalhe.setFgAtivo(true);
         detalhe.setDtCadastro(receitaAgh.getDtCadastro());
         detalhe.setDtVencimento(gc.getTime());
         
         detalheRepository.save(detalhe);
      }
     

      return receitaAgh;
   }
   
   @Override
   @Transactional
   public ReceitaAgendamentoHeader alterar(ReceitaAgendamentoHeader receitaAgh) throws Exception
   {
      validarAlterar(receitaAgh);
      completarAlterar(receitaAgh);

      // ALTERANDO DESPESA HEADER
      getRepository().save(receitaAgh);

      // DELETANDO TODOS OS DETALHES
      ReceitaAgendamentoDetalhe detalhe = new ReceitaAgendamentoDetalhe();
      detalhe.setIdReceitaAgh(receitaAgh.getIdReceitaAgh());
      
      List<ReceitaAgendamentoDetalhe> listaDetalhe = detalheService.pesquisar(detalhe, null);
      
      for (ReceitaAgendamentoDetalhe receitaAgendamentoDetalhe : listaDetalhe)
      {
         detalheRepository.delete(receitaAgendamentoDetalhe);
      }
      
      // ADICIONANDO NOVAS DESPESA DETALHE
      Date dataVencimento = receitaAgh.getDtInicio();
      GregorianCalendar gc = new GregorianCalendar();
      gc.setTime(dataVencimento);
      
      // INSERINDO DESPESA AGENDAMENTO DETALHE
      for(int i = 0; i < receitaAgh.getNrParcelas(); i++)
      {
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_DIARIA)
         {
            gc.add(Calendar.DAY_OF_MONTH, 1);
         }
         
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_SEMANAL)
         {
            gc.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
         }
         
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_MENSAL)
         {
            gc.add(Calendar.MONTH, 1);
         }
         
         if(i != 0 && receitaAgh.getIdPeriodoAgh().intValue() == TIPO_PERIODO_AGENDAMENTO_ANUAL)
         {
            gc.add(Calendar.YEAR, 1);
         }
         
         ReceitaAgendamentoDetalhe agendamentoDetalhe = new ReceitaAgendamentoDetalhe();
         agendamentoDetalhe.setIdReceitaAgh(receitaAgh.getIdReceitaAgh());
         agendamentoDetalhe.setNrParcela(i+1);
         agendamentoDetalhe.setVlParcela(receitaAgh.getVlReceitaAgh().doubleValue() / receitaAgh.getNrParcelas().doubleValue());
         agendamentoDetalhe.setFgReceitaPaga(false);
         agendamentoDetalhe.setFgAtivo(true);
         agendamentoDetalhe.setDtCadastro(receitaAgh.getDtCadastro());
         agendamentoDetalhe.setDtVencimento(gc.getTime());
         
         detalheRepository.save(agendamentoDetalhe);
      }

      return receitaAgh;
   }
   
   @Transactional
   public void inativarReceitaAgendamento(BigInteger idReceitaAgendamento) throws Exception
   {
      Optional<ReceitaAgendamentoHeader> receitaOptional = this.get(idReceitaAgendamento);
      ReceitaAgendamentoHeader receitaAgendamento = receitaOptional.get();
      
      receitaAgendamento.setFgAtivo(false);
      receitaAgendamento.setDtAlteracao(new Date());
      
      getRepository().save(receitaAgendamento);
   }

}