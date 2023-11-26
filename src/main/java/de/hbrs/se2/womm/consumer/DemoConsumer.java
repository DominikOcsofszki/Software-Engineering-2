package de.hbrs.se2.womm.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import de.hbrs.se2.womm.dtos.StudentDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DemoConsumer {

    DemoConsumer(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");

            con.setRequestMethod("GET");
//            int responseCode = con.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
//            System.out.println("content:" + content.toString());
            in.close();
            con.disconnect();
            jsonToStudentDTO(content.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private List<StudentDTO> jsonToStudentDTO(String json) {
        Gson gson = new Gson();
        ArrayList<StudentDTO> studentDTOList = new ArrayList<>();
        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement item: jsonArray) {
//            System.out.println(item);
//            JsonObject jsonObject = item.getAsJsonObject();
            studentDTOList.add(gson.fromJson(item, StudentDTO.class));
        }
        System.out.println(studentDTOList);
        return studentDTOList;
    }

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080/api/users");
            DemoConsumer consumer = new DemoConsumer(url);


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}