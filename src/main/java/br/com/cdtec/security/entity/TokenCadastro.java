package br.com.cdtec.security.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="tb_token_cadastro", schema="ngc")
@SequenceGenerator(name = "SQ_TOKEN_CADASTRO", sequenceName = "SQ_TOKEN_CADASTRO", allocationSize = 1)
@Proxy(lazy = true)
public class TokenCadastro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TOKEN_CADASTRO")	
	@Column(name="id_token_cadastro")
	private BigInteger idTokenCadastro;
	
	@Column(name="id_usuario")
	private BigInteger idUsuario;
	
	@Column(name="ds_token")
	private String dsToken;
	
	@Column(name="fg_usado")
	private Boolean fgUsado;

	
	public BigInteger getIdTokenCadastro() {
		return idTokenCadastro;
	}

	public void setIdTokenCadastro(BigInteger idTokenCadastro) {
		this.idTokenCadastro = idTokenCadastro;
	}

	public BigInteger getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(BigInteger idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDsToken() {
		return dsToken;
	}

	public void setDsToken(String dsToken) {
		this.dsToken = dsToken;
	}

	public Boolean getFgUsado() {
		return fgUsado;
	}

	public void setFgUsado(Boolean fgUsado) {
		this.fgUsado = fgUsado;
	}

}