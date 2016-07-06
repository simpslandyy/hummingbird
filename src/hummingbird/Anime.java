package hummingbird;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Anime {
	private int id;
	private int mal_id;
	private String status;
	private String url;
	private String title;
	private String alt_title;
	private int ep_count;
	private int ep_length;
	private String cover_image;
	private String synposis;
	private String show_type;
	private Date start_airing;
	private Date finish_airing;
	private double community_rating;
	private String age_rating;
	private JSONArray genres;	
	
	public Anime() {
		
	} 
	
	/*
	 * parseObject
	 * 	parses JSONObject containing information about an anime, and constructs an AnimeObject
	 */
	public void parseObject(JSONObject animeObj) throws JSONException, ParseException {		
		this.id = animeObj.getInt("id");
		this.mal_id = animeObj.getInt("mal_id");
		this.status = animeObj.getString("slug");
		this.url = animeObj.getString("url");
		this.title = animeObj.getString("title");
		this.ep_count = animeObj.getInt("episode_count");
		this.ep_length = animeObj.getInt("episode_length");
		this.cover_image = animeObj.getString("cover_image");
		this.show_type = animeObj.getString("show_type");
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		this.start_airing = df.parse(animeObj.getString("started_airing"));		
		this.community_rating = animeObj.getDouble("community_rating");
		this.genres = (JSONArray) animeObj.get("genres");	
		
		// The following may return null values, so we gotta error check
		// The null value returned is of type "Object"
		if (animeObj.has("alternate_title") && !(animeObj.get("alternate_title") instanceof Object)) {
			this.alt_title = animeObj.getString("alternate_title");	
		}
		if (animeObj.has("synopsis") && !(animeObj.get("synopsis") instanceof Object)) {
			this.synposis = animeObj.getString("synopsis");			
		}
		if (animeObj.has("finished_airing") && !(animeObj.get("finished_airing") instanceof Object)) {
			this.finish_airing = df.parse(animeObj.getString("finished_airing"));
		}
		if (animeObj.has("age_rating") && !(animeObj.get("age_rating") instanceof Object)) {
			this.age_rating = animeObj.getString("age_rating"); 
		}
		
	}
	
	@Override
	public String toString() {
		return "\n {id=" + id + ",\n mal_id=" + mal_id + ",\n status=" + status + ",\n url=" + url + ",\n title=" + title
				+ ",\n alt_title=" + alt_title + ",\n ep_count=" + ep_count + ",\n ep_length=" + ep_length + ",\n cover_image="
				+ cover_image + ",\n synposis=" + synposis + ",\n show_type=" + show_type + ",\n start_airing=" + start_airing
				+ ",\n finish_airing=" + finish_airing + ",\n community_rating=" + community_rating + ",\n age_rating="
				+ age_rating + ",\n genres=" + genres + "}\n";
	}
	
}
