package com.mvc.entity;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityObject implements GrantedAuthority{
    public GrantedAuthorityObject(String authority){
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    private String authority;
    @Override
    public String getAuthority() {
        return authority;
    }
}
