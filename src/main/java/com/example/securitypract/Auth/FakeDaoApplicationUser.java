package com.example.securitypract.Auth;


import com.example.securitypract.Security.ApplicationUserRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeDaoApplicationUser implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder ;

    @Autowired
    FakeDaoApplicationUser(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder ;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String userName) {
        return getAllUsers().stream().filter(applicationUser -> applicationUser.getUsername().equals(userName)).findFirst();
    }

    public List<ApplicationUser> getAllUsers(){
        List<ApplicationUser> users = new ArrayList<>(Arrays.asList(
                new ApplicationUser(
                        "shahzaib",
                        this.passwordEncoder.encode("123"),
                        ApplicationUserRule.STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "ali",
                        this.passwordEncoder.encode("123"),
                        ApplicationUserRule.ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                 new ApplicationUser(
                "aqib",
                this.passwordEncoder.encode("123"),
                ApplicationUserRule.TRAINEE.getGrantedAuthorities(),
                true,
                true,
                true,
                true
        )
        ));

        return users ;
    }




}
