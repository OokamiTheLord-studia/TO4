package tk.arktech;

public abstract class FileInterface {
    protected String name;

    @Override
    public String toString() {
        return name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
           this.name = name;
    }

}
