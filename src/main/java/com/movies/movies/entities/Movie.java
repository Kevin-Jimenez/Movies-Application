package com.movies.movies.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@Getter @Setter
public class Movie {
    private String title;
    private String rating;
    private String overview;
    private String relaseYear;
    private String posteUrl;
    private String votes;
    private String gender;
    private String actor;
    private String director;
    private String languajes;
}
