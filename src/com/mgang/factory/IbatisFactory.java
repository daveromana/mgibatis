package com.mgang.factory;

import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 
 * @author meigang
 * 单例模式，得到SqlMapClient
 *
 */
public class IbatisFactory {
	private static SqlMapClient sqlMap;
	static{
		try {
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(Resources.getResourceAsReader("SqlMapConfig.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//抛出一个运行时异常
			throw new RuntimeException("初始化ibatis出错，因为:"+e.getMessage());
		}
	}
	//工厂方法得到sqlMap
	public static SqlMapClient getSqlMapClient(){
		return sqlMap;
	}
}
