package ProggettoInformaticaTpsit;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

    private static final String[] SIMBOLI = {"🍒", "🍋", "🍊", "🔔", "💎"};
    private static final int[] VALORI = {10, 20, 50, 100, 500};

    private String nome;
    private int righe;
    private int colonne;
    private String[][] griglia;
    private Random random;

    public SlotMachine() {
        this.nome = "CPL Slot";
        this.righe = 3;
        this.colonne = 3;
        this.griglia = new String[righe][colonne];
        this.random = new Random();
    }

    public SlotMachine(String nome, int righe, int colonne) {
        this.nome = nome;
        this.righe = righe;
        this.colonne = colonne;
        this.griglia = new String[righe][colonne];
        this.random = new Random();
    }


    public String getNome() { return nome; }
    public int getRighe() { return righe; }
    public int getColonne() { return colonne; }
    public String[][] getGriglia() { return griglia; }


    public void gira() {
        for (int i = 0; i < righe; i++)
            for (int j = 0; j < colonne; j++)
                griglia[i][j] = SIMBOLI[random.nextInt(SIMBOLI.length)];
    }

    public void stampaGriglia() {
        System.out.println("\n  |  ROLL  |");
        System.out.println("------------");
        for (int i = 0; i < righe; i++) {
            System.out.print("  | ");
            for (int j = 0; j < colonne; j++)
                System.out.print(griglia[i][j] + " ");

            // La riga vincente è quella centrale
            if (i == righe / 2) System.out.print("| <---");
            else                System.out.print("|");
            System.out.println();
        }
        System.out.println("------------");
    }

    public int controllaVincita() {
        String[] rigaCentrale = griglia[righe / 2];
        String primo = rigaCentrale[0];

        for (String simbolo : rigaCentrale)
            if (!simbolo.equals(primo)) return 0; // nessuna vincita

        for (int i = 0; i < SIMBOLI.length; i++)
            if (SIMBOLI[i].equals(primo)) return VALORI[i];

        return 0;
    }

    public void avvia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Benvenuto alla " + nome + "! ---");

        while (true) {
            System.out.print("\nPremi INVIO per giocare (o scrivi 'esci'): ");
            if (scanner.nextLine().equalsIgnoreCase("esci")) break;
            CPL_Gambling.partiteGiocate ++;
            if(CPL_Gambling.partiteGiocate == 10){
                break;
            }
            gira();
            stampaGriglia();

            int premio = controllaVincita();
            if (premio > 0)
                System.out.println("JACKPOT! Hai vinto " + premio + " gettoni con tre " + griglia[righe/2][0] + "!");
            else
                System.out.println("Nessuna vincita, riprova!");
        }

        System.out.println("Grazie per aver giocato!");
        scanner.close();
    }

    public String toString() {
        return "SlotMachine{nome='" + nome + "', righe=" + righe + ", colonne=" + colonne + "}";
    }

    public static void main(String[] args) {
        SlotMachine slot = new SlotMachine();
        slot.avvia();
    }
}