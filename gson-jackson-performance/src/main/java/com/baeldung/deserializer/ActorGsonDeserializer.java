package com.baeldung.deserializer;

import com.baeldung.pojo.cinema.ActorGson;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by giuse on 08/07/2016.
 */
public class ActorGsonDeserializer implements JsonDeserializer<ActorGson> {

    @Override
    public ActorGson deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) jsonElement;

        String[] filmography = jsonObject.get("filmography").getAsString().split("-", -1);

        return new ActorGson(jsonObject.get("imdbID").getAsString()
                ,jsonObject.get("name").getAsString()
                ,new Date(jsonObject.get("dateOfBirth").getAsLong())
                ,jsonObject.get("nationality").getAsString()
                , Arrays.asList(filmography) );

    }

}