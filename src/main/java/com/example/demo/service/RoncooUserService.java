/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoncooUserDao;
import com.example.demo.vo.RoncooUser;

/**
 * @author c0z00k8
 *
 */
@Service
public class RoncooUserService {

	@Autowired
	private RoncooUserDao roncooUserDao;
	
	public int updateById(int id){
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(id);
		roncooUser.setName("测试2");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.updateById(roncooUser);
		return result;
	}
	
	public int deleteById(int id){
		int result = roncooUserDao.deleteById(id);
		return result;
	}
}
