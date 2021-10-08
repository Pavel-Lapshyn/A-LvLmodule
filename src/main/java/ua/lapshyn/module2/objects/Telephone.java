package ua.lapshyn.module2.objects;

import lombok.*;


@Getter
@Setter
public class Telephone extends Product {
    private String model;

    @Override
    public String getProductType() {
        return super.getProductType();
    }

    @Override
    public String toString() {
        return super.getProductType() + '\t' + "series=" + super.getSeries() + " model=" + model +
                " screen type=" + super.getScreenType() + " price=" + super.getPrice();
    }
}
