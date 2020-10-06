package com.example.sprint2be.model;


import com.example.sprint2be.model.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "_rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id tu tang, khong can them id
    private Integer rankId;
    private String name;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.DETACH)
//    @JsonManagedReference
    private Set<User> users;

    public Rank(){}

    public Rank(String name) {
        this.name = name;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
