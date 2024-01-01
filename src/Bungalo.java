import java.time.LocalDate;

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
        reservas = new Reserva(LocalDate.of(2004, 6, 4), LocalDate.of(2004, 6, 4));
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

    public boolean comprobarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin)
    {
        return reservas.comprobarDisponibilidad(fechaInicio, fechaFin);
    }

    public void addReserva(ReservaBungalo reserva)
    {
        reservas.addReserva(reserva);
    }

    public boolean eliminarReserva(String id)
    {
        return reservas.eliminarReserva(id);
    }

    public boolean reservarActividad(String id, Actividad act, LocalDate fechaInicio, LocalDate fechaFin)
    {
        return reservas.reservarActividad(id, act, fechaInicio, fechaFin);
    }

    public boolean eliminarReservaActividad(String id)
    {
        return reservas.eliminarActividad(id);
    }

    public void listarReservas()
    {
        reservas.listarReservas();
    }

    public boolean mostrarReserva(String id)
    {
        return reservas.mostrarReserva(id);
    }

    public boolean facturar(String id)
    {
        return reservas.facturar(id);
    }
}
