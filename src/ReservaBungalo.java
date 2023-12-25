import java.util.ArrayList;
import java.time.LocalDateTime;

public class ReservaBungalo extends  Reserva
{
    private Bungalo bungalo;
    private Cliente cliente;
    private ArrayList<Actividad> actividades;
    private String id;

    public  ReservaBungalo(LocalDateTime fechaInicio, LocalDateTime fechaFin, Bungalo bungalo, Cliente cliente, String id)
    {
        super(fechaInicio, fechaFin);
        this.bungalo = bungalo;
        this.cliente = cliente;
        this.id = id;
    }
}
