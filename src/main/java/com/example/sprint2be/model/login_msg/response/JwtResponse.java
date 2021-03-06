
package com.example.sprint2be.model.login_msg.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {

    // Thien: Return id to get cart
    private String userId;

    private String token;

    private String username;

    private String email;

    private String avatar;

    private Long wallet;

    private Collection<? extends GrantedAuthority> authorities;


    public JwtResponse() {
    }

    public JwtResponse(String userId, String token, String username, String email, String avatar, Long wallet ,Collection<?
            extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.token = token;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.wallet = wallet;
        this.authorities = authorities;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Long getWallet() {
        return wallet;
    }

    public void setWallet(Long wallet) {
        this.wallet = wallet;
    }
}
