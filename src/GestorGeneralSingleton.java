import java.util.Scanner;

public class GestorGeneralSingleton implements java.io.Serializable
{
    static GestorGeneralSingleton instance = null;
    private GestorClientes gestClientes;
    private GestorBungalos gestBungalos;
    private GestorActividades gestActividades;

    private GestorGeneralSingleton()
    {
        gestClientes = GestorClientes.getInstance();
        gestBungalos = GestorBungalos.getInstance();
        gestActividades = GestorActividades.getInstance();
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

    public void menuClientes()
    {
        int opc = -1;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\tMenu De Gestion De Clientes");
            System.out.println("\t---------------------------\n");
            System.out.print("1.-Añadir cliente\n2.-Listar clientes\n3.-Mostrar informacion de un cliente\n0.-Volver al menu principal\n\nElige una opcion: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                    gestClientes.addCliente();
                    break;
                case 2:
                    gestClientes.listarClientes();
                    break;
                case 3:
                    gestClientes.mostrarCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida, pruebe de nuevo.");
                    break;
            }
        }while(opc != 0);
    }

    public void menuActividades()
    {
        int opc = -1;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\tMenu De Gestion De Actividades");
            System.out.println("\t------------------------------\n");
            System.out.print("1.-Añadir actividad\n2.-Listar actividades\n3.-Mostrar informacion de una actividad\n0.-Volver al menu principal\n\nElige una opcion: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                    gestActividades.addActividad();
                    break;
                case 2:
                    gestActividades.listarActividades();
                    break;
                case 3:
                    gestActividades.mostrarActividad();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida, pruebe de nuevo.");
                    break;
            }
        }while(opc != 0);
    }

    public void menuReservas()
    {
        int opc = -1;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\tMenu De Gestion De Reservas");
            System.out.println("\t---------------------------\n");
            System.out.print("1.-Hacer reserva\n2.-Eliminar reserva\n3.-Añadir actividad a reserva\n4.-Eliminar actividad de reserva\n5.-Listar reservas de un bungalo\n6.-Mostrar reserva concreta\n0.-Volver al menu principal\n\nElige una opcion: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                    gestBungalos.reservar();
                    break;
                case 2:
                    gestBungalos.eliminarReserva();
                    break;
                case 3:
                    gestBungalos.reservarActividad();
                    break;
                case 4:
                    gestBungalos.eliminarReservaActividad();
                    break;
                case 5:
                    gestBungalos.listarReservasBungalo();
                    break;
                case 6:
                    gestBungalos.mostrarReserva();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida, pruebe de nuevo.");
                    break;
            }
        }while(opc != 0);
    }

    public void menuFacturacion()
    {
        int opc = -1;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\tMenu De Gestion De Facturacion");
            System.out.println("\t------------------------------\n");
            System.out.print("1.-Generar factura\n2.-Listar facturas de cliente\n3.-Mostrar informacion de una factura\n0.-Volver al menu principal\n\nElige una opcion: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                    gestBungalos.facturar();
                    break;
                case 2:
                    gestClientes.listarFacturasCliente();
                    break;
                case 3:
                    gestClientes.mostrarFacturaCliente();
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
