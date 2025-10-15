package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        var hotel = Hotel.getInstance();
        var ok = hotel.addRoom(1, new Suite(SuiteType.Standard, (byte) 2));
        // let's check error message
        ok = hotel.addRoom(1, new Suite(SuiteType.JuniorSuite, (byte) 3));
        ok = hotel.addRoom(2, new Suite(SuiteType.DeLuxe, (byte) 3));

        ok = hotel.addRoom(3, new Suite(SuiteType.Studio, (byte) 3));
        ok = hotel.addRoom(5, new Suite(SuiteType.DeLuxe, (byte) 3));
        System.out.println(hotel);
        // let's check it's a real singleton:
        var hotel2 = Hotel.getInstance();
        System.out.println(hotel2);

        // lets found Deluxe:
        var deluxes = hotel.getSuites(SuiteType.DeLuxe);
        System.out.println("deluxes:");
        System.out.println(deluxes);

        // let's found President - empty for our case:
        var President = hotel.getSuites(SuiteType.President);
        System.out.println("President:");
        System.out.println(President);

        // Let's book something and check what is booked
        var vasya = new Person("Vasily", "Vasiliev");
        var petya = new Person("Peter", "Petrov");

        var booked = hotel.book(vasya,
                new BookItem(2, new DateInterval(
                        new MyDate(1, Month.AUGUST, 2024),
                        new MyDate(10, Month.AUGUST, 2024)
                )));
        var booked2 = hotel.book(vasya,
                new BookItem(3, new DateInterval(
                        new MyDate(2, Month.SEPTEMBER, 2024),
                        new MyDate(20, Month.OCTOBER, 2024)
                )));

        var booked3 = hotel.book(petya,
                new BookItem(2, new DateInterval(
                        new MyDate(1, Month.AUGUST, 2024),
                        new MyDate(10, Month.AUGUST, 2024)
                )));
        // We expect fail here.
        System.out.println("Trying to book room 2");
        var booked4 = hotel.book(petya,
                new BookItem(2, new DateInterval(
                        new MyDate(3, Month.SEPTEMBER, 2024),
                        new MyDate(4, Month.SEPTEMBER, 2024)
                )));
        System.out.println("Vasya's bookings:");
        System.out.println(hotel.getBookingsByPerson(vasya));

        System.out.println("Petyas's bookings:");
        System.out.println(hotel.getBookingsByPerson(petya));
        // Bookings for number 3:
        System.out.println("Bookings for room 3:");
        System.out.println(hotel.getBookingsByRoom(3));
        System.out.println("Bookings for room 2:");
        var booking_room_2 = hotel.getBookingsByRoom(2);
        System.out.println(booking_room_2);
        System.out.println("Bookings for room 5:");
        System.out.println(hotel.getBookingsByRoom(5));
        // Removing booking for room 2:
        ok = hotel.removeBooking(booking_room_2.get(1));
        System.out.println("Bookings for room 2 after deleting:");
        var booking_room_2_again = hotel.getBookingsByRoom(2);
        System.out.println(booking_room_2_again);

    }
}