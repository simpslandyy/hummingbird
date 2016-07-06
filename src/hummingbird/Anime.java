package hummingbird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.json.JSONObject;


public class Anime {
	private int id;
	private int mal_id;
	private String status;
	private String url;
	private String title;
	private String alt_title;
	private String ep_count;
	private String ep_length;
	private String cover_image;
	private String synposis;
	private String show_type;
	private Date start_airing;
	private Date finish_airing;
	private double community_rating;
	private String age_rating;
	private String genres;
	private String endpoint;
	
	public Anime() {
		this.endpoint = "https://hummingbird.me/api/v1";
	}

	public void getById(int animeID) throws IOException {
		// modify the endpoint so that it gets by id.
		String endpoint = String.format("%s/anime/%d", this.endpoint, animeID);
		
		// convert string object to a url object
		URL obj = new URL(endpoint);
		
		// Open an HTTP connection, default-method: GET
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		
		// retrieve status code
		int statusCode = conn.getResponseCode();
		System.out.println("Hitting this endpoint: " + endpoint);
		System.out.println("Status code is: " + statusCode);
		
		// pipes the input stream into a buffer that we can read from (like reading from a file)
		BufferedReader buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuffer res = new StringBuffer();
		
		// while each line of the file doesn't equal null, append it to another StringBuffer
		while((line = buff.readLine()) != null) {
			res.append(line);
		}
		
		// close the buffer
		buff.close();

		System.out.println(res.toString());
		
		// convert JSON string to a JSON Object
		JSONObject jsonObj = new JSONObject(res.toString());
		
		// getInt returns any values in the JSON that are ints, getString is the same thing but for strings
		System.out.println(jsonObj.getInt("id"));
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		Anime some = new Anime(); // create a new anime object
		some.getById(55); // call the getById method
	}
}
