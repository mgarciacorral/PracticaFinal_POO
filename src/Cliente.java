import java.util.ArrayList;

public class Cliente implements java.io.Serializable
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
        facturas = new ArrayList<Factura>();
    }

    public String getId()
    {
        return identificador;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }

}
