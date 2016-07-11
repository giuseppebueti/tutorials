package com.baeldung.pojo.cinema;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by giuse on 06/07/2016.
 */
public class Movie {

    @Expose
    private String title;

    @Expose
    private String year;

    @Expose
    private String released;

    private String director;

    @Expose
    private List<ActorGson> actors;

    @Expose
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

    public List<ActorGson> getActors() {
        return actors;
    }

    public void setActors(List<ActorGson> actors) {
        this.actors = actors;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public Movie(String title, String year, String released, String director, List<ActorGson> actors, String imdbID) {
        this.title = title;
        this.year = year;
        this.released = released;
        this.director = director;
        this.actors = actors;
        this.imdbID = imdbID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

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
