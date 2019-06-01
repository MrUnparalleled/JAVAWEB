package com._520it.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要读取的文件的名称
		String filename = request.getParameter("filename");
		//获得中文参数的乱码
//		filename = new String(filename.getBytes("ISO8859-1"),"UTF-8");
//		// 获得浏览器的user-Agent(用于处理中文命名的文件名字)
//		String agent = request.getParameter("User-Agent");
//		String fileNameEncoding="";
//		//对不同的浏览器进行不同的编码
//		if (agent.contains("MSIE")) {
//			// IE浏览器
//			fileNameEncoding = URLEncoder.encode(filename, "utf-8");
//			fileNameEncoding = fileNameEncoding.replace("+", " ");
//		} else if (agent.contains("Firefox")) {
//			// 火狐浏览器
//			Encoder encoder = Base64.getEncoder();
//			fileNameEncoding = "=?utf-8?B?" + encoder.encodeToString(filename.getBytes("utf-8")) + "?=";
//		} else {
//			// 其它浏览器
//			fileNameEncoding = URLEncoder.encode(filename, "utf-8");
//		}

		// 0.设置下载的两个头信息
		//要下载的文件的类型----------------客户端通过MineType来区别
		response.setContentType(this.getServletContext().getMimeType(filename));// 文件类型(如果没有会报错)
		//告诉客户端改文件不是直接解析，而是以附件的形式打开（下载）--------filename=" + filename对filename进行解码
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.获得资源的绝对路径
		String realpath = this.getServletContext().getRealPath("download/" + filename);
		// 2.获取文件的输入流
		InputStream in = new FileInputStream(realpath);
		// 3.放到response的缓存区中
		OutputStream out = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		// 关闭资源
		in.close();
		out.close();// out资源其实自动回关闭，可以不用写
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}