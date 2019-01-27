package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

//A classe WebService também é gerenciada pelo EJB

@WebService
@Stateless
public class LivrariaWS {

	@Inject
	LivroDao dao;

	// Método utilizado para pesquisar o livro pelo nome
	@WebResult(name = "autores")
	public List<Livro> getLivrosPeloNome(@WebParam(name = "titilo") String nome) {

		System.out.println("LivrariaWS: procurando pelo nome " + nome);

		// aqui usaremos o DAO para executar a pesquisa
		
		//retrorna a pesquisa de livro pelo nome
		return dao.livrosPeloNome(nome);
	}

}
