package com.baeldung.deserializer;

import com.baeldung.pojo.cinema.ActorJackson;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Macbook13 on 7/13/16.
 */
public class ActorJacksonDeserializer extends StdDeserializer<ActorJackson> {


    public ActorJacksonDeserializer(Class<ActorJackson> vc) {
        super(vc);
    }

    @Override
    public ActorJackson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String imdbId = node.get("imdbID").asText();
        String name = node.get("name").asText();
        String nationality = node.get("nationality").asText();
        Date birth = new Date(node.get("dateOfBirth").asLong());
        List<String> filmography = node.findValuesAsText("filmography");

        return new ActorJackson(imdbId, name, birth, nationality, filmography);
    }
}
