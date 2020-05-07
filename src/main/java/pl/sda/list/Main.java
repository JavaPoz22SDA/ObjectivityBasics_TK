package pl.sda.list;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws  IOException {
       final int N=10;
       List l = new List(N);
       for(int i=0;i<N/2;i++)
           l.addElement((1 << i));
       l.addElement(2);
       l.addElement(8);
       l.print();
       l.delFirst(2);
       l.print();
        for(int i=0;i<N/2;i++)
            l.addElement((1 << i));
        l.print();
        System.out.println("Po usunięciu powtórzeń:");
        l.delRepeats();
        l.print();
        l.saveToFile("list.txt");
    }
}
