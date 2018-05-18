package com.orange.otheatre.otheatre.controller;


import com.orange.otheatre.otheatre.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String homePage(HttpSession session, Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if ( authentication != null ) {

            try {
                User principal = (User) authentication.getPrincipal();
                model.addAttribute("principal", principal);
            } catch ( Exception ex ) {

            }
        }

        return "homePage";
    }
}
