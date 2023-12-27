package com.family.delicieux.controller;

import com.family.delicieux.form.SeasonForm;
import com.family.delicieux.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/season")
public class SeasonController {

    private final SeasonService seasonService;
    @Autowired
    public SeasonController(SeasonService seasonService){
        this.seasonService = seasonService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<SeasonForm> seasonList = seasonService.getSeasonListView();
        model.addAttribute("seasonList", seasonList);
        return "season/list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        SeasonForm seasonForm = new SeasonForm();
        model.addAttribute("seasonForm", seasonForm);
        return "season/register";
    }

    @PostMapping("/post")
    public String register(@ModelAttribute SeasonForm seasonForm) {
        seasonService.postSeason(seasonForm);
        return "redirect:/season/list";
    }

}
