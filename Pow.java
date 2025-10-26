package ru.evstafeva.mathematics;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Pow {
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
}
