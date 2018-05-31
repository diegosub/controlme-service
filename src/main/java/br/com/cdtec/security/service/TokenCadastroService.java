package br.com.cdtec.security.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import br.com.cdtec.crud.service.CrudService;
import br.com.cdtec.security.entity.TokenCadastro;
import br.com.cdtec.security.repository.TokenCadastroRepository;


@Service
public class TokenCadastroService extends CrudService<TokenCadastro, BigInteger, TokenCadastroRepository> {

	private static final long serialVersionUID = 1L;



}