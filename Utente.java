package ceciliJava;

import java.util.*;

public class Utente {
	
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String password;
	private String telefono;
	
	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, String username, String email, String password, String telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
	}
	
	public void inserisciDati(Scanner tastiera) {
		
		System.out.print("$$$$$$$$ Inserisci il tuo nome => ");
		this.nome = tastiera.next();
		System.out.print("$$$$$$$$$ Inserisci il tuo cognome => ");
		this.nome = tastiera.next();
		System.out.print("$$$$$$$$$$ Inserisci il tuo username => ");
		this.nome = tastiera.next();
		System.out.print("$$$$$$$$$$$ Inserisci la tua email => ");
		this.nome = tastiera.next();
		System.out.print("$$$$$$$$$$$$ Inserisci la tua password => ");
		this.nome = tastiera.next();
		System.out.print("$$$$$$$$$$$$$ Inserisci il tuo numero di telefono => ");
		this.nome = tastiera.next();
		
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + "]";
	}
	
	

}
