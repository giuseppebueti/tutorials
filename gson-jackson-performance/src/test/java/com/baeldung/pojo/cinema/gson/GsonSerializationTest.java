package com.baeldung.pojo.cinema.gson;

import com.baeldung.pojo.cinema.ActorGson;
import com.baeldung.serializer.ActorGsonSerializer;
import com.baeldung.pojo.cinema.Movie;
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

/**
 * Created by giuse on 06/07/2016.
 */
public class GsonSerializationTest {

    //Java To JSON

    private Gson gson=null;
    private Movie movie=null;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    @Before
    public void init() throws ParseException {
        gson = new Gson();
        movie = createMovie();
    }



    @Test
    public void testJavaToJsonSimple() throws ParseException, IOException, URISyntaxException {

        String serializedMovie = gson.toJson(movie);
        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        Assert.assertEquals("Comparing json file with serialized content ...",fileData,serializedMovie);
    }

    @Test
    public void testJavaToJsonCustomSerializer() throws URISyntaxException, IOException {
        gson=new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("dd-MM-yyyy")
                .registerTypeAdapter(ActorGson.class,new ActorGsonSerializer())
                .create();

        String serializedMovie = gson.toJson(movie);

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomSerializer.json").toURI())));
        Assert.assertEquals("Comparing json file with serialized content ...",fileData,serializedMovie);
    }

    @Test
    public void testJavaToJsonExposedAndNullValue() throws ParseException, URISyntaxException, IOException {
         gson=new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setDateFormat("dd-MM-yyyy")
                .registerTypeAdapter(ActorGson.class,new ActorGsonSerializer())
                .create();

         movie = createMovieWithNullValue();

         String serializedMovie = gson.toJson(movie);
         String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomSerializer2.json").toURI())));
         Assert.assertEquals("Comparing json file with serialized content ...",fileData,serializedMovie);
    }

    private Movie createMovie() throws ParseException {
        ActorGson rudyYoungblood = new ActorGson("nm2199632","Rudy Youngblood",sdf.parse("09-21-1982"),"American",
                Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        ActorGson daliaHernandez = new ActorGson("nm2199664","Dalia Hernandez",sdf.parse("08-14-1985"),"Mexican",
                Arrays.asList("Apocalypto","Capadocia") );

        Movie movie = new Movie("Apocalypto","2006","2008","Mel Gibson",
                Arrays.asList(rudyYoungblood,daliaHernandez),"tt0472043");
        return movie;
    }

    private Movie createMovieWithNullValue() throws ParseException {
        ActorGson rudyYoungblood = new ActorGson("nm2199632",null,sdf.parse("09-21-1982"),"American",
                Arrays.asList("Apocalypto","Beatdown","Wind Walkers") );
        ActorGson daliaHernandez = new ActorGson("nm2199664","Dalia Hernandez",null,"Mexican",
                Arrays.asList("Apocalypto","Capadocia") );

        Movie movie = new Movie("Apocalypto","2006","2008","Mel Gibson",
                Arrays.asList(rudyYoungblood,daliaHernandez),"tt0472043");
        return movie;
    }


}
