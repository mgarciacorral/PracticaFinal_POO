import java.util.ArrayList;
import java.time.LocalDate;

public class Reserva implements java.io.Serializable
{
    protected ArrayList<Reserva> reservas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin)
    {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        reservas = new ArrayList<Reserva>();
    }

    public String getId()
    {
        return "";
    }

    public int getReservas()
    {
        return reservas.size();
    }

    public boolean comprobarDisponibilidad(LocalDate inicio, LocalDate fin)
    {
        for (int i = 0; i < reservas.size(); i++)
        {
            if (!(reservas.get(i).fechaInicio.isAfter(fin) || reservas.get(i).fechaFin.isBefore(inicio)))
            {
                return false;
            }
        }
        return true;
    }

    public void addReserva(ReservaBungalo reserva)
    {
        reservas.add(reserva);
    }

    public LocalDate getFechaInicio()
    {
        return fechaInicio;
    }

    public LocalDate getFechaFin()
    {
        return fechaFin;
    }

    public boolean eliminarReserva(String id)
    {
        for (int i = 0; i < reservas.size(); i++)
        {
            if (reservas.get(i).getId().equals(id))
            {
                if(fechaInicio.isAfter(LocalDate.now()))
                {
                    System.out.println("No se puede eliminar una reserva que ya ha pasado.");
                    return true;
                }
                else
                {
                    reservas.remove(i);
                    System.out.println("Reserva eliminada.");
                    return true;
                }
            }
        }
        return false;
    }

    public void addActividad(Actividad act, LocalDate fechaInicio, LocalDate fechaFin)
    {

    }

    public Actividad getActividad()
    {
        return null;
    }

    public String getDescripcion()
    {
        return "";
    }

    public boolean reservarActividad(String id, Actividad act, LocalDate fechaInicio, LocalDate fechaFin)
    {
        for (int i = 0; i < reservas.size(); i++)
        {
            if (reservas.get(i).getId().equals(id))
            {
                reservas.get(i).addActividad(act, fechaInicio, fechaFin);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarActividad(String id)
    {
           for(int i = 0; i < reservas.size(); i++)
           {
                if(reservas.get(i).getId().equals(id))
                {
                     return reservas.get(i).eliminarActividad(id);
                }
           }
           System.out.println("No se ha encontrado la reserva.");
           return false;
    }

    public void listarReservas()
    {
        System.out.println("Listado de reservas:");
        System.out.println("--------------------");
        System.out.println("ID \t\tFecha inicio \tFecha fin");
        for(int i = 0; i < reservas.size(); i++)
        {
            System.out.println(reservas.get(i).getId() + "\t\t" + reservas.get(i).getFechaInicio() + "\t\t" + reservas.get(i).getFechaFin());
        }
    }

    public boolean mostrarReserva(String id)
    {
        for(int i = 0; i < reservas.size(); i++)
        {
            if(reservas.get(i).getId().equals(id))
            {
                reservas.get(i).mostrarReserva(id);
                return true;
            }
        }
        System.out.println("No se ha encontrado la reserva.");
        return false;
    }

    public boolean facturar(String id)
    {
        for(int i = 0; i < reservas.size(); i++)
        {
            if(reservas.get(i).getId().equals(id))
            {
                reservas.get(i).facturar(id);
                return true;
            }
        }
        System.out.println("No se ha encontrado la reserva.");
        return false;
    }
}
