/**
 * Clase que representa el servicio de catering
 */
public class ServicioCatering extends ServicioEspecialDecorator
{

    /**
     * Constructor de la clase ServicioCatering
     * @param bungalo
     */
    public ServicioCatering(Bungalo bungalo)
    {
        super(bungalo);
    }

    /**
     * @return precio del servicio
     */
    public float getPrecio()
    {
        return super.getPrecio() + 50;
    }
}
