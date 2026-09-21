package com.examen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    @DisplayName("Prueba Atómica: Suma básica")
    void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3), "La suma de 2 y 3 debe ser 5");
    }

    @Test
    @DisplayName("Prueba Atómica: Resta básica")
    void testRestar() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.restar(5, 3), "La resta de 5 y 3 debe ser 2");
    }
} 