import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase Factura
 */
public class Factura implements java.io.Serializable
{
    private String id;
    private float costeTotal;
    private LocalDate fechaFacturacion;
    private Bungalo bungalo;
    private ArrayList<Reserva> actividades;
    private String reserva;

    /**
     * Constructor de la clase Factura
     * @param id
     * @param costeTotal
     * @param bungalo
     * @param actividades
     * @param reserva
     */
    public Factura(String id, float costeTotal, Bungalo bungalo, ArrayList<Reserva> actividades, String reserva)
    {
        this.id = id;
        this.costeTotal = costeTotal;
        this.fechaFacturacion = LocalDate.now();
        this.bungalo = bungalo;
        this.actividades = actividades;
    }

    /**
     * @return id de la factura
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return coste total
     */
    public float getCosteTotal()
    {
        return costeTotal;
    }

    /**
     * @return fecha de facturacion
     */
    public LocalDate getFechaFacturacion()
    {
        return fechaFacturacion;
    }

    /**
     * @return reserva
     */
    public String getReserva()
    {
        return reserva;
    }

    /**
     * @return bungalo reservado
     */
    public String getBungalo()
    {
        return bungalo.getId() + " - " + bungalo.getNombre();
    }

    /**
     * Muestra el listado de actividades reservadas
     */
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
