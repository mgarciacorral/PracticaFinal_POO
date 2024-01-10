import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteTest {

    @Test
    public void testGetId() {
        Cliente cliente = new Cliente("1", "Cliente Test", "123456789");
        assertEquals("1", cliente.getId());
    }

    @Test
    public void testGetNombre() {
        Cliente cliente = new Cliente("1", "Cliente Test", "123456789");
        assertEquals("Cliente Test", cliente.getNombre());
    }

    @Test
    public void testGetTelefono() {
        Cliente cliente = new Cliente("1", "Cliente Test", "123456789");
        assertEquals("123456789", cliente.getTelefono());
    }

}