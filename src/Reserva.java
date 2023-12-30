import java.util.ArrayList;
import java.time.LocalDate;

public class Reserva implements java.io.Serializable
{
    private ArrayList<Reserva> reservas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin)
    {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        reservas = new ArrayList<Reserva>();
    }

    public int getReservas()
    {
        return reservas.size();
    }

    public boolean comprobarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin)
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

    public void addReserva(ReservaBungalo reserva)
    {
        reservas.add(reserva);
    }

    public LocalDate getFechaInicio()
    {
        return fechaInicio;
    }

    public LocalDate getFechaFin()
    {
        return fechaFin;
    }
}
