package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {

        String greeting = "hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")

    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


    @GetMapping("hello-names")
    public String helloNames( Model model){
        ArrayList<String> names = new ArrayList<>();
        names.add("Launchcode");
        names.add("Java");
        names.add("Javascript");
        names.add("Python");

        model.addAttribute("names", names) ;
       

        return "hello-list";
    }

}
