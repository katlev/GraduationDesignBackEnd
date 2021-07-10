package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class LiteratureFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LiteratureFileExample() {
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

        public Criteria andLiteratureNameIsNull() {
            addCriterion("literature_name is null");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameIsNotNull() {
            addCriterion("literature_name is not null");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameEqualTo(String value) {
            addCriterion("literature_name =", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameNotEqualTo(String value) {
            addCriterion("literature_name <>", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameGreaterThan(String value) {
            addCriterion("literature_name >", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameGreaterThanOrEqualTo(String value) {
            addCriterion("literature_name >=", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameLessThan(String value) {
            addCriterion("literature_name <", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameLessThanOrEqualTo(String value) {
            addCriterion("literature_name <=", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameLike(String value) {
            addCriterion("literature_name like", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameNotLike(String value) {
            addCriterion("literature_name not like", value, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameIn(List<String> values) {
            addCriterion("literature_name in", values, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameNotIn(List<String> values) {
            addCriterion("literature_name not in", values, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameBetween(String value1, String value2) {
            addCriterion("literature_name between", value1, value2, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteratureNameNotBetween(String value1, String value2) {
            addCriterion("literature_name not between", value1, value2, "literatureName");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathIsNull() {
            addCriterion("literature_path is null");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathIsNotNull() {
            addCriterion("literature_path is not null");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathEqualTo(String value) {
            addCriterion("literature_path =", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathNotEqualTo(String value) {
            addCriterion("literature_path <>", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathGreaterThan(String value) {
            addCriterion("literature_path >", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathGreaterThanOrEqualTo(String value) {
            addCriterion("literature_path >=", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathLessThan(String value) {
            addCriterion("literature_path <", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathLessThanOrEqualTo(String value) {
            addCriterion("literature_path <=", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathLike(String value) {
            addCriterion("literature_path like", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathNotLike(String value) {
            addCriterion("literature_path not like", value, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathIn(List<String> values) {
            addCriterion("literature_path in", values, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathNotIn(List<String> values) {
            addCriterion("literature_path not in", values, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathBetween(String value1, String value2) {
            addCriterion("literature_path between", value1, value2, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteraturePathNotBetween(String value1, String value2) {
            addCriterion("literature_path not between", value1, value2, "literaturePath");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckIsNull() {
            addCriterion("literature_check is null");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckIsNotNull() {
            addCriterion("literature_check is not null");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckEqualTo(Integer value) {
            addCriterion("literature_check =", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckNotEqualTo(Integer value) {
            addCriterion("literature_check <>", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckGreaterThan(Integer value) {
            addCriterion("literature_check >", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("literature_check >=", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckLessThan(Integer value) {
            addCriterion("literature_check <", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckLessThanOrEqualTo(Integer value) {
            addCriterion("literature_check <=", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckIn(List<Integer> values) {
            addCriterion("literature_check in", values, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckNotIn(List<Integer> values) {
            addCriterion("literature_check not in", values, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckBetween(Integer value1, Integer value2) {
            addCriterion("literature_check between", value1, value2, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("literature_check not between", value1, value2, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionIsNull() {
            addCriterion("literature_opinion is null");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionIsNotNull() {
            addCriterion("literature_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionEqualTo(String value) {
            addCriterion("literature_opinion =", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionNotEqualTo(String value) {
            addCriterion("literature_opinion <>", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionGreaterThan(String value) {
            addCriterion("literature_opinion >", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("literature_opinion >=", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionLessThan(String value) {
            addCriterion("literature_opinion <", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionLessThanOrEqualTo(String value) {
            addCriterion("literature_opinion <=", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionLike(String value) {
            addCriterion("literature_opinion like", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionNotLike(String value) {
            addCriterion("literature_opinion not like", value, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionIn(List<String> values) {
            addCriterion("literature_opinion in", values, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionNotIn(List<String> values) {
            addCriterion("literature_opinion not in", values, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionBetween(String value1, String value2) {
            addCriterion("literature_opinion between", value1, value2, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureOpinionNotBetween(String value1, String value2) {
            addCriterion("literature_opinion not between", value1, value2, "literatureOpinion");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanIsNull() {
            addCriterion("literature_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanIsNotNull() {
            addCriterion("literature_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanEqualTo(Long value) {
            addCriterion("literature_checkMan =", value, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanNotEqualTo(Long value) {
            addCriterion("literature_checkMan <>", value, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanGreaterThan(Long value) {
            addCriterion("literature_checkMan >", value, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("literature_checkMan >=", value, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanLessThan(Long value) {
            addCriterion("literature_checkMan <", value, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("literature_checkMan <=", value, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanIn(List<Long> values) {
            addCriterion("literature_checkMan in", values, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanNotIn(List<Long> values) {
            addCriterion("literature_checkMan not in", values, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanBetween(Long value1, Long value2) {
            addCriterion("literature_checkMan between", value1, value2, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("literature_checkMan not between", value1, value2, "literatureCheckman");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearIsNull() {
            addCriterion("literature_year is null");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearIsNotNull() {
            addCriterion("literature_year is not null");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearEqualTo(String value) {
            addCriterion("literature_year =", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearNotEqualTo(String value) {
            addCriterion("literature_year <>", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearGreaterThan(String value) {
            addCriterion("literature_year >", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearGreaterThanOrEqualTo(String value) {
            addCriterion("literature_year >=", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearLessThan(String value) {
            addCriterion("literature_year <", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearLessThanOrEqualTo(String value) {
            addCriterion("literature_year <=", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearLike(String value) {
            addCriterion("literature_year like", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearNotLike(String value) {
            addCriterion("literature_year not like", value, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearIn(List<String> values) {
            addCriterion("literature_year in", values, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearNotIn(List<String> values) {
            addCriterion("literature_year not in", values, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearBetween(String value1, String value2) {
            addCriterion("literature_year between", value1, value2, "literatureYear");
            return (Criteria) this;
        }

        public Criteria andLiteratureYearNotBetween(String value1, String value2) {
            addCriterion("literature_year not between", value1, value2, "literatureYear");
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