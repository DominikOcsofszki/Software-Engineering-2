package de.hbrs.se2.womm.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import de.hbrs.se2.womm.dtos.AbstractDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractApiConsumer<ExtendsAbstractDTO extends AbstractDTO> {

    abstract protected List<? extends AbstractDTO> getDtosFromUrlSubClass(String urlString);
//        return getDtosFromUrlSubClass(url);

    protected List<? extends AbstractDTO> getDtosFromUrl(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + urlString);
            return null;
        }
        return getDtoFromURL(url);
    }
    private List<? extends AbstractDTO> getDtoFromURL(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jsonToDTO(content.toString());
    }

    private List<ExtendsAbstractDTO> jsonToDTO(String json) {
        Gson gson = new Gson();
        ArrayList<ExtendsAbstractDTO> dtoList = new ArrayList<>();
        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement item : jsonArray) {
            dtoList.add(jsonToDTO(item, gson));
        }
        return dtoList;
    }

    abstract protected ExtendsAbstractDTO jsonToDTO(JsonElement item, Gson gson);
//        gson.fromJson(item, ExtendsAbstractDTO.class)
}
