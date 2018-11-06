package chadbot.wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import chadbot.wiki.json.Search;

public class WikiText {


	//
	//this code was stolen from https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
	public static String getWikiText(String searchThing) throws IOException {
		URL url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles="+searchThing);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Gson gson = new Gson();
		Search search = gson.fromJson(response.toString(), Search.class);
		return search.query.pages[0].pageid+"";
	}

}
