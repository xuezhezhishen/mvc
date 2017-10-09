package com.mvc.component.service;

import com.mvc.entity.GrantedAuthorityObject;
import com.mvc.entity.Role;
import com.mvc.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spencer.hong on 2017/6/19.
 */
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.findUserInfoByName("hlb");
        List<GrantedAuthorityObject> grantedAuthorityObjects = new ArrayList<>();
        for(Role role: userInfo.getRole()){
            GrantedAuthorityObject grantedAuthorityObject = new GrantedAuthorityObject(role.getRoleName());
            grantedAuthorityObjects.add(grantedAuthorityObject);
        }

        UserDetails user = new User(userInfo.getUserName(), userInfo.getPassword(), grantedAuthorityObjects);
        return user;
    }
}
