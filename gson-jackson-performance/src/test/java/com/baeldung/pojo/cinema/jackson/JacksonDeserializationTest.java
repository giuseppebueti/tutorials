package com.baeldung.pojo.cinema.jackson;

import com.baeldung.deserializer.ActorJacksonDeserializer;
import com.baeldung.pojo.cinema.ActorJackson;
import com.baeldung.pojo.cinema.MovieJackson;
import com.baeldung.pojo.cinema.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by giuse on 06/07/2016.
 */
public class JacksonDeserializationTest {

    //JSON To JAVA

    private static ObjectMapper mapper = null;

    @Before
    public void init() throws ParseException {
        mapper = new ObjectMapper();
    }

    @Test
    public void simpleDeserializer() throws URISyntaxException, IOException, ParseException {
        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        MovieJackson movieJackson = mapper.readValue(fileData, MovieJackson.class);
        Assert.assertEquals("Comparing json file with serialized content ...",createMovie(), movieJackson);
    }

    @Test
    public void testJsonToJavaCustomDeserializer() throws URISyntaxException, IOException, ParseException {

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomDeserializer.json").toURI())));
        SimpleModule module = new SimpleModule("SampleModule");
        module.addDeserializer(ActorJackson.class, new ActorJacksonDeserializer(ActorJackson.class));

        MovieJackson movieJackson = mapper
                .registerModule(module)
                .readValue(fileData, MovieJackson.class);
        Assert.assertEquals("Comparing json file with serialized content ...", createMovie(),movieJackson);
    }

    private MovieJackson createMovie() throws ParseException {
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632", JsonUtil.getDateFormat().parse("21-09-1982"),Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return new MovieJackson("tt0472043","Mel Gibson", Arrays.asList(rudyYoungblood));
    }
}
