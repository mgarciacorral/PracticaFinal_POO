public class Bungalo extends Gestionable
{
    private String nombre;
    private int capacidad;
    private float precio;

    public Bungalo(String id, String nombre, int capacidad, float precio)
    {
        super(id);
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public int getCapacidad()
    {
        return this.capacidad;
    }

    public float getPrecio()
    {
        return this.precio;
    }
}
