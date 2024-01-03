import java.time.LocalDate;

/**
 * Clase ReservaActividad
 */
public class ReservaActividad extends Reserva
{
    private Actividad actividad;

    /**
     * Constructor de la clase ReservaActividad
     * @param fechaInicio
     * @param fechaFin
     * @param actividad
     */
    public  ReservaActividad(LocalDate fechaInicio, LocalDate fechaFin, Actividad actividad)
    {
        super(fechaInicio, fechaFin);
        this.actividad = actividad;
    }

    /**
     * @return instancia de la actividad
     */
    public Actividad getActividad()
    {
        return actividad;
    }
}

