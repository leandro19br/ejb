package br.com.caelum.agendador;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/*� poss�vel combinar o @Singleton com a anota��o @Startup que indica
para o container EJB que esse Session Bean deve ser carregado no in�cio da aplica��o:*/

@Singleton
@Startup
public class Agendador {

	
	/*Define a hora, minuto e segundos que ir� chamar o agendador*/
	
	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	void agendado() {
		System.out.println("verificando servi�o externo periodicamente");
	}

}
