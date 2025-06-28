package br.com.bradeco.analisador.impl;

import br.com.bradeco.analisador.AnalisadorDeTexto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementação concreta do AnalisadorDeTexto.
 * Esta classe contém a lógica interna e aplica princípios SOLID.
 */
public class AnalisadorDeTextoImpl implements AnalisadorDeTexto {

    private static final int PALAVRAS_POR_MINUTO_PADRAO = 200;

    // Princípio da Responsabilidade Única (SOLID): Cada método tem uma única responsabilidade bem definida.

    @Override
    public long contarPalavras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        // Usa uma expressão regular para dividir por espaços em branco.
        return texto.trim().split("\\s+").length;
    }

    @Override
    public long contarCaracteres(String texto) {
        if (texto == null) {
            return 0;
        }
        return texto.length();
    }

    @Override
    public Map.Entry<String, Long> encontrarPalavraMaisFrequente(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return null;
        }

        // Usa a API de Streams do Java para um código mais limpo e funcional.
        return Arrays.stream(texto.trim().toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }

    @Override
    public double calcularTempoLeituraEstimado(String texto) {
        // Princípio Aberto/Fechado (SOLID): Poderíamos estender esta classe para permitir
        // a configuração de PALAVRAS_POR_MINUTO sem alterar este código,
        // por exemplo, adicionando um construtor.
        long totalPalavras = contarPalavras(texto);
        if (totalPalavras == 0) {
            return 0.0;
        }
        return (double) totalPalavras / PALAVRAS_POR_MINUTO_PADRAO;
    }
}