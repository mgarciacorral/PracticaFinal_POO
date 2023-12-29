public class ServicioEspecialDecorator extends ReservaBungalo
{
    private ReservaBungalo reserva;

    public ServicioEspecialDecorator(ReservaBungalo reserva)
    {
        super(reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getBungalo(), reserva.getCliente(), reserva.getId());
        this.reserva = reserva;
    }
}
