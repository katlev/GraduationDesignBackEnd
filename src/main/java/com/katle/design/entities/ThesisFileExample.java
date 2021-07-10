package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class ThesisFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThesisFileExample() {
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

        public Criteria andThesisNameIsNull() {
            addCriterion("thesis_name is null");
            return (Criteria) this;
        }

        public Criteria andThesisNameIsNotNull() {
            addCriterion("thesis_name is not null");
            return (Criteria) this;
        }

        public Criteria andThesisNameEqualTo(String value) {
            addCriterion("thesis_name =", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameNotEqualTo(String value) {
            addCriterion("thesis_name <>", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameGreaterThan(String value) {
            addCriterion("thesis_name >", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameGreaterThanOrEqualTo(String value) {
            addCriterion("thesis_name >=", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameLessThan(String value) {
            addCriterion("thesis_name <", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameLessThanOrEqualTo(String value) {
            addCriterion("thesis_name <=", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameLike(String value) {
            addCriterion("thesis_name like", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameNotLike(String value) {
            addCriterion("thesis_name not like", value, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameIn(List<String> values) {
            addCriterion("thesis_name in", values, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameNotIn(List<String> values) {
            addCriterion("thesis_name not in", values, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameBetween(String value1, String value2) {
            addCriterion("thesis_name between", value1, value2, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisNameNotBetween(String value1, String value2) {
            addCriterion("thesis_name not between", value1, value2, "thesisName");
            return (Criteria) this;
        }

        public Criteria andThesisPathIsNull() {
            addCriterion("thesis_path is null");
            return (Criteria) this;
        }

        public Criteria andThesisPathIsNotNull() {
            addCriterion("thesis_path is not null");
            return (Criteria) this;
        }

        public Criteria andThesisPathEqualTo(String value) {
            addCriterion("thesis_path =", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathNotEqualTo(String value) {
            addCriterion("thesis_path <>", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathGreaterThan(String value) {
            addCriterion("thesis_path >", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathGreaterThanOrEqualTo(String value) {
            addCriterion("thesis_path >=", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathLessThan(String value) {
            addCriterion("thesis_path <", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathLessThanOrEqualTo(String value) {
            addCriterion("thesis_path <=", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathLike(String value) {
            addCriterion("thesis_path like", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathNotLike(String value) {
            addCriterion("thesis_path not like", value, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathIn(List<String> values) {
            addCriterion("thesis_path in", values, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathNotIn(List<String> values) {
            addCriterion("thesis_path not in", values, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathBetween(String value1, String value2) {
            addCriterion("thesis_path between", value1, value2, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisPathNotBetween(String value1, String value2) {
            addCriterion("thesis_path not between", value1, value2, "thesisPath");
            return (Criteria) this;
        }

        public Criteria andThesisCheckIsNull() {
            addCriterion("thesis_check is null");
            return (Criteria) this;
        }

        public Criteria andThesisCheckIsNotNull() {
            addCriterion("thesis_check is not null");
            return (Criteria) this;
        }

        public Criteria andThesisCheckEqualTo(Integer value) {
            addCriterion("thesis_check =", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckNotEqualTo(Integer value) {
            addCriterion("thesis_check <>", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckGreaterThan(Integer value) {
            addCriterion("thesis_check >", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("thesis_check >=", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckLessThan(Integer value) {
            addCriterion("thesis_check <", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckLessThanOrEqualTo(Integer value) {
            addCriterion("thesis_check <=", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckIn(List<Integer> values) {
            addCriterion("thesis_check in", values, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckNotIn(List<Integer> values) {
            addCriterion("thesis_check not in", values, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckBetween(Integer value1, Integer value2) {
            addCriterion("thesis_check between", value1, value2, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("thesis_check not between", value1, value2, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionIsNull() {
            addCriterion("thesis_opinion is null");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionIsNotNull() {
            addCriterion("thesis_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionEqualTo(String value) {
            addCriterion("thesis_opinion =", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionNotEqualTo(String value) {
            addCriterion("thesis_opinion <>", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionGreaterThan(String value) {
            addCriterion("thesis_opinion >", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("thesis_opinion >=", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionLessThan(String value) {
            addCriterion("thesis_opinion <", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionLessThanOrEqualTo(String value) {
            addCriterion("thesis_opinion <=", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionLike(String value) {
            addCriterion("thesis_opinion like", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionNotLike(String value) {
            addCriterion("thesis_opinion not like", value, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionIn(List<String> values) {
            addCriterion("thesis_opinion in", values, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionNotIn(List<String> values) {
            addCriterion("thesis_opinion not in", values, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionBetween(String value1, String value2) {
            addCriterion("thesis_opinion between", value1, value2, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisOpinionNotBetween(String value1, String value2) {
            addCriterion("thesis_opinion not between", value1, value2, "thesisOpinion");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanIsNull() {
            addCriterion("thesis_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanIsNotNull() {
            addCriterion("thesis_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanEqualTo(Long value) {
            addCriterion("thesis_checkMan =", value, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanNotEqualTo(Long value) {
            addCriterion("thesis_checkMan <>", value, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanGreaterThan(Long value) {
            addCriterion("thesis_checkMan >", value, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("thesis_checkMan >=", value, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanLessThan(Long value) {
            addCriterion("thesis_checkMan <", value, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("thesis_checkMan <=", value, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanIn(List<Long> values) {
            addCriterion("thesis_checkMan in", values, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanNotIn(List<Long> values) {
            addCriterion("thesis_checkMan not in", values, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanBetween(Long value1, Long value2) {
            addCriterion("thesis_checkMan between", value1, value2, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("thesis_checkMan not between", value1, value2, "thesisCheckman");
            return (Criteria) this;
        }

        public Criteria andThesisYearIsNull() {
            addCriterion("thesis_year is null");
            return (Criteria) this;
        }

        public Criteria andThesisYearIsNotNull() {
            addCriterion("thesis_year is not null");
            return (Criteria) this;
        }

        public Criteria andThesisYearEqualTo(String value) {
            addCriterion("thesis_year =", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearNotEqualTo(String value) {
            addCriterion("thesis_year <>", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearGreaterThan(String value) {
            addCriterion("thesis_year >", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearGreaterThanOrEqualTo(String value) {
            addCriterion("thesis_year >=", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearLessThan(String value) {
            addCriterion("thesis_year <", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearLessThanOrEqualTo(String value) {
            addCriterion("thesis_year <=", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearLike(String value) {
            addCriterion("thesis_year like", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearNotLike(String value) {
            addCriterion("thesis_year not like", value, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearIn(List<String> values) {
            addCriterion("thesis_year in", values, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearNotIn(List<String> values) {
            addCriterion("thesis_year not in", values, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearBetween(String value1, String value2) {
            addCriterion("thesis_year between", value1, value2, "thesisYear");
            return (Criteria) this;
        }

        public Criteria andThesisYearNotBetween(String value1, String value2) {
            addCriterion("thesis_year not between", value1, value2, "thesisYear");
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