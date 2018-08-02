/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月17日
 */
package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.RoncooUserService;
import com.example.demo.vo.UserVO;



/**
 * @author c0z00k8
 *
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private RoncooUserService roncooUserService;
	
	@Value("${desc}")
	private String desc;
	
	@RequestMapping("/get/{id}/{name}")
	@ResponseBody
	public UserVO get(@PathVariable int id,@PathVariable String name){
		UserVO user=new UserVO();
		user.setId(id);
		user.setName(name);
		user.setCreateDate(new Date());
		user.setDesc(desc);
//		roncooUserService.updateById(id);
		roncooUserService.deleteById(id);
		return user;
	}
	
	@RequestMapping("/index")
	public String index(ModelMap map){
		map.put("title", "hello world");
//		throw new RuntimeException();
		return "index";
	}
	
	
	
}
