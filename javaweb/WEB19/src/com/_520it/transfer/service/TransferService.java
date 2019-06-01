package com._520it.transfer.service;

import java.sql.Connection;
import java.sql.SQLException;

import com._520it.transfer.dao.TransferDao;
import com._520it.utils.DataSourceUtils;

public class TransferService {

	public boolean tansfer(String out, String in, String money) {
		boolean transfer=true;
		Connection conn=null;
		try {
			conn = DataSourceUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//调用dao层的转入和转出方法
			TransferDao dao=new TransferDao();
			dao.in(conn,in,money);
			//模拟停电
			int i=1/0;
			dao.out(conn,out,money);
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			transfer=!transfer;
			e.printStackTrace();
		}finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transfer;
	}

}
