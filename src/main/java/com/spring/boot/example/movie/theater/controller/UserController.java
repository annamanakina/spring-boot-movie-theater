package com.spring.boot.example.movie.theater.controller;

import com.spring.boot.example.movie.theater.item.UserTest;
import com.spring.boot.example.movie.theater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


//https://memorynotfound.com/spring-security-user-registration-example-thymeleaf/
@Controller
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    /*@GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserTest user = new UserTest();
        //user.setFirstName().setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }*/

    /*@GetMapping(path="/all")
    public @ResponseBody Iterable<UserTest> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }*/


    /*@RequestParam String firstName,
                                                    @RequestParam String lastName,
                                                    @RequestParam String birthday,
                                                    @RequestParam String email,
                                                    @RequestParam String password*/
    //@ResponseBody Iterable<UserTest> to get json/xml format

    @ModelAttribute("user")
    public UserTest userTest() {
        return new UserTest();
    }


    @GetMapping("/register")
    public String showRegistrationPage(){
        return "registration";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") UserTest user, Model model) {
        UserTest userObject = new UserTest();
        userObject.setFirstName(user.getFirstName());
        userObject.setLastName(user.getLastName());
        userObject.setBirthday(user.getBirthday());
        userObject.setEmail(user.getEmail());
        userObject.setPassword(user.getPassword());
        userRepository.save(user);
        System.out.println("user: " + user);
        //model.addAttribute("")
        // This returns a JSON or XML with the users
        //return userRepository.findAll();
        //"redirect:/index"
        model.addAttribute("user", user);
        return "redirect:/greeting"; //redirect:/ forward:/
    }

    @GetMapping
    public String greetingUser() {
        return "greeting";
    }

}
