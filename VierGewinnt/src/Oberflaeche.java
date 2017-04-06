import java.util.Scanner;

public class Oberflaeche {

	private Spielsteuerung dieSpielsteuerung;
	private Scanner sc;

	public Oberflaeche(Spielsteuerung steuerung) {
		dieSpielsteuerung = steuerung;
		sc = new Scanner(System.in);

	}

	public void zeigeFeld() {
		int[][] feld = dieSpielsteuerung.getSpielfeld();
		for (int i = 0; i < feld[0].length; i++) {
			for (int j = 0; j < feld.length; j++) {
				System.out.print("[ " + dieSpielsteuerung.getSpielerFigur(feld[j][i]) + " ] ");
			}
			System.out.println();
		}
		for (int i = 0; i < feld.length; i++) {
			System.out.print("  " + (i + 1) + "   ");
		}
		System.out.println();
	}

	public void warteAufEingabe() {
		System.out.println("Spieler am Zug: " + dieSpielsteuerung.getAktuellerSpielerName());
		int spalte = 0;
		do {
			System.out.print("Spalte: ");
			spalte = sc.nextInt();
		} while (!dieSpielsteuerung.werfeStein(spalte - 1));
	}

	public String namensEingabe(int spielerNummer) {
		System.out.println("Spieler " + spielerNummer + ", bitte Namen eingeben: ");
		return sc.nextLine();
	}

	public boolean nochmalSpielen() {
		System.out.print("Nochmal spielen? (j/n) ");
		String jn;
		do {
			jn = sc.nextLine();
		} while(!jn.toLowerCase().contentEquals("j") && !jn.toLowerCase().equals("n"));
		
		if(jn.toLowerCase().equals("j")) {
			return true;
		} else {
			System.out.println("Bis bald!");
			return false;
		}		
	}

}
