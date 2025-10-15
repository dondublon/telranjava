package org.example;

public class Suite {
    // public int number;
    public SuiteType type;
    public byte places; // sleeping places

    public Suite(SuiteType type, byte places) {
        this.type = type;
        this.places = places;
    }

    @Override
    public String toString() {
        return "Suite{" +
                "type=" + type +
                ", places=" + places +
                '}';
    }
}
