package com.example.sprint2be.model;


import javax.persistence.*;

@Entity
@Table(name = "_rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id tu tang, khong can them id
    private Integer rankId;
    private String name;
    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   // @JsonManagedReference
    //private Set<User> users;

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

   // public Set<User> getUsers() {
    //    return users;
    //}
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
