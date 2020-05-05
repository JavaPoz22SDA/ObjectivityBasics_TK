package pl.sda.order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    public List<Item> getItems() {
        return items;
    }

    private List<Item> items;
    /**
     * Liczba pozycji w zamówieniu
     */
    private int counter;
    /**
     * Max liczba pozycji w zamówieniu
     */
    private int maxSize;


    public Order() {
        this.maxSize = 10;
        items = new ArrayList<Item>();
    }

    public Order(int maxSize) {
        items = new ArrayList<Item>();
        this.maxSize = maxSize;
    }

    void addItem(Item i) {
        items.add(i);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zamówienie:\n");
        for (Item i : items) {
            builder.append(i.toString() + "\n");
        }
        builder.append("\nRazem: " + String.format("%.2f zł", calculateValue(false)));
        builder.append("\nRazem po rabacie: " + String.format("%.2f zł", calculateValue(true)));
        return builder.toString();
    }

    /**
     * Oblicza wartość zamówienia
     *
     * @return wartość zamówienia
     */
    double calculateValue(boolean isDiscount) {
        double sumValue = 0;
        if (isDiscount) {
            for (Item i : items) {
                sumValue += i.calculateValueWithDiscount();
            }
        } else {
            for (Item i : items) {
                sumValue += i.calculate();
            }
        }
        return sumValue;
    }

    void delItem(int index) {
        if (index < items.size())
            items.remove(index);
    }

    void editItem(int index) {

    }

    public static void saveOrder(Order o, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(o);
        }
    }

    public static Order readOrder(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
            return (Order)inputStream.readObject();
        }
    }
}
