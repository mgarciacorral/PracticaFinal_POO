import java.util.ArrayList;

public class Cliente
{
    private String identificador;
    private String nombre;
    private String telefono;
    private ArrayList<Factura> facturas;

    public Cliente(String id, String nombre, String telefono)
    {
        this.identificador = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
