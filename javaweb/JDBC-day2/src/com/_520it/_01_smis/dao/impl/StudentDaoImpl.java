package com._520it._01_smis.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com._520it._01_smis.dao.IStudentDao;
import com._520it._01_smis.domain.Student;
import com._520it._01_smis.util.JdbcUtil;
//贾琏欲执事
public class StudentDaoImpl implements IStudentDao{
	@Override
	public void save(Student stu) {
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO t_student(name,age)values('").append(stu.getName()).append("',").append(stu.getAge()).append(")");
		//声明资源
		Connection connection=null;
		Statement statement=null;
		try {
			connection=JdbcUtil.getConnection();
			statement=connection.createStatement();
			statement.executeUpdate(sql.toString());
			//====================================
			//处理结果集
			//=====================================
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JdbcUtil.close(null, statement, connection);
			}
	}

	@Override
	public void delete(Long id) {
		String sql="DELETE FROM t_student WHERE id="+id;
		//声明资源
		Connection connection=null;
		Statement statement=null;
		try {
			connection=JdbcUtil.getConnection();
			statement=connection.createStatement();
			statement.executeUpdate(sql);
			//====================================
			//处理结果集
			//=====================================
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JdbcUtil.close(null, statement, connection);
			}
		}

	@Override
	public void update(Long id, Student newstu) {
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE t_student SET name='").append(newstu.getName()).append("',age=").append(newstu.getAge()).append(" WHERE id=");
		sql.append(id).append("");
		//声明资源
		Connection connection=null;
		Statement statement=null;
		try {
			connection=JdbcUtil.getConnection();
			statement=connection.createStatement();
			statement.executeUpdate(sql.toString());
			//====================================
			//处理结果集
			//=====================================
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JdbcUtil.close(null, statement, connection);
			}
		}
	

	@Override
	public Student get(Long id) {
		String sql="SELECT * FROM t_student WHERE id="+id;
		//声明资源
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=JdbcUtil.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			//====================================
			//处理结果集
			if (resultSet.next()) {
				Student stu=new Student();
				stu.setId(resultSet.getLong("id"));
				stu.setAge(resultSet.getInt("age"));
				stu.setName(resultSet.getString("name"));
				return stu;
				
			}
			//=====================================
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JdbcUtil.close(resultSet, statement, connection);
		}
		
		return null;
	}

	@Override
	public List<Student> listsAll() {
		List<Student> list=new ArrayList<>();
		String sql="SELECT * FROM t_student";
		//声明资源
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=JdbcUtil.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			//====================================
			//处理结果集
			while(resultSet.next()) {
				Student stu=new Student();
				stu.setId(resultSet.getLong("id"));
				stu.setAge(resultSet.getInt("age"));
				stu.setName(resultSet.getString("name"));
				list.add(stu);//吧学生对象先存储到list集合中
			}
			//=====================================
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JdbcUtil.close(resultSet, statement, connection);
		}
		return list;
	}

}
