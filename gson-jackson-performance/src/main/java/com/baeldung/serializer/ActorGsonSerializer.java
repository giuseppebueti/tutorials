package com.baeldung.serializer;

import com.baeldung.pojo.cinema.ActorGson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by giuse on 08/07/2016.
 */
public class ActorGsonSerializer implements JsonSerializer<ActorGson> {


    @Override
    public JsonElement serialize(ActorGson actor, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject actorJsonObj = new JsonObject();
        actorJsonObj.addProperty("imdbID", actor.getImdbId());
        actorJsonObj.addProperty("name", actor.getName());
        actorJsonObj.addProperty("dateOfBirth", actor.getDateOfBirth() != null ? actor.getDateOfBirth().getTime() : null);
        actorJsonObj.addProperty("nationality", actor.getNationality());
        actorJsonObj.addProperty("N° Film: ",  actor.getFilmography()  != null ?  actor.getFilmography().size() : null);
        actorJsonObj.addProperty("filmography", actor.getFilmography() != null ? convertFilmography(actor.getFilmography()) : null);

        return actorJsonObj;

    }

    private String convertFilmography(List<String> filmography) {

        return filmography.stream().collect(Collectors.joining(" - "));
    }


}