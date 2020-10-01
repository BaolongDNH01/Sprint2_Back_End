package com.example.sprint2be.repository;

import com.example.sprint2be.model.HistoryRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRegisterRepository extends JpaRepository<HistoryRegister, Integer> {


}
