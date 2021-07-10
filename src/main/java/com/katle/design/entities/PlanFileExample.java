package com.katle.design.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PlanFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanFileExample() {
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
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

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanPathIsNull() {
            addCriterion("plan_path is null");
            return (Criteria) this;
        }

        public Criteria andPlanPathIsNotNull() {
            addCriterion("plan_path is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPathEqualTo(String value) {
            addCriterion("plan_path =", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathNotEqualTo(String value) {
            addCriterion("plan_path <>", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathGreaterThan(String value) {
            addCriterion("plan_path >", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathGreaterThanOrEqualTo(String value) {
            addCriterion("plan_path >=", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathLessThan(String value) {
            addCriterion("plan_path <", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathLessThanOrEqualTo(String value) {
            addCriterion("plan_path <=", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathLike(String value) {
            addCriterion("plan_path like", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathNotLike(String value) {
            addCriterion("plan_path not like", value, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathIn(List<String> values) {
            addCriterion("plan_path in", values, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathNotIn(List<String> values) {
            addCriterion("plan_path not in", values, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathBetween(String value1, String value2) {
            addCriterion("plan_path between", value1, value2, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanPathNotBetween(String value1, String value2) {
            addCriterion("plan_path not between", value1, value2, "planPath");
            return (Criteria) this;
        }

        public Criteria andPlanStartIsNull() {
            addCriterion("plan_start is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartIsNotNull() {
            addCriterion("plan_start is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartEqualTo(Date value) {
            addCriterionForJDBCDate("plan_start =", value, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_start <>", value, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_start >", value, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_start >=", value, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartLessThan(Date value) {
            addCriterionForJDBCDate("plan_start <", value, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_start <=", value, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartIn(List<Date> values) {
            addCriterionForJDBCDate("plan_start in", values, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_start not in", values, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_start between", value1, value2, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_start not between", value1, value2, "planStart");
            return (Criteria) this;
        }

        public Criteria andPlanEndIsNull() {
            addCriterion("plan_end is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndIsNotNull() {
            addCriterion("plan_end is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end =", value, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end <>", value, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_end >", value, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end >=", value, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndLessThan(Date value) {
            addCriterionForJDBCDate("plan_end <", value, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_end <=", value, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndIn(List<Date> values) {
            addCriterionForJDBCDate("plan_end in", values, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_end not in", values, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_end between", value1, value2, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_end not between", value1, value2, "planEnd");
            return (Criteria) this;
        }

        public Criteria andPlanValueIsNull() {
            addCriterion("plan_value is null");
            return (Criteria) this;
        }

        public Criteria andPlanValueIsNotNull() {
            addCriterion("plan_value is not null");
            return (Criteria) this;
        }

        public Criteria andPlanValueEqualTo(String value) {
            addCriterion("plan_value =", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotEqualTo(String value) {
            addCriterion("plan_value <>", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueGreaterThan(String value) {
            addCriterion("plan_value >", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueGreaterThanOrEqualTo(String value) {
            addCriterion("plan_value >=", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueLessThan(String value) {
            addCriterion("plan_value <", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueLessThanOrEqualTo(String value) {
            addCriterion("plan_value <=", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueLike(String value) {
            addCriterion("plan_value like", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotLike(String value) {
            addCriterion("plan_value not like", value, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueIn(List<String> values) {
            addCriterion("plan_value in", values, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotIn(List<String> values) {
            addCriterion("plan_value not in", values, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueBetween(String value1, String value2) {
            addCriterion("plan_value between", value1, value2, "planValue");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotBetween(String value1, String value2) {
            addCriterion("plan_value not between", value1, value2, "planValue");
            return (Criteria) this;
        }

        public Criteria andActualValueIsNull() {
            addCriterion("actual_value is null");
            return (Criteria) this;
        }

        public Criteria andActualValueIsNotNull() {
            addCriterion("actual_value is not null");
            return (Criteria) this;
        }

        public Criteria andActualValueEqualTo(String value) {
            addCriterion("actual_value =", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotEqualTo(String value) {
            addCriterion("actual_value <>", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueGreaterThan(String value) {
            addCriterion("actual_value >", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueGreaterThanOrEqualTo(String value) {
            addCriterion("actual_value >=", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueLessThan(String value) {
            addCriterion("actual_value <", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueLessThanOrEqualTo(String value) {
            addCriterion("actual_value <=", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueLike(String value) {
            addCriterion("actual_value like", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotLike(String value) {
            addCriterion("actual_value not like", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueIn(List<String> values) {
            addCriterion("actual_value in", values, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotIn(List<String> values) {
            addCriterion("actual_value not in", values, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueBetween(String value1, String value2) {
            addCriterion("actual_value between", value1, value2, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotBetween(String value1, String value2) {
            addCriterion("actual_value not between", value1, value2, "actualValue");
            return (Criteria) this;
        }

        public Criteria andPlanCheckIsNull() {
            addCriterion("plan_check is null");
            return (Criteria) this;
        }

        public Criteria andPlanCheckIsNotNull() {
            addCriterion("plan_check is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCheckEqualTo(Integer value) {
            addCriterion("plan_check =", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckNotEqualTo(Integer value) {
            addCriterion("plan_check <>", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckGreaterThan(Integer value) {
            addCriterion("plan_check >", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_check >=", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckLessThan(Integer value) {
            addCriterion("plan_check <", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckLessThanOrEqualTo(Integer value) {
            addCriterion("plan_check <=", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckIn(List<Integer> values) {
            addCriterion("plan_check in", values, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckNotIn(List<Integer> values) {
            addCriterion("plan_check not in", values, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckBetween(Integer value1, Integer value2) {
            addCriterion("plan_check between", value1, value2, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_check not between", value1, value2, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionIsNull() {
            addCriterion("plan_opinion is null");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionIsNotNull() {
            addCriterion("plan_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionEqualTo(String value) {
            addCriterion("plan_opinion =", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionNotEqualTo(String value) {
            addCriterion("plan_opinion <>", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionGreaterThan(String value) {
            addCriterion("plan_opinion >", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("plan_opinion >=", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionLessThan(String value) {
            addCriterion("plan_opinion <", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionLessThanOrEqualTo(String value) {
            addCriterion("plan_opinion <=", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionLike(String value) {
            addCriterion("plan_opinion like", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionNotLike(String value) {
            addCriterion("plan_opinion not like", value, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionIn(List<String> values) {
            addCriterion("plan_opinion in", values, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionNotIn(List<String> values) {
            addCriterion("plan_opinion not in", values, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionBetween(String value1, String value2) {
            addCriterion("plan_opinion between", value1, value2, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanOpinionNotBetween(String value1, String value2) {
            addCriterion("plan_opinion not between", value1, value2, "planOpinion");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManIsNull() {
            addCriterion("plan_check_man is null");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManIsNotNull() {
            addCriterion("plan_check_man is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManEqualTo(Long value) {
            addCriterion("plan_check_man =", value, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManNotEqualTo(Long value) {
            addCriterion("plan_check_man <>", value, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManGreaterThan(Long value) {
            addCriterion("plan_check_man >", value, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_check_man >=", value, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManLessThan(Long value) {
            addCriterion("plan_check_man <", value, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManLessThanOrEqualTo(Long value) {
            addCriterion("plan_check_man <=", value, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManIn(List<Long> values) {
            addCriterion("plan_check_man in", values, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManNotIn(List<Long> values) {
            addCriterion("plan_check_man not in", values, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManBetween(Long value1, Long value2) {
            addCriterion("plan_check_man between", value1, value2, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanCheckManNotBetween(Long value1, Long value2) {
            addCriterion("plan_check_man not between", value1, value2, "planCheckMan");
            return (Criteria) this;
        }

        public Criteria andPlanYearIsNull() {
            addCriterion("plan_year is null");
            return (Criteria) this;
        }

        public Criteria andPlanYearIsNotNull() {
            addCriterion("plan_year is not null");
            return (Criteria) this;
        }

        public Criteria andPlanYearEqualTo(String value) {
            addCriterion("plan_year =", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotEqualTo(String value) {
            addCriterion("plan_year <>", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearGreaterThan(String value) {
            addCriterion("plan_year >", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearGreaterThanOrEqualTo(String value) {
            addCriterion("plan_year >=", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLessThan(String value) {
            addCriterion("plan_year <", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLessThanOrEqualTo(String value) {
            addCriterion("plan_year <=", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLike(String value) {
            addCriterion("plan_year like", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotLike(String value) {
            addCriterion("plan_year not like", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearIn(List<String> values) {
            addCriterion("plan_year in", values, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotIn(List<String> values) {
            addCriterion("plan_year not in", values, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearBetween(String value1, String value2) {
            addCriterion("plan_year between", value1, value2, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotBetween(String value1, String value2) {
            addCriterion("plan_year not between", value1, value2, "planYear");
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