package com.kt.spring5jokesapp.controllers;

import com.kt.spring5jokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kontelk on 8/18/23.
 */
@Controller
public class JokeController {

    private final JokeService jokeService;

    @Autowired   // this annotation is not necessary in constructor - we can remove it
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
