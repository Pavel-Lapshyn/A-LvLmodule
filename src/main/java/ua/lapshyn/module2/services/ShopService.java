package ua.lapshyn.module2.services;


import ua.lapshyn.module2.objects.*;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import java.net.URISyntaxException;
import java.net.URL;


public class ShopService {
    private static final List<Invoice> invoices = new ArrayList<>();

    public static List<Product> csvToList(String fileName) {
        ClassLoader classLoader = ShopService.class.getClassLoader();
        URL source = classLoader.getResource(fileName);
        if (source == null) {
            throw new IllegalArgumentException("file " + fileName + " doesn't exist");
        } else {
            List<String[]> productsList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(source.toURI())))) {
                String csvLine;
                while ((csvLine = reader.readLine()) != null) {
                    String[] productFeatures = csvLine.split(",");
                    try {
                        if (Arrays.asList(productFeatures).contains("")) {
                            throw new IncorrectStringValueException("parameter empty at string: " + csvLine);
                        }
                        productsList.add(productFeatures);
                    } catch (IncorrectStringValueException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }

            List<Product> objProductsList = new ArrayList<>();
            for (String[] productParameters : productsList) {
                if (productParameters[0].equals("Telephone")) {
                    Telephone telephone = new Telephone();
                    telephone.setProductType(productParameters[0]);
                    telephone.setSeries(productParameters[1]);
                    telephone.setModel(productParameters[2]);
                    telephone.setScreenType(productParameters[4]);
                    telephone.setPrice(Integer.parseInt(productParameters[6]));
                    objProductsList.add(telephone);
                } else if (productParameters[0].equals("Television")) {
                    Television television = new Television();
                    television.setProductType(productParameters[0]);
                    television.setSeries(productParameters[1]);
                    television.setDiagonal(productParameters[3]);
                    television.setScreenType(productParameters[4]);
                    television.setCountry(productParameters[5]);
                    television.setPrice(Integer.parseInt(productParameters[6]));
                    objProductsList.add(television);
                }
            }
            return objProductsList;
        }
    }

    private static void logCreation(Invoice invoice) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/logs.txt",true))) {
                writer.write(System.lineSeparator() + "["+LocalDateTime.now()+ "] ["+ invoice.getCustomer().toString() + "] [" + invoice.getProducts() +"]");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void randomInvoiceGenerator(List<Product> productsList) {
        Invoice randomInvoice = new Invoice();
        List<Product> invoiceProducts = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1, 6); i++) {
            invoiceProducts.add(productsList.get(ThreadLocalRandom.current().nextInt(productsList.size())));
        }
        randomInvoice.setProducts(invoiceProducts);
        randomInvoice.setCustomer(PersonService.randomCustomer());
        invoices.add(randomInvoice);
        logCreation(randomInvoice);
    }

}