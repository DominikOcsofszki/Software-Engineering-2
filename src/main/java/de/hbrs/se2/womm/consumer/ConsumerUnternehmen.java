package de.hbrs.se2.womm.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;

import java.util.List;

public class ConsumerUnternehmen extends AbstractApiConsumer<UnternehmenDTO> {

    @Override
    protected List<? extends AbstractDTO> getDtosFromUrlSubClass(String urlString) {
        return inSuperClassGetDtosFromUrl(urlString);
    }

    @Override
    protected UnternehmenDTO jsonToDTO(JsonElement item, Gson gson) {
        return gson.fromJson(item, UnternehmenDTO.class);
    }

    public static void main(String[] args) {
        ConsumerUnternehmen consumerUnternehmen = new ConsumerUnternehmen();
        consumerUnternehmen.getDtosFromUrlSubClass(CONSUMER_URLS.UNTERNEHMEN.GET_All_UNTERNEHMEN_URL);
    }
}
