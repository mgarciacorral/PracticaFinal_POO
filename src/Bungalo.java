import java.time.LocalDate;

/**
 * Clase Bungalo
 */
public class Bungalo implements java.io.Serializable
{
    private Reserva reservas;
    private String id;
    private String nombre;
    private int capacidad;
    private float precio;

    /**
     * Constructor de la clase Bungalo
     * @param id
     * @param nombre
     * @param capacidad
     * @param precio
     */
    public Bungalo(String id, String nombre, int capacidad, float precio)
    {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        reservas = new Reserva(LocalDate.of(2004, 6, 4), LocalDate.of(2004, 6, 4));
    }

    /**
     * @return identificador del bungalo
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return capacidad del bungalo
     */
    public int getCapacidad()
    {
        return capacidad;
    }

    /**
     * @return nombre del bungalo
     */
    public String  getNombre()
    {
        return nombre;
    }

    /**
     * @return precio del bungalo
     */
    public float getPrecio()
    {
        return precio;
    }

    /**
     * @return numero de reservas
     */
    public int getNumReservas()
    {
        return reservas.getReservas();
    }

    /**
     * @param fechaInicio
     * @param fechaFin
     * @return true si esta disponible, false si no
     */
    public boolean comprobarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin)
    {
        return reservas.comprobarDisponibilidad(fechaInicio, fechaFin);
    }

    /**
     * añaade una reserva al bungalo
     * @param reserva
     */
    public void addReserva(ReservaBungalo reserva)
    {
        reservas.addReserva(reserva);
    }

    /**
     * @param id
     * @return true si se ha encontrado la reserva, false si no
     */
    public boolean eliminarReserva(String id)
    {
        return reservas.eliminarReserva(id);
    }

    /**
     * @param id
     * @param act
     * @param fechaInicio
     * @param fechaFin
     * @return true si se ha reservado correctamente, false si no
     */
    public boolean reservarActividad(String id, Actividad act, LocalDate fechaInicio, LocalDate fechaFin)
    {
        return reservas.reservarActividad(id, act, fechaInicio, fechaFin);
    }

    /**
     * @param id de la reserva
     * @return true si se ha encontrado la reserva, false si no
     */
    public boolean eliminarReservaActividad(String id)
    {
        return reservas.eliminarActividad(id);
    }

    /**
     * lista las reservas del bungalo
     */
    public void listarReservas()
    {
        reservas.listarReservas();
    }

    /**
     * @param id de la reserva
     * @return true si se ha encontrado la reserva, false si no
     */
    public boolean mostrarReserva(String id)
    {
        return reservas.mostrarReserva(id);
    }

    /**
     * @param id de la reserva
     * @return true si se ha facturado correctamente, false si no
     */
    public boolean facturar(String id)
    {
        return reservas.facturar(id);
    }
}
