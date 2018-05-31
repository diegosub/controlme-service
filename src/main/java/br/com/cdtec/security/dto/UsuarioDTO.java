package br.com.cdtec.security.dto;

import java.math.BigInteger;
import java.util.Date;

public class UsuarioDTO {
	
	private BigInteger idUsuario;	
	private String dsNome;	
	private String dsEmail;	
	private String dsSenha;
	private String dsConfirmarSenha;	
	private String dsPerfil;
	private Date dtCadastro;
	private Integer idPerfil;
	private Boolean fgValido;
	
	
	public BigInteger getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(BigInteger idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDsNome() {
		return dsNome;
	}
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	public String getDsConfirmarSenha() {
		return dsConfirmarSenha;
	}
	public void setDsConfirmarSenha(String dsConfirmarSenha) {
		this.dsConfirmarSenha = dsConfirmarSenha;
	}
	public String getDsPerfil() {
		return dsPerfil;
	}
	public void setDsPerfil(String dsPerfil) {
		this.dsPerfil = dsPerfil;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public Boolean getFgValido() {
		return fgValido;
	}
	public void setFgValido(Boolean fgValido) {
		this.fgValido = fgValido;
	}	
}