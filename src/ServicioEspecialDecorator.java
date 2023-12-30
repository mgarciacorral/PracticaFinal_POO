public class ServicioEspecialDecorator extends Bungalo
{
    private Bungalo bungalo;

    public ServicioEspecialDecorator(Bungalo bungalo)
    {
        super(bungalo.getId(), bungalo.getNombre(), bungalo.getCapacidad(), bungalo.getPrecio());
        this.bungalo = bungalo;
    }
}
