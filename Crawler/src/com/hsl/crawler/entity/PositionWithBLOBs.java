package com.hsl.crawler.entity;

public class PositionWithBLOBs extends Position {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.html
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String html;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.content
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.split
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String split;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.html
	 * @return  the value of position.html
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.html
	 * @param html  the value for position.html
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.content
	 * @return  the value of position.content
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.content
	 * @param content  the value for position.content
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.split
	 * @return  the value of position.split
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getSplit() {
		return split;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.split
	 * @param split  the value for position.split
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setSplit(String split) {
		this.split = split;
	}
}