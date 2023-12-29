import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class GestorBungalos implements java.io.Serializable
{
    private ArrayList<Bungalo> bungalos;
    private int contador = 0;

    public GestorBungalos()
    {
        bungalos = new ArrayList<Bungalo>();
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

    public void reservarAdaptado(Bungalo bungalo, LocalDateTime fechaInicio, LocalDateTime fechaFin)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tiene disponibles los siguientes servicios especiales:\n1- Catering\n2- Asistente personal");
        System.out.print("Introduzca el numero del servicio que desea, 0 si no desea ninguno o 3 si desea ambos servicios: ");
        int opcion = sc.nextInt();

        switch (opcion)
        {
            case 0:
                bungalo.addReserva(fechaInicio, fechaFin);
                System.out.println("Reserva realizada.");
                break;
            case 1:
                bungalo.addReserva(fechaInicio, fechaFin);
                System.out.println("Reserva realizada.");
                break;
            case 2:
                bungalo.addReserva(fechaInicio, fechaFin);
                System.out.println("Reserva realizada.");
                break;
            case 3:
                bungalo.addReserva(fechaInicio, fechaFin);
                System.out.println("Reserva realizada.");
                break;
            default:
                System.out.println("Opcion invalida.");
                break;
        }
    }

    public void hacerReserva()
    {
        Scanner sc = new Scanner(System.in);
        String adaptado;
        System.out.println("El bungalo debe ser adaptado? (s/n): ");
        adaptado = sc.nextLine();

        System.out.println("Introduzca la fecha de inicio de la reserva: ");
        System.out.print("Dia: ");
        int diaInicio = sc.nextInt();
        System.out.print("Mes: ");
        int mesInicio = sc.nextInt();
        System.out.print("Año: ");
        int anioInicio = sc.nextInt();

        System.out.println("Introduzca la fecha de fin de la reserva: ");
        System.out.print("Dia: ");
        int diaFin = sc.nextInt();
        System.out.print("Mes: ");
        int mesFin = sc.nextInt();
        System.out.print("Año: ");
        int anioFin = sc.nextInt();

        LocalDateTime fechaInicio = LocalDateTime.of(anioInicio, mesInicio, diaInicio, 0, 0);
        LocalDateTime fechaFin = LocalDateTime.of(anioFin, mesFin, diaFin, 0, 0);

        System.out.print("Introduzca el numero de personas que se alojara en el bungalow: ");
        int numPersonas = sc.nextInt();

        System.out.println("Listado de bungalos disponibles ");
        System.out.println("--------------------------------");
        ArrayList<String> bungalosDisponibles = new ArrayList<String>();

        if(adaptado.equals("s"))
        {
            for(int i = 0; i < bungalos.size(); i++)
            {
                int cont = 0;
                if(bungalos.get(i) instanceof BungaloAdaptado)
                {
                    if(bungalos.get(i).getCapacidad() >= numPersonas)
                    {
                        if(bungalos.get(i).comprobarDisponibilidad(fechaInicio, fechaFin))
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
            }
        }
        else
        {
            for(int i = 0; i < bungalos.size(); i++)
            {
                int cont = 0;
                if(!(bungalos.get(i) instanceof BungaloAdaptado))
                {
                    if(bungalos.get(i).getCapacidad() >= numPersonas)
                    {
                        if(bungalos.get(i).comprobarDisponibilidad(fechaInicio, fechaFin))
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
            }
        }

        System.out.print("Introduzca el id del bungalo que desea reservar: ");
        String id = sc.nextLine();
        for(int i = 0; i < bungalosDisponibles.size(); i++)
        {
            if(bungalosDisponibles.get(i).equals(id))
            {
                for(int j = 0; j < bungalos.size(); j++)
                {
                    if(bungalos.get(j).getId().equals(id))
                    {
                        if(adaptado.equals("s"))
                        {
                            reservarAdaptado(bungalos.get(j), fechaInicio, fechaFin);
                        }
                        else
                        {
                            bungalos.get(j).addReserva(fechaInicio, fechaFin);
                            System.out.println("Reserva realizada.");
                            return;
                        }
                    }
                }
            }
        }
    }
}
