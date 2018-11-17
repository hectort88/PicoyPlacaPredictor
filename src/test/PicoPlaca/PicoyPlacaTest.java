package test.PicoPlaca;

import PicoPlaca.PicoyPlaca;
import PicoPlaca.Plate;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class PicoyPlacaTest {
    PicoyPlaca pp1;

    @Before
    public void setUp() throws Exception {
        pp1 = new PicoyPlaca(LocalDateTime.of(2018,11,12, 6,15,0), new Plate("abc1b2"));
    }

    @Test
    public void isCarAllowedPlacaTerminandoEn2() {
        assertTrue(pp1.isCarAllowed()); //06:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertFalse(pp1.isCarAllowed()); //07:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 2);
        assertFalse(pp1.isCarAllowed()); //09:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertTrue(pp1.isCarAllowed()); //10:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 2);
        assertTrue(pp1.isCarAllowed()); //12:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 3);
        assertTrue(pp1.isCarAllowed()); //15:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 3);
        assertFalse(pp1.isCarAllowed()); //18:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertFalse(pp1.isCarAllowed()); //19:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertTrue(pp1.isCarAllowed()); //20:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 14);
        assertTrue(pp1.isCarAllowed()); //20:15 permitido
    }

    @Test
    public void isCarAllowedPlacaTerminandoEn6() {
        pp1.setPlate(new Plate("abc476"));
        pp1.setDate(LocalDateTime.of(2018, 12, 5, 6, 20, 15));
        assertTrue(pp1.isCarAllowed()); //06:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertFalse(pp1.isCarAllowed()); //07:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 2);
        assertFalse(pp1.isCarAllowed()); //09:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertTrue(pp1.isCarAllowed()); //10:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 2);
        assertTrue(pp1.isCarAllowed()); //12:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 3);
        assertTrue(pp1.isCarAllowed()); //15:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 3);
        assertFalse(pp1.isCarAllowed()); //18:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertFalse(pp1.isCarAllowed()); //19:15 prohibido
        PicoyPlacaTest.AgregarHoras(pp1, 1);
        assertTrue(pp1.isCarAllowed()); //20:15 permitido
        PicoyPlacaTest.AgregarHoras(pp1, 14);
        assertTrue(pp1.isCarAllowed()); //20:15 permitido
    }

    public static void AgregarHoras(PicoyPlaca n, int horas) {
        n.setDate(n.getDate().plusHours(horas));
        System.out.println(n.getDate());
    }
}