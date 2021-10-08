package ua.lapshyn.module2;

import ua.lapshyn.module2.objects.*;
import ua.lapshyn.module2.services.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productsList = ShopService.csvToList("goods.csv");
        for (int i = 0; i < 15; i++) {
            ShopService.randomInvoiceGenerator(productsList);
        }


    }
}
