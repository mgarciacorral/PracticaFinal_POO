import  Utiles.MySerializer;

/**
 * Clase Main
 */
public class Main
{
    /**
     * Metodo main
     * @param args
     */
    public static void main(String[] args)
    {

        GestorGeneralSingleton gestor = MySerializer.deserialize("gestor.dat");
        if (gestor == null)
            gestor = GestorGeneralSingleton.getInstance();

        Menu menu = new Menu(gestor);

        menu.ejecutar();
    }
}