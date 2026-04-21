package ProggettoInformaticaTpsit;
import java.util.*;

public class CPL_Gambling {

    private String nomeApp = "CPL Gambling";
    private String localitaServer;
    private double saldoCassa;
    private double puntataMinima;
    private double puntataMassima;
    private List<String> giochiOfferti;

    public CPL_Gambling(){
        this.giochiOfferti = new ArrayList<>();
    }

    public CPL_Gambling(String localitaServer,
                        double saldoCassa, double puntataMinima, double puntataMassima){
        this.localitaServer = localitaServer;
        this.saldoCassa = saldoCassa;
        this.puntataMinima = puntataMinima;
        this.puntataMassima = puntataMassima;
        this.giochiOfferti = new ArrayList<>();
    }



    public void inserisciDati(Scanner tastiera){
        System.out.println("Inserisci la località del server a cui si è connessi: ");
        this.localitaServer = tastiera.nextLine();
        System.out.println("Inserisci la quantità di denaro nella cassa dell'app: ");
        this.saldoCassa = tastiera.nextDouble();
        System.out.println("Inserisci la puntata minima consentita: ");
        this.puntataMinima = tastiera.nextDouble();
        System.out.println("Inserisci la puntata massima consentita: ");
        this.puntataMassima = tastiera.nextDouble();
        System.out.println("Quanti giochi contiene l'app? ");
        int n = tastiera.nextInt();
        tastiera.nextLine();
        System.out.println("Inserisci i giochi contenuti nell'app: ");
        for(int i = 0; i < n; i++){
            String gioco = tastiera.nextLine();
            this.aggiungiGioco(gioco);
        }
    }

    public void aggiungiGioco(String gioco){
        this.giochiOfferti.add(gioco);
    }

    public void pagaVincita(double importo){
        if (importo <= saldoCassa){
            this.saldoCassa = this.saldoCassa - importo;
            System.out.println("Vincita pagata: " + importo);
        } else {
            System.out.println("Saldo del Casinò insufficiente! Impossibile pagare.");
        }
    }

    public void incassaPuntata(double importo){
        this.saldoCassa = this.saldoCassa + importo;
    }

    public String toString(){
        return  "Nome Casinò: " + this.nomeApp +
                "\nLocalità del server: " + this.localitaServer +
                "\nSaldo della cassa del Casinò: " + this.saldoCassa +
                "\nPuntata minima consentita: " + this.puntataMinima +
                "\nPuntata massima consentita: " + this.puntataMassima +
                "\nGiochi offerti: " + this.giochiOfferti.toString();
    }
}