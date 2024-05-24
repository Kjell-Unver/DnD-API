package com.example.dndapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// new imports
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
    public class DnDController {








        @GetMapping("/html")
        String htmlsite() {
            return "index";
        }

        @GetMapping("/active")
        String activesite(@RequestParam(name="name", required=false, defaultValue="World") Model model) {
            // model.addAttribute("name", {someID});
            return "index";
        }





    @GetMapping("/active/{someID}")
    public String getAttr(@PathVariable(value="someID") String id,
                          @RequestParam(name="name", required=false, defaultValue="World") String name,
                          @RequestParam(name="h", required=false, defaultValue="World") String h,
                          Model model)

    {

        model.addAttribute("name", name);
        model.addAttribute("h", h);
        System.out.println(id);

        return "index";
    }












    }