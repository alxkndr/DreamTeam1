import java.util.Scanner;
public class Main {
    private Giocatore[] squadra;
    private int numGiocatori;

    public Main(int maxGiocatori) {
        squadra = new Giocatore[maxGiocatori];
        numGiocatori = 0;
    }

    // Metodo per aggiungere un giocatore alla squadra
    public void aggiungiGiocatore(Giocatore giocatore) {
        if (numGiocatori < squadra.length) {
            if (hasCapitano() && giocatore.isCapitano()) {
                System.out.println("La squadra già ha un capitano!");
                return;
            }
            squadra[numGiocatori] = giocatore;
            numGiocatori++;
        } else {
            System.out.println("La squadra è piena!");
        }
    }

    // Metodo per visualizzare tutti i giocatori della squadra
    public void visualizzaSquadra() {
        for (int i = 0; i < numGiocatori; i++) {
            Giocatore giocatore = squadra[i];
            System.out.println("Nome: " + giocatore.getNome() + ", Capitano: " + giocatore.isCapitano() + ", Goal: " + giocatore.getGoal());
        }
    }

    // Metodo per modificare i dati di un giocatore a scelta
    public void modificaGiocatore(int index, String nome, boolean capitano, int goal) {
        if (index >= 0 && index < numGiocatori) {
            Giocatore giocatore = squadra[index];
            giocatore.setNome(nome);
            giocatore.setCapitano(capitano);
            giocatore.setGoal(goal);
        } else {
            System.out.println("Indice non valido!");
        }
    }

    // Metodo per cancellare un giocatore dalla squadra
    public void cancellaGiocatore(int index) {
        if (index >= 0 && index < numGiocatori) {
            for (int i = index; i < numGiocatori - 1; i++) {
                squadra[i] = squadra[i + 1];
            }
            numGiocatori--;
        } else {
            System.out.println("Indice non valido!");
        }
    }

    // Metodo per visualizzare i giocatori che hanno realizzato più di 5 goal
    public void visualizzaGiocatoriGoal() {
        for (int i = 0; i < numGiocatori; i++) {
            Giocatore giocatore = squadra[i];
            if (giocatore.getGoal() > 5) {
                System.out.println("Nome: " + giocatore.getNome() + ", Goal: " + giocatore.getGoal());
            }
        }
    }

    // Metodo per visualizzare il nome del capitano
    public void visualizzaCapitano() {
        for (int i = 0; i < numGiocatori; i++) {
            Giocatore giocatore = squadra[i];
            if (giocatore.isCapitano()) {
                System.out.println("Capitano: " + giocatore.getNome());
                return;
            }
        }
        System.out.println("Non c'è un capitano nella squadra!");
    }

    // Metodo per assegnare il ruolo di capitano in modo casuale
    public void assegnaCapitanoCasuale() {
        if (!hasCapitano()) {
            int index = (int) (Math.random() * numGiocatori);
            Giocatore giocatore = squadra[index];
            giocatore.setCapitano(true);
        }
    }

    // Metodo per controllare se c'è un capitano nella squadra
    private boolean hasCapitano() {
        for (int i = 0; i < numGiocatori; i++) {
            Giocatore giocatore = squadra[i];
            if (giocatore.isCapitano()) {
                return true;
            }
        }
        return false;
    }

    // Metodo main
    public static void main(String[] args) {
        Main squadra = new Main(10);

        Scanner in = new Scanner(System.in);

        Giocatore giocatore1 = new Giocatore("Ronaldo", true, 900);
        Giocatore giocatore2 = new Giocatore();
        Giocatore giocatore3 = new Giocatore("Neymar", true, 100);

        int count = 0;
        boolean input = false;

        String nome = "";
        boolean capitano = false;
        int goal = 0;

        String newnome = "";
        boolean newcapitano = false;
        int newgoal = 0;

        do {

            System.out.println("1- Aggiungere un giocatore alla squadra, controllando che non ci sia più di un capitano");
            System.out.println("2- Visualizzare tutti i giocatori della squadra");
            System.out.println("3- Modificare i dati di un giocatore a scelta");
            System.out.println("4- Cancellare un giocatore dalla squadra ");
            System.out.println("5- Visualizzare i giocatori che hanno realizzato più di 5 goal.");
            System.out.println("6- Visualizzare il nome del capitano");
            System.out.println("7- Assegnare il ruolo di capitano in modo casuale se non ancora presente");
            System.out.println("0- Esci dal campo");

            int scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    squadra.aggiungiGiocatore(giocatore1);
                    break;
                case 2:
                    squadra.visualizzaSquadra();
                    break;
                case 3:
                    System.out.println("Inserisci il nome del giocatore che vuoi modificare: ");
                    nome = in.next();
                    System.out.println("Inserisci (true/false se capitano o meno) del giocatore che vuoi modificare: ");
                    capitano = in.nextBoolean();
                    System.out.println("Inserisci i goal del giocatore che vuoi modificare: ");
                    goal = in.nextInt();
                    squadra.modificaGiocatore(count, nome, capitano, goal);
                    break;
            }
        } while (!input);
    }
}