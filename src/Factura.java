import java.time.LocalDate;

public class Factura implements java.io.Serializable
{
    private String id;
    private String costeTotal;
    private LocalDate fechaFacturacion;

    public Factura(String id, String costeTotal, LocalDate fechaFacturacion)
    {
        this.id = id;
        this.costeTotal = costeTotal;
        this.fechaFacturacion = fechaFacturacion;
    }
}
