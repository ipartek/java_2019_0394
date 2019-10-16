package com.ipartek.formacion.banco.consola;

import com.ipartek.formacion.banco.servicios.ServiciosBancarios;
import com.ipartek.formacion.banco.servicios.ServiciosBancariosImpl;

public class App 
{
    public static void main( String[] args )
    {
    	String rutaFicheroCSV = App.class.getClassLoader().getResource("movimientos.csv").getFile().replace("%20", " ");
    	
        ServiciosBancarios servicios = new ServiciosBancariosImpl();
        
        servicios.importarCSV(rutaFicheroCSV);
    }
}
