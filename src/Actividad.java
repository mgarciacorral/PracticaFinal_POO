public class Actividad
{
    private String descripcion;
    private float precioDiaPersona;
    private  int numPersonas;

    public Actividad(String id, String descripcion, float precioDiaPersona, int numPersonas)
    {
        this.descripcion = descripcion;
        this.precioDiaPersona = precioDiaPersona;
        this.numPersonas = numPersonas;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public float getPrecioDiaPersona()
    {
        return this.precioDiaPersona;
    }

    public int getNumPersonas()
    {
        return this.numPersonas;
    }

}
