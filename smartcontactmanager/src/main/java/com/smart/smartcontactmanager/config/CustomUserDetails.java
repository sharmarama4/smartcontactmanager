package com.smart.smartcontactmanager.config;

import com.smart.smartcontactmanager.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails{
    private User user;

    public CustomUserDetails(User user) {
        this.user=user;
    }
    @Override
    public Collection<?extends GrantedAuthority>getAuthorities(){
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getRole());
        return List.of(simpleGrantedAuthority);
    }


    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {

        return user.getEmail();
    }




    @Override
    public String getPassword() {
        return user.getPassword();
    }



}