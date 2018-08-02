/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.vo.RoncooUserLog;

/**
 * @author c0z00k8
 *
 */
public interface RoncooUserLogDao extends JpaRepository<RoncooUserLog, Integer>{

//	@Query(value = "select u from RoncooUserLog u where u.userName=?1")
	List<RoncooUserLog> findByUserName(String userName);

	List<RoncooUserLog> findByUserNameAndUserIp(String string, String string2);

	/**
	 * @param exampl
	 * @param pageable
	 * @return
	 */
	Page<RoncooUserLog> findByUserName(String userName, Pageable pageable);

}
