# Analisador de Texto - Componente Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

> Componente Java para análise estatística de textos: contagem de palavras, caracteres, tempo de leitura e identificação da palavra mais frequente.

---

## ✨ Funcionalidades

- ✅ Contagem de palavras
- ✅ Contagem de caracteres
- ✅ Cálculo de tempo estimado de leitura
- ✅ Identificação da palavra mais frequente no texto

---

## 🚀 Como usar

### 1. Adicionando como dependência (via Maven)

> *(O componente foi publicado no Maven Central com `groupId` `io.github.renanbreier`)*

```xml
<dependency>
  <groupId>io.github.renanbreier</groupId>
  <artifactId>analisadortexto</artifactId>
  <version>1.0.0</version>
</dependency>
```

---

### 2. Utilização no código Java

```java
import br.com.bradeco.analisador.AnalisadorDeTexto;
import br.com.bradeco.analisador.impl.AnalisadorDeTextoImpl;

public class Main {
    public static void main(String[] args) {
        AnalisadorDeTexto analisador = new AnalisadorDeTextoImpl();
        String texto = "Java é uma linguagem poderosa e versátil.";

        long palavras = analisador.contarPalavras(texto);
        long caracteres = analisador.contarCaracteres(texto);
        double tempoLeitura = analisador.calcularTempoLeituraEstimado(texto);
        var palavraFrequente = analisador.encontrarPalavraMaisFrequente(texto);

        System.out.println("Palavras: " + palavras);
        System.out.println("Caracteres: " + caracteres);
        System.out.println("Tempo de leitura (min): " + tempoLeitura);
        System.out.println("Palavra mais frequente: " + palavraFrequente);
    }
}
```

---

## 📁 Estrutura do Projeto

```text
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── bradeco/
                    └── analisador/
                        └── AnalisadorDeTexto.java
                        └── impl/
                            └── AnalisadorDeTextoImpl.java
```

---

## 💡 Princípios SOLID

O componente foi projetado seguindo os princípios SOLID:

- **SRP**: Cada método possui uma responsabilidade clara
- **OCP**: A classe pode ser estendida sem ser modificada
- **LSP**: Substituição segura da interface pela implementação
- **ISP**: Interface com métodos coesos e necessários
- **DIP**: Dependência de abstração (`AnalisadorDeTexto`) em vez de implementação concreta

---

## 📦 Compilação

Compile com Maven:

```bash
mvn clean install
```

---

## 🙋 Autor

Feito com 💙 por [Renan Breier](https://github.com/renanbreier)
