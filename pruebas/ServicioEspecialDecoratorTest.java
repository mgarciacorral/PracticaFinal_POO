import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioEspecialDecoratorTest {

    @Test
    void getPrecio() {
        Bungalo bungalo = new Bungalo("B001", "Bungalo1", 4, 100.0f);
        ServicioEspecialDecorator servicioEspecial = new ServicioEspecialDecorator(bungalo);

        assertEquals(100.0f, servicioEspecial.getPrecio(), 0.001);
    }

    // Agrega más pruebas según sea necesario para cubrir otros métodos o casos.
}
