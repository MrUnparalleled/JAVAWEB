package com._520it._05_blob;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com._520it.util.JdbcUtil;
import com.mysql.cj.jdbc.Blob;

public class BlobTest {
	@Test
	public void test1() throws Exception {
		String sql="INSERT INTO t_image(image) VALUES (?)";
		Connection conn=JdbcUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setBlob(1, new FileInputStream("C:/image.jpg"));
		ps.executeUpdate();
		JdbcUtil.close(null, ps, conn);
		
	}
	
	@Test
	public void test2() throws Exception {
		String sql="SELECT * FROM t_image";
		Connection conn=JdbcUtil.getConnection();
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			Blob blob =(Blob) rs.getBlob("image");
			InputStream in=blob.getBinaryStream();
			Files.copy(in, Paths.get("C:/123.jpg"));
		}
		JdbcUtil.close(rs, ps, conn);
		
	}

}
