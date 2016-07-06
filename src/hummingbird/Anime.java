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
		this.alt_title = animeObj.getString("alternate_title");
		this.ep_count = animeObj.getInt("episode_count");
		this.ep_length = animeObj.getInt("episode_length");
		this.cover_image = animeObj.getString("cover_image");
		 
		if (animeObj.has("synopsis")) {
			this.synposis = animeObj.getString("synopsis");			
		}
		
		this.show_type = animeObj.getString("show_type");
		
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		this.start_airing = df.parse(animeObj.getString("started_airing"));
		this.finish_airing = df.parse(animeObj.getString("finished_airing"));
		this.community_rating = animeObj.getDouble("community_rating");
		this.age_rating = animeObj.getString("age_rating");
		this.genres = (JSONArray) animeObj.get("genres");	
	}
	
	@Override
	public String toString() {
		return "Anime [id=" + id + ", mal_id=" + mal_id + ", status=" + status + ", url=" + url + ", title=" + title
				+ ", alt_title=" + alt_title + ", ep_count=" + ep_count + ", ep_length=" + ep_length + ", cover_image="
				+ cover_image + ", synposis=" + synposis + ", show_type=" + show_type + ", start_airing=" + start_airing
				+ ", finish_airing=" + finish_airing + ", community_rating=" + community_rating + ", age_rating="
				+ age_rating + ", genres=" + genres + "]";
	}
	
}
