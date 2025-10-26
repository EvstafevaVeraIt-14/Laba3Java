package ru.evstafeva.array;
import java.util.Arrays;

public class ImmutableListOfValues {
    private final int[] values;

    public ImmutableListOfValues(int... elements) { //конструктор массива с элеметами, записанными через запятую
        if (elements == null) {
            throw new IllegalArgumentException("Массив значений не может быть пустым.");
        }
        this.values = Arrays.copyOf(elements, elements.length); //копия для обеспечения иммутабельности (неизменяемости)
    }

    public ImmutableListOfValues(ImmutableListOfValues list) { //конструктор копирования
        if (list == null) {
            throw new IllegalArgumentException("Массив значений не может быть пустым.");
        }
        this.values = Arrays.copyOf(list.values,list.size());
    }


    public int positionN(int index) { //метод для получения значения по индексу
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Значение индекса не может выходить за диапазон значений массива.");
        }
        return values[index];
    }

    public ImmutableListOfValues replacementValue(int index, int value) { //метод для замены элемента по индексу
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Значение индекса не может выходить за диапазон значений массива.");
        }
        int[] newArr = Arrays.copyOf(values,values.length);
        newArr[index] = value;
        return new ImmutableListOfValues(newArr);
    }

    public int[] toArray() { // метод копирования
        return Arrays.copyOf(values,values.length);
    }

    public boolean isEmpty() { // метод для проверки на пустоту
        return (values.length == 0);
    }

    public int size() { // метод возврата размера
        return values.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
