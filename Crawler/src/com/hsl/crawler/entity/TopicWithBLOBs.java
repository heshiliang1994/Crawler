package com.hsl.crawler.entity;

public class TopicWithBLOBs extends Topic {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column topic.chinese
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String chinese;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column topic.englist
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	private String englist;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column topic.chinese
	 * @return  the value of topic.chinese
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getChinese() {
		return chinese;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column topic.chinese
	 * @param chinese  the value for topic.chinese
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column topic.englist
	 * @return  the value of topic.englist
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getEnglist() {
		return englist;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column topic.englist
	 * @param englist  the value for topic.englist
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setEnglist(String englist) {
		this.englist = englist;
	}
}