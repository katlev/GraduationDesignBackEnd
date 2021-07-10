package com.katle.design.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LeaveMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaveMessageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Long value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Long value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Long value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Long value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Long> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Long> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Long value1, Long value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Long value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Long value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Long value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Long value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Long value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Long> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Long> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Long value1, Long value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Long value1, Long value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuMessageIsNull() {
            addCriterion("stu_message is null");
            return (Criteria) this;
        }

        public Criteria andStuMessageIsNotNull() {
            addCriterion("stu_message is not null");
            return (Criteria) this;
        }

        public Criteria andStuMessageEqualTo(String value) {
            addCriterion("stu_message =", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotEqualTo(String value) {
            addCriterion("stu_message <>", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageGreaterThan(String value) {
            addCriterion("stu_message >", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageGreaterThanOrEqualTo(String value) {
            addCriterion("stu_message >=", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageLessThan(String value) {
            addCriterion("stu_message <", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageLessThanOrEqualTo(String value) {
            addCriterion("stu_message <=", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageLike(String value) {
            addCriterion("stu_message like", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotLike(String value) {
            addCriterion("stu_message not like", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageIn(List<String> values) {
            addCriterion("stu_message in", values, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotIn(List<String> values) {
            addCriterion("stu_message not in", values, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageBetween(String value1, String value2) {
            addCriterion("stu_message between", value1, value2, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotBetween(String value1, String value2) {
            addCriterion("stu_message not between", value1, value2, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuDateIsNull() {
            addCriterion("stu_date is null");
            return (Criteria) this;
        }

        public Criteria andStuDateIsNotNull() {
            addCriterion("stu_date is not null");
            return (Criteria) this;
        }

        public Criteria andStuDateEqualTo(Date value) {
            addCriterionForJDBCDate("stu_date =", value, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_date <>", value, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_date >", value, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_date >=", value, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateLessThan(Date value) {
            addCriterionForJDBCDate("stu_date <", value, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_date <=", value, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateIn(List<Date> values) {
            addCriterionForJDBCDate("stu_date in", values, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_date not in", values, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_date between", value1, value2, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_date not between", value1, value2, "stuDate");
            return (Criteria) this;
        }

        public Criteria andStuTimeIsNull() {
            addCriterion("stu_time is null");
            return (Criteria) this;
        }

        public Criteria andStuTimeIsNotNull() {
            addCriterion("stu_time is not null");
            return (Criteria) this;
        }

        public Criteria andStuTimeEqualTo(Date value) {
            addCriterionForJDBCTime("stu_time =", value, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("stu_time <>", value, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("stu_time >", value, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("stu_time >=", value, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeLessThan(Date value) {
            addCriterionForJDBCTime("stu_time <", value, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("stu_time <=", value, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeIn(List<Date> values) {
            addCriterionForJDBCTime("stu_time in", values, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("stu_time not in", values, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("stu_time between", value1, value2, "stuTime");
            return (Criteria) this;
        }

        public Criteria andStuTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("stu_time not between", value1, value2, "stuTime");
            return (Criteria) this;
        }

        public Criteria andTeachIdIsNull() {
            addCriterion("teach_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachIdIsNotNull() {
            addCriterion("teach_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachIdEqualTo(Long value) {
            addCriterion("teach_id =", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotEqualTo(Long value) {
            addCriterion("teach_id <>", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdGreaterThan(Long value) {
            addCriterion("teach_id >", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teach_id >=", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdLessThan(Long value) {
            addCriterion("teach_id <", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdLessThanOrEqualTo(Long value) {
            addCriterion("teach_id <=", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdIn(List<Long> values) {
            addCriterion("teach_id in", values, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotIn(List<Long> values) {
            addCriterion("teach_id not in", values, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdBetween(Long value1, Long value2) {
            addCriterion("teach_id between", value1, value2, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotBetween(Long value1, Long value2) {
            addCriterion("teach_id not between", value1, value2, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachMessageIsNull() {
            addCriterion("teach_message is null");
            return (Criteria) this;
        }

        public Criteria andTeachMessageIsNotNull() {
            addCriterion("teach_message is not null");
            return (Criteria) this;
        }

        public Criteria andTeachMessageEqualTo(String value) {
            addCriterion("teach_message =", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageNotEqualTo(String value) {
            addCriterion("teach_message <>", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageGreaterThan(String value) {
            addCriterion("teach_message >", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageGreaterThanOrEqualTo(String value) {
            addCriterion("teach_message >=", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageLessThan(String value) {
            addCriterion("teach_message <", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageLessThanOrEqualTo(String value) {
            addCriterion("teach_message <=", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageLike(String value) {
            addCriterion("teach_message like", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageNotLike(String value) {
            addCriterion("teach_message not like", value, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageIn(List<String> values) {
            addCriterion("teach_message in", values, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageNotIn(List<String> values) {
            addCriterion("teach_message not in", values, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageBetween(String value1, String value2) {
            addCriterion("teach_message between", value1, value2, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachMessageNotBetween(String value1, String value2) {
            addCriterion("teach_message not between", value1, value2, "teachMessage");
            return (Criteria) this;
        }

        public Criteria andTeachDateIsNull() {
            addCriterion("teach_date is null");
            return (Criteria) this;
        }

        public Criteria andTeachDateIsNotNull() {
            addCriterion("teach_date is not null");
            return (Criteria) this;
        }

        public Criteria andTeachDateEqualTo(Date value) {
            addCriterionForJDBCDate("teach_date =", value, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("teach_date <>", value, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateGreaterThan(Date value) {
            addCriterionForJDBCDate("teach_date >", value, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teach_date >=", value, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateLessThan(Date value) {
            addCriterionForJDBCDate("teach_date <", value, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teach_date <=", value, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateIn(List<Date> values) {
            addCriterionForJDBCDate("teach_date in", values, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("teach_date not in", values, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teach_date between", value1, value2, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teach_date not between", value1, value2, "teachDate");
            return (Criteria) this;
        }

        public Criteria andTeachTimeIsNull() {
            addCriterion("teach_time is null");
            return (Criteria) this;
        }

        public Criteria andTeachTimeIsNotNull() {
            addCriterion("teach_time is not null");
            return (Criteria) this;
        }

        public Criteria andTeachTimeEqualTo(Date value) {
            addCriterionForJDBCTime("teach_time =", value, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("teach_time <>", value, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("teach_time >", value, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("teach_time >=", value, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeLessThan(Date value) {
            addCriterionForJDBCTime("teach_time <", value, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("teach_time <=", value, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeIn(List<Date> values) {
            addCriterionForJDBCTime("teach_time in", values, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("teach_time not in", values, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("teach_time between", value1, value2, "teachTime");
            return (Criteria) this;
        }

        public Criteria andTeachTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("teach_time not between", value1, value2, "teachTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}