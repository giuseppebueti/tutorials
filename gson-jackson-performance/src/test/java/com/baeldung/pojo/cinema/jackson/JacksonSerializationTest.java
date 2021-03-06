package com.baeldung.pojo.cinema.jackson;

import com.baeldung.pojo.cinema.ActorJackson;
import com.baeldung.pojo.cinema.MovieJackson;
import com.baeldung.serializer.ActorJacksonSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

import static com.baeldung.pojo.cinema.util.JsonUtil.getDateFormat;

/**
 * Created by giuse on 06/07/2016.
 */
public class JacksonSerializationTest {

    //Java To JSON

    private static ObjectMapper mapper = null;

    @Before
    public void init() throws ParseException {
        mapper = new ObjectMapper();
    }


    @Test
    public void testJavaToJsonSerializer() throws ParseException, URISyntaxException, IOException {

        String jsonResult = mapper.setDateFormat(getDateFormat()).writeValueAsString(createMovie());
        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        Assert.assertNotEquals("Comparing json file with serialized content ...",fileData,jsonResult);
    }


    @Test
    public void testJavaToJsonExposedAndNullValue() throws ParseException, URISyntaxException, IOException {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new ActorJacksonSerializer(ActorJackson.class));

        String jsonResult = mapper
                .registerModule(module)
                .writer(new DefaultPrettyPrinter())
                .writeValueAsString(createMovieWithNullValue());

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomSerializer2.json").toURI())));
        Assert.assertEquals("Comparing json file with serialized content ...",fileData,jsonResult);
    }

    private MovieJackson createMovieWithNullValue() throws ParseException {
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632",getDateFormat().parse("21-09-1982"), Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return  new MovieJackson(null, "Mel Gibson", Arrays.asList(rudyYoungblood));
    }

    private MovieJackson createMovie() throws ParseException {
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632",getDateFormat().parse("21-09-1982"),Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return new MovieJackson("tt0472043","Mel Gibson",Arrays.asList(rudyYoungblood));
    }



}
