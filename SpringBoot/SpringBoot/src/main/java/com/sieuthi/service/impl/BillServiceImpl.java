package com.sieuthi.service.impl;
import com.sieuthi.model.Bill;
import com.sieuthi.repository.BillRepository;
import com.sieuthi.service.BillService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BillServiceImpl implements BillService {
    private final BillRepository repo;
    public BillServiceImpl(BillRepository repo){this.repo=repo;}
    public List<Bill> findAll(){return repo.findAll();}
    public Bill findById(Long id){return repo.findById(id).orElse(null);}
    public Bill save(Bill bill){bill.calculateTotal(); return repo.save(bill);}
    public void delete(Long id){repo.deleteById(id);}
}
