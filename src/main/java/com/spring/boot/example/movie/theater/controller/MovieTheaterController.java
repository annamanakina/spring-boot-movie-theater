package com.spring.boot.example.movie.theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie.theater")
public class MovieTheaterController {
    //todo some logic here
    //method = RequestMethod.GET by default

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    //@RequestMapping(value = "/helloagain", method = RequestMethod.GET)

    //http://websystique.com/springmvc/spring-4-mvc-helloworld-tutorial-annotation-javaconfig-full-example/
    //https://memorynotfound.com/spring-mvc-xml-configuration-example/

}
