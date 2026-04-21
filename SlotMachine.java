package CPL;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    
    private static final String[] SIMBOLI = {"🍒", "🍋", "🍊", "🔔", "💎"};
    private static final int[] VALORI = {10, 20, 50, 100, 500};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("--- Benvenuto alla CPL Slot! ---");
        
        while (true) {
            System.out.print("\nPremi INVIO per giocare (o scrivi 'esci'): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("esci")) break;

            String[][] griglia = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    griglia[i][j] = SIMBOLI[random.nextInt(SIMBOLI.length)];
                }
            }

            System.out.println("\n  |  ROLL  |");
            System.out.println("------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("  | ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(griglia[i][j] + " ");
                }

                if (i == 1) System.out.print("| <---");
                else System.out.print("|");
                System.out.println();
            }
            System.out.println("------------");

            controllaVincita(griglia[1]);
        }
        
        System.out.println("Grazie per aver giocato!");
        scanner.close();
    }

    private static void controllaVincita(String[] rigaCentrale) {
        if (rigaCentrale[0].equals(rigaCentrale[1]) && rigaCentrale[1].equals(rigaCentrale[2])) {
            String simboloVincente = rigaCentrale[0];
            int premio = 0;

            for (int i = 0; i < SIMBOLI.length; i++) {
                if (SIMBOLI[i].equals(simboloVincente)) {
                    premio = VALORI[i];
                    break;
                }
            }
            System.out.println("JACKPOT! Hai vinto " + premio + " gettoni con tre " + simboloVincente + "!");
        } else {
            System.out.println("Nessuna vincita, riprova!");
        }
    }
}