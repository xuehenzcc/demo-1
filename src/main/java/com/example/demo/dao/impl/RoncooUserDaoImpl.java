/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.demo.dao.RoncooUserDao;
import com.example.demo.util.base.JdbcDaoImpl;
import com.example.demo.util.base.Page;
import com.example.demo.util.base.Sql;
import com.example.demo.vo.RoncooUser;

import ch.qos.logback.core.rolling.helper.RollingCalendar;

/**
 * @author c0z00k8
 *
 */
@Repository
public class RoncooUserDaoImpl extends JdbcDaoImpl implements RoncooUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.dao.RoncooUserDao#insert(com.example.demo.vo.RoncooUser)
	 */
	@Override
	public int insert(RoncooUser roncooUser) {
		// TODO Auto-generated method stub
		String sql="insert into roncoo_user (name,create_time) values(?,?)";
		int result = jdbcTemplate.update(sql, roncooUser.getName(), roncooUser.getCreateTime());
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.dao.RoncooUserDao#updateById(com.example.demo.vo.RoncooUser)
	 */
	@Override
	public int updateById(RoncooUser roncooUser) {
		String sql="update roncoo_user set name=?,create_time=? where id=?";
		int result = jdbcTemplate.update(sql, roncooUser.getName(), roncooUser.getCreateTime(),roncooUser.getId());
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.dao.RoncooUserDao#deleteById(int)
	 */
	@Override
	public int deleteById(int id) {
		String sql="delete from roncoo_user where id=?";
		int result = jdbcTemplate.update(sql,id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.dao.RoncooUserDao#selectById(int)
	 */
	@Override
	public RoncooUser selectById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from roncoo_user where id=?";
		return queryForObject(sql, RoncooUser.class, id);
	}

//	@Override
	public Page<RoncooUser> queryForPage(int pageCurrent, int pageSize, String name){
		// 确定参数
		/*String sql = "select * from roncoo_user where name=?";
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class, name);*/
		
		// 若name可能为空，则要进行判定，如下
		/*StringBuffer sql = new StringBuffer("select * from roncoo_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class);*/
		
		// 若要like查询，如下
		StringBuffer sql = new StringBuffer("select * from roncoo_user where 1");
		if(!StringUtils.isEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class);
	}
}
