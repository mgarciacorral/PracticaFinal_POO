import java.time.LocalDateTime;

public class ReservaActividad extends  Reserva
{
    private Actividad actividad;

    public  ReservaActividad(LocalDateTime fechaInicio, LocalDateTime fechaFin, Actividad actividad)
    {
        super(fechaInicio, fechaFin);
        this.actividad = actividad;
    }
}
