package org.tva.mytva;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculateurTvaTest {
	private CalculateurTva calculateur=new CalculateurTva();
    @Test
    public void calculTvaMarocTest() {
        double result = calculateur.calculerTva(100, "Maroc");
        assertEquals(20.0, result,0.1);
    }

    @Test
    public void calculTvaFranceTest() {
        double result = calculateur.calculerTva(100, "France");
        assertEquals(30.0, result,0.1);
    }

    @Test
    public void calculTvaEspagne1000MoinsTest() {
        double result = calculateur.calculerTva(500, "Espagne");
        assertEquals(0.0, result,0.1);
    }

    @Test
    public void calculTvaEspagne1000PlusTest() {
        double result = calculateur.calculerTva(1500, "Espagne");
        assertEquals(225.0, result,0.1);
    }
    
    @Test
    public void calculTvaEspagne1000Test() {
        double result = calculateur.calculerTva(1000, "Espagne");
        assertEquals(150.0, result,0.1);
    }
    
    @Test
    public void calculTvaPaysIntrouvableTestFirst() {
        try {
            calculateur.calculerTva(100, "algeria");
        } catch (IllegalArgumentException e) {
            assertEquals("Pays non pris en charge", e.getMessage());
        }
    }
   
}
