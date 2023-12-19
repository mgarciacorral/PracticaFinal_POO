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
}
