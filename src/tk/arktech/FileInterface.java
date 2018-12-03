package tk.arktech;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class FileInterface{
    protected String name;
    protected HashMap<Folder, String> whereami = new HashMap<>();

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

    protected void addLocation(Folder f, String name)
    {
        whereami.put(f, name);
    }

    protected void removeLocation(Folder f)
    {
        whereami.remove(f);
    }

}
