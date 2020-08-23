package com.reza.flightreservation.service;

import com.reza.flightreservation.entity.User;
import com.reza.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException("User not found for Email: "+ email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),user.getRoles());
    }
}
