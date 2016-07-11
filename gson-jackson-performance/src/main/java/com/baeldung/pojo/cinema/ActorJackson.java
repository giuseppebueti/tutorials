package com.baeldung.pojo.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by giuse on 07/07/2016.
 */
public class ActorJackson {

    @JsonProperty("IMDB Code")
    private String imdbId;

    private String name;

    @JsonIgnore
    @JsonProperty("Date Of Birth")
    private Date dateOfBirth;

    private String nationality;

    private List<String> filmography;

    public ActorJackson(String imdbId, String name, Date dateOfBirth, String nationality, List<String> filmography) {
        this.imdbId = imdbId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.filmography = filmography;
    }

    public ActorJackson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorJackson that = (ActorJackson) o;

        if (imdbId != null ? !imdbId.equals(that.imdbId) : that.imdbId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        return filmography != null ? filmography.equals(that.filmography) : that.filmography == null;

    }

    @Override
    public int hashCode() {
        int result = imdbId != null ? imdbId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (filmography != null ? filmography.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActorJackson{" +
                "imdbId='" + imdbId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", filmography=" + filmography +
                '}';
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<String> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<String> filmography) {
        this.filmography = filmography;
    }
}
