package ProggettoInformaticaTpsit;
import java.util.*;

public class MainCPL_Gambling {
    public static void main(String args[]) {

        Scanner tastiera = new Scanner(System.in);
        System.out.println("===BENVENUTO IN -CPL GAMBLING- ===");
        System.out.println("===  PER ORA ABBIAMO UN SOLO   ===");
        System.out.println("=== GIOCO DISPONIBILE, SCUSATE ===");
        System.out.println("===       PER IL DISAGIO       ===");

        SlotMachine slot = new SlotMachine();

        CPL_Gambling cpl = new CPL_Gambling();

        cpl.aggiungiGioco(slot.getNome());

        while(cpl.iniziaPartita() == true) {
            System.out.println("Prima di giocare teniamo ad informarti" +
                    " riguardo le probabilita' di vincita': " +
                    "\n===TRIS: 0,14%==="+
                    "\n===COPPIA: 29,63%==="+
                    "\n===TUTTI DIVERSI: 69,14%===");

            slot.avvia();
        }
    }
}
