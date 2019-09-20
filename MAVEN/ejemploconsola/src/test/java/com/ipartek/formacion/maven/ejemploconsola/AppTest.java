package com.ipartek.formacion.maven.ejemploconsola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void sumar5mas3() {
        assertEquals(8, Biblioteca.sumar(5, 3));
    }

    @Test
    public void restar5menos2() {
        assertEquals(2, Biblioteca.restar(5, 2));
    }
}
