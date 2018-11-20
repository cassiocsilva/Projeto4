package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class CriptografarTest {
	
    @Test public void CT146() throws IOException {
    	
    	Criptografar classUnderTest = new Criptografar();
    	
    	String texto = "aaaaa";
        
        assertEquals("ddddd",classUnderTest.criptografar(texto));
    }
    
    @Test public void CT147() throws IOException {
    	
    	Criptografar classUnderTest = new Criptografar();
    	
    	String texto = "wxyza";
        
        assertEquals("zabcd",classUnderTest.criptografar(texto));
    }
    
    @Test public void CT148() throws IOException {
    	
    	Criptografar classUnderTest = new Criptografar();
    	
    	String texto = "11111";
        
        assertEquals("44444",classUnderTest.criptografar(texto));
    }
    
    @Test public void CT149() throws IOException {
    	
    	Criptografar classUnderTest = new Criptografar();
    	
    	String texto = "67890";
        
        assertEquals("90123",classUnderTest.criptografar(texto));
    }
}
