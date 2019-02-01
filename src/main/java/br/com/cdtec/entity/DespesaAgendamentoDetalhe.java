package br.com.cdtec.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_despesa_agd", schema = "ngc")
@SequenceGenerator(name = "SQ_DESPESA_AGD", sequenceName = "SQ_DESPESA_AGD", allocationSize = 1)
@Proxy(lazy = true)
public class DespesaAgendamentoDetalhe implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESPESA_AGD")
	@Column(name = "id_despesa_agd")
	private BigInteger idDespesaAgd;

	@Column(name = "id_despesa_agh")
	private BigInteger idDespesaAgh;
	
	@Column(name = "nr_parcela")
	private Integer nrParcela;
	
	@Column(name = "vl_parcela")
	private Integer vlParcela;
	
	@Column(name = "dt_vencimento")
	private Date dtVencimento;
	
	@Column(name = "fg_despesa_paga")
	private Boolean fgDespesaPaga;
	
	@Column(name = "fg_ativo")
	private Boolean fgAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro")
	private Date dtCadastro;

	@Column(name = "id_despesa")
	private BigInteger idDespesa;

	public BigInteger getIdDespesaAgd()
	{
		return idDespesaAgd;
	}

	public void setIdDespesaAgd(BigInteger idDespesaAgd)
	{
		this.idDespesaAgd = idDespesaAgd;
	}

	public BigInteger getIdDespesaAgh()
	{
		return idDespesaAgh;
	}

	public void setIdDespesaAgh(BigInteger idDespesaAgh)
	{
		this.idDespesaAgh = idDespesaAgh;
	}

	public Integer getNrParcela()
	{
		return nrParcela;
	}

	public void setNrParcela(Integer nrParcela)
	{
		this.nrParcela = nrParcela;
	}

	public Integer getVlParcela()
	{
		return vlParcela;
	}

	public void setVlParcela(Integer vlParcela)
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

	public Boolean getFgDespesaPaga()
	{
		return fgDespesaPaga;
	}

	public void setFgDespesaPaga(Boolean fgDespesaPaga)
	{
		this.fgDespesaPaga = fgDespesaPaga;
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

	public BigInteger getIdDespesa()
	{
		return idDespesa;
	}

	public void setIdDespesa(BigInteger idDespesa)
	{
		this.idDespesa = idDespesa;
	}
}