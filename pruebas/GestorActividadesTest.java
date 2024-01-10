import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorActividadesTest {

    @Test
    public void testGetInstance() {
        GestorActividades gestor1 = GestorActividades.getInstance();
        GestorActividades gestor2 = GestorActividades.getInstance();
        assertSame(gestor1, gestor2);
    }

}