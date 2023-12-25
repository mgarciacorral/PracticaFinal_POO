public class Actividad
{
    private String id;
    private String descripcion;
    private float precio;

    public Actividad(String id, String descripcion, float precio)
    {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getId()
    {
        return id;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public float getPrecio()
    {
        return precio;
    }
}
