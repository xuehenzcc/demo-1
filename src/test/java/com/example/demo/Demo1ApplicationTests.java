package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.RoncooUserDao;
import com.example.demo.dao.RoncooUserLogDao;
import com.example.demo.util.component.RoncooJmsComponent;
import com.example.demo.util.component.RoncooRedisComponent;
import com.example.demo.vo.RoncooUser;
import com.example.demo.vo.RoncooUserLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Autowired
	private RoncooUserDao roncooUserDao;
	@Autowired 
	private RoncooRedisComponent redisComponent;
	@Autowired
	private RoncooJmsComponent roncooJmsComponent;

	@Test
	public void send() {
		roncooJmsComponent.send("hello world");
	}
	
	@Test
	public void get(){
		System.out.println(redisComponent.get("roncoo"));
	}
	@Test
	public void set(){
		redisComponent.set("roncoo","zcc");
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void insert() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName("测试");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.insert(roncooUser);
		System.out.println(result);
	}
	
	@Test
	public void delete() {
		int result = roncooUserDao.deleteById(1);
		System.out.println(result);
	}

	@Test
	public void update() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(2);
		roncooUser.setName("测试2");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.updateById(roncooUser);
		System.out.println(result);
	}

	@Test
	public void select() {
		RoncooUser result = roncooUserDao.selectById(2);
		System.out.println(result);
	}
	

	@Test
	public void select2() {
		RoncooUser result = roncooUserDao.selectById(7);
		System.out.println(result);
	}
	
	// 分页测试
//	@Test
//	public void queryForPage(){
//		Page<RoncooUser> result = roncooUserDao.queryForPage(1, 20, "测试");
//		System.out.println(result.getList());
//	}
	
	
	
	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	@Test
	public void insertJPA() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void deleteJPA() {
		roncooUserLogDao.deleteById(1);
	}

	@Test
	public void updateJPA() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void selectJPA() {
		Optional<RoncooUserLog> result = roncooUserLogDao.findById(1);
		System.out.println(result);
	}

	@Test
	public void selectJPA2() {
		List<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境");
		System.out.println(result);
	}

	@Test
	public void select3() {
		List<RoncooUserLog> result = roncooUserLogDao.findByUserNameAndUserIp("无境2", "192.168.0.1");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
		System.out.println("记录数："+result.getContent());
	}

	
}
