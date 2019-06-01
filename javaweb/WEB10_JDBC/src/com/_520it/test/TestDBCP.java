package com._520it.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com._520it.utils.DBCPUtils;
import com._520it.utils.JDBCUtils_V3;

public class TestDBCP {
	
	@Test
	public void testUser() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DBCPUtils.getConnection();
			String sql="select * from user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			
		}finally {
			JDBCUtils_V3.close(conn, pstmt, rs);
			
		}
	}
}
