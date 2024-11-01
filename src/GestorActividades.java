import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase GestorActividades
 */
public class GestorActividades implements java.io.Serializable
{
    private ArrayList<Actividad> actividades;
    private int contador = 0;
    static GestorActividades instance;

    /**
     * Constructor de la clase GestorActividades
     */
    private GestorActividades()
    {
        actividades = new ArrayList<Actividad>();
    }

    /**
     * @param id de la actividad
     * @return instancia de la actividad
     */
    public Actividad getActividad(String id)
    {
        for(int i = 0; i < actividades.size(); i++)
        {
            if(actividades.get(i).getId().equals(id))
            {
                return actividades.get(i);
            }
        }
        return null;
    }

    /**
     * @return instancia de GestorActividades
     */
    public static GestorActividades getInstance()
    {
        if (instance == null)
        {
            instance = new GestorActividades();
        }
        return instance;
    }

    /**
     * Añade una actividad
     */
    public void addActividad()
    {
        String id = "A" + contador;
        contador++;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la descripción de la actividad: ");
        String descripcion = sc.nextLine();
        System.out.print("\nIntroduzca el precio de la actividad: ");
        float precio = sc.nextFloat();
        actividades.add(new Actividad(id, descripcion, precio));
    }

    /**
     * Lista las actividades
     */
    public void listarActividades()
    {
        System.out.println("Listado de actividades:");
        System.out.println("----------------------");
        System.out.println("ID \t\tDescripcion");

        for(int i = 0; i < actividades.size(); i++)
        {
            System.out.println(actividades.get(i).getId() + "\t\t" + actividades.get(i).getDescripcion());
        }
    }

    /**
     * Muestra la informacion de una actividad
     */
    public void mostrarActividad()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el identificador de la actividad: ");
        String id = sc.nextLine();
        for(int i = 0; i < actividades.size(); i++)
        {
            if(actividades.get(i).getId().equals(id))
            {
                System.out.println("Informacion de la actividad:");
                System.out.println("---------------------------");
                System.out.println("ID: " + actividades.get(i).getId());
                System.out.println("Descripcion: " + actividades.get(i).getDescripcion());
                System.out.println("Precio: " + actividades.get(i).getPrecio());
                return;
            }
        }
        System.out.println("La actividad no existe.");
    }
}
