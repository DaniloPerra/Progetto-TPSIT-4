package ProggettoInformaticaTpsit;
import java.util.*;

public class CPL_Gambling {
    private final String NOME_APP = "CPL Gambling";
    private double saldoCassa = 10000;
    private double puntataMinima = 1;
    private double puntataMassima = 50;
    private List<String> giochiOfferti;

    private static final int MAX_PARTITE = 10;  // limite massimo di partite
    public static int partiteGiocate = 0;                 // contatore partite giocate

    public CPL_Gambling(){
        this.giochiOfferti = new ArrayList<>();
        this.partiteGiocate = 0;
    }

    public String getNome(){
        return this.NOME_APP;
    }

    public double getSaldoCassa() {
        return this.saldoCassa;
    }

    public double getPuntataMinima() {
        return this.puntataMinima;
    }

    public double getPuntataMassima() {
        return this.puntataMassima;
    }

    // Restituisce true se si può ancora giocare, false se il limite è raggiunto
    public boolean puoiGiocare() {
        return partiteGiocate < MAX_PARTITE;
    }

    // Da chiamare all'inizio di ogni partita — restituisce false se il limite è raggiunto
    public boolean iniziaPartita() {
        if (!puoiGiocare()) {
            System.out.println("Limite di " + MAX_PARTITE + " partite raggiunto! Non puoi più giocare.");
            return false;
        }
        partiteGiocate++;
        System.out.println("Partita " + partiteGiocate + "/" + MAX_PARTITE + " iniziata.");
        return true;
    }

    public int getPartiteGiocate() {
        return partiteGiocate;
    }

    public int getPartiteRimanenti() {
        return MAX_PARTITE - partiteGiocate;
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
        return  "Nome Casinò: " + this.NOME_APP +
                "\nSaldo della cassa del Casinò: " + this.saldoCassa +
                "\nPuntata minima consentita: " + this.puntataMinima +
                "\nPuntata massima consentita: " + this.puntataMassima +
                "\nGiochi offerti: " + this.giochiOfferti.toString() +
                "\nPartite giocate: " + this.partiteGiocate + "/" + MAX_PARTITE +
                "\nPartite rimanenti: " + this.getPartiteRimanenti();
    }
}