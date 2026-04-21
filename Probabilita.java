package CPL;

public class Probabilita {
	
	static String tipoDiGioco(String nomeGioco) {
		
		String stringa = "";
		
		if(nomeGioco.equalsIgnoreCase("Slot")) {
			
			stringa =  "Benvenuto nella sezione delle Slot, la percentuale di vincita "
					+ "si aggira tra il 92% al 94% ma con vincite basse, "
					+ "infatti per legge le Slot devono restituire il 65% dei soldi giocati"
					+ "annualmente";
			
		}
		
		return stringa;
	}

}
