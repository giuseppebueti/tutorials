package com.baeldung.serializer;

import com.baeldung.pojo.cinema.ActorGson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by giuse on 08/07/2016.
 */
public class ActorGsonSerializer implements JsonSerializer<ActorGson> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public JsonElement serialize(ActorGson actor, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject actorJsonObj = new JsonObject();
        actorJsonObj.addProperty("IMDB Code", actor.getImdbId());
        actorJsonObj.addProperty("Date Of Birth", actor.getDateOfBirth() != null ? sdf.format(actor.getDateOfBirth()) : null);
        actorJsonObj.addProperty("N° Film: ",  actor.getFilmography()  != null ?  actor.getFilmography().size() : null);
        actorJsonObj.addProperty("filmography", actor.getFilmography() != null ? convertFilmography(actor.getFilmography()) : null);
        return actorJsonObj;
    }

    private String convertFilmography(List<String> filmography) {
        return filmography.stream().collect(Collectors.joining("-"));
    }
}