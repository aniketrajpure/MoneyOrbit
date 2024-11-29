package com.example.bankapp.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private BigDecimal balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transaction;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    // Default constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(String username, String password, BigDecimal balance, List<Transaction> transaction, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.transaction = transaction;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    // Implement methods from UserDetails interface
    @Override
    public boolean isAccountNonExpired() {
        return true; // Customize according to your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Customize according to your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Customize according to your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Customize according to your requirements
    }
}
