import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class FacturaTest {

    @Test
    public void testGetId() {
        Factura factura = new Factura("1", 150.0f, new Bungalo("1", "Bungalo Test", 4, 100.0f),
                new ArrayList<>(), "Reserva1");
        assertEquals("1", factura.getId());
    }

    @Test
    public void testGetCosteTotal() {
        Factura factura = new Factura("1", 150.0f, new Bungalo("1", "Bungalo Test", 4, 100.0f),
                new ArrayList<>(), "Reserva1");
        assertEquals(150.0f, factura.getCosteTotal(), 0.001);
    }

    @Test
    public void testGetFechaFacturacion() {
        Factura factura = new Factura("1", 150.0f, new Bungalo("1", "Bungalo Test", 4, 100.0f),
                new ArrayList<>(), "Reserva1");
        assertEquals(LocalDate.now(), factura.getFechaFacturacion());
    }

    @Test
    public void testGetReserva() {
        Factura factura = new Factura("1", 150.0f, new Bungalo("1", "Bungalo Test", 4, 100.0f),
                new ArrayList<>(), "Reserva1");
        assertEquals("Reserva1", factura.getReserva());
    }

    @Test
    public void testGetBungalo() {
        Factura factura = new Factura("1", 150.0f, new Bungalo("1", "Bungalo Test", 4, 100.0f),
                new ArrayList<>(), "Reserva1");
        assertEquals("1 - Bungalo Test", factura.getBungalo());
    }

    @Test
    public void testListarActividades() {
        Factura factura = new Factura("1", 150.0f, new Bungalo("1", "Bungalo Test", 4, 100.0f),
                new ArrayList<>(), "Reserva1");
        factura.listarActividades();
        // Aquí podrías agregar aserciones adicionales si lo consideras necesario
    }
}