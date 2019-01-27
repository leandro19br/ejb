package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {

		/*
		 * Uma vez criado o proxy podemos executar a chamada remota usando o
		 * m�todo getLivrosPeloNome(..). Repare que parece que fazemos uma
		 * chamada local, mas na verdade ser� feita uma requisi��o HTTP que
		 * enviar� o SOAP. O resultado dessa chamada � um array de livros:
		 */

		LivrariaWS cliente = new LivrariaWSProxy();

		Livro[] livros = cliente.getLivrosPeloNome("Java");

		for (Livro livro : livros) {
			
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor().getNome());

		}

	}

}