/**
 * Clase Actividad
 */
public class Actividad implements java.io.Serializable
{
    private String id;
    private String descripcion;
    private float precio;

    /**
     * Constructor de la clase Actividad
     * @param id
     * @param descripcion
     * @param precio
     */
    public Actividad(String id, String descripcion, float precio)
    {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * @return id de la actividad
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return descripcion de la actividad
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @return precio de la actividad
     */
    public float getPrecio()
    {
        return precio;
    }
}
