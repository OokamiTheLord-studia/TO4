package tk.arktech;

public class Plik extends FileInterface implements IPlik {
    //TODO: Zastanowić się jakiego typu
    private String content;

    public String getContent() {
        //TODO: Dodać implementację
        return content;
    }

    public void setContent(String content) {
        //TODO: Dodać implementację
        this.content = content;
    }

    public Plik(String content) {
        //TODO: Dodać implementację
        this.content = content;
    }

    public Plik() {
        //TODO: Dodać implementację
        this.content = "";
    }
}
