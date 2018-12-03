package tk.arktech;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Folder extends FileInterface {

    private HashMap<String, FileInterface> itemList = new HashMap<>();

    public FileInterface getItem(String nazwa)
    {
        return itemList.get(nazwa);

    }

    public void addItem(FileInterface item)
    {
        if(itemList.putIfAbsent(item.getName(), item) != null) {
            System.out.println("Plik o podanej nazwie już istnieje, czy zapisać w tym samym folderze? {Y/other]");

                if (System.console().readLine() == "Y") {
                    String s = "1";
                    int i = 2;
                    while (itemList.putIfAbsent(item.getName() + s, item) != null) {
                        s = Integer.toString(i);
                        i += 1;
                    }
                }

        }
    }

    public void ls()
    {
        itemList.forEach((k, v) ->
            System.out.println(k) );
    }

    public void ls(String prompt)
    {
        itemList.forEach((k, v) ->
                System.out.println(prompt+k) );
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
