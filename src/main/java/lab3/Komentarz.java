package lab3;

public class Komentarz {
	private int id;
	private String zawartosc;
	public static int aktualnyId = 1;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZawartosc() {
		return zawartosc;
	}
	public void setZawartosc(String zawartosc) {
		this.zawartosc = zawartosc;
	}
}
