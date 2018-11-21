package br.com.cdtec.crud.service;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdtec.crud.repository.GenericRepository;

/**
 * Classe extenda o CrudService deve ser annotada com @Transaction apontando
 * para o transctionManager que deseja usar na classe, caso não seja annotada
 * com @Transaction, os metodos não irão abrir transação a não ser que já
 * estejam incluidos em uma transação
 */
public abstract class CrudService<Entity, IdClass extends Serializable, Repository extends GenericRepository<Entity, IdClass>>
		extends GenericService<Entity, IdClass>
{

	private static final long serialVersionUID = 1L;

	@Autowired
	private Repository repository;

	@Transactional
	public Optional<Entity> get(IdClass id) throws Exception
	{
		
		Optional<Entity> retorno = getRepository().findById(id);
		return retorno;
	}

	@Transactional
	public Entity inserir(Entity entity) throws Exception
	{
		validarInserir(entity);
		completarInserir(entity);
		getRepository().save(entity);
		return entity;
	}

	@Transactional
	public Entity alterar(Entity entity) throws Exception
	{
		validarAlterar(entity);
		completarAlterar(entity);
		getRepository().save(entity);
		return entity;
	}

	@Transactional
	public Page<Entity> listarTodos(int page, int count, Sort sort) throws Exception
	{
		Pageable pages = PageRequest.of(page, count, sort);
		return getRepository().findAll(pages);
	}

	@Override
	@Transactional
	public List<Entity> pesquisar(Entity entity, Sort sort) throws Exception
	{
		return implementarPesquisar(entity, sort);
	}

	// SOBRESCREVER O METODO NO SERVICE PARA REALIZAR A PESQUISA
	@Transactional
	public List<Entity> implementarPesquisar(Entity entity, Sort sort) throws Exception
	{
		return null;
	}
	
   public void executeComando(Session session, final String cmdSql) throws Exception
   {
      session.doWork(new Work()
      {
         @Override
         public void execute(Connection conn) throws SQLException
         {
            CallableStatement cs = conn.prepareCall("{call " + cmdSql + "}");
            cs.execute();
            cs.close();
         }
      });
   }

	public void completarInserir(Entity entity) throws Exception
    {
    }
	
	public void completarAlterar(Entity entity) throws Exception
    {
    }
	
	public void validarInserir(Entity entity) throws Exception
	{
	}

	public void validarAlterar(Entity entity) throws Exception
	{
	}

	public Repository getRepository()
	{
		return repository;
	}

	public void setRepository(Repository repository)
	{
		this.repository = repository;
	}
}