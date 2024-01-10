import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioCateringTest {

    @Test
    void getPrecio() {
        Bungalo bungalo = new Bungalo("B002", "Bungalo2", 6, 120.0f);
        ServicioCatering servicioCatering = new ServicioCatering(bungalo);

        assertEquals(130.0f, servicioCatering.getPrecio(), 0.001);
    }

    // Agrega más pruebas según sea necesario para cubrir otros métodos o casos.
}
