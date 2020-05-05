package pl.sda.order;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "orderDetails.fck";
        Item item=new Item("Cukier", 3,4);
        System.out.println(item.toString());
        Item item1=new Item("Mąka", 13,5);
        System.out.println(item1.toString());
        Item item2=new Item("Chleb", 1,3.5);
        System.out.println(item2.toString());
        Item item3=new Item("Wino", 21,4);
        System.out.println(item3.toString());
        System.out.println();
        Order order=new Order();
        order.addItem(item);
        order.addItem(item2);
        order.addItem(item1);
        order.addItem(item3);
        System.out.println(order.toString());

        Order.saveOrder(order,fileName);
        System.out.println("nowe");
        Order orderRead = Order.readOrder(fileName);
        System.out.println(orderRead.toString());
    }
}
