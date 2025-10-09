package com.sieuthi.service;
import com.sieuthi.model.SanPham;
import java.util.List;
public interface SanPhamService {
    List<SanPham> findAll();
    SanPham findById(Long id);
    SanPham save(SanPham sp);
    void delete(Long id);
}
