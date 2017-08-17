package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // Create a new instance of Actor
        Actor actor = new Actor();
        actor.setName("John Smith");
        actor.setRealname("Johnathan Adam Smith");

        // Create a new instance of Movie
        Movie movie = new Movie();
        movie.setTitle("Moana");
        movie.setYear(2016);
        movie.setDescription("A polynesian princess leaves her island to restore peace.");

        // Add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        // Add the list of movies to the actor's movie list
        actor.setMovies(movies);

        // Save the actor to the database
        actorRepository.save(actor);

        // Grab all the actors from the database and send them to the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }

}
