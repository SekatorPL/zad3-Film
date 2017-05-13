package lab3;

import java.util.ArrayList;
import java.util.List;


public class FilmSerwis{
	private static List <Film> db = new ArrayList <Film> ();
	private static int aktualnyId = 1;
	public void dodajFilm(Film film){
		
		film.setId(++aktualnyId);
		db.add(film);
	}
	public Film wybierzFilmPoId(int id){
		
		for(Film film : db){
			
			if(film.getId() == id){
				
				return film;
			}
		}
		
		return null;
	}
	public void usunFilm(Film film){
		
		db.remove(film);
	}
	public void aktualizujFilm(Film f){
		
		for(Film film : db){
			
			if(film.getId() == film.getId()){
				
				film.setKraj_produkcji(f.getKraj_produkcji());
				film.setRok_produkcji(f.getRok_produkcji());
				film.setTytul(f.getTytul());
				film.setZysk(f.getZysk());
			}
		}
	}
	public List <Film> wszystkieFilmy(){
		
		return db;
	}
	public Komentarz KomentarzPoId(int filmId, int komentarzId){
		
		Film film = wybierzFilmPoId(filmId);
		
		if(film == null) return null;
		
		for(Komentarz komentarz : film.getKomentarze()){
			
			if(komentarz.getId() == komentarzId) return komentarz;
		}
		
		return null;
	}
}