package com.lg.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 *
 */
public class PageBean {

	private int page = 1;// 页码

	private int rows = 10;// 页大小

	private int total = 0;// 总记录数

	private boolean pagination = true;// 是否分页

	// 保留上一次的请求地址
	private  String url;

	// 保留上一次请求所携带的参数
	private  Map<String, String []> paMap=new HashMap<>();

	/**
	 *  pageBean 初始化方法
	 */
	public  void setRequest(HttpServletRequest req) {
		this.setPage(req.getParameter("page"));
		this.setRows(req.getParameter("rows"));
		this.setPagination(req.getParameter("pagination"));

		this.setUrl(req.getRequestURL().toString());
		this.setPaMap(req.getParameterMap());
	}

	public void setPagination(String pagination) {
		if("false".equals(pagination)) {
			this.setPagination(false);
		}
	}

	/**
	 * 改变 rows属性 页大小
	 * @param rows
	 */
	public void setRows(String rows) {
		if(StringUtils.isNotBlank(rows)) {
			this.setRows(Integer.valueOf(rows));
		}
	}

	/**
	 * 改变 page属性 页码的大小
	 * @param page
	 */
	public void setPage(String page) {
		if(StringUtils.isNotBlank(page)) {
			this.setPage(Integer.valueOf(page));
		}
	}


	public PageBean() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public Map<String, String[]> getPaMap() {
		return paMap;
	}

	public void setPaMap(Map<String, String[]> paMap) {
		this.paMap = paMap;
	}

	/**
	 * 获得起始记录的下标
	 *
	 * @return
	 */
	public int getStartIndex() {
		return (this.page - 1) * this.rows;
	}

	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
	}

	/**
	 * 获取上一页的方法
	 * @return
	 */
	public int getPreviousPage() {
		return this.page>1 ? this.page-1 : this.page;
	}

	/**
	 * 获取下一页的方法
	 * @return
	 */
	public int getNextPage() {
		return this.page<this.getMaxPage() ? this.page+1 : this.getMaxPage();
	}

	/**
	 * 获取最大页码
	 * @return
	 */
	public int getMaxPage() {
		return this.total % this.rows == 0 ? this.total/this.rows : this.total/this.rows+1 ;
	}

}

