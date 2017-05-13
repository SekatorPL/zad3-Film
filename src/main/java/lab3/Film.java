package lab3;

import java.util.List;

public class Film {
	private int id;
	private String tytul;
	private String kraj_produkcji;
	private int zysk;
	private int rok_produkcji;
	private List <Komentarz> komentarze;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getKraj_produkcji() {
		return kraj_produkcji;
	}
	public void setKraj_produkcji(String kraj_produkcji) {
		this.kraj_produkcji = kraj_produkcji;
	}
	public int getZysk() {
		return zysk;
	}
	public void setZysk(int zysk) {
		this.zysk = zysk;
	}
	public int getRok_produkcji() {
		return rok_produkcji;
	}
	public void setRok_produkcji(int rok_produkcji) {
		this.rok_produkcji = rok_produkcji;
	}
	public List<Komentarz> getKomentarze() {
		return komentarze;
	}
	public void setKomentarze(List<Komentarz> komentarze) {
		this.komentarze = komentarze;
	}
}
