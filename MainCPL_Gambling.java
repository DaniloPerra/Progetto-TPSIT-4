package ProggettoInformaticaTpsit;
import java.util.*;

public class MainCPL_Gambling {
    public static void main(String args[]) {

        Scanner tastiera = new Scanner(System.in);

        System.out.println("Quanti sedi ha il CPL Gambling?");
        int n = tastiera.nextInt();

        CPL_Gambling cplMomentaneo = new CPL_Gambling();
        CPL_Gambling[] arrayCPL = new CPL_Gambling[n];

        for (int i = 0; i < n; i++) {
            cplMomentaneo.inserisciDati(tastiera);
            arrayCPL[i] = cplMomentaneo;
        }

        for (int j = 0; j < n; j++) {
            System.out.println(arrayCPL[j].toString());
        }

        System.out.println("Prima di giocare teniamo ad informarti" +
                            " riguardo le probabilita' di vincita': " +
                            "\n===TRIS: 0,14%==="+
                            "\n===COPPIA: 29,63%==="+
                            "\n===TUTTI DIVERSI: 69,14%===");


    }
}
