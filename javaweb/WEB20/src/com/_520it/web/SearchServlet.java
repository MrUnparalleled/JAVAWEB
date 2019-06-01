package com._520it.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.service.ProductService;

import net.sf.json.JSONArray;
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//接收数据
			String pname = request.getParameter("word");
			//传递数据和请求
			ProductService service =new ProductService();
			List<Object> pnameList = service.search(pname);
			//解决中文乱码
			response.setContentType("text/html;charset=utf-8");
			//
			JSONArray pnames = JSONArray.fromObject(pnameList);
			String pString = pnames.toString();
			System.out.println(pString);
			response.getWriter().write(pString);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}