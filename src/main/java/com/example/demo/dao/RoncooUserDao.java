/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.dao;

import com.example.demo.vo.RoncooUser;

/**
 * @author c0z00k8
 *
 */
public interface RoncooUserDao {

	int insert(RoncooUser roncooUser);
	
	int updateById(RoncooUser roncooUser);
	
	int deleteById(int id);
	
	RoncooUser selectById(int id);
}
