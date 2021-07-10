package com.katle.design.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GuidanceFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuidanceFileExample() {
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

        public Criteria andGuidanceIdIsNull() {
            addCriterion("guidance_id is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdIsNotNull() {
            addCriterion("guidance_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdEqualTo(Long value) {
            addCriterion("guidance_id =", value, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdNotEqualTo(Long value) {
            addCriterion("guidance_id <>", value, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdGreaterThan(Long value) {
            addCriterion("guidance_id >", value, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("guidance_id >=", value, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdLessThan(Long value) {
            addCriterion("guidance_id <", value, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdLessThanOrEqualTo(Long value) {
            addCriterion("guidance_id <=", value, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdIn(List<Long> values) {
            addCriterion("guidance_id in", values, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdNotIn(List<Long> values) {
            addCriterion("guidance_id not in", values, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdBetween(Long value1, Long value2) {
            addCriterion("guidance_id between", value1, value2, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andGuidanceIdNotBetween(Long value1, Long value2) {
            addCriterion("guidance_id not between", value1, value2, "guidanceId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameIsNull() {
            addCriterion("guidance_name is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameIsNotNull() {
            addCriterion("guidance_name is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameEqualTo(String value) {
            addCriterion("guidance_name =", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameNotEqualTo(String value) {
            addCriterion("guidance_name <>", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameGreaterThan(String value) {
            addCriterion("guidance_name >", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_name >=", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameLessThan(String value) {
            addCriterion("guidance_name <", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameLessThanOrEqualTo(String value) {
            addCriterion("guidance_name <=", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameLike(String value) {
            addCriterion("guidance_name like", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameNotLike(String value) {
            addCriterion("guidance_name not like", value, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameIn(List<String> values) {
            addCriterion("guidance_name in", values, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameNotIn(List<String> values) {
            addCriterion("guidance_name not in", values, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameBetween(String value1, String value2) {
            addCriterion("guidance_name between", value1, value2, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidanceNameNotBetween(String value1, String value2) {
            addCriterion("guidance_name not between", value1, value2, "guidanceName");
            return (Criteria) this;
        }

        public Criteria andGuidancePathIsNull() {
            addCriterion("guidance_path is null");
            return (Criteria) this;
        }

        public Criteria andGuidancePathIsNotNull() {
            addCriterion("guidance_path is not null");
            return (Criteria) this;
        }

        public Criteria andGuidancePathEqualTo(String value) {
            addCriterion("guidance_path =", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathNotEqualTo(String value) {
            addCriterion("guidance_path <>", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathGreaterThan(String value) {
            addCriterion("guidance_path >", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_path >=", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathLessThan(String value) {
            addCriterion("guidance_path <", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathLessThanOrEqualTo(String value) {
            addCriterion("guidance_path <=", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathLike(String value) {
            addCriterion("guidance_path like", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathNotLike(String value) {
            addCriterion("guidance_path not like", value, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathIn(List<String> values) {
            addCriterion("guidance_path in", values, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathNotIn(List<String> values) {
            addCriterion("guidance_path not in", values, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathBetween(String value1, String value2) {
            addCriterion("guidance_path between", value1, value2, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidancePathNotBetween(String value1, String value2) {
            addCriterion("guidance_path not between", value1, value2, "guidancePath");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateIsNull() {
            addCriterion("guidance_date is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateIsNotNull() {
            addCriterion("guidance_date is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateEqualTo(Date value) {
            addCriterionForJDBCDate("guidance_date =", value, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("guidance_date <>", value, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("guidance_date >", value, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("guidance_date >=", value, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateLessThan(Date value) {
            addCriterionForJDBCDate("guidance_date <", value, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("guidance_date <=", value, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateIn(List<Date> values) {
            addCriterionForJDBCDate("guidance_date in", values, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("guidance_date not in", values, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("guidance_date between", value1, value2, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("guidance_date not between", value1, value2, "guidanceDate");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormIsNull() {
            addCriterion("guidance_form is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormIsNotNull() {
            addCriterion("guidance_form is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormEqualTo(String value) {
            addCriterion("guidance_form =", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormNotEqualTo(String value) {
            addCriterion("guidance_form <>", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormGreaterThan(String value) {
            addCriterion("guidance_form >", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_form >=", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormLessThan(String value) {
            addCriterion("guidance_form <", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormLessThanOrEqualTo(String value) {
            addCriterion("guidance_form <=", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormLike(String value) {
            addCriterion("guidance_form like", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormNotLike(String value) {
            addCriterion("guidance_form not like", value, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormIn(List<String> values) {
            addCriterion("guidance_form in", values, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormNotIn(List<String> values) {
            addCriterion("guidance_form not in", values, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormBetween(String value1, String value2) {
            addCriterion("guidance_form between", value1, value2, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceFormNotBetween(String value1, String value2) {
            addCriterion("guidance_form not between", value1, value2, "guidanceForm");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueIsNull() {
            addCriterion("guidance_value is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueIsNotNull() {
            addCriterion("guidance_value is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueEqualTo(String value) {
            addCriterion("guidance_value =", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueNotEqualTo(String value) {
            addCriterion("guidance_value <>", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueGreaterThan(String value) {
            addCriterion("guidance_value >", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_value >=", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueLessThan(String value) {
            addCriterion("guidance_value <", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueLessThanOrEqualTo(String value) {
            addCriterion("guidance_value <=", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueLike(String value) {
            addCriterion("guidance_value like", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueNotLike(String value) {
            addCriterion("guidance_value not like", value, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueIn(List<String> values) {
            addCriterion("guidance_value in", values, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueNotIn(List<String> values) {
            addCriterion("guidance_value not in", values, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueBetween(String value1, String value2) {
            addCriterion("guidance_value between", value1, value2, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceValueNotBetween(String value1, String value2) {
            addCriterion("guidance_value not between", value1, value2, "guidanceValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckIsNull() {
            addCriterion("guidance_check is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckIsNotNull() {
            addCriterion("guidance_check is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckEqualTo(Integer value) {
            addCriterion("guidance_check =", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckNotEqualTo(Integer value) {
            addCriterion("guidance_check <>", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckGreaterThan(Integer value) {
            addCriterion("guidance_check >", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("guidance_check >=", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckLessThan(Integer value) {
            addCriterion("guidance_check <", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckLessThanOrEqualTo(Integer value) {
            addCriterion("guidance_check <=", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckIn(List<Integer> values) {
            addCriterion("guidance_check in", values, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckNotIn(List<Integer> values) {
            addCriterion("guidance_check not in", values, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckBetween(Integer value1, Integer value2) {
            addCriterion("guidance_check between", value1, value2, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("guidance_check not between", value1, value2, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionIsNull() {
            addCriterion("guidance_opinion is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionIsNotNull() {
            addCriterion("guidance_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionEqualTo(String value) {
            addCriterion("guidance_opinion =", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionNotEqualTo(String value) {
            addCriterion("guidance_opinion <>", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionGreaterThan(String value) {
            addCriterion("guidance_opinion >", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_opinion >=", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionLessThan(String value) {
            addCriterion("guidance_opinion <", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionLessThanOrEqualTo(String value) {
            addCriterion("guidance_opinion <=", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionLike(String value) {
            addCriterion("guidance_opinion like", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionNotLike(String value) {
            addCriterion("guidance_opinion not like", value, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionIn(List<String> values) {
            addCriterion("guidance_opinion in", values, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionNotIn(List<String> values) {
            addCriterion("guidance_opinion not in", values, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionBetween(String value1, String value2) {
            addCriterion("guidance_opinion between", value1, value2, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceOpinionNotBetween(String value1, String value2) {
            addCriterion("guidance_opinion not between", value1, value2, "guidanceOpinion");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManIsNull() {
            addCriterion("guidance_check_man is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManIsNotNull() {
            addCriterion("guidance_check_man is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManEqualTo(Long value) {
            addCriterion("guidance_check_man =", value, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManNotEqualTo(Long value) {
            addCriterion("guidance_check_man <>", value, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManGreaterThan(Long value) {
            addCriterion("guidance_check_man >", value, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManGreaterThanOrEqualTo(Long value) {
            addCriterion("guidance_check_man >=", value, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManLessThan(Long value) {
            addCriterion("guidance_check_man <", value, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManLessThanOrEqualTo(Long value) {
            addCriterion("guidance_check_man <=", value, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManIn(List<Long> values) {
            addCriterion("guidance_check_man in", values, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManNotIn(List<Long> values) {
            addCriterion("guidance_check_man not in", values, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManBetween(Long value1, Long value2) {
            addCriterion("guidance_check_man between", value1, value2, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckManNotBetween(Long value1, Long value2) {
            addCriterion("guidance_check_man not between", value1, value2, "guidanceCheckMan");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearIsNull() {
            addCriterion("guidance_year is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearIsNotNull() {
            addCriterion("guidance_year is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearEqualTo(String value) {
            addCriterion("guidance_year =", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearNotEqualTo(String value) {
            addCriterion("guidance_year <>", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearGreaterThan(String value) {
            addCriterion("guidance_year >", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_year >=", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearLessThan(String value) {
            addCriterion("guidance_year <", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearLessThanOrEqualTo(String value) {
            addCriterion("guidance_year <=", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearLike(String value) {
            addCriterion("guidance_year like", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearNotLike(String value) {
            addCriterion("guidance_year not like", value, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearIn(List<String> values) {
            addCriterion("guidance_year in", values, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearNotIn(List<String> values) {
            addCriterion("guidance_year not in", values, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearBetween(String value1, String value2) {
            addCriterion("guidance_year between", value1, value2, "guidanceYear");
            return (Criteria) this;
        }

        public Criteria andGuidanceYearNotBetween(String value1, String value2) {
            addCriterion("guidance_year not between", value1, value2, "guidanceYear");
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