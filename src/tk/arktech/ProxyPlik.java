package tk.arktech;

public class ProxyPlik extends FileInterface implements IPlik{
    private IPlik plik;

    public ProxyPlik(IPlik plik) {
        //TODO: Zweryfikować implementację
        this.plik = plik;
    }

    public void rename(String name)
    {
        //TODO: Dodać implementację
    }

    public String getContent() {
        //TODO: Dodać implementację
        return plik.getContent();
    }

    public void setContent(String content) {
        //TODO: Dodać implementację
        plik.setContent(content);
    }



}
