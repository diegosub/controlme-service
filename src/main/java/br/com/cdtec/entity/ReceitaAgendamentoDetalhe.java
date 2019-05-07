package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_receita_agd", schema = "ngc")
@SequenceGenerator(name = "SQ_RECEITA_AGD", sequenceName = "SQ_RECEITA_AGD", allocationSize = 1)
@Proxy(lazy = true)
public class ReceitaAgendamentoDetalhe implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECEITA_AGD")
   @Column(name = "id_receita_agd")
   private BigInteger idReceitaAgd;

   @Column(name = "id_receita_agh")
   private BigInteger idReceitaAgh;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_receita_agh", insertable = false, updatable = false)
   private ReceitaAgendamentoHeader receitaAgendamentoHeader;

   @Column(name = "nr_parcela")
   private Integer nrParcela;

   @Column(name = "vl_parcela")
   private Double vlParcela;

   @Column(name = "dt_vencimento")
   private Date dtVencimento;

   @Column(name = "fg_receita_paga")
   private Boolean fgReceitaPaga;

   @Column(name = "fg_ativo")
   private Boolean fgAtivo;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_cadastro")
   private Date dtCadastro;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dt_alteracao")
   private Date dtAlteracao;

   @Column(name = "id_receita")
   private BigInteger idReceita;

   public BigInteger getIdReceitaAgd()
   {
      return idReceitaAgd;
   }

   public void setIdReceitaAgd(BigInteger idReceitaAgd)
   {
      this.idReceitaAgd = idReceitaAgd;
   }

   public BigInteger getIdReceitaAgh()
   {
      return idReceitaAgh;
   }

   public void setIdReceitaAgh(BigInteger idReceitaAgh)
   {
      this.idReceitaAgh = idReceitaAgh;
   }

   public ReceitaAgendamentoHeader getReceitaAgendamentoHeader()
   {
      return receitaAgendamentoHeader;
   }

   public void setReceitaAgendamentoHeader(ReceitaAgendamentoHeader receitaAgendamentoHeader)
   {
      this.receitaAgendamentoHeader = receitaAgendamentoHeader;
   }

   public Integer getNrParcela()
   {
      return nrParcela;
   }

   public void setNrParcela(Integer nrParcela)
   {
      this.nrParcela = nrParcela;
   }

   public Double getVlParcela()
   {
      return vlParcela;
   }

   public void setVlParcela(Double vlParcela)
   {
      this.vlParcela = vlParcela;
   }

   public Date getDtVencimento()
   {
      return dtVencimento;
   }

   public void setDtVencimento(Date dtVencimento)
   {
      this.dtVencimento = dtVencimento;
   }

   public Boolean getFgReceitaPaga()
   {
      return fgReceitaPaga;
   }

   public void setFgReceitaPaga(Boolean fgReceitaPaga)
   {
      this.fgReceitaPaga = fgReceitaPaga;
   }

   public Boolean getFgAtivo()
   {
      return fgAtivo;
   }

   public void setFgAtivo(Boolean fgAtivo)
   {
      this.fgAtivo = fgAtivo;
   }

   public Date getDtCadastro()
   {
      return dtCadastro;
   }

   public void setDtCadastro(Date dtCadastro)
   {
      this.dtCadastro = dtCadastro;
   }

   public Date getDtAlteracao()
   {
      return dtAlteracao;
   }

   public void setDtAlteracao(Date dtAlteracao)
   {
      this.dtAlteracao = dtAlteracao;
   }

   public BigInteger getIdReceita()
   {
      return idReceita;
   }

   public void setIdReceita(BigInteger idReceita)
   {
      this.idReceita = idReceita;
   }
}