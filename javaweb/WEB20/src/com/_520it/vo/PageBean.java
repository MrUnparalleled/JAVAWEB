package com._520it.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	//当前页
	private int currentPage;
	//当前商品条数
	private int currentCount;
	
	//总页数
	private int totalPage;
	
	//总商品数
	private int totalCount;
	
	//当前页商品信息
	private List<T> ProductList = new ArrayList<T>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getProductList() {
		return ProductList;
	}

	public void setProductList(List<T> productList) {
		ProductList = productList;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", currentCount=" + currentCount + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", ProductList=" + ProductList + "]";
	}

	
}
