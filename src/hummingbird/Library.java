package hummingbird;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Library {
	private ArrayList<Anime> library;
	
	public Library() {
		this.library = new ArrayList<Anime>();
	}
	
	public static void main(String[] args) throws JSONException, IOException, ParseException {
		Library lib = new Library();
		HttpRequest hum = new HttpRequest();
		JSONArray search = hum.getByTitle("gundam");
//		JSONArray search = hum.getById(55);
		
//		System.out.print(search.toString());
		
		lib.addToLibrary(search);
		System.out.println(lib.toString());
	}
	
	public void addToLibrary(JSONArray animeObj) throws JSONException, ParseException {
		
		// For each anime within the animeObj, create an Anime Object & add it to the library
		for (Object anime : animeObj) {
			Anime item = new Anime();
			item.parseObject((JSONObject) anime);
			this.library.add(item);
			
		}
	}

	@Override
	public String toString() {
		return "Library: \n" + this.library;
	}

}
