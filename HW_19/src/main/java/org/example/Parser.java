package org.example;

import java.util.Scanner;

public class Parser {
    private final Scanner scanner;

    public Parser(Scanner source) {
        this.scanner = source;
    }
    public Integer inputRoomNumber() {
        System.out.print("Введите номер комнаты");
        var line = this.scanner.nextLine();
        return Integer.parseInt(line);
    }
    public Person inputPerson() {
        System.out.print("Введите имя и фамилию через пробел");
        var line = this.scanner.nextLine();
        String[] parts = line.split(" ");
        return new Person(parts[0], parts[1]);
    }

    public MyDate inputDate(String prompt) {
        System.out.print(String.format("Введите %s в формате mm.dd.yyyy: ", prompt));
        var s = this.scanner.nextLine();
        return MyDate.parse(s);
    }


}
