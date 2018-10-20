package br.com.cdtec.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class CartaoDTO implements Serializable
{
   private static final long serialVersionUID = 1L;

   private BigInteger idCartao;

   private String dsCartao;

   private Integer nrDiaCorte;

   private BigInteger idUsuario;

   private Boolean fgAtivo;

   private Date dtCadastro;

   private Date dtAlteracao;

   private String tpCategoria;

   private String fgControle;

   public BigInteger getIdCartao()
   {
      return idCartao;
   }

   public void setIdCartao(BigInteger idCartao)
   {
      this.idCartao = idCartao;
   }

   public String getDsCartao()
   {
      return dsCartao;
   }

   public void setDsCartao(String dsCartao)
   {
      this.dsCartao = dsCartao;
   }

   public Integer getNrDiaCorte()
   {
      return nrDiaCorte;
   }

   public void setNrDiaCorte(Integer nrDiaCorte)
   {
      this.nrDiaCorte = nrDiaCorte;
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

   public String getTpCategoria()
   {
      return tpCategoria;
   }

   public void setTpCategoria(String tpCategoria)
   {
      this.tpCategoria = tpCategoria;
   }

   public String getFgControle()
   {
      return fgControle;
   }

   public void setFgControle(String fgControle)
   {
      this.fgControle = fgControle;
   }
}