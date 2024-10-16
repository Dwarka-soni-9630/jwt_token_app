package com.jwt.jwttoken.service;


import com.jwt.jwttoken.dao.UserRepo;
import com.jwt.jwttoken.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
	private UserRepo repo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public User saveUser(User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
	    return repo.save(user) ;
		
	}
}
