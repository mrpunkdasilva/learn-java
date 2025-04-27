# Formatação de Números

## NumberFormat

### Formatação Básica
```java
// Formatadores básicos
NumberFormat nf = NumberFormat.getInstance();
NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
NumberFormat percentFormat = NumberFormat.getPercentInstance();

// Exemplos
double number = 1234.56;
String formatted = nf.format(number);          // "1,234.56"
String currency = currencyFormat.format(number);// "$1,234.56"
String percent = percentFormat.format(0.75);   // "75%"
```

### Localização
```java
// Formatadores localizados
Locale brLocale = new Locale("pt", "BR");
NumberFormat brCurrency = NumberFormat.getCurrencyInstance(brLocale);
String brValue = brCurrency.format(1234.56);   // "R$ 1.234,56"

Locale frLocale = new Locale("fr", "FR");
NumberFormat frCurrency = NumberFormat.getCurrencyInstance(frLocale);
String frValue = frCurrency.format(1234.56);   // "1 234,56 €"
```

## DecimalFormat

### Padrões Customizados
```java
// Padrões de formatação
DecimalFormat df = new DecimalFormat("#,###.##");
String num = df.format(1234567.89);    // "1,234,567.89"

// Zeros à esquerda
DecimalFormat df2 = new DecimalFormat("000000.00");
String padded = df2.format(123.4);     // "000123.40"

// Sufixos e prefixos
DecimalFormat df3 = new DecimalFormat("€ #,###.00");
String euro = df3.format(1234.56);     // "€ 1,234.56"
```

### Símbolos Customizados
```java
DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
symbols.setDecimalSeparator(',');
symbols.setGroupingSeparator('.');

DecimalFormat custom = new DecimalFormat("#,###.##", symbols);
String result = custom.format(1234.56); // "1.234,56"
```

## Parsing

### Conversão de Strings
```java
// Parse básico
NumberFormat nf = NumberFormat.getInstance();
Number num = nf.parse("1,234.56");

// Parse com locale
NumberFormat frFormat = NumberFormat.getInstance(Locale.FRANCE);
Number frNum = frFormat.parse("1 234,56");

// Tratamento de erros
try {
    Number value = nf.parse("invalid");
} catch (ParseException e) {
    System.err.println("Formato inválido");
}
```

## Casos Especiais

### Números Científicos
```java
// Notação científica
DecimalFormat scientific = new DecimalFormat("0.###E0");
String sci = scientific.format(123456.789); // "1.235E5"

// Precisão customizada
DecimalFormat precise = new DecimalFormat("0.000000");
String precision = precise.format(Math.PI); // "3.141593"
```

### Arredondamento
```java
DecimalFormat df = new DecimalFormat("#,###.##");
df.setRoundingMode(RoundingMode.HALF_UP);

String rounded = df.format(123.456);  // "123.46"
```

## Boas Práticas

### Constantes de Formato
```java
public class NumberUtils {
    public static final DecimalFormat MONEY_FORMAT = 
        new DecimalFormat("#,##0.00");
    
    public static final DecimalFormat PERCENT_FORMAT = 
        new DecimalFormat("#.##%");
}
```

### Validação
```java
public boolean isValidNumber(String numStr, NumberFormat format) {
    try {
        format.parse(numStr);
        return true;
    } catch (ParseException e) {
        return false;
    }
}
```

## Frameworks e Bibliotecas

### Java Money API
```java
// Usando JavaMoney
MonetaryAmount amount = Money.of(1234.56, "USD");
MonetaryAmountFormat format = 
    MonetaryFormats.getAmountFormat(Locale.US);
String formatted = format.format(amount);
```

## Próximos Passos
- [Internacionalização](i18n.md)
- [Formatação de Datas](date-formatting.md)