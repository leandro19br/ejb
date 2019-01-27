package br.com.caelum.agendador;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/*É possível combinar o @Singleton com a anotação @Startup que indica
para o container EJB que esse Session Bean deve ser carregado no início da aplicação:*/

@Singleton
@Startup
public class Agendador {

	
	/*Define a hora, minuto e segundos que irá chamar o agendador*/
	
	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	void agendado() {
		System.out.println("verificando serviço externo periodicamente");
	}

}
