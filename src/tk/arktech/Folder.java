package tk.arktech;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Folder extends FileInterface {

    protected HashMap<String, FileInterface> itemList = new HashMap<>();

    public FileInterface getItem(String nazwa)
    {
        return itemList.get(nazwa);

    }

    public void addItem(FileInterface item)
    {

        if(!itemList.containsValue(item)) {
            if (itemList.putIfAbsent(item.getName(), item) != null) {
                System.out.println("Plik o podanej nazwie już istnieje, czy zapisać w tym samym folderze? {Y/other]");

                if (System.console().readLine().equals("Y")) {
                    String s = "1";
                    int i = 2;
                    while (itemList.putIfAbsent(item.getName() + s, item) != null) {
                        s = Integer.toString(i++);
                    }
                    item.addLocation(this,item.getName() + s);

                }


            }
            else
            {
                item.addLocation(this,
                        item.getName());
            }
        }
        else
        {
            System.out.println("Podany plik już istnieje w tym folderze");

        }

    }

    public Folder addItem(Folder item)
    {

        if(!itemList.containsValue(item)) {
            if (itemList.putIfAbsent(item.getName(), item) != null) {
                System.out.println("Plik o podanej nazwie już istnieje, czy zapisać w tym samym folderze? {Y/other]");

                if (System.console().readLine().equals("Y")) {
                    String s = "1";
                    int i = 2;
                    while (itemList.putIfAbsent(item.getName() + s, item) != null) {
                        s = Integer.toString(i++);
                    }
                    item.addLocation(this,item.getName() + s);

                }


            }
            else
            {
                item.addLocation(this, item.getName());
            }
        }
        else
        {
            System.out.println("Podany plik już istnieje w tym folderze");

        }
        return item;
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
        itemList.forEach((k,v) -> {
            if(v instanceof Folder)
            {
                System.out.println("["+k+"]");
                ((Folder) v).tree(">");
            }
            else
            {
                System.out.println(k);
            }
                }
        );
    }

    public void tree(String prompt)
    {
        itemList.forEach((k,v) -> {
                    if(v instanceof Folder)
                    {
                        System.out.println(prompt+"["+k+"]");
                        ((Folder) v).tree(prompt+">");
                    }
                    else
                    {
                        System.out.println(prompt+k);
                    }
                }
        );
    }

    public void removeItem(String nazwa)
    {
        itemList.remove(nazwa).removeLocation(this);
    }

    public Folder(String nazwa) {
        super.name = nazwa;
    }

    public void renameFile(String oldname, String newname)
    {
        if(itemList.containsKey(newname))
        {
           System.out.println("Podana nazwa jest zajęta");
        }
        else
        {
            if(itemList.containsKey(oldname))
            {
                FileInterface item = itemList.remove( oldname );
                itemList.put( newname, item );
                item.removeLocation(this);
                item.addLocation(this, newname);
            }
            else
            {
                System.out.println("Plik o podanej nazwie nie istnieje");
            }
        }
    }

    public void rename(String newname)
    {
        super.name = newname;
    }

    public void renameInAll(String newname)
    {
        boolean flag = true;
        for (Folder aWhereami : whereami.keySet()) {
            if (aWhereami.itemList.containsKey(newname)) {
                flag = false;
            }
        }
        if(flag)
        {
            for(Folder fWhereami : whereami.keySet())
            {

                fWhereami.itemList.remove(whereami.get(fWhereami));
                fWhereami.itemList.put(newname, this);
            }
            whereami.replaceAll((k, v) -> newname);
            super.name = newname;
        }
        else
        {
            System.out.println("Nie można zmienić wszystkich nazw");
        }
    }

    public void renameWhereAble(String newname)
    {
        int i = 0;
        for(Folder fWhereami : whereami.keySet())
        {
            if(!fWhereami.itemList.containsKey(newname))
            {
                fWhereami.itemList.remove(whereami.get(fWhereami));
                fWhereami.itemList.put(newname, this);
                whereami.replace(fWhereami, newname);
                i++;
            }
        }
        super.name = newname;
        System.out.println("Zmieniono nazwę w " + Integer.toString(i) + " folderach");
    }

}
