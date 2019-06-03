package com.hsl.crawler.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public TopicExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andTopicidIsNull() {
			addCriterion("topicId is null");
			return (Criteria) this;
		}

		public Criteria andTopicidIsNotNull() {
			addCriterion("topicId is not null");
			return (Criteria) this;
		}

		public Criteria andTopicidEqualTo(Integer value) {
			addCriterion("topicId =", value, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidNotEqualTo(Integer value) {
			addCriterion("topicId <>", value, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidGreaterThan(Integer value) {
			addCriterion("topicId >", value, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidGreaterThanOrEqualTo(Integer value) {
			addCriterion("topicId >=", value, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidLessThan(Integer value) {
			addCriterion("topicId <", value, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidLessThanOrEqualTo(Integer value) {
			addCriterion("topicId <=", value, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidIn(List<Integer> values) {
			addCriterion("topicId in", values, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidNotIn(List<Integer> values) {
			addCriterion("topicId not in", values, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidBetween(Integer value1, Integer value2) {
			addCriterion("topicId between", value1, value2, "topicid");
			return (Criteria) this;
		}

		public Criteria andTopicidNotBetween(Integer value1, Integer value2) {
			addCriterion("topicId not between", value1, value2, "topicid");
			return (Criteria) this;
		}

		public Criteria andKeywordIsNull() {
			addCriterion("keyword is null");
			return (Criteria) this;
		}

		public Criteria andKeywordIsNotNull() {
			addCriterion("keyword is not null");
			return (Criteria) this;
		}

		public Criteria andKeywordEqualTo(String value) {
			addCriterion("keyword =", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordNotEqualTo(String value) {
			addCriterion("keyword <>", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordGreaterThan(String value) {
			addCriterion("keyword >", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordGreaterThanOrEqualTo(String value) {
			addCriterion("keyword >=", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordLessThan(String value) {
			addCriterion("keyword <", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordLessThanOrEqualTo(String value) {
			addCriterion("keyword <=", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordLike(String value) {
			addCriterion("keyword like", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordNotLike(String value) {
			addCriterion("keyword not like", value, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordIn(List<String> values) {
			addCriterion("keyword in", values, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordNotIn(List<String> values) {
			addCriterion("keyword not in", values, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordBetween(String value1, String value2) {
			addCriterion("keyword between", value1, value2, "keyword");
			return (Criteria) this;
		}

		public Criteria andKeywordNotBetween(String value1, String value2) {
			addCriterion("keyword not between", value1, value2, "keyword");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andTimeIsNull() {
			addCriterion("time is null");
			return (Criteria) this;
		}

		public Criteria andTimeIsNotNull() {
			addCriterion("time is not null");
			return (Criteria) this;
		}

		public Criteria andTimeEqualTo(Date value) {
			addCriterion("time =", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotEqualTo(Date value) {
			addCriterion("time <>", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThan(Date value) {
			addCriterion("time >", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("time >=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThan(Date value) {
			addCriterion("time <", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThanOrEqualTo(Date value) {
			addCriterion("time <=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeIn(List<Date> values) {
			addCriterion("time in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotIn(List<Date> values) {
			addCriterion("time not in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeBetween(Date value1, Date value2) {
			addCriterion("time between", value1, value2, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotBetween(Date value1, Date value2) {
			addCriterion("time not between", value1, value2, "time");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table topic
	 * @mbggenerated  Sun Jun 02 14:07:59 CST 2019
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table topic
     *
     * @mbggenerated do_not_delete_during_merge Fri May 31 16:36:05 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}