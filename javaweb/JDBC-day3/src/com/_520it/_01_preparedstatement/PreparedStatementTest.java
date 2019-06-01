package com._520it._01_preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com._520it.util.JdbcUtil;

public class PreparedStatementTest {
	
	@Test
	public void testName() throws Exception {
		//¼ÖçöÓûÖ´ÊÂ
		String sql="INSERT INTO t_student(name,age) VALUES(?,?)";
		Connection conn=JdbcUtil.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		preparedStatement.setString(1, "AA");
		preparedStatement.setInt(2, 12);
		preparedStatement.executeUpdate();
		JdbcUtil.close(null, preparedStatement, conn);
	}

}
