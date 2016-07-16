package com.baeldung.deserializer;

import com.baeldung.pojo.cinema.ActorGson;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by giuse on 08/07/2016.
 */
public class ActorGsonDeserializer implements JsonDeserializer<ActorGson> {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public ActorGson deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = (JsonObject) jsonElement;
        String[] filmography = jsonObject.get("filmography").getAsString().split(";", -1);
        Date dateOfBirth = null;
        try {
            dateOfBirth = simpleDateFormat.parse(jsonObject.get("dateOfBirth").getAsString());
        } catch (ParseException e) {
            dateOfBirth = null;
        }

        return new ActorGson(jsonObject.get("imdbId").getAsString(), dateOfBirth, Arrays.asList(filmography) );
    }

}