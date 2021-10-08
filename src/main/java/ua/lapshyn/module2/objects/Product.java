package ua.lapshyn.module2.objects;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String productType;
    private String series;
    private String screenType;
    private int price;

    public String getProductType() {
        return productType;
    }
}
