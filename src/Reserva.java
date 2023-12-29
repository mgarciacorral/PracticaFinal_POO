import java.util.ArrayList;
import java.time.LocalDateTime;

public class Reserva implements java.io.Serializable
{
    private ArrayList<Reserva> reservas;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Reserva(LocalDateTime fechaInicio, LocalDateTime fechaFin)
    {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        reservas = new ArrayList<Reserva>();
    }

    public int getReservas()
    {
        return reservas.size();
    }

    public boolean comprobarDisponibilidad(LocalDateTime fechaInicio, LocalDateTime fechaFin)
    {
        for (int i = 0; i < reservas.size(); i++)
        {
            if (reservas.get(i).fechaInicio.isAfter(fechaInicio) && reservas.get(i).fechaFin.isBefore(fechaFin))
            {
                return false;
            }
        }
        return true;
    }

    public void addReserva(LocalDateTime fechaInicio, LocalDateTime fechaFin)
    {
        reservas.add(new Reserva(fechaInicio, fechaFin));
    }

    public LocalDateTime getFechaInicio()
    {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin()
    {
        return fechaFin;
    }


}
