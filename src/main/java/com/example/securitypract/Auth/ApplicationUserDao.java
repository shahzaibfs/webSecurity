package com.example.securitypract.Auth;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername (String userName ) ;
}
