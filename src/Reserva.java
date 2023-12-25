import java.util.ArrayList;
import java.time.LocalDateTime;

public class Reserva
{
    private ArrayList<Reserva> reservas;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Reserva(LocalDateTime fechaInicio, LocalDateTime fechaFin)
    {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getReservas()
    {
        return reservas.size();
    }
}
