import java.util.Date;

public class ReservaActividad extends  Reserva
{
    private Actividad actividad;

    public  ReservaActividad(Date fechaInicio, Date fechaFin, Actividad actividad)
    {
        super(fechaInicio, fechaFin);
        this.actividad = actividad;
    }
}
