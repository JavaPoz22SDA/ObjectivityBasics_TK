package pl.sda.list;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class List {
    int[] numbers;
    int capacity;
    int size;

    public List(int capacity) {
        this.capacity = capacity;
        this.numbers = new int[capacity];
        this.size = 0;
    }

    /**
     * dodaje liczbę do tablicy @numbers lub rzuca wyjątek gdy lista jest pełna
     *
     * @param number liczba dodawana do tablicy @numbers
     * @throws FullTableException
     */
    public void addElement(int number) {
        if (size < capacity) {
            numbers[size] = number;
            size++;
        } else
            try {
                throw new FullTableException("Nie można dodać więcej elementów, lista pełna!");
            } catch (FullTableException e) {
                System.out.println(e.getMessage());
            }
    }

    /**
     * Metoda sprawdza czy dana liczba jest w tablicy
     *
     * @param value szukana liczba
     * @return indeks szukanej liczby lub -1 gdy brak
     */
    public int find(int value) {
        int index = -1;
        for (int i = 0; i < size; i++)
            if (numbers[i] == value)
                return i;
        return index;
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lista:\n")
                .append("Pojemność: " + this.capacity + "\n")
                .append("Rozmiar: " + this.size + "\n")
                .append("Elementy: ");
        for (int i = 0; i < size; i++)
            stringBuilder.append(" " + numbers[i]);
        System.out.println(stringBuilder.toString());
    }

    /**
     * Usuwa pierwsze wystąpienie liczby
     * @param value liczba do usunięcia
     */
    public void delFirst(int value) {
        int index = find(value);
        if (index != -1) {
            for (int a = index; a < size; a++) {
                numbers[a] = numbers[a + 1];
            }
            size--;
        }
    }

    /**
     * Usuwa powtórzenia liczb z tablicy
     */
    public void delRepeats() {
        numbers = Arrays.stream(numbers).distinct().toArray();
        size = numbers.length;
    }

    /**
     * Odwraca liczby w tablicy
     */
    public void reverse() {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < size; i++)
            integerStack.push(numbers[i]);
        int i = 0;
        while (!integerStack.isEmpty()) {
            numbers[i] = integerStack.pop();
            i++;
        }
    }

    public void saveToFile(String fileName) throws IOException {
        Writer writer = new FileWriter(fileName);
       writer.write("Pojemność: " + this.capacity + "\n");
        writer.write("Rozmiar: " + this.size + "\n");
        writer.write("Elementy: ");
        for (int i = 0; i < size; i++)
            writer.write(" " + numbers[i]);
        writer.flush();
        writer.close();
    }
}
