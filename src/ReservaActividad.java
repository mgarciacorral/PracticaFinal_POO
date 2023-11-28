import java.time.LocalDate;

public class ReservaActividad
{
    private Actividad actividad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ReservaActividad(Actividad actividad, LocalDate fechaInicio, LocalDate fechaFin)
    {
        this.actividad = actividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio()
    {
        return this.fechaInicio;
    }

    public LocalDate getFechaFin()
    {
        return this.fechaFin;
    }
}
