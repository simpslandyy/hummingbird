package hummingbird;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Anime implements Comparable<Anime> {
	private int id;
	private int mal_id;
	private String status;
	private String slug;
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
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");

		this.id = animeObj.getInt("id");
		this.mal_id = animeObj.getInt("mal_id");
		this.status = animeObj.getString("status");
		this.slug = animeObj.getString("slug");
		this.url = animeObj.getString("url");
		this.title = animeObj.getString("title");
		this.cover_image = animeObj.getString("cover_image");
		this.show_type = animeObj.getString("show_type");
		this.start_airing = df.parse(animeObj.getString("started_airing"));		
		this.community_rating = animeObj.getDouble("community_rating");
		this.genres = (JSONArray) animeObj.get("genres");	
		
		// The following may return null values, so we gotta error check
		// The null value returned is of type "Object"
		if (animeObj.has("alternate_title") && !(animeObj.get("alternate_title") instanceof Object)) {
			this.alt_title = animeObj.getString("alternate_title");	
		}
		if (animeObj.has("episode_count") && !(animeObj.get("episode_count") instanceof Object)) {
			this.ep_count = animeObj.getInt("episode_count");			
		}
		if (animeObj.has("episode_length") && !(animeObj.get("episode_length") instanceof Object)) {
			this.ep_length = animeObj.getInt("episode_length");			
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
	public int compareTo(Anime anime) {
		Date st_airing = anime.getStart_airing();
		
		return this.start_airing.compareTo(st_airing);
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the mal_id
	 */
	public int getMal_id() {
		return mal_id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the alt_title
	 */
	public String getAlt_title() {
		return alt_title;
	}

	/**
	 * @return the ep_count
	 */
	public int getEp_count() {
		return ep_count;
	}

	/**
	 * @return the ep_length
	 */
	public int getEp_length() {
		return ep_length;
	}

	/**
	 * @return the cover_image
	 */
	public String getCover_image() {
		return cover_image;
	}

	/**
	 * @return the synposis
	 */
	public String getSynposis() {
		return synposis;
	}

	/**
	 * @return the show_type
	 */
	public String getShow_type() {
		return show_type;
	}

	/**
	 * @return the start_airing
	 */
	public Date getStart_airing() {
		return start_airing;
	}

	/**
	 * @return the finish_airing
	 */
	public Date getFinish_airing() {
		return finish_airing;
	}

	/**
	 * @return the community_rating
	 */
	public double getCommunity_rating() {
		return community_rating;
	}

	/**
	 * @return the age_rating
	 */
	public String getAge_rating() {
		return age_rating;
	}

	/**
	 * @return the genres
	 */
	public JSONArray getGenres() {
		return genres;
	}

	@Override
	public String toString() {
		return "\n {id=" + id + ",\n mal_id=" + mal_id + ",\n slug=" + slug + ",\n status=" + status + ",\n url=" + url + ",\n title=" + title
				+ ",\n alt_title=" + alt_title + ",\n ep_count=" + ep_count + ",\n ep_length=" + ep_length + ",\n cover_image="
				+ cover_image + ",\n synposis=" + synposis + ",\n show_type=" + show_type + ",\n start_airing=" + start_airing
				+ ",\n finish_airing=" + finish_airing + ",\n community_rating=" + community_rating + ",\n age_rating="
				+ age_rating + ",\n genres=" + genres + "}\n";
	}

	
}
