import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioAsistenteTest {

    @Test
    void getPrecio() {
        Bungalo bungalo = new Bungalo("B001", "Bungalo1", 4, 100.0f);
        ServicioAsistente servicioAsistente = new ServicioAsistente(bungalo);

        assertEquals(115.0f, servicioAsistente.getPrecio(), 0.001);
    }

}
