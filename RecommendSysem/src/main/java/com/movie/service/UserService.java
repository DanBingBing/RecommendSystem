package com.movie.service;

import java.util.List;

import com.movie.pojo.User;

public interface UserService {

	public List<User> findUsername(String username);

	public boolean register(User user);

}
