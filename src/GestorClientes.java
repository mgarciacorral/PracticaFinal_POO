import java.util.ArrayList;
import  java.util.Scanner;

public class GestorClientes implements java.io.Serializable
{
    private ArrayList<Cliente> clientes;

    public GestorClientes()
    {
        clientes = new ArrayList<Cliente>();
    }

    public  void addCliente()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el identificador fiscal del cliente: ");
        String id = sc.nextLine();
        for(int i = 0; i < clientes.size(); i++)
        {
            if(clientes.get(i).getId().equals(id))
            {
                System.out.println("El cliente ya existe.");
                return;
            }
        }

        System.out.print("\nIntroduzca el nombre y apellidos del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("\nIntroduzca el telefono del cliente: ");
        String telefono = sc.nextLine();

        clientes.add(new Cliente(id, nombre, telefono));
    }

    public void  listarClientes()
    {
        System.out.println("Listado de clientes:");
        System.out.println("--------------------");
        System.out.println("ID\t\tNombre");
        System.out.println("--\t\t------");

        for(int i = 0; i < clientes.size(); i++)
        {
            System.out.println(clientes.get(i).getId() + "\t\t" + clientes.get(i).getNombre());
        }
    }

    public void  mostrarCliente()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el identificador fiscal del cliente: ");
        String id = sc.nextLine();
        for(int i = 0; i < clientes.size(); i++)
        {
            if(clientes.get(i).getId().equals(id))
            {
                System.out.println("Informacion del cliente:");
                System.out.println("-----------------------");
                System.out.println("ID: " + clientes.get(i).getId());
                System.out.println("Nombre: " + clientes.get(i).getNombre());
                System.out.println("Telefono: " + clientes.get(i).getTelefono());
                return;
            }
        }
        System.out.println("No se ha encontrado el cliente.");
    }
}
