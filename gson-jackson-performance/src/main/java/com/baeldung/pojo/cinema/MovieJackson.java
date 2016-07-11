package com.baeldung.pojo.cinema;

import java.util.List;

/**
 * Created by giuse on 06/07/2016.
 */
public class MovieJackson {

    private String title;

    private String year;

    private String released;

    private String director;

    private List<ActorJackson> actors;

    private String imdbID;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<ActorJackson> getActors() {
        return actors;
    }

    public void setActors(List<ActorJackson> actors) {
        this.actors = actors;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public MovieJackson(String title, String year, String released, String director, List<ActorJackson> actors, String imdbID) {
        this.title = title;
        this.year = year;
        this.released = released;
        this.director = director;
        this.actors = actors;
        this.imdbID = imdbID;
    }

    public MovieJackson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieJackson movie = (MovieJackson) o;

        return imdbID != null ? imdbID.equals(movie.imdbID) : movie.imdbID == null;

    }

    @Override
    public int hashCode() {
        return imdbID != null ? imdbID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", released='" + released + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                ", imdbID='" + imdbID + '\'' +
                '}';
    }
}
