package ru.evstafeva.house;

public class House2 {
    private final int floors; // final - нельзя изменить после создания

    public House2() {
        this.floors = 1; // по умолчанию с 1 этажом
    }

    public House2(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть неотрицательным числом. Получено: " + floors);
        }
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public String ending(int floors){
        int lastDigit = floors % 10;
        if (lastDigit == 1) {
            if (floors % 100 == 11){
                return "этажами";
            } else {
                return "этажом";
            }
        } else {
            return "этажами";
        }
    }

    @Override
    public String toString() {
        return "Дом с " + floors + " " + ending(floors);
    }
}
