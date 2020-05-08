package pl.sda.time;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    Time t1 =new Time(10,56);
    Time t2 =new Time(0,123);

    @Test
    void should_return_2h_3min_when_h0_m123() {
        //given
        Time result = new Time(2,3);

        //then
        assertEquals(t2,result);
    }
    @Test
    void should_return_3h_17min_() {
        //given
        Time result = new Time("10 h 56 min");

        //then
        assertEquals(t1,result);
    }
    @Test
    void should_return_12h_59min_when_t1_plus_t2() {
        //given

        //when
        Time result = t1.add(t2);

        //then
        assertEquals(new Time(12,59),result);
    }

    @Test
    void should_return_8h_53min_when_t1_sub_t2() {
        //when
        Time result = t1.sub(t2);

        //then
        assertEquals(new Time(8,53),result);
    }
    @Test
    void should_return_8h_53min_when_t2_sub_t1() {
        //when
        Time result = t2.sub(t1);

        //then
        assertEquals(new Time(-8,-53),result);
    }
    @Test
    void should_return_21h_52min_when_t1_multiply_2() {
        //when
        Time result = t1.multiply(2);

        //then
        assertEquals(new Time(21,52),result);
    }

    @Test
    void should_return_15h_2min_when_sum_t1_t2_t2() {
        //given
        Time[] tab ={t1,t2,t2};
        //when
        Time result = Time.sum(tab,3);

        //then
        assertEquals(new Time(15,2),result);
    }
}