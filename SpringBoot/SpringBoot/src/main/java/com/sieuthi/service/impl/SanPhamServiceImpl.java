package com.sieuthi.service.impl;
import com.sieuthi.model.SanPham;
import com.sieuthi.repository.SanPhamRepository;
import com.sieuthi.service.SanPhamService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository repo;
    public SanPhamServiceImpl(SanPhamRepository repo){this.repo=repo;}
    public List<SanPham> findAll(){return repo.findAll();}
    public SanPham findById(Long id){return repo.findById(id).orElse(null);}
    public SanPham save(SanPham sp){return repo.save(sp);}
    public void delete(Long id){repo.deleteById(id);}
}
