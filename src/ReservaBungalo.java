import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class ReservaBungalo extends Reserva
{
    private Bungalo bungalo;
    private Cliente cliente;
    private String id;

    public  ReservaBungalo(LocalDate fechaInicio, LocalDate fechaFin, Bungalo bungalo, Cliente cliente, String id)
    {
        super(fechaInicio, fechaFin);
        this.bungalo = bungalo;
        this.cliente = cliente;
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public Bungalo getBungalo()
    {
        return bungalo;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void addActividad(Actividad act, LocalDate fechaInicioAct, LocalDate fechaFinAct)
    {
        if(fechaInicioAct.isAfter(getFechaInicio()) && fechaFinAct.isBefore(getFechaFin()))
        {
            reservas.add(new ReservaActividad(fechaInicioAct, fechaFinAct, act));
            System.out.println("Actividad reservada correctamente");
        }
        else
        {
            System.out.println("Las fechas de la actividad no están dentro de las fechas de la reserva del bungalo");
        }
    }

    public void listarActividadesReserva()
    {
        System.out.println("Listado de actividades reservadas:");
        System.out.println("----------------------------------");
        System.out.println("ID \t\tDescripcion");
        System.out.println("---\t\t-----------");

        for(int i = 0; i < reservas.size(); i++)
        {
            System.out.println(reservas.get(i).getActividad().getId() + "\t\t" + reservas.get(i).getActividad().getDescripcion());
        }
    }


    public boolean eliminarActividad(String id)
    {
        Scanner sc = new Scanner(System.in);
        listarActividadesReserva();
        System.out.print("\nIntroduzca el identificador de la actividad a eliminar: ");
        id = sc.nextLine();

        for (int i = 0; i < reservas.size(); i++)
        {
            if (reservas.get(i).getActividad().getId().equals(id))
            {
                if(reservas.get(i).getFechaInicio().isAfter(LocalDate.now()))
                {
                    reservas.remove(i);
                    System.out.println("Actividad eliminada.");
                    return true;
                }
                else
                {
                    System.out.println("No se puede eliminar una actividad que ya ha pasado.");
                    return true;
                }
            }
        }
        System.out.println("No se ha encontrado la actividad.");
        return false;
    }

    public boolean mostrarReserva(String id)
    {
        System.out.println("Informacion de la reserva:");
        System.out.println("--------------------------");
        System.out.println("ID: " + id);
        System.out.println("Fecha inicio: " + getFechaInicio());
        System.out.println("Fecha fin: " + getFechaFin());
        System.out.println("Bungalo: " + bungalo.getNombre());
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Actividades reservadas: " + getReservas());

        return true;
    }
}
