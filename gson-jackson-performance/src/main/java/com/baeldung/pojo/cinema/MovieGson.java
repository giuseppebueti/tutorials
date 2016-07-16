package com.baeldung.pojo.cinema;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by giuse on 06/07/2016.
 */
public class MovieGson {

    @Expose
    private String imdbId;
    private String director;
    @Expose
    private List<ActorGson> actors;

    public MovieGson() {
    }

    public MovieGson(String imdbId, String director, List<ActorGson> actors ) {
        this.director = director;
        this.actors = actors;
        this.imdbId = imdbId;
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

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieGson movieGson = (MovieGson) o;

        if (director != null ? !director.equals(movieGson.director) : movieGson.director != null) return false;
        if (actors != null ? !actors.equals(movieGson.actors) : movieGson.actors != null) return false;
        return imdbId != null ? imdbId.equals(movieGson.imdbId) : movieGson.imdbId == null;

    }

    @Override
    public int hashCode() {
        int result = director != null ? director.hashCode() : 0;
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (imdbId != null ? imdbId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieGson{" +
                "director='" + director + '\'' +
                ", actors=" + actors +
                ", imdbId='" + imdbId + '\'' +
                '}';
    }
}
