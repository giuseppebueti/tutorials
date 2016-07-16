package com.baeldung.deserializer;

import com.baeldung.pojo.cinema.ActorJackson;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Macbook13 on 7/13/16.
 */
public class ActorJacksonDeserializer extends StdDeserializer<ActorJackson> {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public ActorJacksonDeserializer(Class<ActorJackson> vc) {
        super(vc);
    }

    @Override
    public ActorJackson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String imdbId = node.get("imdbId").asText();
        Date  dateOfBirth = null;
        try {
            dateOfBirth = simpleDateFormat.parse(node.get("dateOfBirth").asText());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> filmography = Arrays.asList(node.get("filmography").asText().split(";",-1));

        return new ActorJackson(imdbId, dateOfBirth, filmography);
    }
}
