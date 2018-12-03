package tk.arktech;

import java.util.ArrayList;

public class Folder extends FileInterface {

    private ArrayList<FileInterface> itemList = new ArrayList<FileInterface>();

    public FileInterface getItem(String nazwa)
    {
        //TODO: Dodać implementację
        return null;
    }

    public void addItem(FileInterface item)
    {
        //TODO: Dodać implementację
    }

    public String ls()
    {
        //TODO: Dodać implementację
        //TODO: Sprawdzić czy na pewno taki typ ma być zwracany, wgl przemyśleć jak ma działać ls
        return null;
    }

    public void tree()
    {
        //TODO: Dodać implementację
        //TODO: Wgl dowidzieć się jak działa tree i co ma robić
    }

    public void removeItem(String nazwa)
    {
        //TODO: Dodać implementację
    }

}
