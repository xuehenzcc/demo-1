/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月17日
 */
package com.example.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.UserVO;

/**
 * @author c0z00k8
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/getUser")
	public UserVO getUser(@RequestParam String name){
		UserVO user=new UserVO();
		user.setName(name);
		user.setId(1);
		user.setDesc("desc");
		user.setCreateDate(new Date());
		return user;
	}
}
