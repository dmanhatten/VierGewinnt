
public class Spielsteuerung {

	private Spielfeld dasSpielfeld;
	private Spieler[] derSpieler;
	private Oberflaeche dieOberflaeche;
	private int aktuellerSpieler;

	public Spielsteuerung() {
		aktuellerSpieler = 1;
		dasSpielfeld = new Spielfeld();
		derSpieler = new Spieler[2];
		derSpieler[0] = new Spieler('X', 1);
		derSpieler[1] = new Spieler('O', -1);
		dieOberflaeche = new Oberflaeche(this);
		derSpieler[0].setName(dieOberflaeche.namensEingabe(1));
		derSpieler[1].setName(dieOberflaeche.namensEingabe(2));

	}

	public void spielen() {
		while (true) {
			if (aktuellerSpieler == 0) {
				aktuellerSpieler = 1;
			} else {
				aktuellerSpieler = 0;
			}
			dieOberflaeche.zeigeFeld();
			dieOberflaeche.warteAufEingabe();
			if (pruefeGewonnen()) {
				derSpieler[aktuellerSpieler].rundeGewonnen();
				System.out.println("Spieler " + getAktuellerSpielerName() + " hat gewonnen!");
				System.out.println("Du hast " + derSpieler[aktuellerSpieler].getRundenGewonne() + " Runde(n) gewonnen!");
				break;
			}
			if (dasSpielfeld.pruefeVoll()) {
				System.out.println("Unentschieden!");
				break;
			}
			
		}
		dieOberflaeche.zeigeFeld();
		if (dieOberflaeche.nochmalSpielen()) {
			dasSpielfeld.initialisiere();
			spielen();
		}
	}

	private boolean pruefeGewonnen() {
		int[][] feld = dasSpielfeld.getFeld();
		int wert = derSpieler[aktuellerSpieler].getWert();
		for (int s = 0; s < feld.length; s++) {
			for (int r = 0; r < feld[s].length; r++) {
				if (feld[s][r] == wert) {
					if (pruefeReihen(wert, s, r) || pruefeSpalten(wert, s, r) || pruefeQuer(wert, s, r)) {
						return true;
					}

				}

			}
		}
		return false;
	}

	private boolean pruefeReihen(int wert, int s, int r) {
		int[][] feld = dasSpielfeld.getFeld();
		int count = 0;
		for (int i = s; i < feld.length; i++) {
			if (feld[i][r] == wert) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}

		return false;
	}

	private boolean pruefeQuer(int wert, int s, int r) {
		int[][] feld = dasSpielfeld.getFeld();
		int count = 0;
		for (int i = s, j = r; i < feld.length && j < feld[i].length; i++, j++) {
			if (feld[i][j] == wert) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}
		count = 0;
		for (int i = s, j = r; i >= 0 && j >= 0; i--, j--) {
			if (feld[i][j] == wert) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}
		count = 0;
		for (int i = s, j = r; i < feld.length && j >= 0; i++, j--) {
			if (feld[i][j] == wert) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}
		count = 0;
		for (int i = s, j = r; i >= 0 && j < feld[i].length; i--, j++) {
			if (feld[i][j] == wert) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}

		return false;
	}

	private boolean pruefeSpalten(int wert, int s, int r) {
		int[][] feld = dasSpielfeld.getFeld();
		int count = 0;
		for (int i = r; i < feld[s].length; i++) {
			if (feld[s][i] == wert) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}

		return false;
	}

	public String getAktuellerSpielerName() {
		return derSpieler[aktuellerSpieler].getName();
	}

	public char getSpielerFigur(int wert) {
		for (int i = 0; i < derSpieler.length; i++) {
			if (derSpieler[i].getWert() == wert) {
				return derSpieler[i].getFigur();
			}
		}

		return ' ';
	}

	public boolean werfeStein(int spalte) {
		return dasSpielfeld.werfeStein(spalte, derSpieler[aktuellerSpieler].getWert());
	}

	public int[][] getSpielfeld() {
		return dasSpielfeld.getFeld();
	}

}
