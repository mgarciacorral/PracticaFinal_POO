import java.time.LocalDate;
import java.util.ArrayList;
public class ReservaBungalo extends Gestionable
{
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private ArrayList<ReservaActividad> actividades;

    public ReservaBungalo(String Id)
    {
        super(Id);
        fechaEntrada = null;
        fechaSalida = null;
        actividades = new ArrayList<ReservaActividad>();
    }
}
