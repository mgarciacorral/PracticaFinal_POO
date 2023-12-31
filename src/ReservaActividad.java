import java.time.LocalDate;

public class ReservaActividad extends Reserva
{
    private Actividad actividad;

    public  ReservaActividad(LocalDate fechaInicio, LocalDate fechaFin, Actividad actividad)
    {
        super(fechaInicio, fechaFin);
        this.actividad = actividad;
    }

    public Actividad getActividad()
    {
        return actividad;
    }
}

