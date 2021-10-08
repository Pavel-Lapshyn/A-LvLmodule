package ua.lapshyn.module2.services;

import ua.lapshyn.module2.objects.Customer;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class PersonService {
    public static Customer randomCustomer() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int number = ThreadLocalRandom.current().nextInt(str.length());
            sb.append(str.charAt(number));
        }
        String email = sb.toString();

        return new Customer(ThreadLocalRandom.current().nextInt(20000),
                email + "@gmail.com",
                ThreadLocalRandom.current().nextInt(5, 100));
    }
}