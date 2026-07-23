package org.example;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Money {
    private int aWholeDollar;
    private int aWholeEuro;
    private int aWholeHryvnia;
    private int fractionOfADollar;
    private int fractionOfAEuro;
    private int fractionOfAHryvnia;

    public Money(int aWholeDollar) {
        this.aWholeDollar = aWholeDollar;
        this.aWholeEuro = (int) (aWholeDollar / 1.1409);
        this.aWholeHryvnia = (int) (aWholeDollar / 0.0223);
        this.fractionOfADollar = aWholeDollar * 100;
        this.fractionOfAEuro = aWholeEuro * 100;
        this.fractionOfAHryvnia = aWholeHryvnia * 100;
    }
}
