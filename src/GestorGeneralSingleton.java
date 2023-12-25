import java.util.Scanner;

public class GestorGeneralSingleton
{
    static GestorGeneralSingleton instance = null;
    private GestorClientes gestClientes;
    private GestorBungalos gestBungalos;
    private GestorActividades gestActividades;

    private GestorGeneralSingleton()
    {
        gestClientes = new GestorClientes();
        gestBungalos = new GestorBungalos();
        gestActividades = new GestorActividades();
    }

    public static GestorGeneralSingleton getInstance()
    {
        if (instance == null)
        {
            instance = new GestorGeneralSingleton();
        }
        return instance;
    }

    public void menuBungalos()
    {
        int opc = -1;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\tMenu De Gestion De Bungalos");
            System.out.println("\t---------------------------\n");
            System.out.print("1.-Dar de alta un bungalo\n2.-Dar de baja un bungalo\n3.-Listar bungalos adaptados\n4.-Listar bungalos no adaptados\n5.-Mostrar informacion bungalo\n0.-Volver al menu principal\n\nElige una opcion: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                    gestBungalos.altaBungalo();
                    break;
                case 2:
                    gestBungalos.bajaBungalo();
                    break;
                case 3:
                    gestBungalos.listarBungalosAdaptados();
                    break;
                case 4:
                    gestBungalos.listarBungalosNoAdaptados();
                    break;
                case 5:
                    gestBungalos.mostrarBungalo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida, pruebe de nuevo.");
                    break;
            }
        }while(opc != 0);
    }
}
