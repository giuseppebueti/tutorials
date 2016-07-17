package com.baeldung.pojo.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by giuse on 06/07/2016.
 */
public class MovieJackson {


    private String imdbId;

    @JsonIgnore
    private String director;

    private List<ActorJackson> actors;

    public MovieJackson() {
    }

    public MovieJackson(String imdbId, String director, List<ActorJackson> actors) {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieJackson that = (MovieJackson) o;

        if (imdbId != null ? !imdbId.equals(that.imdbId) : that.imdbId != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        return actors != null ? actors.equals(that.actors) : that.actors == null;

    }

    @Override
    public int hashCode() {
        int result = imdbId != null ? imdbId.hashCode() : 0;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieJackson{" +
                "imdbId='" + imdbId + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }
}
