public abstract class Gestionable
{
    private String Id;

    public Gestionable(String id)
    {
        this.Id = id;
    }

    public String getId()
    {
        return this.Id;
    }

    public void setId(String id)
    {
        this.Id = id;
    }
}
