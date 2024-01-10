import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ReservaBungaloTest {

    @Test
    void testGetId() {
        // Crear una instancia de Bungalo y Cliente
        Bungalo bungalo = new Bungalo("B1", "NombreBungalo", 4, 100.0F);
        Cliente cliente = new Cliente("12345678A", "NombreCliente", "DireccionCliente");

        // Crear una instancia de ReservaBungalo
        ReservaBungalo reservaBungalo = new ReservaBungalo(LocalDate.now(), LocalDate.now().plusDays(7), bungalo, cliente, "R1");

        // Obtener el ID de la reserva
        assertEquals("R1", reservaBungalo.getId());
    }

    @Test
    void testGetBungalo() {
        // Crear una instancia de Bungalo y Cliente
        Bungalo bungalo = new Bungalo("B1", "NombreBungalo", 4, 100.0F);
        Cliente cliente = new Cliente("12345678A", "NombreCliente", "DireccionCliente");

        // Crear una instancia de ReservaBungalo
        ReservaBungalo reservaBungalo = new ReservaBungalo(LocalDate.now(), LocalDate.now().plusDays(7), bungalo, cliente, "R1");

        // Obtener la instancia de Bungalo desde la reserva
        assertEquals(bungalo, reservaBungalo.getBungalo());
    }

    @Test
    void testGetCliente() {
        // Crear una instancia de Bungalo y Cliente
        Bungalo bungalo = new Bungalo("B1", "NombreBungalo", 4, 100.0F);
        Cliente cliente = new Cliente("12345678A", "NombreCliente", "DireccionCliente");

        // Crear una instancia de ReservaBungalo
        ReservaBungalo reservaBungalo = new ReservaBungalo(LocalDate.now(), LocalDate.now().plusDays(7), bungalo, cliente, "R1");

        // Obtener la instancia de Cliente desde la reserva
        assertEquals(cliente, reservaBungalo.getCliente());
    }
}