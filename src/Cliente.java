import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Cliente implements java.io.Serializable
{
    private String identificador;
    private String nombre;
    private String telefono;
    private ArrayList<Factura> facturas;
    private int contFacturas = 0;

    public Cliente(String id, String nombre, String telefono)
    {
        this.identificador = id;
        this.nombre = nombre;
        this.telefono = telefono;
        facturas = new ArrayList<Factura>();
    }

    public String getId()
    {
        return identificador;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void addFactura(float costeTotal, Bungalo bungalo, ArrayList<Reserva> actividades, String reserva)
    {
        facturas.add(new Factura("F" + contFacturas, costeTotal, bungalo, actividades, reserva));
        contFacturas++;
    }

    public void facturar(Bungalo bungalo, ArrayList<Reserva> actividades, String id, LocalDate FechaFin)
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
            float costeTotal = bungalo.getPrecio();
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

    public void listarFacturas()
    {
        System.out.println("Listado de facturas:");
        System.out.println("--------------------");
        System.out.println("Id \t\tCliente  \t\tFecha");
        System.out.println("---\t\t-------  \t\t-----");

        for(int i = 0; i < facturas.size(); i++)
        {
            System.out.println(facturas.get(i).getId() + "\t\t" + identificador + "\t\t" + facturas.get(i).getFechaFacturacion());
        }
    }

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
                System.out.println("Bungalo: " + facturas.get(i).getBungalo().getNombre());
                facturas.get(i).listarActividades();
                return;
            }
        }
        System.out.println("No se ha encontrado la factura.");
    }
}
