package test.PicoPlaca;

import PicoPlaca.Plate;

import java.time.DayOfWeek;

import static org.junit.Assert.*;

public class PlateTest {
    private Plate p1;
    private Plate p2;
    private Plate p3;
    private Plate p4;
    private Plate p5;

    @org.junit.Before
    public void setUp() throws Exception {
        p1 = new Plate("abc012");
        p2 = new Plate("abc014");
        p3 = new Plate("abc016");
        p4 = new Plate("abc018");
        p5 = new Plate("abc010");
    }

    @org.junit.Test
    public void getRestrictedDays() {
        assertEquals(DayOfWeek.MONDAY, p1.getRestrictedDay());
        assertEquals(DayOfWeek.TUESDAY, p2.getRestrictedDay());
        assertEquals(DayOfWeek.WEDNESDAY, p3.getRestrictedDay());
        assertEquals(DayOfWeek.THURSDAY, p4.getRestrictedDay());
        assertEquals(DayOfWeek.FRIDAY, p5.getRestrictedDay());
    }
}