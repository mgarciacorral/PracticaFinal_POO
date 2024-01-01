import java.time.LocalDate;
import java.util.ArrayList;

public class Factura implements java.io.Serializable
{
    private String id;
    private float costeTotal;
    private LocalDate fechaFacturacion;
    private Bungalo bungalo;
    private ArrayList<Reserva> actividades;
    private String reserva;

    public Factura(String id, float costeTotal, Bungalo bungalo, ArrayList<Reserva> actividades, String reserva)
    {
        this.id = id;
        this.costeTotal = costeTotal;
        this.fechaFacturacion = LocalDate.now();
    }

    public String getId()
    {
        return id;
    }

    public float getCosteTotal()
    {
        return costeTotal;
    }

    public LocalDate getFechaFacturacion()
    {
        return fechaFacturacion;
    }

    public String getReserva()
    {
        return reserva;
    }

    public Bungalo getBungalo()
    {
        return bungalo;
    }

    public void listarActividades()
    {
        System.out.println("Listado de actividades reservadas:");
        System.out.println("ID \t\tDescripcion");
        System.out.println("---\t\t-----------");

        for(int i = 0; i < actividades.size(); i++)
        {
            System.out.println(actividades.get(i).getActividad().getId() + "\t\t" + actividades.get(i).getActividad().getDescripcion());
        }
    }
}
