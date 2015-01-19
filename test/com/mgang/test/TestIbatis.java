package com.mgang.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.mgang.domain.MGUser;

public class TestIbatis {
	private static SqlMapClient sqlMap;
	@Before
	public void before() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		//从SqlMapConfig.xml中构建SqlMapClient
		sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	}
	
	@Test
	public void testSelect(){
		System.out.println("--all user");
		try {
			List<MGUser> users = sqlMap.queryForList("MGUser.getAll",null);
			for(MGUser u : users){
				System.out.println(u.getNickName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testInsert() throws SQLException{
		MGUser u = new MGUser("xiaoqiang","小强","xiaoqiang",new Date(),0);
		sqlMap.insert("MGUser.insertOne",u);
		System.out.println("insert success");
	}
	
	@Test
	public void testDelete() throws SQLException{
		int id = 4;
		sqlMap.delete("MGUser.deleteById", id);
		System.out.println("delete success");
	}
	
	@Test
	public void testUpdate() throws SQLException{
		MGUser u = (MGUser) sqlMap.queryForObject("MGUser.getUserById", 3);
		u.setNickName("大东");
		u.setUserName("dadong");
		sqlMap.update("MGUser.updateById",u);
		System.out.println("update success");
	}
	
	@Test
	public void testSelectResultMap() throws SQLException{
		//sqlMap.queryForList("MGUser.getAllToResultMap")返回的还是对象集合
		List<MGUser> users = sqlMap.queryForList("MGUser.getAllToResultMap");
		for(MGUser u : users){
			System.out.println(u.toString());
		}
	}
}
