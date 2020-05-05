package pl.sda.order;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private int quantity;
    private double price;


    public Item(String name, int quantity, double price) {
        this.name = name;
        /** Ilość sztuk  */
        this.quantity = quantity;
        /** Cena pojedyńczej sztuki  */
        this.price = price;
    }

    /**
     * Oblicza wartość pozycji zamówienia
     *
     * @return
     */
    double calculate() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("%-20s %10.2f zł %4d szt. %10.2f zł %10.2f zł", name, price, quantity, calculate(),calculateValueWithDiscount());
    }

    double calculateValueWithDiscount() {
        if (quantity >= 5 && quantity <= 10) {
            return (price - (price * 0.05)) * quantity;
        } else if (quantity > 10 && quantity <= 20) {
            return (price - (price * 0.1)) * quantity;
        } else if (quantity > 20) {
            return (price - (price * 0.15)) * quantity;
        } else
            return price * quantity;
    }
}
