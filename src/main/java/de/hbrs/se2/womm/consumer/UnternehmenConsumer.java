package de.hbrs.se2.womm.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UnternehmenConsumer {

    UnternehmenConsumer(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("GET");
//            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            jsonToStudentDTO(content.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private List<UnternehmenDTO> jsonToStudentDTO(String json) {
        Gson gson = new Gson();
        ArrayList<UnternehmenDTO> studentDTOList = new ArrayList<>();
        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement item: jsonArray) {
            studentDTOList.add(gson.fromJson(item, UnternehmenDTO.class));
        }
        System.out.println(studentDTOList);
        return studentDTOList;
    }

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080/api/users");
            UnternehmenConsumer consumer = new UnternehmenConsumer(url);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}