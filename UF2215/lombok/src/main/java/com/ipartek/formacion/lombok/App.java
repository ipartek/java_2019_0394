package com.ipartek.formacion.lombok;

import java.util.Date;

public class App 
{
    public static void main( String[] args )
    {
        Persona p = new Persona();
        p.setNombre("Javier");
        p.setApellidos("Lete");
        p.setFechaNacimiento(new Date());
        
        System.out.println(p);
    }
}
