package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserMapper;
import com.movie.pojo.User;
import com.movie.pojo.UserExample;
import com.movie.pojo.UserExample.Criteria;
import com.movie.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public List<User> findUsername(String username) {
		
		UserExample example=new UserExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		
		return userMapper.selectByExample(example);
	}

	@Override
	public boolean register(User user) {
		
		// 使用mabatis插入一条记录成功后会返回  -2147482646
		// insert() 方法会把表中的所有字段都插入，这里 user 中没有值的则默认插入表中的值为 null,也就是会覆盖表中设置的默认值
		//int count = userMapper.insert(user);
		
		// insertSelective()方法只会插入 user 中传递过来的非空字段
		userMapper.insertSelective(user);
		//System.out.println(count);
		
		return true;
	}

}
