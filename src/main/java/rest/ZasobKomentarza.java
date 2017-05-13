package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lab3.Film;
import lab3.FilmSerwis;
import lab3.Komentarz;

@Path("/filmy")
public class ZasobKomentarza{
	
	private FilmSerwis db = new FilmSerwis();
	
	@DELETE
	@Path("/{filmId}/komentarze/{komentarzId}")
	public Response usunKomentarzPoId(@PathParam("filmId") int filmId, @PathParam("komentarzId") int komentarzId){
		
		Komentarz result = db.KomentarzPoId(filmId, komentarzId);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		
		db.wybierzFilmPoId(filmId).getKomentarze().remove(result);
		return Response.ok().build();
	}
	@POST
	@Path("/{id}/komentarze")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dodajKomentarz(@PathParam("id") int id, Komentarz komentarz){
		
		Film result = db.wybierzFilmPoId(id);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		
		if(result.getKomentarze() == null){
			
			result.setKomentarze(new ArrayList <Komentarz>());
		}
		
		komentarz.setId(++Komentarz.aktualnyId);
		result.getKomentarze().add(komentarz);
		return Response.ok().build();
	}
	@GET
	@Path("/{filmId}/komentarze/{komentarzId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response wyswietlKomentarzPoId(@PathParam("filmId") int filmId, @PathParam("komentarzId") int komentarzId){
		
		Komentarz result = db.KomentarzPoId(filmId, komentarzId);
		
		if(result == null) return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	@GET
	@Path("/{id}/komentarze")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Komentarz> wyswietlKomentarze(@PathParam("id") int id){
		
		Film result = db.wybierzFilmPoId(id);
		
		if(result == null){
			
			return null;
		}
		
		return result.getKomentarze();
	}
}