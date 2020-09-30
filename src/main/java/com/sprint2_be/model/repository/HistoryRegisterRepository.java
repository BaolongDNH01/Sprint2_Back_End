package com.sprint2_be.model.repository;

import com.sprint2_be.model.entity.HistoryRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRegisterRepository extends JpaRepository<HistoryRegister, Integer> {


}
