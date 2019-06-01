package com._520it._08_druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import com._520it.util.DruidUtil;

public class DruidTest {
	
	public DataSource getDataSource() {
		BasicDataSource dSource=new BasicDataSource();
		dSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dSource.setUsername("root");
		dSource.setPassword("root");
		dSource.setUrl("jdbc:mysql://localhost:3306/jdbcdemo?serverTimezone=GMT%2B8");
		return dSource;
	}
@Test
public void test1() throws Exception {
	//DataSource ds=this.getDataSource();
	//Connection conn=ds.getConnection();
	Connection conn=DruidUtil.getConn();
	PreparedStatement ps=conn.prepareStatement("SELECT * FROM t_student");
	ResultSet rs= ps.executeQuery();
	while (rs.next()) {
		System.out.println(rs.getLong("id"));
	}
}
}
