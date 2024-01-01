public class ServicioAsistente extends ServicioEspecialDecorator
{

    public ServicioAsistente(Bungalo bungalo)
    {
        super(bungalo);
    }

    public float getPrecio()
    {
        return super.getPrecio() + 100;
    }
}
