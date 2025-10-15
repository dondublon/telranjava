package org.example;

import java.util.Map;
import java.util.HashMap;


public class Hotel {
    private static final Hotel INSTANCE = new Hotel();
    private final Map<Integer, Suite> suites;  // Suite by number

    private Hotel() {
        this.suites = new HashMap<Integer, Suite>();
    }

    public static Hotel getInstance() {
        return INSTANCE;
    }

    public void addRoom(int number, Suite suite) {
        if (this.suites.containsKey(number)) {
            System.out.printf("The suite number %s already presented: %s%n", number, this.suites.get(number));
        }
        else {
            this.suites.put(number, suite);
        }

    }

    public Suite getSuite(int number) {
        return this.suites.get(number);
    }
}
