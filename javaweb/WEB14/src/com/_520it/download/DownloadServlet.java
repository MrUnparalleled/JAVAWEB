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
		//��ȡҪ��ȡ���ļ�������
		String filename = request.getParameter("filename");
		//������Ĳ���������
//		filename = new String(filename.getBytes("ISO8859-1"),"UTF-8");
//		// ����������user-Agent(���ڴ��������������ļ�����)
//		String agent = request.getParameter("User-Agent");
//		String fileNameEncoding="";
//		//�Բ�ͬ����������в�ͬ�ı���
//		if (agent.contains("MSIE")) {
//			// IE�����
//			fileNameEncoding = URLEncoder.encode(filename, "utf-8");
//			fileNameEncoding = fileNameEncoding.replace("+", " ");
//		} else if (agent.contains("Firefox")) {
//			// ��������
//			Encoder encoder = Base64.getEncoder();
//			fileNameEncoding = "=?utf-8?B?" + encoder.encodeToString(filename.getBytes("utf-8")) + "?=";
//		} else {
//			// ���������
//			fileNameEncoding = URLEncoder.encode(filename, "utf-8");
//		}

		// 0.�������ص�����ͷ��Ϣ
		//Ҫ���ص��ļ�������----------------�ͻ���ͨ��MineType������
		response.setContentType(this.getServletContext().getMimeType(filename));// �ļ�����(���û�лᱨ��)
		//���߿ͻ��˸��ļ�����ֱ�ӽ����������Ը�������ʽ�򿪣����أ�--------filename=" + filename��filename���н���
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.�����Դ�ľ���·��
		String realpath = this.getServletContext().getRealPath("download/" + filename);
		// 2.��ȡ�ļ���������
		InputStream in = new FileInputStream(realpath);
		// 3.�ŵ�response�Ļ�������
		OutputStream out = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		// �ر���Դ
		in.close();
		out.close();// out��Դ��ʵ�Զ��عرգ����Բ���д
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}