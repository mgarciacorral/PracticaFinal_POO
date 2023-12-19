import java.util.ArrayList;
import java.util.Date;

public class Reserva
{
    private ArrayList<Reserva> reservas;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(Date fechaInicio, Date fechaFin)
    {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
