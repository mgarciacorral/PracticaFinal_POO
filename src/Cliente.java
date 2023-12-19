import java.util.ArrayList;

public class Cliente
{
    private String id;
    private String nombre;
    private String telefono;
    private ArrayList<Factura> facturas;

    public Cliente(String id, String nombre, String telefono)
    {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
