public class ServicioEspecialDecorator extends BungaloAdaptado
{
    private BungaloAdaptado bungalo;

    public ServicioEspecialDecorator(BungaloAdaptado bungalo)
    {
        super(" ", " ", 0, 0);
        this.bungalo = bungalo;
    }
}
