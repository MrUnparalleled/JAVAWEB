package com._520it._02_smis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com._520it._02_smis.dao.IStudentDao;
import com._520it._02_smis.domain.Student;
import com._520it.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao{

	public void set(Student stu) {
		//贾琏欲执事
		Connection conn=null;
		PreparedStatement statement=null;
		String sql="INSERT INTO t_student(name,age)VALUES(?,?)";
		try {
			conn=JdbcUtil.getConnection();
			statement=conn.prepareStatement(sql);
			statement.setString(1, stu.getName());
			statement.setInt(2, stu.getAge());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, statement, conn);
		}
		
	}

	public void delete(Long id) {
		Connection conn=null;
		PreparedStatement statement=null;
		String sql="DELETE FROM t_student WHERE id=?";
		try {
			conn=JdbcUtil.getConnection();
			statement=conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, statement, conn);
		}
		
	}

	public void update(Long id, Student stu) {
		Connection conn=null;
		PreparedStatement statement=null;
		String sql="UPDATE t_student SET name=?,age=? WHERE id=?";
		try {
			conn=JdbcUtil.getConnection();
			statement=conn.prepareStatement(sql);
			statement.setString(1, stu.getName());
			statement.setInt(2, stu.getAge());
			statement.setLong(3, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, statement, conn);
		}
		
		
	}

	public Student get(Long id) {
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet re=null;
		String sql="SELECT * FROM t_student WHERE id=?";
		try {
			conn=JdbcUtil.getConnection();
			statement=conn.prepareStatement(sql);
			statement.setLong(1, id);
			re=statement.executeQuery();
			//====================
			//处理结果集
			if (re.next()) {
				Student stu=new Student();
				stu.setId(re.getLong("id"));
				stu.setName(re.getString("name"));
				stu.setAge(re.getInt("age"));
				return stu;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, statement, conn);
		}
		return null;
	}

	public List<Student> listAll() {
		List<Student> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet re=null;
		String sql="SELECT * FROM t_student";
		try {
			conn=JdbcUtil.getConnection();
			statement=conn.prepareStatement(sql);
			re=statement.executeQuery();
			//====================
			//处理结果集
			while(re.next()) {
				Student stu=new Student();
				stu.setId(re.getLong("id"));
				stu.setName(re.getString("name"));
				stu.setAge(re.getInt("age"));
				list.add(stu);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, statement, conn);
		}
		return list;
	}

}
