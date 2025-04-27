# Formatação de Datas

## DateTimeFormatter

### Padrões Básicos
```java
// Formatadores predefinidos
DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;
DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;

// Formatação básica
LocalDate date = LocalDate.now();
String formatted = date.format(isoDate);  // 2024-01-20
```

### Padrões Customizados
```java
// Criando formatadores customizados
DateTimeFormatter custom = DateTimeFormatter.ofPattern("dd/MM/yyyy");
DateTimeFormatter withTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Aplicando formatação
LocalDateTime now = LocalDateTime.now();
String result = now.format(custom);       // 20/01/2024
```

## Localização

### Formatação por Locale
```java
// Formatadores localizados
DateTimeFormatter brFormat = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    .withLocale(new Locale("pt", "BR"));

DateTimeFormatter usFormat = 
    DateTimeFormatter.ofPattern("MM/dd/yyyy")
                    .withLocale(Locale.US);
```

### Nomes Localizados
```java
// Meses e dias da semana
DateTimeFormatter monthFormat = 
    DateTimeFormatter.ofPattern("MMMM", new Locale("pt", "BR"));
String mes = monthFormat.format(LocalDate.now());  // "janeiro"
```

## Parsing

### Conversão de Strings
```java
// Parse básico
String dateStr = "2024-01-20";
LocalDate date = LocalDate.parse(dateStr);

// Parse com formato específico
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate customDate = LocalDate.parse("20/01/2024", formatter);
```

### Tratamento de Erros
```java
try {
    LocalDate date = LocalDate.parse("data-inválida");
} catch (DateTimeParseException e) {
    System.err.println("Formato de data inválido");
}
```

## Casos Especiais

### Zonas de Tempo
```java
// Formatação com timezone
ZonedDateTime zdt = ZonedDateTime.now();
DateTimeFormatter zoneFormat = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm z");
String withZone = zdt.format(zoneFormat);  // "20/01/2024 15:30 BRT"
```

### Períodos e Durações
```java
// Formatando períodos
Period period = Period.between(
    LocalDate.of(2023, 1, 1),
    LocalDate.of(2024, 1, 1)
);
// P1Y (ISO-8601)

// Formatando durações
Duration duration = Duration.between(
    LocalDateTime.now(),
    LocalDateTime.now().plusHours(2)
);
// PT2H (ISO-8601)
```

## Boas Práticas

### Constantes de Formato
```java
public class DateUtils {
    public static final DateTimeFormatter BR_DATE = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static final DateTimeFormatter BR_DATE_TIME = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
}
```

### Validação
```java
public boolean isValidDate(String dateStr, DateTimeFormatter formatter) {
    try {
        LocalDate.parse(dateStr, formatter);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}
```

## Próximos Passos
- [Formatação de Números](number-formatting.md)
- [Internacionalização](i18n.md)