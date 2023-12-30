import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class GestorBungalos implements java.io.Serializable
{
    private ArrayList<Bungalo> bungalos;
    private int contador = 0;
    static GestorBungalos instance;
    private GestorClientes gestClientes;
    private int contReservas;

    private GestorBungalos()
    {
        bungalos = new ArrayList<Bungalo>();
        gestClientes = GestorClientes.getInstance();
    }

    public static GestorBungalos getInstance()
    {
        if (instance == null)
        {
            instance = new GestorBungalos();
        }
        return instance;
    }

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

    public LocalDate crearFecha()
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

    public void reservarAdaptado(Bungalo bungalo, LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, String id)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Desea añadir servicio de catering (s/n): ");
        String opc = sc.nextLine();

        if(opc.equals("s"))
        {
            bungalo = new ServicioCatering(bungalo);
        }

        System.out.print("Desea añadir servicio de asistente (s/n): ");
        opc = sc.nextLine();

        if(opc.equals("s"))
        {
            bungalo = new ServicioAsistente(bungalo);
        }

        bungalo.addReserva(new ReservaBungalo(fechaInicio, fechaFin, bungalo, cliente, id));
        System.out.println("Reserva realizada.");
    }

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
                if(!(bungalos.get(i) instanceof BungaloAdaptado) && bungalos.get(i).getCapacidad() >= numPersonas && bungalos.get(i).comprobarDisponibilidad(fechaInicio, fechaFin))
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
}
