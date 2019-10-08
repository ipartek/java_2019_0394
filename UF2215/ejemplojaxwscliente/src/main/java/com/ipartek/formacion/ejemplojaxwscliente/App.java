package com.ipartek.formacion.ejemplojaxwscliente;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.ipartek.formacion.ejemplojaxws.ServicioJaxWs;
import com.ipartek.formacion.ejemplojaxws.ServicioJaxWsService;

// wsimport -keep http://localhost:8080/serviciojaxws?wsdl
// Genera todas las clases com.ipartek.formacion.ejemplojaxws.* 

public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {
    	ServicioJaxWsService peticionServicio = new ServicioJaxWsService(
                new URL("http://localhost:8080/serviciojaxws?wsdl"),    // URL real del web service.
                new QName("http://ejemplojaxws.formacion.ipartek.com/",           // copiado del código generado por wsimport  
                      "ServicioJaxWsService"));
          ServicioJaxWs servicio = peticionServicio.getServicioJaxWsPort();

          // Ya podemos usarlo
          System.out.println(servicio.saludar("asdfasdf"));
    }
}
