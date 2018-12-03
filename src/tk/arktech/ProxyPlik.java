package tk.arktech;

import java.io.File;

public class ProxyPlik extends FileInterface{
    private Plik plik;

    public ProxyPlik(Plik plik) {
        this.plik = plik;
        super.name = plik.getName();
    }

    public void rename(String name)
    {
        this.name = name;
        this.plik.setName(name);
    }

//    public void rename(String name, )


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
//                System.out.println("test");
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

    public Object getContent() {
        return plik.getContent();
    }

    public void setContent(Object content) {
        plik.setContent(content);
    }

//    protected void addLocation(Folder f, String name)
//    {
//        plik.whereami.put(f, name);
//    }
//
//    protected void removeLocation(Folder f)
//    {
//        plik.whereami.remove(f);
//    }



}
