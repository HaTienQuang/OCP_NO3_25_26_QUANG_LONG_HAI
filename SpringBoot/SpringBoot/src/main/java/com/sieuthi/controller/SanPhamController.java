package com.sieuthi.controller;
import com.sieuthi.model.SanPham;
import com.sieuthi.service.SanPhamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    private final SanPhamService service;
    public SanPhamController(SanPhamService service){this.service=service;}

    @GetMapping
    public String list(Model model){
        model.addAttribute("ds", service.findAll());
        return "sanpham/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("sanPham", new SanPham());
        return "sanpham/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SanPham sp){
        service.save(sp);
        return "redirect:/sanpham";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("sanPham", service.findById(id));
        return "sanpham/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/sanpham";
    }
}
