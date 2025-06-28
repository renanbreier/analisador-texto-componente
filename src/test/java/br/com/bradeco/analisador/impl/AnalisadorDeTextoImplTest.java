package br.com.bradeco.analisador.impl;

import br.com.bradeco.analisador.AnalisadorDeTexto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para AnalisadorDeTextoImpl.
 * Valida o funcionamento do componente.
 */
class AnalisadorDeTextoImplTest {

    private AnalisadorDeTexto analisador;

    @BeforeEach
    void setUp() {
        // Roda antes de cada teste, garantindo um objeto novo.
        analisador = new AnalisadorDeTextoImpl();
    }

    @Test
    @DisplayName("Deve contar as palavras corretamente em um texto simples")
    void testContarPalavras() {
        String texto = "Este é um texto de exemplo.";
        assertEquals(5, analisador.contarPalavras(texto));
    }

    @Test
    @DisplayName("Deve retornar 0 palavras para texto nulo ou vazio")
    void testContarPalavrasComTextoVazio() {
        assertEquals(0, analisador.contarPalavras(null));
        assertEquals(0, analisador.contarPalavras(""));
        assertEquals(0, analisador.contarPalavras("   "));
    }
    
    @Test
    @DisplayName("Deve contar os caracteres corretamente")
    void testContarCaracteres() {
        String texto = "Olá";
        assertEquals(3, analisador.contarCaracteres(texto));
    }
    
    @Test
    @DisplayName("Deve encontrar a palavra mais frequente")
    void testPalavraMaisFrequente() {
        String texto = "casa é sua casa mas a casa não é minha";
        Map.Entry<String, Long> resultado = analisador.encontrarPalavraMaisFrequente(texto);
        assertEquals("casa", resultado.getKey());
        assertEquals(3L, resultado.getValue());
    }
    
    @Test
    @DisplayName("Deve calcular o tempo de leitura corretamente")
    void testTempoLeitura() {
        // 400 palavras devem levar 2 minutos (400 / 200 = 2.0)
        StringBuilder textoLongo = new StringBuilder();
        for (int i = 0; i < 400; i++) {
            textoLongo.append("palavra ");
        }
        assertEquals(2.0, analisador.calcularTempoLeituraEstimado(textoLongo.toString()));
    }
}