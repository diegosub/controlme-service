package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class DespesaAgendamentoHeaderDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idDespesaAgh;
   
   private String dsDespesaAgh;

   private BigInteger idCategoria;
   
   private CategoriaDTO categoria;

   private BigInteger idSubcategoria;

   private SubcategoriaDTO subcategoria;
   
   private BigInteger idConta;

   private ContaDTO conta;
   
   private Date dtInicio;

   private Double vlDespesaAgh;
   
   private Integer nrParcelas;

   private BigInteger idUsuario;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   private String dsObservacao;
   
   private Integer idPeriodoAgh;
   
   private List<DespesaAgendamentoDetalheDTO> listaAgendamentoDetalheDTO;
   

   public BigInteger getIdDespesaAgh()
   {
      return idDespesaAgh;
   }

   public void setIdDespesaAgh(BigInteger idDespesaAgh)
   {
      this.idDespesaAgh = idDespesaAgh;
   }

   public String getDsDespesaAgh()
   {
      return dsDespesaAgh;
   }

   public void setDsDespesaAgh(String dsDespesaAgh)
   {
      this.dsDespesaAgh = dsDespesaAgh;
   }

   public BigInteger getIdCategoria()
   {
      return idCategoria;
   }

   public void setIdCategoria(BigInteger idCategoria)
   {
      this.idCategoria = idCategoria;
   }

   public CategoriaDTO getCategoria()
   {
      return categoria;
   }

   public void setCategoria(CategoriaDTO categoria)
   {
      this.categoria = categoria;
   }

   public BigInteger getIdSubcategoria()
   {
      return idSubcategoria;
   }

   public void setIdSubcategoria(BigInteger idSubcategoria)
   {
      this.idSubcategoria = idSubcategoria;
   }

   public SubcategoriaDTO getSubcategoria()
   {
      return subcategoria;
   }

   public void setSubcategoria(SubcategoriaDTO subcategoria)
   {
      this.subcategoria = subcategoria;
   }

   public Date getDtInicio()
   {
      return dtInicio;
   }

   public void setDtInicio(Date dtInicio)
   {
      this.dtInicio = dtInicio;
   }

   public Double getVlDespesaAgh()
   {
      return vlDespesaAgh;
   }

   public void setVlDespesaAgh(Double vlDespesaAgh)
   {
      this.vlDespesaAgh = vlDespesaAgh;
   }

   public Integer getNrParcelas()
   {
      return nrParcelas;
   }

   public void setNrParcelas(Integer nrParcelas)
   {
      this.nrParcelas = nrParcelas;
   }

   public BigInteger getIdUsuario()
   {
      return idUsuario;
   }

   public void setIdUsuario(BigInteger idUsuario)
   {
      this.idUsuario = idUsuario;
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

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
   }

   public Integer getIdPeriodoAgh()
   {
      return idPeriodoAgh;
   }

   public void setIdPeriodoAgh(Integer idPeriodoAgh)
   {
      this.idPeriodoAgh = idPeriodoAgh;
   }

   public List<DespesaAgendamentoDetalheDTO> getListaAgendamentoDetalheDTO()
   {
      return listaAgendamentoDetalheDTO;
   }

   public void setListaAgendamentoDetalheDTO(List<DespesaAgendamentoDetalheDTO> listaAgendamentoDetalheDTO)
   {
      this.listaAgendamentoDetalheDTO = listaAgendamentoDetalheDTO;
   }

   public BigInteger getIdConta()
   {
      return idConta;
   }

   public void setIdConta(BigInteger idConta)
   {
      this.idConta = idConta;
   }

   public ContaDTO getConta()
   {
      return conta;
   }

   public void setConta(ContaDTO conta)
   {
      this.conta = conta;
   }

   public static long getSerialversionuid()
   {
      return serialVersionUID;
   }
}