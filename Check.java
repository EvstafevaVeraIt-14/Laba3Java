package ru.evstafeva.errors;

import java.util.Scanner;

public class Check {
    Scanner keyboard = new Scanner(System.in);

    public int checkAnInteger() { //проверка на целое число
        int number;
        String line;
        while (true) {
            line = keyboard.next().trim();
            try {
                number = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Недопустимое значение. Введите целое число: ");
            }
        }
        return number;
    }

    public String checkString() { //проверка на строку без цифр
        String line;
        boolean valid;
        while (true) {
            line = keyboard.next().trim();
            valid = true;
            for (int i = 0; i < line.length(); i++ ){
                char character = line.charAt(i);
                if (!Character.isLetter(character)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return line;
            } else {
                System.out.print("Недопустимое значение. Введите строку: ");
            }
        }
    }

    public double checkDouble() { //проверка на число double
        double number;
        String line;
        while (true) {
            line = keyboard.next().trim();
            try {
                number = Double.parseDouble(line);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Недопустимое значение. Введите число: ");
            }
        }
        return number;
    }
}
