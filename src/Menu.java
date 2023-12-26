import java.util.Scanner;

public class Menu implements java.io.Serializable
{
    private GestorGeneralSingleton gestor;

    public Menu()
    {
        gestor = GestorGeneralSingleton.getInstance();
    }

    public void ejecutar()
    {
        int opc = -1;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\tMenu Principal Del Gestor Del Resort");
            System.out.println("\t------------------------------------\n");
            System.out.print("1.-Gestion de Bungalos\n2.-Gestion de Clientes\n3.-Gestion de Actividades\n4.-Gestion de Reservas\n5.-Gestion de Facturacion\n6.-Salvar datos\n0.-Salir\n\nElige una opcion: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 0:
                    System.out.println("Gracias por elegir esta aplicacion.");
                    break;
                case 1:
                    gestor.menuBungalos();
                    break;
                case 2:
                    gestor.menuClientes();
                    break;
                case 3:
                    gestor.menuActividades();
                    break;
                default:
                    System.out.println("Opcion no valida, pruebe de nuevo.");
                    break;
            }
        }while(opc != 0);
    }
}
