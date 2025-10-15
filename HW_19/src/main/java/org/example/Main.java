package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        var hotel = Hotel.getInstance();
        hotel.addRoom(1, new Suite(SuiteType.Standard, (byte) 2));
        // let's check error message
        hotel.addRoom(1, new Suite(SuiteType.JuniorSuite, (byte) 3));
        hotel.addRoom(2, new Suite(SuiteType.DeLuxe, (byte) 3));
        hotel.addRoom(3, new Suite(SuiteType.Studio, (byte) 3));
        System.out.println(hotel);
        // let's check its a real singleton:
        var hotel2 = Hotel.getInstance();
        System.out.println(hotel2);

    }
}