package pl.sda.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    @DisplayName("return 12 when quantity = 3 and price = 4")
    void should_return_12() {
        //given
        Item item=new Item("Cukier",3,4);
        //when
        double result = item.calculate();

        //then
        assertEquals(12,result);
    }


    @Test
    @DisplayName("return 19 when quantity = 5 and price = 4")
    void should_return_19() {
        //given
        Item item=new Item("Cukier",5,4);
        //when
        double result = item.calculateValueWithDiscount();

        //then
        assertEquals(19,result);
    }
    @Test
    @DisplayName("return 38 when quantity = 10 and price = 4")
    void should_return_38() {
        //given
        Item item=new Item("Cukier",10,4);
        //when
        double result = item.calculateValueWithDiscount();

        //then
        assertEquals(38,result);
    }
    @Test
    @DisplayName("return 39.6 when quantity = 11 and price = 4")
    void should_return_39_6() {
        //given
        Item item=new Item("Cukier",11,4);
        //when
        double result = item.calculateValueWithDiscount();

        //then
        assertEquals(39.6,result);
    }
    @Test
    @DisplayName("return 72 when quantity = 20 and price = 4")
    void should_return_72() {
        //given
        Item item=new Item("Cukier",20,4);
        //when
        double result = item.calculateValueWithDiscount();

        //then
        assertEquals(72,result);
    }
    @Test
    @DisplayName("return 71,4 when quantity = 21 and price = 4")
    void should_return_71_4() {
        //given
        Item item=new Item("Cukier",21,4);
        //when
        double result = item.calculateValueWithDiscount();
        result *=100;
        result =Math.round(result);
        result/=100;

        //then
        assertEquals(71.4,result);
    }
    @Test
    @DisplayName("return 58,5 when quantity = 13 and price = 5")
    void should_return_58_5() {
        //given
        Item item=new Item("Cukier",13,5);
        //when
        double result = item.calculateValueWithDiscount();

        //then
        assertEquals(58.5,result);
    }
}