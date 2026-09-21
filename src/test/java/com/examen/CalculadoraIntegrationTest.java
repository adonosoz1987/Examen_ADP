package com.examen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIntegrationTest {

    @Test
    @DisplayName("Prueba de Integración: Flujo combinado de operaciones")
    void testFlujoCombinadoCalculadora() {
        Calculadora calc = new Calculadora();
        int suma = calc.sumar(10, 20);
        int resultadoFinal = calc.restar(suma, 5);
        assertEquals(25, resultadoFinal, "La integración de operaciones suma y resta debe dar 25");
    }
} 