public class Cliente extends Gestionable
{
    private String nombre;
    private String apellidos;
    private String telefono;

    public Cliente(String Id, String nombre, String apellidos, String telefono)
    {
        super(Id);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellidos()
    {
        return this.apellidos;
    }

    public String getTelefono()
    {
        return this.telefono;
    }
}
