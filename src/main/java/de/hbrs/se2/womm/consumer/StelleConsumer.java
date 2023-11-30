package de.hbrs.se2.womm.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import de.hbrs.se2.womm.dtos.StelleDTO;

public class StelleConsumer extends AbstractApiConsumer<StelleDTO>{

    @Override
    protected StelleDTO jsonToDTO(JsonElement item, Gson gson) {
        return gson.fromJson(item, StelleDTO.class);
    }
}
