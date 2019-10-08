package com.ipartek.formacion.ejemplojaxws;

import javax.xml.ws.Endpoint;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Servidor arrancado");
    	Endpoint.publish("http://localhost:8080/serviciojaxws", new ServicioJaxWs());
    }
}
