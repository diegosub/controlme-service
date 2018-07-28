package br.com.cdtec.security.dto;

import java.math.BigInteger;

public class TokenCadastroDTO {
	
	private BigInteger idTokenCadastro;
	private BigInteger idUsuario;
	private String dsToken;
	private boolean fgUsado;
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
	public boolean isFgUsado() {
		return fgUsado;
	}
	public void setFgUsado(boolean fgUsado) {
		this.fgUsado = fgUsado;
	}
	
}