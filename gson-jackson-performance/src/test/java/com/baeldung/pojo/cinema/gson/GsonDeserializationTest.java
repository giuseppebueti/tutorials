package com.baeldung.pojo.cinema.gson;

import com.baeldung.pojo.cinema.ActorGson;
import com.baeldung.deserializer.ActorGsonDeserializer;
import com.baeldung.pojo.cinema.ActorJackson;
import com.baeldung.pojo.cinema.MovieGson;
import com.baeldung.pojo.cinema.MovieJackson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

import static com.baeldung.pojo.cinema.util.JsonUtil.getDateFormat;

/**
 * Created by giuse on 06/07/2016.
 */
public class GsonDeserializationTest {

    //JSON To JAVA

    private Gson gson=null;

    @Before
    public void init() throws ParseException {
        gson = new Gson();
    }

    @Test
    public void simpleDeserializer() throws URISyntaxException, IOException, ParseException {
        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        MovieGson parsedMovie = gson.fromJson(fileData, MovieGson.class);
        Assert.assertEquals("Comparing json file with serialized content ...",createMovie(), parsedMovie);
    }

    @Test
    public void testJsonToJavaCustomDeserializer() throws URISyntaxException, IOException, ParseException {

        gson=new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(ActorGson.class,new ActorGsonDeserializer())
                .create();

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomDeserializer.json").toURI())));
        MovieGson movieGson = gson.fromJson(fileData, MovieGson.class);

        Assert.assertEquals("Comparing json file with serialized content ...", createMovie(), movieGson);
    }

    private MovieGson createMovie() throws ParseException {
        ActorGson rudyYoungblood = new ActorGson("nm2199632",getDateFormat().parse("21-09-1982"),Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return new MovieGson("tt0472043","Mel Gibson", Arrays.asList(rudyYoungblood));
    }
}
