public class ServicioCatering extends ServicioEspecialDecorator
{

    public ServicioCatering(Bungalo bungalo)
    {
        super(bungalo);
    }

    public float getPrecio()
    {
        return super.getPrecio() + 50;
    }
}
