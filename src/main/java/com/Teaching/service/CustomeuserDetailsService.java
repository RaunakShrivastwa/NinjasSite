package com.Teaching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Teaching.entity.CustomeUserDetails;
import com.Teaching.Student.Student;
import com.Teaching.Student.StudentRepositery;

@Service
public class CustomeuserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepositery userReprository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       Student user= this.userReprository.findByEmail(email);
       if(user==null){
           throw new UsernameNotFoundException("user not found");
       }
        return new CustomeUserDetails(user);

    }
}
