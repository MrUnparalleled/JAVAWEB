package com._520it.transfer.service;

import java.sql.SQLException;

import com._520it.transfer.dao.MyTransferDao;
import com._520it.utils.MyDataSourceUtils;

public class MyTransferService {

	public boolean tansfer(String out, String in, String money) {
		boolean transfer=true;
		try {
			//开启事务
			MyDataSourceUtils.startTransaction();
			//调用dao层的转入和转出方法
			MyTransferDao dao=new MyTransferDao();
			dao.in(in,money);
			//模拟停电
			int i=1/0;
			dao.out(out,money);
			
		} catch (Exception e) {
			try {
				MyDataSourceUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			transfer=!transfer;
			e.printStackTrace();
		}finally {
			try {
				MyDataSourceUtils.commitTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transfer;
	}

}
