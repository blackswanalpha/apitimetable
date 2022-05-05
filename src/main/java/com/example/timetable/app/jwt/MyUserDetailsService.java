package com.example.timetable.app.jwt;

import com.example.timetable.app.login.LoginBean;
import com.example.timetable.app.login.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    LoginDAO loginDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginBean loginBean = new LoginBean();


        try {
            loginBean = loginDAO.findByName(s);
           // loginBean.orElseThrow(()->new UsernameNotFoundException("Not found: "+s));
            if (loginBean != null) {
                return new org.springframework.security.core.userdetails.User(
                        loginBean.getLoginName(), loginBean.getLoginPassword(), AuthorityUtils.createAuthorityList(loginBean.getRankStatus())
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new org.springframework.security.core.userdetails.User(
                loginBean.getLoginName(), loginBean.getLoginPassword(), AuthorityUtils.createAuthorityList(loginBean.getRankStatus())
        );
    }


}