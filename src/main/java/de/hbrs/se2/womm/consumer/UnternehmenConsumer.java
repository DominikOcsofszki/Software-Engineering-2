package de.hbrs.se2.womm.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UnternehmenConsumer {

//    public UnternehmenConsumer() {
//
//    }

    public List<UnternehmenDTO> getUnternehmen(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("GET");
//            int responseCode = con.getResponseCode();
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
    private List<UnternehmenDTO> jsonToDTO(String json) {
        Gson gson = new Gson();
        ArrayList<UnternehmenDTO> dtoList = new ArrayList<>();
        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement item: jsonArray) {
            dtoList.add(gson.fromJson(item, UnternehmenDTO.class));
        }
//        System.out.println(dtoList);
        return dtoList;
    }

//    public static void main(String[] args) {
//
//        try {
//            URL url = new URL("http://localhost:8080/api/users");
//            UnternehmenConsumer consumer = new UnternehmenConsumer();
//            List<UnternehmenDTO> dtoList = consumer.getUnternehmen(url);
//            dtoList.forEach(System.out::println);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
}