package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

/*classe intermediária, uma classe AutorService que fica entre os Beans e os DAOs. A classe AutorService também 
será um Session Bean e responsável por abrir uma nova transação. É ela quem recebe um AutorDao injetado e delega a chamada:*/

@Stateless
public class AutorService {
	
	@Inject//Na classe AutorService, vamos primeiro injetar o AutorDao
	AutorDao autorDao;
	
	//O método adiciona(..) recebe um autor e delega a chamada para o DAO
	
	/*Nesse método poderiam ficar mais regras ou chamadas de regras de negócios. É muito comum ter essa divisão de responsabilidade entre bean, serviço e DAO em um projeto real.
	O bean possui muito código relacionado ao JSF (view), o serviço é o controlador na regra de negócio e o DAO possui o código de infraestrutura.*/
	
	public void adiciona(Autor autor) {
	    autorDao.salva(autor);
	}

	public List<Autor> todosAutores() {
		//apenas delega para o dao
		return autorDao.todosAutores();
	}

}
