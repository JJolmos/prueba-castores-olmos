package com.castores.prueba.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.castores.prueba.model.Usuarios;
import com.castores.prueba.rerpository.UsuarioRepository;

@Controller
public class HomeController {

    private final UsuarioRepository usuarioRepository;

    public HomeController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails UserDetails = (UserDetails) authentication.getPrincipal();
            Usuarios usuario = usuarioRepository.findByCorreo(UserDetails.getUsername());
            model.addAttribute("user", usuario);
        }

        return "home";
    }

}