package com.sieuthi.repository;
import com.sieuthi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BillRepository extends JpaRepository<Bill, Long> {}
