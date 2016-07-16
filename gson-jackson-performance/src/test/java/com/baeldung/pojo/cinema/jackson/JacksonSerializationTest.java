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

/**
 * Created by giuse on 06/07/2016.
 */
public class JacksonSerializationTest {

    //Java To JSON

    private static ObjectMapper mapper = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private MovieJackson movie;

    @Before
    public void init() throws ParseException {
        mapper = new ObjectMapper();
        movie = createMovie();
    }


    @Test
    public void testJavaToJsonSerializer() throws ParseException, URISyntaxException, IOException {

        String jsonResult = mapper.setDateFormat(DateFormat.getDateTimeInstance()).writeValueAsString(movie);
        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        Assert.assertNotEquals("Comparing json file with serialized content ...",fileData,jsonResult);
    }


    @Test
    public void testJavaToJsonExposedAndNullValue() throws ParseException, URISyntaxException, IOException {
        SimpleModule module = new SimpleModule("SampleModule");
        module.addSerializer(new ActorJacksonSerializer(ActorJackson.class));

        String jsonResult = null;
        try {
            jsonResult = mapper
                    .registerModule(module)
                    .writer(new DefaultPrettyPrinter())
                    .writeValueAsString(createMovieWithNullValue());
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomSerializer2.json").toURI())));
        Assert.assertEquals("Comparing json file with serialized content ...",fileData,jsonResult);
    }

    private MovieJackson createMovieWithNullValue() throws ParseException {
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632",sdf.parse("21-09-1982"), Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return  new MovieJackson(null, "Mel Gibson", Arrays.asList(rudyYoungblood));
    }

    private MovieJackson createMovie() throws ParseException {
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632",sdf.parse("21-09-1982"),Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return new MovieJackson("tt0472043","Mel Gibson",Arrays.asList(rudyYoungblood));
    }



}
