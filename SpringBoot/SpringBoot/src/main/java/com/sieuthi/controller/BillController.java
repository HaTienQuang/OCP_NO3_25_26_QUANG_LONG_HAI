package com.sieuthi.controller;
import com.sieuthi.model.Bill;
import com.sieuthi.model.BillItem;
import com.sieuthi.model.SanPham;
import com.sieuthi.model.User;
import com.sieuthi.repository.SanPhamRepository;
import com.sieuthi.repository.UserRepository;
import com.sieuthi.service.BillService;
import com.sieuthi.service.SanPhamService;
import com.sieuthi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;
    private final SanPhamService sanPhamService;
    private final UserService userService;

    public BillController(BillService billService, SanPhamService sanPhamService, UserService userService){
        this.billService = billService;
        this.sanPhamService = sanPhamService;
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("ds", billService.findAll());
        return "bill/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("bill", new Bill());
        model.addAttribute("products", sanPhamService.findAll());
        model.addAttribute("users", userService.findAll());
        return "bill/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Bill bill, @RequestParam(required=false) List<Long> productIds, @RequestParam(required=false) List<Integer> qty){
        if(productIds != null && qty != null){
            List<BillItem> items = new ArrayList<>();
            for(int i=0;i<productIds.size();i++){
                SanPham p = sanPhamService.findById(productIds.get(i));
                int q = qty.get(i);
                if(p!=null){
                    BillItem it = new BillItem();
                    it.setSanPham(p);
                    it.setSoLuong(q);
                    it.setGia(p.getGia());
                    it.setBill(bill);
                    items.add(it);
                }
            }
            bill.setItems(items);
        }
        bill.calculateTotal();
        billService.save(bill);
        return "redirect:/bill";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        billService.delete(id);
        return "redirect:/bill";
    }
}
