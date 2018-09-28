package br.com.cdtec.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.response.Response;
import br.com.cdtec.security.dto.TokenCadastroDTO;
import br.com.cdtec.security.dto.UsuarioDTO;
import br.com.cdtec.security.service.UsuarioService;
import br.com.cdtec.util.CriptoMD5;

@RestController
@CrossOrigin(origins = "*")
public class RegistrarUsuarioController
{

	// @Autowired
	// private UsuarioService usuarioService;

	@PostMapping(value = "/api/auth/registrar")
	public ResponseEntity<?> registrar(HttpServletRequest request, @RequestBody UsuarioDTO usuarioDTO,
			BindingResult result)
	{

		Response<UsuarioDTO> response = new Response<UsuarioDTO>();

		try
		{
			validarRegistrar(usuarioDTO, result);
			if (result.hasErrors())
			{
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			completarInserir(usuarioDTO, request);
			// usuarioDTO = convertEntityToDTO(usuarioService.inserir(usuarioDTO));
			response.setData(usuarioDTO);
		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/api/auth/ativar")
	public ResponseEntity<?> ativar(HttpServletRequest request, @RequestBody TokenCadastroDTO tokenCadastroDTO,
			BindingResult result)
	{

		Response<TokenCadastroDTO> response = new Response<TokenCadastroDTO>();

		try
		{

			validarParametros(tokenCadastroDTO, result);
			if (result.hasErrors())
			{
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			// completarInserir(usuarioDTO, request);
			// usuarioDTO =
			// convertEntityToDTO(usuarioService.inserir(convertDTOToEntity(usuarioDTO)));
			// response.setData(usuarioDTO);
		}
		catch (Exception e)
		{
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);

	}

	protected void validarParametros(TokenCadastroDTO tokenCadastroDTO, BindingResult result)
	{

		if (tokenCadastroDTO == null)
		{
			result.addError(new ObjectError("Token", "O Link enviado é inválido!"));
		}

		if (tokenCadastroDTO.getIdUsuario() == null || tokenCadastroDTO.getIdUsuario().intValue() <= 0)
		{
			result.addError(new ObjectError("Token", "O Link enviado é inválido!"));
		}

		if (tokenCadastroDTO.getDsToken() == null || tokenCadastroDTO.getDsToken().trim().equals(""))
		{
			result.addError(new ObjectError("Token", "O Link enviado é inválido!"));
		}

	}

	protected void validarRegistrar(UsuarioDTO usuarioDTO, BindingResult result)
	{

		if (usuarioDTO.getDsNome() == null || usuarioDTO.getDsNome().trim().equals(""))
		{
			result.addError(new ObjectError("Usuário", "O campo Nome é obrigatório."));
			return;
		}

		if (usuarioDTO.getDsEmail() == null || usuarioDTO.getDsEmail().trim().equals(""))
		{
			result.addError(new ObjectError("Usuário", "O campo E-mail é obrigatório."));
			return;
		}

		if (usuarioDTO.getDsSenha() == null || usuarioDTO.getDsSenha().trim().equals(""))
		{
			result.addError(new ObjectError("Usuário", "O campo Senha é obrigatório."));
			return;
		}

		if (!usuarioDTO.getDsSenha().equals(usuarioDTO.getDsConfirmarSenha()))
		{
			result.addError(new ObjectError("Usuário", "O campo Senha deve ser equivalente ao campo Confirmar Senha."));
			return;
		}

	}

	protected void completarInserir(UsuarioDTO usuarioDTO, HttpServletRequest request)
	{

		usuarioDTO.setDtCadastro(new Date());
		usuarioDTO.setIdPerfil(UsuarioService.PERFIL_OPERADOR);
		usuarioDTO.setFgValido(false);
		usuarioDTO.setDsSenha(CriptoMD5.stringHexa(usuarioDTO.getDsSenha()));

		// ENVIAR EMAIL DE VALIDACAO DE USUARIO

	}

}
