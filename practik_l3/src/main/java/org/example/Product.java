package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends Money {
    private String productName;

    public Product() { super(); }

    public Product(int aWholeDollar, String productName) {
        super(aWholeDollar);
        this.productName = productName;
    }

    public void lowerThePriceOfTheProductByDollars(int numberOfDollars) {
        if (this.getAWholeDollar() - numberOfDollars >= 0) {
            this.setAWholeDollar(this.getAWholeDollar() - numberOfDollars);
            float fractionOfAEuro = numberOfDollars / 1.1409F;
            this.setAWholeEuro((int) (numberOfDollars / 1.1409));
            float fractionOfAHryvnia = numberOfDollars / 0.0223F;
            this.setAWholeHryvnia((int) (numberOfDollars / 0.0223));
            this.setFractionOfADollar(this.getAWholeDollar() * 100);
            this.setFractionOfAEuro((int) (fractionOfAEuro * 100));
            this.setFractionOfAHryvnia((int) (fractionOfAHryvnia) * 100);
        }
        else {
            this.setAWholeDollar(0);
            this.setAWholeEuro(0);
            this.setAWholeHryvnia(0);
            this.setFractionOfADollar(0);
            this.setFractionOfAEuro(0);
            this.setFractionOfAHryvnia(0);
        }
    }

    public void lowerThePriceOfTheProductByEuro(int numberOfEuro) {
        if (this.getAWholeEuro() - numberOfEuro >= 0) {
            this.setAWholeEuro(this.getAWholeEuro() - numberOfEuro);
            float fractionOfADollar = numberOfEuro / 0.8762F;
            this.setAWholeDollar((int) (numberOfEuro / 0.8762));
            float fractionOfAHryvnia = numberOfEuro / 0.0196F;
            this.setAWholeHryvnia((int) (numberOfEuro / 0.0196));
            this.setFractionOfADollar((int) (fractionOfADollar) * 100);
            this.setFractionOfAEuro(this.getAWholeEuro() * 100);
            this.setFractionOfAHryvnia((int) (fractionOfAHryvnia) * 100);
        }
        else {
            this.setAWholeDollar(0);
            this.setAWholeEuro(0);
            this.setAWholeHryvnia(0);
            this.setFractionOfADollar(0);
            this.setFractionOfAEuro(0);
            this.setFractionOfAHryvnia(0);
        }
    }

    public void lowerThePriceOfTheProductByHryvnia(int numberOfHryvnia) {
        if (this.getAWholeHryvnia() - numberOfHryvnia >= 0) {
            this.setAWholeHryvnia(this.getAWholeHryvnia() - numberOfHryvnia);
            float fractionOfADollar = numberOfHryvnia / 44.7750F;
            this.setAWholeDollar((int) (numberOfHryvnia / 44.7750));
            float fractionOfAEuro = numberOfHryvnia / 51.0660F;
            this.setAWholeEuro((int) (numberOfHryvnia / 51.0660));
            this.setFractionOfADollar((int) (fractionOfADollar) * 100);
            this.setFractionOfAEuro((int) (fractionOfAEuro) * 100);
            this.setFractionOfAHryvnia(this.getAWholeHryvnia() * 100);
        }
        else {
            this.setAWholeDollar(0);
            this.setAWholeEuro(0);
            this.setAWholeHryvnia(0);
            this.setFractionOfADollar(0);
            this.setFractionOfAEuro(0);
            this.setFractionOfAHryvnia(0);
        }
    }

    @Override
    public String toString() {
        return "Product(aWholeDollar=" + this.getAWholeDollar() + ", aWholeEuro=" + this.getAWholeEuro() + ", aWholeHryvnia=" + this.getAWholeHryvnia() + ", productName=" + this.getProductName() + ")";
    }
}
