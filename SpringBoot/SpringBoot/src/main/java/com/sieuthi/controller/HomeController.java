package com.sieuthi.controller;

import com.sieuthi.service.SanPhamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final SanPhamService sanPhamService;

    public HomeController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", sanPhamService.findAll());
        return "index";
    }
}
