import java.util.Date;

public class Factura
{
    private String id;
    private String costeTotal;
    private Date fechaFacturacion;

    public Factura(String id, String costeTotal, Date fechaFacturacion)
    {
        this.id = id;
        this.costeTotal = costeTotal;
        this.fechaFacturacion = fechaFacturacion;
    }
}
