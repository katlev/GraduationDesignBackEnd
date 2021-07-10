package com.katle.design.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DefenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DefenceExample() {
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

        public Criteria andDefenceIdIsNull() {
            addCriterion("defence_id is null");
            return (Criteria) this;
        }

        public Criteria andDefenceIdIsNotNull() {
            addCriterion("defence_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceIdEqualTo(Long value) {
            addCriterion("defence_id =", value, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdNotEqualTo(Long value) {
            addCriterion("defence_id <>", value, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdGreaterThan(Long value) {
            addCriterion("defence_id >", value, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("defence_id >=", value, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdLessThan(Long value) {
            addCriterion("defence_id <", value, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdLessThanOrEqualTo(Long value) {
            addCriterion("defence_id <=", value, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdIn(List<Long> values) {
            addCriterion("defence_id in", values, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdNotIn(List<Long> values) {
            addCriterion("defence_id not in", values, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdBetween(Long value1, Long value2) {
            addCriterion("defence_id between", value1, value2, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceIdNotBetween(Long value1, Long value2) {
            addCriterion("defence_id not between", value1, value2, "defenceId");
            return (Criteria) this;
        }

        public Criteria andDefenceNameIsNull() {
            addCriterion("defence_name is null");
            return (Criteria) this;
        }

        public Criteria andDefenceNameIsNotNull() {
            addCriterion("defence_name is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceNameEqualTo(String value) {
            addCriterion("defence_name =", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameNotEqualTo(String value) {
            addCriterion("defence_name <>", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameGreaterThan(String value) {
            addCriterion("defence_name >", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameGreaterThanOrEqualTo(String value) {
            addCriterion("defence_name >=", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameLessThan(String value) {
            addCriterion("defence_name <", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameLessThanOrEqualTo(String value) {
            addCriterion("defence_name <=", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameLike(String value) {
            addCriterion("defence_name like", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameNotLike(String value) {
            addCriterion("defence_name not like", value, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameIn(List<String> values) {
            addCriterion("defence_name in", values, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameNotIn(List<String> values) {
            addCriterion("defence_name not in", values, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameBetween(String value1, String value2) {
            addCriterion("defence_name between", value1, value2, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefenceNameNotBetween(String value1, String value2) {
            addCriterion("defence_name not between", value1, value2, "defenceName");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceIsNull() {
            addCriterion("defence_place is null");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceIsNotNull() {
            addCriterion("defence_place is not null");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceEqualTo(String value) {
            addCriterion("defence_place =", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceNotEqualTo(String value) {
            addCriterion("defence_place <>", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceGreaterThan(String value) {
            addCriterion("defence_place >", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("defence_place >=", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceLessThan(String value) {
            addCriterion("defence_place <", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceLessThanOrEqualTo(String value) {
            addCriterion("defence_place <=", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceLike(String value) {
            addCriterion("defence_place like", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceNotLike(String value) {
            addCriterion("defence_place not like", value, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceIn(List<String> values) {
            addCriterion("defence_place in", values, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceNotIn(List<String> values) {
            addCriterion("defence_place not in", values, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceBetween(String value1, String value2) {
            addCriterion("defence_place between", value1, value2, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefencePlaceNotBetween(String value1, String value2) {
            addCriterion("defence_place not between", value1, value2, "defencePlace");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeIsNull() {
            addCriterion("defence_time is null");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeIsNotNull() {
            addCriterion("defence_time is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeEqualTo(Date value) {
            addCriterionForJDBCTime("defence_time =", value, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("defence_time <>", value, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("defence_time >", value, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("defence_time >=", value, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeLessThan(Date value) {
            addCriterionForJDBCTime("defence_time <", value, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("defence_time <=", value, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeIn(List<Date> values) {
            addCriterionForJDBCTime("defence_time in", values, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("defence_time not in", values, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("defence_time between", value1, value2, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("defence_time not between", value1, value2, "defenceTime");
            return (Criteria) this;
        }

        public Criteria andDefenceDateIsNull() {
            addCriterion("defence_date is null");
            return (Criteria) this;
        }

        public Criteria andDefenceDateIsNotNull() {
            addCriterion("defence_date is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceDateEqualTo(Date value) {
            addCriterionForJDBCDate("defence_date =", value, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("defence_date <>", value, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("defence_date >", value, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("defence_date >=", value, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateLessThan(Date value) {
            addCriterionForJDBCDate("defence_date <", value, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("defence_date <=", value, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateIn(List<Date> values) {
            addCriterionForJDBCDate("defence_date in", values, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("defence_date not in", values, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("defence_date between", value1, value2, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("defence_date not between", value1, value2, "defenceDate");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsIsNull() {
            addCriterion("defence_teachs is null");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsIsNotNull() {
            addCriterion("defence_teachs is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsEqualTo(String value) {
            addCriterion("defence_teachs =", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsNotEqualTo(String value) {
            addCriterion("defence_teachs <>", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsGreaterThan(String value) {
            addCriterion("defence_teachs >", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsGreaterThanOrEqualTo(String value) {
            addCriterion("defence_teachs >=", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsLessThan(String value) {
            addCriterion("defence_teachs <", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsLessThanOrEqualTo(String value) {
            addCriterion("defence_teachs <=", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsLike(String value) {
            addCriterion("defence_teachs like", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsNotLike(String value) {
            addCriterion("defence_teachs not like", value, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsIn(List<String> values) {
            addCriterion("defence_teachs in", values, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsNotIn(List<String> values) {
            addCriterion("defence_teachs not in", values, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsBetween(String value1, String value2) {
            addCriterion("defence_teachs between", value1, value2, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceTeachsNotBetween(String value1, String value2) {
            addCriterion("defence_teachs not between", value1, value2, "defenceTeachs");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsIsNull() {
            addCriterion("defence_students is null");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsIsNotNull() {
            addCriterion("defence_students is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsEqualTo(String value) {
            addCriterion("defence_students =", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsNotEqualTo(String value) {
            addCriterion("defence_students <>", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsGreaterThan(String value) {
            addCriterion("defence_students >", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsGreaterThanOrEqualTo(String value) {
            addCriterion("defence_students >=", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsLessThan(String value) {
            addCriterion("defence_students <", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsLessThanOrEqualTo(String value) {
            addCriterion("defence_students <=", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsLike(String value) {
            addCriterion("defence_students like", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsNotLike(String value) {
            addCriterion("defence_students not like", value, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsIn(List<String> values) {
            addCriterion("defence_students in", values, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsNotIn(List<String> values) {
            addCriterion("defence_students not in", values, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsBetween(String value1, String value2) {
            addCriterion("defence_students between", value1, value2, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceStudentsNotBetween(String value1, String value2) {
            addCriterion("defence_students not between", value1, value2, "defenceStudents");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderIsNull() {
            addCriterion("defence_leader is null");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderIsNotNull() {
            addCriterion("defence_leader is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderEqualTo(String value) {
            addCriterion("defence_leader =", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderNotEqualTo(String value) {
            addCriterion("defence_leader <>", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderGreaterThan(String value) {
            addCriterion("defence_leader >", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("defence_leader >=", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderLessThan(String value) {
            addCriterion("defence_leader <", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderLessThanOrEqualTo(String value) {
            addCriterion("defence_leader <=", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderLike(String value) {
            addCriterion("defence_leader like", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderNotLike(String value) {
            addCriterion("defence_leader not like", value, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderIn(List<String> values) {
            addCriterion("defence_leader in", values, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderNotIn(List<String> values) {
            addCriterion("defence_leader not in", values, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderBetween(String value1, String value2) {
            addCriterion("defence_leader between", value1, value2, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceLeaderNotBetween(String value1, String value2) {
            addCriterion("defence_leader not between", value1, value2, "defenceLeader");
            return (Criteria) this;
        }

        public Criteria andDefenceYearIsNull() {
            addCriterion("defence_year is null");
            return (Criteria) this;
        }

        public Criteria andDefenceYearIsNotNull() {
            addCriterion("defence_year is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceYearEqualTo(String value) {
            addCriterion("defence_year =", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearNotEqualTo(String value) {
            addCriterion("defence_year <>", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearGreaterThan(String value) {
            addCriterion("defence_year >", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearGreaterThanOrEqualTo(String value) {
            addCriterion("defence_year >=", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearLessThan(String value) {
            addCriterion("defence_year <", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearLessThanOrEqualTo(String value) {
            addCriterion("defence_year <=", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearLike(String value) {
            addCriterion("defence_year like", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearNotLike(String value) {
            addCriterion("defence_year not like", value, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearIn(List<String> values) {
            addCriterion("defence_year in", values, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearNotIn(List<String> values) {
            addCriterion("defence_year not in", values, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearBetween(String value1, String value2) {
            addCriterion("defence_year between", value1, value2, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andDefenceYearNotBetween(String value1, String value2) {
            addCriterion("defence_year not between", value1, value2, "defenceYear");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
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