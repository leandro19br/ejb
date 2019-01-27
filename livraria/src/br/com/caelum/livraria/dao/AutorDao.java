package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;


/*A CLASSE SER� GEENCIADA PELO ejb, CRIANDO UM JNDI PARA ELA NO SERVIDOR 
EXSITEM 3 TIPOS DE ANOTAÇÕAES EJB - @STATELESS - UTILIZA POLL DE CONEXÇÃO - @SINGLETON - 1 ESTANCIADO BEAN E @STATFULL - EXCLUSIVO DO CLIENTE*/
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)//opcional - expecifica o tipo de gerenciamento CONTAINER(padrão)
@Interceptors({LogInterceptador.class})//cong dizendo que a classe está sendo interseptada
public class AutorDao {
	
	//anotação específica para EJB gereniar conexão com BD
	//sem a utilização do EJB para gerenciar a transação do banco, teria que utilizar os métodos getTransaction.begin() e getTransaction.commit()
	@PersistenceContext
	private EntityManager em;//pussui metodos para trabalhar com objetos
	
	/* REQUIRED opcional e padrão / Mandatory - quam faz a chamada tem que abrir uma transação ex: Classe AutorService chama autorDao passando a transação.
	  NEVER - nunca poderá ter uma transação aberta - NEW sempre abrirá uma nova transação mesmo que já exista uma aberta*/
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		em.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return em.createQuery("select a from Autor a ", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.em.find(Autor.class, autorId );
		return autor;
	}
	
}
