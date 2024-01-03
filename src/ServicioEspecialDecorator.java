/**
 * Clase que representa un servicio especial
 */
public class ServicioEspecialDecorator extends Bungalo
{
    private Bungalo bungalo;

    /**
     * Constructor de la clase ServicioEspecialDecorator
     * @param bungalo
     */
    public ServicioEspecialDecorator(Bungalo bungalo)
    {
        super(bungalo.getId(), bungalo.getNombre(), bungalo.getCapacidad(), bungalo.getPrecio());
        this.bungalo = bungalo;
    }

    /**
     * @return precio del servicio
     */
    public float getPrecio()
    {
        return bungalo.getPrecio();
    }
}
