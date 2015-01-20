package com.mgang.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mgang.domain.MGUser;
import com.mgang.factory.IbatisFactory;

public class TestIbatis {
	private static SqlMapClient sqlMap;
	@Before
	public void before() throws IOException{
		sqlMap = IbatisFactory.getSqlMapClient();
	}
	
	@Test
	public void testSelect(){
		System.out.println("--all user");
		try {
			List<MGUser> users = sqlMap.queryForList("MGUser.getAll",null);
			for(MGUser u : users){
				System.out.println(u.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("select success");
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
		MGUser u = (MGUser) sqlMap.queryForObject("MGUser.getUserById", 13);
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
		System.out.println("resultMap success");
	}
	
	@Test
	public void testProcedure() throws SQLException{
		Map p = new HashMap();
		p.put("p2", 13);
		MGUser u = (MGUser) sqlMap.queryForObject("MGUser.procedure",p);
		System.out.println(u.toString());
		System.out.println("procedure success");
		
	}
	
}
