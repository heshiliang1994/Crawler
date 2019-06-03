package com.hsl.crawler.entity;

import java.util.Date;

public class Page {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.pageId
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private Integer pageid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.topicId
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private Integer topicid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.page
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private Integer page;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.url
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.status
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.time
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private Date time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column page.html
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String html;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.pageId
	 * @return  the value of page.pageId
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Integer getPageid() {
		return pageid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.pageId
	 * @param pageid  the value for page.pageId
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setPageid(Integer pageid) {
		this.pageid = pageid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.topicId
	 * @return  the value of page.topicId
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Integer getTopicid() {
		return topicid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.topicId
	 * @param topicid  the value for page.topicId
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.page
	 * @return  the value of page.page
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.page
	 * @param page  the value for page.page
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.url
	 * @return  the value of page.url
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.url
	 * @param url  the value for page.url
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.status
	 * @return  the value of page.status
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.status
	 * @param status  the value for page.status
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.time
	 * @return  the value of page.time
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.time
	 * @param time  the value for page.time
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column page.html
	 * @return  the value of page.html
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column page.html
	 * @param html  the value for page.html
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setHtml(String html) {
		this.html = html;
	}
}