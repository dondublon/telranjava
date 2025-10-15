package org.example;

import java.util.Map;
import java.util.HashMap;


public class Hotel {
    private final Map<Integer, Suite> Suites;  // Suite by number

    public Hotel() {
        this.Suites = new HashMap<Integer, Suite>();
    }

    public void addRoom(int number, Suite suite) {
        if (this.Suites.containsKey(number)) {
            System.out.printf("The suite number %s already presented: %s%n", number, this.Suites.get(number));
        }
        else {
            this.Suites.put(number, suite);
        }

    }

    public Suite getSuite(int number) {
        return this.Suites.get(number);
    }
}
