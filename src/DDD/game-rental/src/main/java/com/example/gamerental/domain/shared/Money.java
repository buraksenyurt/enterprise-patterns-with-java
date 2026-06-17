package com.example.gamerental.domain.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

/*
    DDD'nin klasik değern nesnelerine (Value Object) örnek.
    Sistemdeki parayı temsil ediyor. Immutable, yani oluşturulduktan sonra değeri değiştirilemez.
    Değiştirmek istersek yeni bir Money nesnesi oluştururuz.
    Böylece sistemdeki parayı temsil eden nesneler tutarlı kalır ve beklenmedik değişikliklere karşı korunmuş oluruz.
    Ayrıca tutar ve para birimi aynı olan iki Money nesnesi birbirine eşit kabul edilir.
    Record türünü kullanmamızın sebebi immutable özelliği otomatik olarak vermesi
    ve değer karşılaştırması için equals ve hashCode metodlarını otomatik olarak sağlamasıdır.
*/
public record Money(BigDecimal amount, Currency currency) {
    // Compact Constructor
    public Money {
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(currency, "Currency cannot be null");
        amount = amount.setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_UP);
    }

    // Sıfır tutarını belirtilen para biriminde oluşturan yardımcı metod
    public static Money zero(Currency currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    private void isCurrencySame(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must be the same");
        }
    }

    // İki Money nesnesini toplar, ancak para birimlerinin aynı olması gerekir
    public Money plus(Money other) {
        isCurrencySame(other);
        return new Money(this.amount.add(other.amount), this.currency);
    }

    // String formatında tutar ve para birimi alarak Money nesnesi oluşturan
    // yardımcı metod
    public static Money of(String amount, String currencyCode) {
        return new Money(new BigDecimal(amount), Currency.getInstance(currencyCode));
    }

    // Parasal değerin sıfırdan büyük olup olmadığını kontrol eden yardımcı metod
    public boolean isPositive() {
        return amount.signum() > 0;
    }
}
