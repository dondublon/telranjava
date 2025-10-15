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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel suites:\n");
        for (Map.Entry<Integer, Suite> entry : this.suites.entrySet()) {
            sb.append("Number ").append(entry.getKey())
                    .append(": ").append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }

    public boolean addRoom(int number, Suite suite) {
        if (this.suites.containsKey(number)) {
            System.out.printf("The suite number %s already presented: %s%n", number, this.suites.get(number));
            return false;
        }
        else {
            this.suites.put(number, suite);
            return true;
        }

    }

    public Suite getSuite(int number) {
        return this.suites.get(number);
    }
    public Map<Integer, Suite> getSuites(SuiteType type) {
        var result = new HashMap<Integer, Suite>();
        for (var num_suite : this.suites.entrySet()) {
            var num = num_suite.getKey();
            var suite = num_suite.getValue();
            if (suite.type == type) {
                result.put(num, suite);
            }
        }
        return result;
    }
}
