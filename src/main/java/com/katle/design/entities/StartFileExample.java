package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class StartFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StartFileExample() {
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

        public Criteria andStartNameIsNull() {
            addCriterion("start_name is null");
            return (Criteria) this;
        }

        public Criteria andStartNameIsNotNull() {
            addCriterion("start_name is not null");
            return (Criteria) this;
        }

        public Criteria andStartNameEqualTo(String value) {
            addCriterion("start_name =", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameNotEqualTo(String value) {
            addCriterion("start_name <>", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameGreaterThan(String value) {
            addCriterion("start_name >", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameGreaterThanOrEqualTo(String value) {
            addCriterion("start_name >=", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameLessThan(String value) {
            addCriterion("start_name <", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameLessThanOrEqualTo(String value) {
            addCriterion("start_name <=", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameLike(String value) {
            addCriterion("start_name like", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameNotLike(String value) {
            addCriterion("start_name not like", value, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameIn(List<String> values) {
            addCriterion("start_name in", values, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameNotIn(List<String> values) {
            addCriterion("start_name not in", values, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameBetween(String value1, String value2) {
            addCriterion("start_name between", value1, value2, "startName");
            return (Criteria) this;
        }

        public Criteria andStartNameNotBetween(String value1, String value2) {
            addCriterion("start_name not between", value1, value2, "startName");
            return (Criteria) this;
        }

        public Criteria andStartPathIsNull() {
            addCriterion("start_path is null");
            return (Criteria) this;
        }

        public Criteria andStartPathIsNotNull() {
            addCriterion("start_path is not null");
            return (Criteria) this;
        }

        public Criteria andStartPathEqualTo(String value) {
            addCriterion("start_path =", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathNotEqualTo(String value) {
            addCriterion("start_path <>", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathGreaterThan(String value) {
            addCriterion("start_path >", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathGreaterThanOrEqualTo(String value) {
            addCriterion("start_path >=", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathLessThan(String value) {
            addCriterion("start_path <", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathLessThanOrEqualTo(String value) {
            addCriterion("start_path <=", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathLike(String value) {
            addCriterion("start_path like", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathNotLike(String value) {
            addCriterion("start_path not like", value, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathIn(List<String> values) {
            addCriterion("start_path in", values, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathNotIn(List<String> values) {
            addCriterion("start_path not in", values, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathBetween(String value1, String value2) {
            addCriterion("start_path between", value1, value2, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartPathNotBetween(String value1, String value2) {
            addCriterion("start_path not between", value1, value2, "startPath");
            return (Criteria) this;
        }

        public Criteria andStartCheckIsNull() {
            addCriterion("start_check is null");
            return (Criteria) this;
        }

        public Criteria andStartCheckIsNotNull() {
            addCriterion("start_check is not null");
            return (Criteria) this;
        }

        public Criteria andStartCheckEqualTo(Integer value) {
            addCriterion("start_check =", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckNotEqualTo(Integer value) {
            addCriterion("start_check <>", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckGreaterThan(Integer value) {
            addCriterion("start_check >", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_check >=", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckLessThan(Integer value) {
            addCriterion("start_check <", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckLessThanOrEqualTo(Integer value) {
            addCriterion("start_check <=", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckIn(List<Integer> values) {
            addCriterion("start_check in", values, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckNotIn(List<Integer> values) {
            addCriterion("start_check not in", values, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckBetween(Integer value1, Integer value2) {
            addCriterion("start_check between", value1, value2, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("start_check not between", value1, value2, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartOpinionIsNull() {
            addCriterion("start_opinion is null");
            return (Criteria) this;
        }

        public Criteria andStartOpinionIsNotNull() {
            addCriterion("start_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andStartOpinionEqualTo(String value) {
            addCriterion("start_opinion =", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionNotEqualTo(String value) {
            addCriterion("start_opinion <>", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionGreaterThan(String value) {
            addCriterion("start_opinion >", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("start_opinion >=", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionLessThan(String value) {
            addCriterion("start_opinion <", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionLessThanOrEqualTo(String value) {
            addCriterion("start_opinion <=", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionLike(String value) {
            addCriterion("start_opinion like", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionNotLike(String value) {
            addCriterion("start_opinion not like", value, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionIn(List<String> values) {
            addCriterion("start_opinion in", values, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionNotIn(List<String> values) {
            addCriterion("start_opinion not in", values, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionBetween(String value1, String value2) {
            addCriterion("start_opinion between", value1, value2, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartOpinionNotBetween(String value1, String value2) {
            addCriterion("start_opinion not between", value1, value2, "startOpinion");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanIsNull() {
            addCriterion("start_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanIsNotNull() {
            addCriterion("start_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanEqualTo(Long value) {
            addCriterion("start_checkMan =", value, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanNotEqualTo(Long value) {
            addCriterion("start_checkMan <>", value, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanGreaterThan(Long value) {
            addCriterion("start_checkMan >", value, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("start_checkMan >=", value, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanLessThan(Long value) {
            addCriterion("start_checkMan <", value, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("start_checkMan <=", value, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanIn(List<Long> values) {
            addCriterion("start_checkMan in", values, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanNotIn(List<Long> values) {
            addCriterion("start_checkMan not in", values, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanBetween(Long value1, Long value2) {
            addCriterion("start_checkMan between", value1, value2, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("start_checkMan not between", value1, value2, "startCheckman");
            return (Criteria) this;
        }

        public Criteria andStartYearIsNull() {
            addCriterion("start_year is null");
            return (Criteria) this;
        }

        public Criteria andStartYearIsNotNull() {
            addCriterion("start_year is not null");
            return (Criteria) this;
        }

        public Criteria andStartYearEqualTo(String value) {
            addCriterion("start_year =", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotEqualTo(String value) {
            addCriterion("start_year <>", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearGreaterThan(String value) {
            addCriterion("start_year >", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearGreaterThanOrEqualTo(String value) {
            addCriterion("start_year >=", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLessThan(String value) {
            addCriterion("start_year <", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLessThanOrEqualTo(String value) {
            addCriterion("start_year <=", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLike(String value) {
            addCriterion("start_year like", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotLike(String value) {
            addCriterion("start_year not like", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearIn(List<String> values) {
            addCriterion("start_year in", values, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotIn(List<String> values) {
            addCriterion("start_year not in", values, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearBetween(String value1, String value2) {
            addCriterion("start_year between", value1, value2, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotBetween(String value1, String value2) {
            addCriterion("start_year not between", value1, value2, "startYear");
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