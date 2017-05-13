package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lab3.Film;
import lab3.FilmSerwis;

@Path("/filmy")
public class ZasobFilmu{
	
	private FilmSerwis db = new FilmSerwis();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response dodajFilm(Film film){
		
		db.dodajFilm(film);
		return Response.ok(film.getId()).build();
	}
	@PUT
	@Path("/{id}")
	public Response aktualizujFilm(@PathParam("id") int id, Film film){
		
		Film result = db.wybierzFilmPoId(id);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		else{
			
			film.setId(id);
			db.aktualizujFilm(film);
		}
		
		return Response.ok().build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Film> wyswietlWszystkieFilmy(){
		
		return db.wszystkieFilmy();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response wyswietlFilmPoId(@PathParam("id") int id){
		
		Film result = db.wybierzFilmPoId(id);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		
		return Response.ok(result).build();
	}
}