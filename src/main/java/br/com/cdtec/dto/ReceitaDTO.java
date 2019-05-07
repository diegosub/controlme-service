package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ReceitaDTO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private BigInteger idReceita;

	private BigInteger idCategoria;
	
	private CategoriaDTO categoria;

	private BigInteger idSubcategoria;

	private SubcategoriaDTO subcategoria;
	
	private BigInteger idConta;
	
	private ContaDTO conta;

	private Date dtReceita;

	private Double vlReceita;
	
	private String strVlReceita;

	private String dsObservacao;

	private BigInteger idUsuario;

	private Boolean fgAtivo;

	private Date dtCadastro;

	private Date dtAlteracao;

   public BigInteger getIdReceita()
   {
      return idReceita;
   }

   public void setIdReceita(BigInteger idReceita)
   {
      this.idReceita = idReceita;
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

   public Date getDtReceita()
   {
      return dtReceita;
   }

   public void setDtReceita(Date dtReceita)
   {
      this.dtReceita = dtReceita;
   }

   public Double getVlReceita()
   {
      return vlReceita;
   }

   public void setVlReceita(Double vlReceita)
   {
      this.vlReceita = vlReceita;
   }

   public String getStrVlReceita()
   {
      return strVlReceita;
   }

   public void setStrVlReceita(String strVlReceita)
   {
      this.strVlReceita = strVlReceita;
   }

   public String getDsObservacao()
   {
      return dsObservacao;
   }

   public void setDsObservacao(String dsObservacao)
   {
      this.dsObservacao = dsObservacao;
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
}