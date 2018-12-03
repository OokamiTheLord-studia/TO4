package tk.arktech;

import java.util.ArrayList;

public class Plik extends FileInterface{
    private Object content;


    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Plik(String name, Object content) {
        this.content = content;
        super.name = name;
    }

    public Plik(String name) {
        super.name = name;
        this.content = null;
    }


}
