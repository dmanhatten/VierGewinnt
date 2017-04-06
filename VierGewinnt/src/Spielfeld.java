
public class Spielfeld {
	
	private int[][] feld;
	
	public Spielfeld() {
		this(8);
	}
	
	public Spielfeld(int spalten) {
		feld = new int[spalten][6];
		initialisiere();
		
	}
	
	public void initialisiere() {
		for(int s = 0; s < feld.length; s++) {
			for(int r = 0; r < feld[s].length; r++) {
				feld[s][r] = 0;
			}
		}
	}

	public int[][] getFeld() {
		return feld;
	}
	
	public boolean werfeStein(int spalte, int wert) {
		if(spalte >= 0 && spalte < feld.length) {
			for(int r = feld[spalte].length - 1; r >= 0; r--) {
				if(feld[spalte][r] == 0) {
					feld[spalte][r] = wert;
					return true;
				}
			}
		}	
		return false;
	}
	
	public boolean pruefeVoll() {
		for(int s = 0; s < feld.length; s++) {
			for(int r = 0; r < feld[s].length; r++) {
				if(feld[s][r] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
