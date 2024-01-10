import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActividadTest {

    @Test
    public void testGetId() {
        // Arrange
        Actividad actividad = new Actividad("1", "Actividad de prueba", 10.0f);

        // Act
        String result = actividad.getId();

        // Assert
        assertEquals("1", result);
    }

    @Test
    public void testGetDescripcion() {
        // Arrange
        Actividad actividad = new Actividad("1", "Actividad de prueba", 10.0f);

        // Act
        String result = actividad.getDescripcion();

        // Assert
        assertEquals("Actividad de prueba", result);
    }

    @Test
    public void testGetPrecio() {
        // Arrange
        Actividad actividad = new Actividad("1", "Actividad de prueba", 10.0f);

        // Act
        float result = actividad.getPrecio();

        // Assert
        assertEquals(10.0f, result, 0.001); // Ajusta la tolerancia según sea necesario
    }
}