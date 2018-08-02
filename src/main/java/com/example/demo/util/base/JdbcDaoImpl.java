/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.util.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;


/**
 * @author c0z00k8
 *
 */
public abstract class JdbcDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Long getLastId(){
		return jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
	}
	
	//获取对象信息
	public <T> T queryForObject(String sql,Class<T> clazz,Object... objects ){
		Assert.hasText(sql,"sql 语句不能为空");
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz),objects);
	}
	
	//获取对象集合
	public <T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	
	
	/**
	 * 分页，jdbcTemplate 不支持like
	 */
	public Page<Map<String, Object>> queryForPage(String sql, int pageCurrent, int pageSize, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
		String sqlCount = Sql.countSql(sql);
		int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
		pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent);
		pageSize = Sql.checkPageSize(pageSize);
		int totalPage = Sql.countTotalPage(count, pageSize);
		String sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlList, args);
		return new Page<Map<String, Object>>(count, totalPage, pageCurrent, pageSize, list);
	}

	/**
	 * 分页，jdbcTemplate 不支持like
	 */
	public <T> Page<T> queryForPage(String sql, int pageCurrent, int pageSize, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
		Assert.isTrue(clazz != null, "clazz 不能为空");
		String sqlCount = Sql.countSql(sql);
		int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
		pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent);
		pageSize = Sql.checkPageSize(pageSize);
		int totalPage = Sql.countTotalPage(count, pageSize);
		String sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize);
		List<T> list = jdbcTemplate.query(sqlList, new BeanPropertyRowMapper<T>(clazz), args);
		return new Page<T>(count, totalPage, pageCurrent, pageSize, list);
	}
}
