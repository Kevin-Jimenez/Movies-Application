package com.movies.movies.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.movies.entities.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Movie> getMovieByName(String title) throws IOException{
        String requestUrl = "https://www.omdbapi.com/?apikey=db4fd391&t="+title;
        ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        List<Movie> movies = new ArrayList<>();
        try{
            String movieTitle = jsonNode.get("Title").asText();
            String rating = jsonNode.get("imdbRating").asText();
            String overView = jsonNode.get("Plot").asText();
            String relaseYear = jsonNode.get("Released").asText();
            String posterUrl = jsonNode.get("Poster").asText();
            String votes = jsonNode.get("imdbVotes").asText();
            String gender = jsonNode.get("Genre").asText();
            String director = jsonNode.get("Director").asText();
            String actor = jsonNode.get("Actors").asText();
            String language = jsonNode.get("Language").asText();
            movies.add(new Movie(movieTitle, rating,overView, relaseYear, posterUrl, votes, gender, director, actor, language));
        }catch (Exception e){
            movies.add(new Movie("Not Found Please Enter Correct Keyword", "N/A", "N/A", "https://img.freepik.com/free-vector/hand-drawn-404-error_23-2147735153.jpg?w=740&t=st=1674586610~exp=1674587210~hmac=9f51d9169e3b17739a0dea1e4726de76eef146ce6dbc5f37967ed3efcc9c5100", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"));
        }

        return movies;
    }
}
