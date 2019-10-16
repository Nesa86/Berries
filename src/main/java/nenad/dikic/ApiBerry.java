package nenad.dikic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiBerry {

	private static String url = "https://pokeapi.co/api/v2/berry/";

	public static int getBerriesCount() throws IOException {
		URL request = new URL(url);
		String response = IOUtils.toString(request.openStream(), "UTF-8");
		JSONObject jObject = new JSONObject(response);
		return jObject.getInt("count");
	}

	public static JSONArray getAllBerriesLink() throws IOException {
		URL request = new URL(url + "?limit=" + getBerriesCount());
		String response = IOUtils.toString(request.openStream(), "UTF-8");
		JSONObject jObject = new JSONObject(response);
		return jObject.getJSONArray("results");
	}

	public static List<Berry> getAllBerries() throws IOException {
		List<Berry> berries = new ArrayList<>();
		JSONArray array = getAllBerriesLink();
		for(int i = 0 ; i < array.length(); i++){
			String link = array.getJSONObject(i).getString("url");
			URL request = new URL(link);
			String response = IOUtils.toString(request.openStream(), "UTF-8");
			JSONObject jObject = new JSONObject(response);
			berries.add(new Berry(jObject));
		}
		return berries;
	}
}