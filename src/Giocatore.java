public class Giocatore {
    private String nome;
    private boolean capitano;
    private int goal;

    // Costruttore senza parametri
    public Giocatore() {
        this.nome = "";
        this.capitano = false;
        this.goal = 0;
    }

    // Costruttore con parametri
    public Giocatore(String nome, boolean capitano, int goal) {
        this.nome = nome;
        this.capitano = capitano;
        this.goal = goal;
    }

    // Metodi get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCapitano() {
        return capitano;
    }

    public void setCapitano(boolean capitano) {
        this.capitano = capitano;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}