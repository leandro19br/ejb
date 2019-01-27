package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

//Classe utilizada para interseptar uma classe (tempo de resposta do bd)

public class LogInterceptador {
	
	
	//método deve retornar um object
	@AroundInvoke//método intersepta o fluxo
	public Object intercepta(InvocationContext context) throws Exception{
		
		long millins = System.currentTimeMillis();
		//chamada do método DAO continua a execução do método interseptado
		Object object = context.proceed();
		
		String metodo = context.getMethod().getName();
		String classe = context.getTarget().getClass().getSimpleName();
		
		System.out.println(" Nome da Classe " + classe + " Nome do Métdo " + metodo);
		
		System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millins));
		
		return object;
		
	}
	

}
