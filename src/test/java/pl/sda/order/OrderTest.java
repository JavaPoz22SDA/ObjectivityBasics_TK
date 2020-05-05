package pl.sda.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("return 15.5 when (quantity = 3 and price = 4) and (quantity = 1 and price = 3.5)")
    void should_return_15_5() {
        //given
        Order order = new Order();
        order.addItem(new Item("Cukier", 3, 4));
        order.addItem(new Item("Chleb", 1, 3.5));

        //when
        double result = order.calculateValue(true);

        //then
        assertEquals(15.5, result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("return 0 when list is empty")
    void should_return_0() {
        //given
        Order o = new Order();
        //when
        double result = o.calculateValue(false);

        //then
        assertEquals(0,result);
    }

    @Test
    @DisplayName("should delete item from list")
    void should_delete_item() {
        //given
        Item item=new Item("Cukier", 3,4);
        Item item2=new Item("Chleb", 1,3.5);
        Order order = new Order();
        order.addItem(item);
        order.addItem(item2);
        //when
        order.delItem(0);

        //then
        assertEquals(1,order.getItems().size());
    }
    @Test
    @DisplayName("should do nothing when index is out of range")
    void should_do_nothing_when_index_outOfRange() {
        //given
        Item item=new Item("Cukier", 3,4);
        Item item2=new Item("Chleb", 1,3.5);
        Order order = new Order();
        order.addItem(item);
        order.addItem(item2);
        //when
        order.delItem(2);

        //then
        assertEquals(2,order.getItems().size());
    }

}