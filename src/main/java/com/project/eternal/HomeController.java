package com.project.eternal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String redirectToSearch() {
        return "redirect:/search.html";
    }
}
