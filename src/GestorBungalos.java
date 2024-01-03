import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Clase GestorBungalos
 */
public class GestorBungalos implements java.io.Serializable
{
    private ArrayList<Bungalo> bungalos;
    private int contador = 0;
    static GestorBungalos instance;
    private GestorClientes gestClientes;
    private GestorActividades gestActividades;
    private int contReservas;

    /**
     * Constructor de la clase GestorBungalos
     */
    private GestorBungalos()
    {
        bungalos = new ArrayList<Bungalo>();
        gestClientes = GestorClientes.getInstance();
        gestActividades = GestorActividades.getInstance();
    }

    /**
     * @return instancia de GestorBungalos
     */
    public static GestorBungalos getInstance()
    {
        if (instance == null)
        {
            instance = new GestorBungalos();
        }
        return instance;
    }

    /**
     * Da de alta un bungalo
     */
    public void altaBungalo()
    {
        String id = "B" + contador;
        contador++;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el nombre del bungalo: ");
        String nombre = sc.nextLine();
        System.out.print("\nIntroduzca la capacidad del bungalo: ");
        int capacidad = sc.nextInt();
        System.out.print("\nIntroduzca el precio por dia del bungalo: ");
        float precio = sc.nextFloat();
        System.out.print("\nEl bungalo ha añadir es adaptado para minusvalidos? (s/n): ");
        String adaptado = sc.next();

        if(adaptado.equals("s"))
        {
            bungalos.add(new BungaloAdaptado(id, nombre, capacidad, precio));
        }
        else
        {
            bungalos.add(new Bungalo(id, nombre, capacidad, precio));
        }
    }

