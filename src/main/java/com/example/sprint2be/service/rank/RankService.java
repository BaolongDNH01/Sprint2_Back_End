package com.example.sprint2be.service.rank;

import com.example.sprint2be.model.Rank;

import java.util.List;

public interface RankService {
    List<Rank> findAll();
    Rank findById(Integer id);
}
