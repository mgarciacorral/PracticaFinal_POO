import  Utiles.MySerializer;

public class Main
{
    public static void main(String[] args)
    {

        Menu menu = MySerializer.deserialize("menu.dat");
        if (menu==null)
            menu = new Menu();

        menu.ejecutar();

        MySerializer.serialize(menu,"menu.dat");
    }
}