package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String posterPath;
    String title;
    String overview;
    String backdropPath;
    double rating;
    String releaseDate;
    int voteCount;
    int movieId;

    //Used for Parceler library
    public Movie() {}

    public Movie (JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
        rating = jsonObject.getDouble("vote_average");
        releaseDate = jsonObject.getString("release_date");
        voteCount = jsonObject.getInt("vote_count");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray (JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);

           //TODO - fetch all sizes and remove hard-coded sizes

    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);

        //TODO - fetch all sizes and remove hard-coded sizes

    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getMovieId() {
        return movieId;
    }
}
