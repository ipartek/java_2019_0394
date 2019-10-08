package DefaultNamespace;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class ClienteCalculadora {

	public static void main(String[] args) throws ServiceException, RemoteException {
		CalculadoraService calculadora = new CalculadoraServiceServiceLocator().getCalculadoraService();
		
		System.out.println(calculadora.sumar(5, 7));
	}

}
