//package de.hbrs.se2.womm.consumer;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.vaadin.flow.component.select.Select;
//import de.hbrs.se2.womm.controller.UnternehmenController;
//import de.hbrs.se2.womm.dtos.AbstractDTO;
//import de.hbrs.se2.womm.dtos.UnternehmenDTO;
//import de.hbrs.se2.womm.services.UnternehmenService;
//import de.hbrs.se2.womm.views.components.SEARCHFILTER;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MusterConsumer {
//
//    UnternehmenController controller;
//    MusterConsumer(UnternehmenController controller){
//        this.controller = controller;
//    }
//
//    private List<UnternehmenDTO> jsonToDTO(String json) {
//        Gson gson = new Gson();
//        ArrayList<UnternehmenDTO> dtoList = new ArrayList<>();
//        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
//        for (JsonElement item: jsonArray) {
//            dtoList.add(gson.fromJson(item, UnternehmenDTO.class));
//        }
//        return dtoList;
//    }
//    public List<? extends AbstractDTO> getAllUnternehmen(){
////    public List<UnternehmenDTO> getAllUnternehmen(){
//        return this.controller.getAllUnternehmen().getBody();
//    }
//
//    public static void main(String[] args) {
//        MusterConsumer consumer = new MusterConsumer(new UnternehmenController(new UnternehmenService());
//        List<UnternehmenDTO> dtoList = consumer.getAllUnternehmen();
//
//            dtoList.forEach(System.out::println);
//
//    }
//}