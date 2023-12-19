import java.util.ArrayList;
import java.util.Date;

public class ReservaBungalo extends  Reserva
{
    private Bungalo bungalo;
    private Cliente cliente;
    private ArrayList<Actividad> actividades;
    private String id;

    public  ReservaBungalo(Date fechaInicio, Date fechaFin, Bungalo bungalo, Cliente cliente, String id)
    {
        super(fechaInicio, fechaFin);
        this.bungalo = bungalo;
        this.cliente = cliente;
        this.id = id;
    }
}
