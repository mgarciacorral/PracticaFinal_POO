import java.time.LocalDateTime;

public class Bungalo implements java.io.Serializable
{
    private Reserva reservas;
    private String id;
    private String nombre;
    private int capacidad;
    private float precio;

    public Bungalo(String id, String nombre, int capacidad, float precio)
    {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        reservas = new Reserva(LocalDateTime.of(2004, 6, 4, 0, 0), LocalDateTime.of(2004, 6, 4, 0, 0));
    }

    public String getId()
    {
        return id;
    }

    public int getCapacidad()
    {
        return capacidad;
    }

    public String  getNombre()
    {
        return nombre;
    }

    public float getPrecio()
    {
        return precio;
    }

    public int getNumReservas()
    {
        return reservas.getReservas();
    }
}
