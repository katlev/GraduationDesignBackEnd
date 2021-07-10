package com.katle.design.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OpenDefenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenDefenceExample() {
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(Long value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(Long value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(Long value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(Long value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(Long value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(Long value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<Long> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<Long> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(Long value1, Long value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(Long value1, Long value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenNameIsNull() {
            addCriterion("open_name is null");
            return (Criteria) this;
        }

        public Criteria andOpenNameIsNotNull() {
            addCriterion("open_name is not null");
            return (Criteria) this;
        }

        public Criteria andOpenNameEqualTo(String value) {
            addCriterion("open_name =", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameNotEqualTo(String value) {
            addCriterion("open_name <>", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameGreaterThan(String value) {
            addCriterion("open_name >", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameGreaterThanOrEqualTo(String value) {
            addCriterion("open_name >=", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameLessThan(String value) {
            addCriterion("open_name <", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameLessThanOrEqualTo(String value) {
            addCriterion("open_name <=", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameLike(String value) {
            addCriterion("open_name like", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameNotLike(String value) {
            addCriterion("open_name not like", value, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameIn(List<String> values) {
            addCriterion("open_name in", values, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameNotIn(List<String> values) {
            addCriterion("open_name not in", values, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameBetween(String value1, String value2) {
            addCriterion("open_name between", value1, value2, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenNameNotBetween(String value1, String value2) {
            addCriterion("open_name not between", value1, value2, "openName");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceIsNull() {
            addCriterion("open_place is null");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceIsNotNull() {
            addCriterion("open_place is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceEqualTo(String value) {
            addCriterion("open_place =", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceNotEqualTo(String value) {
            addCriterion("open_place <>", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceGreaterThan(String value) {
            addCriterion("open_place >", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("open_place >=", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceLessThan(String value) {
            addCriterion("open_place <", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceLessThanOrEqualTo(String value) {
            addCriterion("open_place <=", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceLike(String value) {
            addCriterion("open_place like", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceNotLike(String value) {
            addCriterion("open_place not like", value, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceIn(List<String> values) {
            addCriterion("open_place in", values, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceNotIn(List<String> values) {
            addCriterion("open_place not in", values, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceBetween(String value1, String value2) {
            addCriterion("open_place between", value1, value2, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenPlaceNotBetween(String value1, String value2) {
            addCriterion("open_place not between", value1, value2, "openPlace");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterionForJDBCTime("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterionForJDBCTime("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterionForJDBCTime("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("open_date is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("open_date is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterionForJDBCDate("open_date =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("open_date <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterionForJDBCDate("open_date >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("open_date >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterionForJDBCDate("open_date <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("open_date <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterionForJDBCDate("open_date in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("open_date not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("open_date between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("open_date not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsIsNull() {
            addCriterion("open_teachs is null");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsIsNotNull() {
            addCriterion("open_teachs is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsEqualTo(String value) {
            addCriterion("open_teachs =", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsNotEqualTo(String value) {
            addCriterion("open_teachs <>", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsGreaterThan(String value) {
            addCriterion("open_teachs >", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsGreaterThanOrEqualTo(String value) {
            addCriterion("open_teachs >=", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsLessThan(String value) {
            addCriterion("open_teachs <", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsLessThanOrEqualTo(String value) {
            addCriterion("open_teachs <=", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsLike(String value) {
            addCriterion("open_teachs like", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsNotLike(String value) {
            addCriterion("open_teachs not like", value, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsIn(List<String> values) {
            addCriterion("open_teachs in", values, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsNotIn(List<String> values) {
            addCriterion("open_teachs not in", values, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsBetween(String value1, String value2) {
            addCriterion("open_teachs between", value1, value2, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenTeachsNotBetween(String value1, String value2) {
            addCriterion("open_teachs not between", value1, value2, "openTeachs");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsIsNull() {
            addCriterion("open_students is null");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsIsNotNull() {
            addCriterion("open_students is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsEqualTo(String value) {
            addCriterion("open_students =", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsNotEqualTo(String value) {
            addCriterion("open_students <>", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsGreaterThan(String value) {
            addCriterion("open_students >", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsGreaterThanOrEqualTo(String value) {
            addCriterion("open_students >=", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsLessThan(String value) {
            addCriterion("open_students <", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsLessThanOrEqualTo(String value) {
            addCriterion("open_students <=", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsLike(String value) {
            addCriterion("open_students like", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsNotLike(String value) {
            addCriterion("open_students not like", value, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsIn(List<String> values) {
            addCriterion("open_students in", values, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsNotIn(List<String> values) {
            addCriterion("open_students not in", values, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsBetween(String value1, String value2) {
            addCriterion("open_students between", value1, value2, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenStudentsNotBetween(String value1, String value2) {
            addCriterion("open_students not between", value1, value2, "openStudents");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderIsNull() {
            addCriterion("open_leader is null");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderIsNotNull() {
            addCriterion("open_leader is not null");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderEqualTo(String value) {
            addCriterion("open_leader =", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderNotEqualTo(String value) {
            addCriterion("open_leader <>", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderGreaterThan(String value) {
            addCriterion("open_leader >", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("open_leader >=", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderLessThan(String value) {
            addCriterion("open_leader <", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderLessThanOrEqualTo(String value) {
            addCriterion("open_leader <=", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderLike(String value) {
            addCriterion("open_leader like", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderNotLike(String value) {
            addCriterion("open_leader not like", value, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderIn(List<String> values) {
            addCriterion("open_leader in", values, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderNotIn(List<String> values) {
            addCriterion("open_leader not in", values, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderBetween(String value1, String value2) {
            addCriterion("open_leader between", value1, value2, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenLeaderNotBetween(String value1, String value2) {
            addCriterion("open_leader not between", value1, value2, "openLeader");
            return (Criteria) this;
        }

        public Criteria andOpenYearIsNull() {
            addCriterion("open_year is null");
            return (Criteria) this;
        }

        public Criteria andOpenYearIsNotNull() {
            addCriterion("open_year is not null");
            return (Criteria) this;
        }

        public Criteria andOpenYearEqualTo(String value) {
            addCriterion("open_year =", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearNotEqualTo(String value) {
            addCriterion("open_year <>", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearGreaterThan(String value) {
            addCriterion("open_year >", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearGreaterThanOrEqualTo(String value) {
            addCriterion("open_year >=", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearLessThan(String value) {
            addCriterion("open_year <", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearLessThanOrEqualTo(String value) {
            addCriterion("open_year <=", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearLike(String value) {
            addCriterion("open_year like", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearNotLike(String value) {
            addCriterion("open_year not like", value, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearIn(List<String> values) {
            addCriterion("open_year in", values, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearNotIn(List<String> values) {
            addCriterion("open_year not in", values, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearBetween(String value1, String value2) {
            addCriterion("open_year between", value1, value2, "openYear");
            return (Criteria) this;
        }

        public Criteria andOpenYearNotBetween(String value1, String value2) {
            addCriterion("open_year not between", value1, value2, "openYear");
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