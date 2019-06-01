package com._520it._03_tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com._520it.util.JdbcUtil;

public class TxTest {

@Test
public void Tx() throws Exception {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	conn=JdbcUtil.getConnection();
	
	try {
		conn.setAutoCommit(false);
		//==============查询余额======================
		String sql="SELECT * FROM employee WHERE name=? AND balance>=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, "老男人");
		ps.setInt(2, 1000);
		rs=ps.executeQuery();
		if (!rs.next()) {
			throw new RuntimeException("余额不足");
		}
		//================老男人减少1000====================
		sql="UPDATE employee SET balance=balance-1000 WHERE name=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, "老男人");
		ps.executeUpdate();
		//==================模拟停电================
		int i=1/0;
		//================老女人增加1000====================
		sql="UPDATE employee SET balance=balance+1000 WHERE name=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, "老女人");
		ps.executeUpdate();
		conn.commit();
		
	} catch (Exception e) {
		e.printStackTrace();
		try {
			conn.rollback();
		} catch (Exception e2) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
}	
	

}

