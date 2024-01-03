import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase Reserva
 */
public class Reserva implements java.io.Serializable
{
    protected ArrayList<Reserva> reservas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    /**
     * Constructor de la clase Reserva
     * @param fechaInicio
     * @param fechaFin
     */
    public Reserva(LocalDate fechaInicio, LocalDate fechaFin)
    {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        reservas = new ArrayList<Reserva>();
    }

    /**
     * @return id de la reserva
     */
    public String getId()
    {
        return "";
    }

    /**
     * @return numero de reservas
     */
    public int getReservas()
    {
        return reservas.size();
    }

    /**
     * @param inicio
     * @param fin
     * @return true si esta disponible
     */
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

    /**
     * añaade una reserva a un bungalo
     * @param reserva
     */
    public void addReserva(ReservaBungalo reserva)
    {
        reservas.add(reserva);
    }

    /**
     * @return fecha inicio
     */
    public LocalDate getFechaInicio()
    {
        return fechaInicio;
    }

    /**
     * @return fecha fin
     */
    public LocalDate getFechaFin()
    {
        return fechaFin;
    }

    /**
     * @param id
     * @return true si se ha eliminado correctamente
     */
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

    /**
     * @param act
     * @param fechaInicio
     * @param fechaFin
     */
    public void addActividad(Actividad act, LocalDate fechaInicio, LocalDate fechaFin)
    {

    }

    /**
     * @return instancia de la actividad
     */
    public Actividad getActividad()
    {
        return null;
    }

    /**
     * @return descripcion de la actividad
     */
    public String getDescripcion()
    {
        return "";
    }

    /**
     * resrva una actividad
     * @param id
     * @param act
     * @param fechaInicio
     * @param fechaFin
     * @return true si se ha reservado correctamente
     */
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

    /**
     * elimina una actividad de una reserva
     * @param id
     * @return true si se ha eliminado correctamente
     */
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

    /**
     * lista las reservas de un bungalo
     */
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

    /**
     * @param id
     * @return true si se ha mostrado correctamente
     */
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

    /**
     * devuelve true si se ha facturado correctamente
     * @param id
     * @return reserva
     */
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
