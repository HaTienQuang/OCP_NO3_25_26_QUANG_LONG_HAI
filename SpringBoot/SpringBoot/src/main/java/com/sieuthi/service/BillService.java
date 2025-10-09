package com.sieuthi.service;
import com.sieuthi.model.Bill;
import java.util.List;
public interface BillService {
    List<Bill> findAll();
    Bill findById(Long id);
    Bill save(Bill bill);
    void delete(Long id);
}
