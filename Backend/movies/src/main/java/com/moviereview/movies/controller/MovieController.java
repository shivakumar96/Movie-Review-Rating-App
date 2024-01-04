package com.moviereview.movies.controller;

import com.moviereview.movies.model.Movie;
import com.moviereview.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbID}")
    public ResponseEntity<Movie> getMovie(@PathVariable String imdbID){
        Movie movie = movieService.getMoviebyIMDBID(imdbID).orElseThrow(()-> new RuntimeException("Object not found"));
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
}
