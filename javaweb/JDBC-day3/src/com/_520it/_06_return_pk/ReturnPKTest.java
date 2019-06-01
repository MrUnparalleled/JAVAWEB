package com._520it._06_return_pk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com._520it.util.JdbcUtil;
public class ReturnPKTest {
	
	@Test
	public void Test1() throws Exception {
		String sql="INSERT INTO t_student(name,age) VALUES (?,?)";
		Connection conn=JdbcUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "乔峰");
		ps.setInt(2, 32);
		ps.executeUpdate();
		//获取自动生成的主键
		ResultSet rs=ps.getGeneratedKeys();
		if (rs.next()) {
			Long id=rs.getLong(1);
			System.out.println(id);
		}
		JdbcUtil.close(rs, ps, conn);
	}

}
