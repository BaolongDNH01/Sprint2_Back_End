package com.example.sprint2be.service.rank.impl;

import com.example.sprint2be.model.Rank;
import com.example.sprint2be.repository.RankRepository;
import com.example.sprint2be.service.rank.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    RankRepository rankRepository;
    @Override
    public List<Rank> findAll() {
        return rankRepository.findAll();
    }

    @Override
    public Rank findById(Integer id) {
        return rankRepository.findById(id).orElse(null);
    }
}
