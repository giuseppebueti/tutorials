package com.baeldung.pojo.cinema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by giuse on 07/07/2016.
 */
public class ActorGson {

    @Expose
    @SerializedName("IMDB Code")
    private String imdbId;

    @SerializedName("Date Of Birth")
    private Date dateOfBirth;

    @Expose
    private List<String> filmography;

    public ActorGson(String imdbId, Date dateOfBirth,  List<String> filmography) {
        this.imdbId = imdbId;
        this.dateOfBirth = dateOfBirth;
        this.filmography = filmography;
    }

    public ActorGson() {
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<String> filmography) {
        this.filmography = filmography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorGson actorGson = (ActorGson) o;

        if (imdbId != null ? !imdbId.equals(actorGson.imdbId) : actorGson.imdbId != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(actorGson.dateOfBirth) : actorGson.dateOfBirth != null)
            return false;
        return filmography != null ? filmography.equals(actorGson.filmography) : actorGson.filmography == null;

    }

    @Override
    public int hashCode() {
        int result = imdbId != null ? imdbId.hashCode() : 0;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (filmography != null ? filmography.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActorGson{" +
                "imdbId='" + imdbId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", filmography=" + filmography +
                '}';
    }
}
