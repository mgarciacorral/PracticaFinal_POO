import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class BungaloTest {

    @Test
    public void testGetId() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        assertEquals("1", bungalo.getId());
    }

    @Test
    public void testGetCapacidad() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        assertEquals(4, bungalo.getCapacidad());
    }

    @Test
    public void testGetNombre() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        assertEquals("Bungalo Test", bungalo.getNombre());
    }

    @Test
    public void testGetPrecio() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        assertEquals(100.0f, bungalo.getPrecio(), 0.001);
    }

    @Test
    public void testGetNumReservas() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        assertEquals(0, bungalo.getNumReservas());
    }

    @Test
    public void testComprobarDisponibilidad() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = LocalDate.now().plusDays(5);
        assertTrue(bungalo.comprobarDisponibilidad(fechaInicio, fechaFin));
    }

    @Test
    public void testListarReservas() {
        Bungalo bungalo = new Bungalo("1", "Bungalo Test", 4, 100.0f);
        bungalo.listarReservas();
    }

}