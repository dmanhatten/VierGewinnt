

public class Spieler {
	private int wert;
	private String name;
	private char figur;
	private int rundenGewonnen;
	
	public Spieler(char figur, int wert) {
		this.figur = figur;
		this.wert = wert;
		rundenGewonnen = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWert() {
		return wert;
	}

	public char getFigur() {
		return figur;
	}
	
	public int getRundenGewonne() {
		return rundenGewonnen;
	}
	
	public void rundeGewonnen() {
		rundenGewonnen++;
	}


}
