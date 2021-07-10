package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class OriginalFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OriginalFileExample() {
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

        public Criteria andOriginalNameIsNull() {
            addCriterion("original_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIsNotNull() {
            addCriterion("original_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameEqualTo(String value) {
            addCriterion("original_name =", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotEqualTo(String value) {
            addCriterion("original_name <>", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThan(String value) {
            addCriterion("original_name >", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("original_name >=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThan(String value) {
            addCriterion("original_name <", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThanOrEqualTo(String value) {
            addCriterion("original_name <=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLike(String value) {
            addCriterion("original_name like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotLike(String value) {
            addCriterion("original_name not like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIn(List<String> values) {
            addCriterion("original_name in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotIn(List<String> values) {
            addCriterion("original_name not in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameBetween(String value1, String value2) {
            addCriterion("original_name between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotBetween(String value1, String value2) {
            addCriterion("original_name not between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalPathIsNull() {
            addCriterion("original_path is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPathIsNotNull() {
            addCriterion("original_path is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPathEqualTo(String value) {
            addCriterion("original_path =", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathNotEqualTo(String value) {
            addCriterion("original_path <>", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathGreaterThan(String value) {
            addCriterion("original_path >", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathGreaterThanOrEqualTo(String value) {
            addCriterion("original_path >=", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathLessThan(String value) {
            addCriterion("original_path <", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathLessThanOrEqualTo(String value) {
            addCriterion("original_path <=", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathLike(String value) {
            addCriterion("original_path like", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathNotLike(String value) {
            addCriterion("original_path not like", value, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathIn(List<String> values) {
            addCriterion("original_path in", values, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathNotIn(List<String> values) {
            addCriterion("original_path not in", values, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathBetween(String value1, String value2) {
            addCriterion("original_path between", value1, value2, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalPathNotBetween(String value1, String value2) {
            addCriterion("original_path not between", value1, value2, "originalPath");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckIsNull() {
            addCriterion("original_check is null");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckIsNotNull() {
            addCriterion("original_check is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckEqualTo(Integer value) {
            addCriterion("original_check =", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckNotEqualTo(Integer value) {
            addCriterion("original_check <>", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckGreaterThan(Integer value) {
            addCriterion("original_check >", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("original_check >=", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckLessThan(Integer value) {
            addCriterion("original_check <", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckLessThanOrEqualTo(Integer value) {
            addCriterion("original_check <=", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckIn(List<Integer> values) {
            addCriterion("original_check in", values, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckNotIn(List<Integer> values) {
            addCriterion("original_check not in", values, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckBetween(Integer value1, Integer value2) {
            addCriterion("original_check between", value1, value2, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("original_check not between", value1, value2, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionIsNull() {
            addCriterion("original_opinion is null");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionIsNotNull() {
            addCriterion("original_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionEqualTo(String value) {
            addCriterion("original_opinion =", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionNotEqualTo(String value) {
            addCriterion("original_opinion <>", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionGreaterThan(String value) {
            addCriterion("original_opinion >", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("original_opinion >=", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionLessThan(String value) {
            addCriterion("original_opinion <", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionLessThanOrEqualTo(String value) {
            addCriterion("original_opinion <=", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionLike(String value) {
            addCriterion("original_opinion like", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionNotLike(String value) {
            addCriterion("original_opinion not like", value, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionIn(List<String> values) {
            addCriterion("original_opinion in", values, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionNotIn(List<String> values) {
            addCriterion("original_opinion not in", values, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionBetween(String value1, String value2) {
            addCriterion("original_opinion between", value1, value2, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOpinionNotBetween(String value1, String value2) {
            addCriterion("original_opinion not between", value1, value2, "originalOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanIsNull() {
            addCriterion("original_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanIsNotNull() {
            addCriterion("original_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanEqualTo(Long value) {
            addCriterion("original_checkMan =", value, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanNotEqualTo(Long value) {
            addCriterion("original_checkMan <>", value, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanGreaterThan(Long value) {
            addCriterion("original_checkMan >", value, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("original_checkMan >=", value, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanLessThan(Long value) {
            addCriterion("original_checkMan <", value, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("original_checkMan <=", value, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanIn(List<Long> values) {
            addCriterion("original_checkMan in", values, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanNotIn(List<Long> values) {
            addCriterion("original_checkMan not in", values, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanBetween(Long value1, Long value2) {
            addCriterion("original_checkMan between", value1, value2, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("original_checkMan not between", value1, value2, "originalCheckman");
            return (Criteria) this;
        }

        public Criteria andOriginalYearIsNull() {
            addCriterion("original_year is null");
            return (Criteria) this;
        }

        public Criteria andOriginalYearIsNotNull() {
            addCriterion("original_year is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalYearEqualTo(String value) {
            addCriterion("original_year =", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearNotEqualTo(String value) {
            addCriterion("original_year <>", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearGreaterThan(String value) {
            addCriterion("original_year >", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearGreaterThanOrEqualTo(String value) {
            addCriterion("original_year >=", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearLessThan(String value) {
            addCriterion("original_year <", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearLessThanOrEqualTo(String value) {
            addCriterion("original_year <=", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearLike(String value) {
            addCriterion("original_year like", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearNotLike(String value) {
            addCriterion("original_year not like", value, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearIn(List<String> values) {
            addCriterion("original_year in", values, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearNotIn(List<String> values) {
            addCriterion("original_year not in", values, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearBetween(String value1, String value2) {
            addCriterion("original_year between", value1, value2, "originalYear");
            return (Criteria) this;
        }

        public Criteria andOriginalYearNotBetween(String value1, String value2) {
            addCriterion("original_year not between", value1, value2, "originalYear");
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