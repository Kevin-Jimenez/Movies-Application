package com.movies.movies.controller;

import com.movies.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/search")
    public String getMovieByName(@RequestParam(name = "title") String title, Model model) throws IOException {
        model.addAttribute("movies",movieService.getMovieByName(title));
        return "index";
    }
}
