package org.example;

public enum SuiteType {
    Standard("стандартный однокомнатный номер", 100),
    Studio("однокомнатный номер с мини-кухней", 150),
    JuniorSuite("номер улучшенной планировки", 200),
    Suite("улучшенной планировки, из двух комнат", 250),
    DeLuxe("номер повышенного комфорта", 300),
    President("самые роскошные номера", 350);

    private final String description;
    private final int price;

    SuiteType(String description, int price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
