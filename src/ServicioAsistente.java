/**
 * Clase que representa el servicio de asistente
 */
public class ServicioAsistente extends ServicioEspecialDecorator
{

    /**
     * Constructor de la clase ServicioAsistente
     * @param bungalo
     */
    public ServicioAsistente(Bungalo bungalo)
    {
        super(bungalo);
    }

    /**
     * @return precio del servicio
     */
    public float getPrecio()
    {
        return (super.getPrecio() + 15);
    }
}