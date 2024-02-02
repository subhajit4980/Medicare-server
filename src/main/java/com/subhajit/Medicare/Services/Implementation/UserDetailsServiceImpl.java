package com.subhajit.Medicare.Services.Implementation;

import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
//
//        return UserDetailsImpl.build(user);
//    }
//
//}
