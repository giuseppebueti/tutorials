package com.baeldung.pojo.cinema.gson;

import com.baeldung.pojo.cinema.ActorGson;
import com.baeldung.deserializer.ActorGsonDeserializer;
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
public class GsonDeserializationTest {

    //JSON To JAVA

    private Gson gson=null;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private Movie movie;

    @Before
    public void init() throws ParseException {
        gson = new Gson();
        movie = createMovie();
    }

    @Test
    public void simpleDeserializer() throws URISyntaxException, IOException, ParseException {

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoSimple.json").toURI())));
        Movie parsedMovie = gson.fromJson(fileData, Movie.class);
        Assert.assertEquals("Comparing json file with serialized content ...",createMovie(), parsedMovie);

    }

    @Test
    public void testJsonToJavaCustomDeserializer() throws URISyntaxException, IOException, ParseException {

        gson=new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("dd-MM-yyyy")
                .registerTypeAdapter(ActorGson.class,new ActorGsonDeserializer())
                .create();

        String fileData = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("./../apocalyptoCustomSerializer.json").toURI())));
        Movie movie = gson.fromJson(fileData, Movie.class);

        Assert.assertEquals("Comparing json file with serialized content ...", createMovie(),movie);
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
}
