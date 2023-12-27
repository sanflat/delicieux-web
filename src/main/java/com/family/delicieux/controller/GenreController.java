package com.family.delicieux.controller;

import com.family.delicieux.form.GenreForm;
import com.family.delicieux.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<GenreForm> genreList = genreService.getGenreListView();
        model.addAttribute("genreList", genreList);
        return "genre/list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("genreForm", new GenreForm());
        return "genre/register";
    }

    @PostMapping("/post")
    public String register(@ModelAttribute GenreForm genreForm) {
        genreService.postGenre(genreForm);
        return "redirect:/genre/list";
    }
}
