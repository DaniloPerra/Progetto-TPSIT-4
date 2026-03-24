package ceciliJava;

import java.util.*;

public class MainUtente {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		
		Utente utente = new Utente();
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$	  Benvenuti nell'applicazione di giochi d'azzardo migliore al mondo  	    $$$$");
		System.out.println("$$$$$$  		Dove il gioco e' responsabile e sicuro			  $$$$$$");
		System.out.println("$$$$$$$$			Benvenuti in CPL Gambling			$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$			   Registrazione				$$$$$$$$");
		utente.inserisciDati(tastiera);
		System.out.print(utente.toString());

}
