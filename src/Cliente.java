import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase Cliente
 */
public class Cliente implements java.io.Serializable
{
    private String identificador;
    private String nombre;
    private String telefono;
    private ArrayList<Factura> facturas;
    private int contFacturas = 0;

    /**
     * Constructor de la clase Cliente
     * @param id
     * @param nombre
     * @param telefono
     */
    public Cliente(String id, String nombre, String telefono)
    {
        this.identificador = id;
        this.nombre = nombre;
        this.telefono = telefono;
        facturas = new ArrayList<Factura>();
    }

    /**
     * @return identificador del cliente
     */
    public String getId()
    {
        return identificador;
    }

    /**
     * @return nombre del cliente
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return telefono del cliente
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * Añade una factura
     * @param costeTotal
     * @param bungalo
     * @param actividades
     * @param reserva
     */
    public void addFactura(float costeTotal, Bungalo bungalo, ArrayList<Reserva> actividades, String reserva)
    {
        String id = "" + contFacturas;
        while (id.length() < 8)
        {
            id = "0" + id;
        }
        facturas.add(new Factura(id, costeTotal, bungalo, actividades, reserva));
        contFacturas++;
    }

    /**
     * Factura una reserva
     * @param bungalo
     * @param actividades
     * @param id
     * @param FechaFin
     * @param FechaInicio
     */
    public void facturar(Bungalo bungalo, ArrayList<Reserva> actividades, String id, LocalDate FechaFin, LocalDate FechaInicio)
    {
        for(int i = 0;i < facturas.size(); i++)
        {
            if(facturas.get(i).getReserva().equals(id))
            {
                System.out.println("La reserva ya ha sido facturada");
                return;
            }
        }

        if(FechaFin.isBefore(LocalDate.now()) || FechaFin.isEqual(LocalDate.now()))
        {
            float costeTotal = bungalo.getPrecio() * FechaInicio.until(FechaFin).getDays();
            for(int i = 0; i < actividades.size(); i++)
            {
                costeTotal += actividades.get(i).getActividad().getPrecio();
            }

            addFactura(costeTotal, bungalo, actividades, id);
            System.out.println("Factura creada correctamente");
        }
        else
        {
            System.out.println("La reserva no ha finalizado");
        }
    }

    /**
     * Muestra el listado de facturas
     */
    public void listarFacturas()
    {
        System.out.println("Listado de facturas:");
        System.out.println("--------------------");
        System.out.println("Id \t\tCliente  \t\tFecha");

        for(int i = 0; i < facturas.size(); i++)
        {
            System.out.println(facturas.get(i).getId() + "\t\t" + identificador + "\t\t" + facturas.get(i).getFechaFacturacion());
        }
    }

    /**
     * Muestra la informacion de una factura
     */
    public void mostrarFactura()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el identificador de la factura: ");
        String id = sc.nextLine();
        for(int i = 0; i < facturas.size(); i++)
        {
            if(facturas.get(i).getId().equals(id))
            {
                System.out.println("Informacion de la factura:");
                System.out.println("-------------------------");
                System.out.println("ID: " + facturas.get(i).getId());
                System.out.println("Coste total: " + facturas.get(i).getCosteTotal());
                System.out.println("Fecha de facturacion: " + facturas.get(i).getFechaFacturacion());
                System.out.println("Bungalo: " + facturas.get(i).getBungalo());
                facturas.get(i).listarActividades();
                return;
            }
        }
        System.out.println("No se ha encontrado la factura.");
    }
}
