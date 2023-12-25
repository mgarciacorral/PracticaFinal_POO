import java.util.ArrayList;
import java.util.Scanner;

public class GestorBungalos
{
    private ArrayList<Bungalo> bungalos;
    private static int contador = 0;

    public GestorBungalos()
    {
        bungalos = new ArrayList<Bungalo>();
    }

    public void altaBungalo()
    {
        String id = "B" + contador;

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
        System.out.print("Introduzca el id del bungalo a mostrar: ");
        String id = sc.nextLine();
        for (int i = 0; i < bungalos.size(); i++)
        {
            if (bungalos.get(i).getId().equals(id))
            {
                System.out.println("ID: " + bungalos.get(i).getId());
                System.out.println("Nombre: " + bungalos.get(i).getNombre());
                System.out.println("Capacidad: " + bungalos.get(i).getCapacidad());
                System.out.println("Precio por dia: " + bungalos.get(i).getPrecio());
                System.out.println("Numero de reservas: " + bungalos.get(i).getNumReservas());
                return;
            }
        }
        System.out.println("No se ha encontrado el bungalo.");
    }
}
