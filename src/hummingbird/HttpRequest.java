package hummingbird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.ParseException;
import org.json.JSONArray;
import org.json.JSONException;

public class HttpRequest {

	private String endpoint;
	
	public HttpRequest() {
		this.endpoint = "https://hummingbird.me/api/v1";
	}
	
	/*
	 * getById
	 * 	return a JSONObject containing a single anime with id `id`.
	 */
	public JSONArray getById(int animeID) throws IOException, JSONException, ParseException {
		// modify the end-point so that it gets by id.
		String endpoint = String.format("%s/anime/%d", this.endpoint, animeID);
		
		// convert string object to a url object
		URL obj = new URL(endpoint);
		
		// Open an HTTP connection, default-method: GET
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		
		// retrieve status code
		int statusCode; 
		
		if ((statusCode = conn.getResponseCode()) != 200) {
			System.err.print("Internal Server Error -> " + statusCode);
			System.exit(1);
		}
		
		JSONArray animeObj = this.getResponse(conn);
		
		return animeObj;
	}
	
	/*
	 * getByTitle
	 * 	return a JSONObject containing information about anime title(s)
	 */
	public JSONArray getByQuery(String query) throws IOException, JSONException, ParseException {
		// modify the end-point so that it gets by a title
		String endpoint = String.format("%s/search/anime/?query=%s", this.endpoint, query);
		
		URL obj = new URL(endpoint);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		
		JSONArray animeObj = this.getResponse(conn);
		
		return animeObj;
	}
	
	/*
	 * getResponse
	 *	return a JSON object of an HTTP response
	 */
	public JSONArray getResponse(HttpURLConnection c) throws IOException {
		JSONArray jsonArr;

		// pipes the input stream into a buffer that we can read from (like reading from a file)
		BufferedReader buff = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String line;
		StringBuffer res = new StringBuffer();
		
		// while each line of the file doesn't equal null, append it to another StringBuffer
		while((line = buff.readLine()) != null) {
			res.append(line);
		}

		buff.close();
			
		// Determine if the response is a single object or array of objects
		// If the first character is '[' then it's an array of objects
		if (res.charAt(0) == '[') {
			jsonArr = new JSONArray(res.toString());
	
		} else {
			String toStringArr = String.format("[%s]", res.toString());
			jsonArr = new JSONArray(toStringArr);
		}
		
				
		return jsonArr;
	}

}
