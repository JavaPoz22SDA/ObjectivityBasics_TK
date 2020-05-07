package pl.sda.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    @DisplayName("should size=1 when addElement")
    void should_size_1()  {
        //given
List list=new List(3);

        //when
        list.addElement(2);

        //then
        assertEquals(1,list.size);
    }


    @Test
    @DisplayName("should return index when number is found")
    void should_return_index()   {
        //given
        List list=new List(5);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(2);

        //when
        int result = list.find(2);
        //then
        assertEquals(1,result);
    }
    @Test
    @DisplayName("should return -1 when number is not found")
    void should_return_minus_1()   {
        //given
        List list=new List(5);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(2);

        //when
        int result = list.find(4);
        //then
        assertEquals(-1,result);
    }


    @Test
    @DisplayName("should return first element in table")
    void should_del_first_element()   {
        //given
        List list=new List(5);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(2);

        //when
        list.delFirst(2);

        //then
        assertEquals(3,list.numbers[1]);
        //assertEquals(3,list.size);
    }

    @Test
    void should_delete_repeat_numbers()   {
        //given
        List list=new List(5);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(2);
        list.addElement(3);

        //when
        list.delRepeats();

        //then
        //assertEquals(3,list.size);
        int[] tab ={1,2,3};
        assertArrayEquals(tab,list.numbers);
        //assertArrayEquals();
    }

    @Test
    void should_reverse_table ()  {
        //given
        List list=new List(5);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);

        //when
        list.reverse();

        //then
        int[] tab ={5,4,3,2,1};
        assertArrayEquals(tab,list.numbers);
    }


}