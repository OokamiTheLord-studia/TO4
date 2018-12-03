package other.pack;

import tk.arktech.*;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Folder root = new Folder("root");
        root.addItem(new ProxyPlik(new Plik("plik1")));
        root.addItem(new Folder("level1")).addItem(new Folder("level2"));
        ((Folder) root.getItem("level1")).addItem(new ProxyPlik(new Plik("plik2")));
        ((Folder)((Folder) root.getItem("level1")).getItem("level2")).addItem(new Plik("plik3"));

        root.tree();

    }
}
