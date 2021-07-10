package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class MiddleFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MiddleFileExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMiddleNameIsNull() {
            addCriterion("middle_name is null");
            return (Criteria) this;
        }

        public Criteria andMiddleNameIsNotNull() {
            addCriterion("middle_name is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleNameEqualTo(String value) {
            addCriterion("middle_name =", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameNotEqualTo(String value) {
            addCriterion("middle_name <>", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameGreaterThan(String value) {
            addCriterion("middle_name >", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameGreaterThanOrEqualTo(String value) {
            addCriterion("middle_name >=", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameLessThan(String value) {
            addCriterion("middle_name <", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameLessThanOrEqualTo(String value) {
            addCriterion("middle_name <=", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameLike(String value) {
            addCriterion("middle_name like", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameNotLike(String value) {
            addCriterion("middle_name not like", value, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameIn(List<String> values) {
            addCriterion("middle_name in", values, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameNotIn(List<String> values) {
            addCriterion("middle_name not in", values, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameBetween(String value1, String value2) {
            addCriterion("middle_name between", value1, value2, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddleNameNotBetween(String value1, String value2) {
            addCriterion("middle_name not between", value1, value2, "middleName");
            return (Criteria) this;
        }

        public Criteria andMiddlePathIsNull() {
            addCriterion("middle_path is null");
            return (Criteria) this;
        }

        public Criteria andMiddlePathIsNotNull() {
            addCriterion("middle_path is not null");
            return (Criteria) this;
        }

        public Criteria andMiddlePathEqualTo(String value) {
            addCriterion("middle_path =", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathNotEqualTo(String value) {
            addCriterion("middle_path <>", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathGreaterThan(String value) {
            addCriterion("middle_path >", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathGreaterThanOrEqualTo(String value) {
            addCriterion("middle_path >=", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathLessThan(String value) {
            addCriterion("middle_path <", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathLessThanOrEqualTo(String value) {
            addCriterion("middle_path <=", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathLike(String value) {
            addCriterion("middle_path like", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathNotLike(String value) {
            addCriterion("middle_path not like", value, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathIn(List<String> values) {
            addCriterion("middle_path in", values, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathNotIn(List<String> values) {
            addCriterion("middle_path not in", values, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathBetween(String value1, String value2) {
            addCriterion("middle_path between", value1, value2, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddlePathNotBetween(String value1, String value2) {
            addCriterion("middle_path not between", value1, value2, "middlePath");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckIsNull() {
            addCriterion("middle_check is null");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckIsNotNull() {
            addCriterion("middle_check is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckEqualTo(Integer value) {
            addCriterion("middle_check =", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckNotEqualTo(Integer value) {
            addCriterion("middle_check <>", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckGreaterThan(Integer value) {
            addCriterion("middle_check >", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("middle_check >=", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckLessThan(Integer value) {
            addCriterion("middle_check <", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckLessThanOrEqualTo(Integer value) {
            addCriterion("middle_check <=", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckIn(List<Integer> values) {
            addCriterion("middle_check in", values, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckNotIn(List<Integer> values) {
            addCriterion("middle_check not in", values, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckBetween(Integer value1, Integer value2) {
            addCriterion("middle_check between", value1, value2, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("middle_check not between", value1, value2, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionIsNull() {
            addCriterion("middle_opinion is null");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionIsNotNull() {
            addCriterion("middle_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionEqualTo(String value) {
            addCriterion("middle_opinion =", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionNotEqualTo(String value) {
            addCriterion("middle_opinion <>", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionGreaterThan(String value) {
            addCriterion("middle_opinion >", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("middle_opinion >=", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionLessThan(String value) {
            addCriterion("middle_opinion <", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionLessThanOrEqualTo(String value) {
            addCriterion("middle_opinion <=", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionLike(String value) {
            addCriterion("middle_opinion like", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionNotLike(String value) {
            addCriterion("middle_opinion not like", value, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionIn(List<String> values) {
            addCriterion("middle_opinion in", values, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionNotIn(List<String> values) {
            addCriterion("middle_opinion not in", values, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionBetween(String value1, String value2) {
            addCriterion("middle_opinion between", value1, value2, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleOpinionNotBetween(String value1, String value2) {
            addCriterion("middle_opinion not between", value1, value2, "middleOpinion");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanIsNull() {
            addCriterion("middle_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanIsNotNull() {
            addCriterion("middle_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanEqualTo(Long value) {
            addCriterion("middle_checkMan =", value, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanNotEqualTo(Long value) {
            addCriterion("middle_checkMan <>", value, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanGreaterThan(Long value) {
            addCriterion("middle_checkMan >", value, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("middle_checkMan >=", value, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanLessThan(Long value) {
            addCriterion("middle_checkMan <", value, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("middle_checkMan <=", value, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanIn(List<Long> values) {
            addCriterion("middle_checkMan in", values, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanNotIn(List<Long> values) {
            addCriterion("middle_checkMan not in", values, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanBetween(Long value1, Long value2) {
            addCriterion("middle_checkMan between", value1, value2, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("middle_checkMan not between", value1, value2, "middleCheckman");
            return (Criteria) this;
        }

        public Criteria andMiddleYearIsNull() {
            addCriterion("middle_year is null");
            return (Criteria) this;
        }

        public Criteria andMiddleYearIsNotNull() {
            addCriterion("middle_year is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleYearEqualTo(String value) {
            addCriterion("middle_year =", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearNotEqualTo(String value) {
            addCriterion("middle_year <>", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearGreaterThan(String value) {
            addCriterion("middle_year >", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearGreaterThanOrEqualTo(String value) {
            addCriterion("middle_year >=", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearLessThan(String value) {
            addCriterion("middle_year <", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearLessThanOrEqualTo(String value) {
            addCriterion("middle_year <=", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearLike(String value) {
            addCriterion("middle_year like", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearNotLike(String value) {
            addCriterion("middle_year not like", value, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearIn(List<String> values) {
            addCriterion("middle_year in", values, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearNotIn(List<String> values) {
            addCriterion("middle_year not in", values, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearBetween(String value1, String value2) {
            addCriterion("middle_year between", value1, value2, "middleYear");
            return (Criteria) this;
        }

        public Criteria andMiddleYearNotBetween(String value1, String value2) {
            addCriterion("middle_year not between", value1, value2, "middleYear");
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