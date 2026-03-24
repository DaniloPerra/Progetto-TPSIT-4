package ProggettoInformaticaTpsit;
import java.util.*;

public class CPL_Gambling {

    private String nomeApp = "CPL Gambling";
    private String localitaServer; //dove è situato il server al quale si è connessi
    private double saldoCassa; //quantità di denaro nel conto dell'applicazione
    private double puntataMinima; //puntata minima consentita
    private double puntataMassima; //puntata massima consentita
    private List<String> giochiOfferti; //lista di grandezza indefinita
                                        //contenente i giochi offerti dal casinò

    public CPL_Gambling(){

    }

    public CPL_Gambling(String localitaServer,
                        double saldoCassa, double puntataMinima, double puntataMassima){
        this.localitaServer = localitaServer;
        this.saldoCassa = saldoCassa;
        this.puntataMinima = puntataMinima;
        this.puntataMassima = puntataMassima;
        this.giochiOfferti = new ArrayList<>();
    }

    public String getNomeApp() {
        return nomeApp;
    }

    public String getLocalitaServer() {
        return localitaServer;
    }

    public void setLocalitaServer(String localitaServer) {
        this.localitaServer = localitaServer;
    }

    public double getSaldoCassa() {
        return saldoCassa;
    }

    public void setSaldoCassa(double saldoCassa) {
        this.saldoCassa = saldoCassa;
    }

    public double getPuntataMinima() {
        return puntataMinima;
    }

    public void setPuntataMinima(double puntataMinima) {
        this.puntataMinima = puntataMinima;
    }

    public double getPuntataMassima() {
        return puntataMassima;
    }

    public void setPuntataMassima(double puntataMassima) {
        this.puntataMassima = puntataMassima;
    }

    public List<String> getGiochiOfferti() {
        return giochiOfferti;
    }

    public void setGiochiOfferti(List<String> giochiOfferti) {
        this.giochiOfferti = giochiOfferti;
    }

    public void inserisciDati(Scanner tastiera){
        System.out.println("Inserisci la località del server a cui si è connessi: ");
        this.localitaServer = tastiera.nextLine();
        tastiera.nextLine();
        System.out.println("Inserisci la quantità di denaro nella cassa dell'app: ");
        this.saldoCassa = tastiera.nextDouble();
        System.out.println("Inserisci la puntata minima consentita: ");
        this.puntataMinima = tastiera.nextDouble();
        System.out.println("Inserisci la puntata massima consentita: ");
        this.puntataMassima = tastiera.nextDouble();
        System.out.println("Quanti giochi contiene l'app? ");
        int n = tastiera.nextInt();
        System.out.println("Inserisci i giochi contenuti nell'app: ");
        for(int i=0; i<n; i++){
            String gioco = tastiera.nextLine();
            tastiera.nextLine();
            this.aggiungiGioco(gioco);
        }
    }

    public void aggiungiGioco(String gioco){
        this.giochiOfferti.add(gioco);
    }

    public void pagaVincita(double importo){    //l'utente incassa una vincita
        if (importo <= saldoCassa){
            this.saldoCassa = this.saldoCassa - importo;
            System.out.println("Vincita pagata: "+ importo);
        }else{
            System.out.println("Saldo del Casinò insufficiente! Impossibile pagare.");
        }
    }

    public void incassaPuntata(double importo){ //il casino incassa una puntata(perdita dell'utente)
        this.saldoCassa = this.saldoCassa + importo;
    }

    public String toString(){
        return  "Nome Casinò: "+this.nomeApp+
                "\nLocalità del server: "+this.localitaServer+
                "\nSaldo della cassa del Casinò: "+this.saldoCassa+
                "\nPuntata minima consentita: "+this.puntataMinima+
                "\nPuntata massima consentita: "+this.puntataMassima+
                "\nGiochi offerti: "+this.giochiOfferti.toString();
    }


}
