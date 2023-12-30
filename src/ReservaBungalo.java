import java.util.ArrayList;
import java.time.LocalDate;

public class ReservaBungalo extends  Reserva
{
    private Bungalo bungalo;
    private Cliente cliente;
    private ArrayList<Actividad> actividades;
    private String id;

    public  ReservaBungalo(LocalDate fechaInicio, LocalDate fechaFin, Bungalo bungalo, Cliente cliente, String id)
    {
        super(fechaInicio, fechaFin);
        this.bungalo = bungalo;
        this.cliente = cliente;
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public Bungalo getBungalo()
    {
        return bungalo;
    }

    public Cliente getCliente()
    {
        return cliente;
    }
}
