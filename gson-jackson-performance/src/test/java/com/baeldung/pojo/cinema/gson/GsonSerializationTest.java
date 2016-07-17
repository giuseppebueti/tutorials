package com.baeldung.pojo.cinema.gson;

import com.baeldung.pojo.cinema.ActorGson;
import com.baeldung.pojo.cinema.ActorJackson;
import com.baeldung.pojo.cinema.MovieGson;
import com.baeldung.pojo.cinema.MovieJackson;
import com.baeldung.serializer.ActorGsonSerializer;
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
public class GsonSerializationTest {

    //Java To JSON

    private Gson gson=null;

    @Before
    public void init() throws ParseException {
        gson = new Gson();
    }

    @Test
    public void testJavaToJsonSimple() throws ParseException, IOException, URISyntaxException {
        String serializedMovie = gson.toJson(createMovie());
        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        Assert.assertEquals("Comparing json file with serialized content ...",fileData,serializedMovie);
    }

    @Test
    public void testJavaToJsonExposedAndNullValue() throws ParseException, URISyntaxException, IOException {
         gson=new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .registerTypeAdapter(ActorGson.class,new ActorGsonSerializer())
                .create();

         String serializedMovie = gson.toJson(createMovieWithNullValue());
         String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomSerializer2.json").toURI())));
         Assert.assertEquals("Comparing json file with serialized content ...",fileData,serializedMovie);
    }

    private MovieGson createMovieWithNullValue() throws ParseException {
        ActorGson rudyYoungblood = new ActorGson("nm2199632",getDateFormat().parse("21-09-1982"), Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return  new MovieGson(null, "Mel Gibson", Arrays.asList(rudyYoungblood));
    }

    private MovieGson createMovie() throws ParseException {
        ActorGson rudyYoungblood = new ActorGson("nm2199632",getDateFormat().parse("21-09-1982"),Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        return new MovieGson("tt0472043","Mel Gibson",Arrays.asList(rudyYoungblood));
    }


}
