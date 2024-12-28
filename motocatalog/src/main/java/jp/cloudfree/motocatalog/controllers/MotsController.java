package jp.cloudfree.motocatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MotsController {
    
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }
}
