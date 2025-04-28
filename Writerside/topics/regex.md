# Expressões Regulares

## Conceitos Básicos

### Padrões Simples
```java
// Padrões básicos
String email = "user@domain.com";
boolean isEmail = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

// Metacaracteres
String texto = "NetRunner_2077";
boolean hasDigits = texto.matches(".*\\d+.*");    // Contém números
boolean isAlpha = texto.matches("[a-zA-Z]+");     // Apenas letras
```

## Quantificadores

### Repetições
```java
Pattern pattern = Pattern.compile("\\w+");  // Uma ou mais palavras
/*
* ? - zero ou um
* + - um ou mais
* * - zero ou mais
* {n} - exatamente n
* {n,} - n ou mais
* {n,m} - entre n e m
*/

String codigo = "ABC-123-XYZ";
boolean valid = codigo.matches("[A-Z]{3}-\\d{3}-[A-Z]{3}");
```

## Classes de Caracteres

### Grupos Predefinidos
```java
// Classes comuns
Pattern digitos = Pattern.compile("\\d");    // [0-9]
Pattern letras = Pattern.compile("\\w");     // [a-zA-Z0-9_]
Pattern espaco = Pattern.compile("\\s");     // [ \t\n\r\f]

// Negação
Pattern naoDigito = Pattern.compile("\\D");  // [^0-9]
Pattern naoLetra = Pattern.compile("\\W");   // [^a-zA-Z0-9_]
Pattern naoEspaco = Pattern.compile("\\S");  // [^ \t\n\r\f]
```

## Grupos e Captura

### Agrupamento
```java
// Grupos nomeados
Pattern dataPattern = Pattern.compile(
    "(?<dia>\\d{2})/(?<mes>\\d{2})/(?<ano>\\d{4})"
);
Matcher m = dataPattern.matcher("21/12/2077");
if (m.matches()) {
    String dia = m.group("dia");   // 21
    String mes = m.group("mes");   // 12
    String ano = m.group("ano");   // 2077
}

// Grupos numerados
Pattern logPattern = Pattern.compile("(\\w+):(\\d+)");
Matcher logMatcher = logPattern.matcher("ERROR:404");
if (logMatcher.matches()) {
    String tipo = logMatcher.group(1);  // ERROR
    String codigo = logMatcher.group(2); // 404
}
```

## Substituições

### Transformações
```java
String log = "ERROR:404:Page Not Found";

// Substituição simples
String formatted = log.replaceAll(":", " - ");

// Substituição com grupos
Pattern p = Pattern.compile("(\\w+):(\\d+):(.+)");
Matcher m = p.matcher(log);
String pretty = m.replaceAll("[$1] Code $2: $3");
// Resultado: "[ERROR] Code 404: Page Not Found"
```

## Validações Comuns

### Padrões Úteis
```java
public class Validators {
    private static final Pattern EMAIL = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@(.+)$"
    );
    
    private static final Pattern IP = Pattern.compile(
        "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$"
    );
    
    private static final Pattern URL = Pattern.compile(
        "^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})([/\\w .-]*)*/?$"
    );
    
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL.matcher(email).matches();
    }
    
    public static boolean isValidIP(String ip) {
        return ip != null && IP.matcher(ip).matches();
    }
    
    public static boolean isValidURL(String url) {
        return url != null && URL.matcher(url).matches();
    }
}
```

## Performance

### Otimizações
```java
// Compilação de pattern
public class RegexOptimizer {
    // Compile uma vez, use várias
    private static final Pattern PATTERN = Pattern.compile("\\w+");
    
    public List<String> findWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
```

## Boas Práticas

### Recomendações
```java
// Use Pattern.quote para caracteres especiais
String special = "user.name+tag";
String escaped = Pattern.quote(special);

// Use grupos nomeados para clareza
Pattern p = Pattern.compile("(?<protocol>https?)://(?<domain>[\\w.-]+)");

// Cache patterns compilados
public class Parser {
    private static final Pattern DATE = Pattern.compile(
        "\\d{4}-\\d{2}-\\d{2}"
    );
    private static final Pattern TIME = Pattern.compile(
        "\\d{2}:\\d{2}:\\d{2}"
    );
}
```

## Próximos Passos

### Tópicos Relacionados
- [Pattern Matching](pattern-matching.md)
- [String Processing](string-processing.md)
- [Text Analysis](text-analysis.md)

[Pattern Matching](pattern-matching.md){.next-step}