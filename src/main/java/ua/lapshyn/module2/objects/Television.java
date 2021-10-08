package ua.lapshyn.module2.objects;

import lombok.*;

@Getter
@Setter
public class Television extends Product {
    private String diagonal;
    private String country;
    private String type = "Television";


    @Override
    public String getProductType() {
        return super.getProductType();
    }

    @Override
    public String toString() {
        return super.getProductType() + '\t' + "series=" + super.getSeries() + " diagonal=" + diagonal +
                " screen type=" + super.getScreenType() + " country=" + country + " price=" + super.getPrice();
    }
}
