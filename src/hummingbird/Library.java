package hummingbird;

import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Library {
	private ArrayList<Anime> library;
	
	public Library() {
		this.library = new ArrayList<Anime>();
	}
	
	/*
	 * 
	 * EXAMPLE of how to put it all together
	 */

	public static void main(String[] args) throws JSONException, IOException, ParseException {
		//	Create a new library that will store the contents of your search
		Library lib = new Library();
	
		//  Instantiate an HTTPRequest, and call one of the methods (getByQuery or getById)
		HttpRequest hum = new HttpRequest();
		JSONArray search = hum.getByQuery("naruto");
	
		//	The object returned is a List of JSONS, so iterate through the list
		for (Object res : search) {
	
		// 	Create a new anime object
			Anime item = new Anime();
	
		// parse out the json and set the values for the anime instance
			item.parseObject((JSONObject) res);
	
			// Add the anime instance to the library
			lib.addToLibrary(item);
		}		
		
		// Sort ascending by date
		Collections.sort(lib.getLibrary());
		
		// Sort descending by date
		Collections.reverse(lib.getLibrary());
		
	}
	public void addToLibrary(Anime anime) {
		this.library.add(anime);
	}

	/*
	 * getLibrary
	 * 		returns an ArrayList<Anime> object.
	 * 		This result is non-filterable, only library objects can be filtered.
	 * */
	public ArrayList<Anime> getLibrary() {
		return library;
	}
	
	/*
	 *  filterByShowType
	 *  	return a LIBRARY based on the show type.
	 *  		returning a library allows us to filter sublibraries, however when it comes time to use the data,
	 *  		we'll be iterating through an ArrayList.
	 * */
	public Library filterByShowType(String type) {
		Library results = new Library();
		
		for (Anime anime : this.library) {
			if (anime.getShow_type().equalsIgnoreCase(type)) {
				results.addToLibrary(anime);
			}
		}
		
		return results;
	}

	/*
	 *  filterByStatus
	 *  	return a LIBRARY based on the airing status
	 * */
	public Library filterByStatus(String status) {
		Library results = new Library();
		
		for (Anime anime : this.library) {
			if (anime.getStatus().equalsIgnoreCase(status)) {
				results.addToLibrary(anime);
			}
		}
		
		return results;
	}
	
	/*
	 * filterByRating
	 * 	return a LIBRARY based on the community rating (0 - 5)
	 * */
	
	public Library filterByRating(int rating) {
		Library results = new Library();
		
		for (Anime anime : this.library) {
			if (anime.getCommunity_rating() >= rating) {
				results.addToLibrary(anime);
			}
		}
		
		return results;
	}
	
	/*
	 * filterByAgeRating
	 * 	return a LIBRARY based on the age rating (e.g. G, PG, PG13, PG17+, PG18+)
	 * */
	public Library filterByAgeRating(String rating) {
		Library results = new Library();
		
		for (Anime anime : this.library) {
			if (anime.getAge_rating().equalsIgnoreCase(rating)) {
				results.addToLibrary(anime);
			}
		}
		
		return results;
	}
	
	public Library sortByStartingDate(String sortOrder) {
		Library results = new Library();
		
		
		return results;
	}
	
	
	@Override
	public String toString() {
		return "Library: \n" + this.library;
	}
}