package br.com.bradeco.analisador;

import java.util.Map;


// Interface que define as operações para análise estatística de textos.

public interface AnalisadorDeTexto {


     // Conta o número total de palavras em um texto.
     // @param texto O texto a ser analisado.
     // @return O número de palavras.
    long contarPalavras(String texto);

     // Conta o número total de caracteres, incluindo espaços e pontuação.
     // @param texto O texto a ser analisado.
     // @return O número total de caracteres.
    long contarCaracteres(String texto);


     // Encontra a palavra que mais se repete no texto. 
     // @param texto O texto a ser analisado.
     // @return Um Map.Entry contendo a palavra mais frequente e sua contagem.
    Map.Entry<String, Long> encontrarPalavraMaisFrequente(String texto);

     // Calcula o tempo estimado de leitura em minutos.
     // A fórmula padrão considera uma velocidade de 200 palavras por minuto.
     // @param texto O texto a ser analisado.
     // @return O tempo de leitura estimado em minutos (pode ser um valor fracionado).
    double calcularTempoLeituraEstimado(String texto);
}