    /**
     * Da de baja un bungalo
     */
    public void bajaBungalo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id del bungalo a eliminar: ");
        String id = sc.nextLine();
        for (int i = 0; i < bungalos.size(); i++)
        {
            if (bungalos.get(i).getId().equals(id))
            {
                if(bungalos.get(i).getNumReservas() == 0)
                {
                    bungalos.remove(i);
                    System.out.println("Bungalo eliminado.");
                    return;
                }
                else
                {
                    System.out.println("El bungalo tiene reservas pendientes.");
                    return;
                }
            }
        }
        System.out.println("No se ha encontrado el bungalo.");
    }

    /**
     * Lista los bungalos adaptados
     */
    public void listarBungalosAdaptados()
    {
        System.out.println("Listado de bungalos adaptados: \n\nID\t\tCapacidad");
        for (int i = 0; i < bungalos.size(); i++)
        {
            if (bungalos.get(i) instanceof BungaloAdaptado)
            {
                System.out.println(bungalos.get(i).getId() + "\t\t" + bungalos.get(i).getCapacidad());
            }
        }


    }

    /**
     * Lista los bungalos no adaptados
     */
    public void listarBungalosNoAdaptados()
    {
        System.out.println("Listado de bungalos NO adaptados: \n\nID\t\tCapacidad");
        for (int i = 0; i < bungalos.size(); i++)
        {
            if (!(bungalos.get(i) instanceof BungaloAdaptado))
            {
                System.out.println(bungalos.get(i).getId() + "\t\t" + bungalos.get(i).getCapacidad());
            }
        }
    }

    /**
     * Muestra la informacion de un bungalo
     */
    public void mostrarBungalo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id del bungalo: ");
        String id = sc.nextLine();
        for (int i = 0; i < bungalos.size(); i++)
        {
            if (bungalos.get(i).getId().equals(id))
            {
                System.out.println("\nInformacion del bungalo:");
                System.out.println("-----------------------");
                System.out.println("ID: " + bungalos.get(i).getId());
                System.out.println("Nombre: " + bungalos.get(i).getNombre());
                System.out.println("Capacidad: " + bungalos.get(i).getCapacidad());
                System.out.println("Precio: " + bungalos.get(i).getPrecio());
                System.out.println("Numero de reservas: " + bungalos.get(i).getNumReservas());
                return;
            }
        }
        System.out.println("No se ha encontrado el bungalo.");
    }

    /**
     * Transforma un input a formato LocalDate
     * @return fecha
     */
    public static LocalDate crearFecha()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("en formato AAAA-MM-DD: ");
        String f= sc.nextLine();
        try{
            return LocalDate.parse(f);
        } catch (Exception e) {
            System.out.println("Fecha no válida");
            return crearFecha();
        }
    }

    /**
     * Reserva un bungalo adaptado
     * @param bungalo
     * @param fechaInicio
     * @param fechaFin
     * @param cliente
     * @param id
     */
    public void reservarAdaptado(Bungalo bungalo, LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, String id)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Desea añadir servicio de catering (s/n): ");
        String opc = sc.nextLine();

        Bungalo bungaloDecorado = bungalo;

        if(opc.equals("s"))
        {
            bungaloDecorado = new ServicioCatering(bungaloDecorado);
        }

        System.out.print("Desea añadir servicio de asistente (s/n): ");
        opc = sc.nextLine();

        if(opc.equals("s"))
        {
            bungaloDecorado = new ServicioAsistente(bungaloDecorado);
        }

        bungalo.addReserva(new ReservaBungalo(fechaInicio, fechaFin, bungaloDecorado, cliente, id));
        System.out.println("Reserva realizada.");
    }

    /**
     * Hace una reserva
     * @param cliente cliente que va a hacer la reserva
     */
    public void hacerReserva(Cliente cliente)
    {
        Scanner sc = new Scanner(System.in);
        String adaptado;
        System.out.print("El bungalo debe ser adaptado? (s/n): ");
        adaptado = sc.nextLine();

        System.out.print("Introduzca la fecha de inicio de la reserva ");
        LocalDate fechaInicio = crearFecha();

        System.out.print("Introduzca la fecha de fin de la reserva ");
        LocalDate fechaFin = crearFecha();

        System.out.print("Introduzca el numero de personas que se alojara en el bungalow: ");
        int numPersonas = sc.nextInt();

        System.out.println("Listado de bungalos disponibles ");
        System.out.println("--------------------------------");
        ArrayList<String> bungalosDisponibles = new ArrayList<String>();

        int cont = 0;
        for(int i = 0; i < bungalos.size(); i++)
        {
            if(adaptado.equals("s"))
            {
                if(bungalos.get(i) instanceof BungaloAdaptado && bungalos.get(i).getCapacidad() >= numPersonas && bungalos.get(i).comprobarDisponibilidad(fechaInicio, fechaFin))
                {
                    cont += 1;
                    bungalosDisponibles.add(bungalos.get(i).getId());
                    System.out.println(cont + " -. " + bungalos.get(i).getId());
                }
            }
            else
            {
                if((!(bungalos.get(i) instanceof BungaloAdaptado)) && bungalos.get(i).getCapacidad() >= numPersonas && bungalos.get(i).comprobarDisponibilidad(fechaInicio, fechaFin))
                {
                    cont += 1;
                    bungalosDisponibles.add(bungalos.get(i).getId());
                    System.out.println(cont + " -. " + bungalos.get(i).getId());
                }
            }
        }
        if(cont == 0)
        {
            System.out.println("No hay bungalos disponibles.");
            return;
        }

        System.out.print("Introduzca el id del bungalo que desea reservar: ");
        Scanner s = new Scanner(System.in);
        String idLeido;
        idLeido = s.nextLine();
        String id = new String(" ");

        for(int i = 0; i < bungalosDisponibles.size(); i++)
        {
            if(bungalosDisponibles.get(i).equals(idLeido))
            {
                id = idLeido;
            }
        }

        if(id.equals(" "))
        {
            System.out.println("El id del bungalo seleccionado es erroneo o no esta en la lista.");
            return;
        }

        for(int j = 0; j < bungalos.size(); j++)
        {
            if(bungalos.get(j).getId().equals(id))
            {
                String idReserva = "R" + contReservas;
                contReservas += 1;
                if(adaptado.equals("s"))
                {
                    reservarAdaptado(bungalos.get(j), fechaInicio, fechaFin, cliente, idReserva);
                }
                else
                {
                    bungalos.get(j).addReserva(new ReservaBungalo(fechaInicio, fechaFin, bungalos.get(j), cliente, idReserva));
                    System.out.println("Reserva realizada.");
                    return;
                }
            }
        }
    }

    /**
     * Reserva un bungalo a nombre de un cliente
     */
    public void reservar()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el identificador fiscal del cliente: ");
        String id = sc.nextLine();

        if(gestClientes.getCliente(id) == null)
        {
            System.out.println("El cliente que quiere reservar aun no esta registrado, introduzca sus datos a continuacion: ");
            gestClientes.addCliente();
        }

        hacerReserva(gestClientes.getCliente(id));
    }

    /**
     * Elimina una reserva
     */
    public void eliminarReserva()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id de la reserva a eliminar: ");
        String id = sc.nextLine();

        for (int i = 0; i < bungalos.size(); i++)
        {
            if(bungalos.get(i).eliminarReserva(id))
            {
                return;
            }
        }
        System.out.println("No se ha encontrado la reserva.");
    }

    /**
     * Añade una actividad a una reserva
     */
    public void reservarActividad()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id de la reserva a la que se añadira la actividad: ");
        String id = sc.nextLine();

        gestActividades.listarActividades();
        System.out.print("Introduzca el id de la actividad que desea añadir: ");
        String act = sc.nextLine();

        Actividad actividad = gestActividades.getActividad(act);

        System.out.print("Introduzca la fecha de inicio de la actividad ");
        LocalDate fechaInicioAct = crearFecha();
        System.out.print("Introduzca la fecha de fin de la actividad ");
        LocalDate fechaFinAct = crearFecha();

        for (int i = 0; i < bungalos.size(); i++)
        {
            if(bungalos.get(i).reservarActividad(id, actividad, fechaInicioAct, fechaFinAct))
            {
                return;
            }
            System.out.println("No se ha encontrado la reserva.");
        }
    }

    /**
     * Elimina una actividad de una reserva
     */
    public void eliminarReservaActividad()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id de la reserva de la que se eliminara la actividad: ");
        String id = sc.nextLine();

        for (int i = 0; i < bungalos.size(); i++)
        {
            if(bungalos.get(i).eliminarReservaActividad(id))
            {
                return;
            }
        }
    }

    /**
     * Lista las reservas de un bungalo
     */
    public void listarReservasBungalo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id del bungalo: ");
        String id = sc.nextLine();

        for (int i = 0; i < bungalos.size(); i++)
        {
            if(bungalos.get(i).getId().equals(id))
            {
                System.out.println("Listado de reservas del bungalo " + id + ":");
                System.out.println("-------------------------------------------");
                bungalos.get(i).listarReservas();
                return;
            }
        }
        System.out.println("No se ha encontrado el bungalo.");
    }

    /**
     * Muestra la informacion de una reserva
     */
    public void mostrarReserva()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id de la reserva: ");
        String id = sc.nextLine();

        for (int i = 0; i < bungalos.size(); i++)
        {
            if(bungalos.get(i).mostrarReserva(id))
            {
                return;
            }
        }
        System.out.println("No se ha encontrado la reserva.");
    }

    /**
     * Crea una factura de una reserva
     */
    public void facturar()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el id de la reserva: ");
        String id = sc.nextLine();

        for (int i = 0; i < bungalos.size(); i++)
        {
            if(bungalos.get(i).facturar(id))
            {
                return;
            }
        }
    }
}
