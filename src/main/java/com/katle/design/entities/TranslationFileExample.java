package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class TranslationFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TranslationFileExample() {
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

        public Criteria andTranslationNameIsNull() {
            addCriterion("translation_name is null");
            return (Criteria) this;
        }

        public Criteria andTranslationNameIsNotNull() {
            addCriterion("translation_name is not null");
            return (Criteria) this;
        }

        public Criteria andTranslationNameEqualTo(String value) {
            addCriterion("translation_name =", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameNotEqualTo(String value) {
            addCriterion("translation_name <>", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameGreaterThan(String value) {
            addCriterion("translation_name >", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameGreaterThanOrEqualTo(String value) {
            addCriterion("translation_name >=", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameLessThan(String value) {
            addCriterion("translation_name <", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameLessThanOrEqualTo(String value) {
            addCriterion("translation_name <=", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameLike(String value) {
            addCriterion("translation_name like", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameNotLike(String value) {
            addCriterion("translation_name not like", value, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameIn(List<String> values) {
            addCriterion("translation_name in", values, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameNotIn(List<String> values) {
            addCriterion("translation_name not in", values, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameBetween(String value1, String value2) {
            addCriterion("translation_name between", value1, value2, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationNameNotBetween(String value1, String value2) {
            addCriterion("translation_name not between", value1, value2, "translationName");
            return (Criteria) this;
        }

        public Criteria andTranslationPathIsNull() {
            addCriterion("translation_path is null");
            return (Criteria) this;
        }

        public Criteria andTranslationPathIsNotNull() {
            addCriterion("translation_path is not null");
            return (Criteria) this;
        }

        public Criteria andTranslationPathEqualTo(String value) {
            addCriterion("translation_path =", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathNotEqualTo(String value) {
            addCriterion("translation_path <>", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathGreaterThan(String value) {
            addCriterion("translation_path >", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathGreaterThanOrEqualTo(String value) {
            addCriterion("translation_path >=", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathLessThan(String value) {
            addCriterion("translation_path <", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathLessThanOrEqualTo(String value) {
            addCriterion("translation_path <=", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathLike(String value) {
            addCriterion("translation_path like", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathNotLike(String value) {
            addCriterion("translation_path not like", value, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathIn(List<String> values) {
            addCriterion("translation_path in", values, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathNotIn(List<String> values) {
            addCriterion("translation_path not in", values, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathBetween(String value1, String value2) {
            addCriterion("translation_path between", value1, value2, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationPathNotBetween(String value1, String value2) {
            addCriterion("translation_path not between", value1, value2, "translationPath");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckIsNull() {
            addCriterion("translation_check is null");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckIsNotNull() {
            addCriterion("translation_check is not null");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckEqualTo(Integer value) {
            addCriterion("translation_check =", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckNotEqualTo(Integer value) {
            addCriterion("translation_check <>", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckGreaterThan(Integer value) {
            addCriterion("translation_check >", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("translation_check >=", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckLessThan(Integer value) {
            addCriterion("translation_check <", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckLessThanOrEqualTo(Integer value) {
            addCriterion("translation_check <=", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckIn(List<Integer> values) {
            addCriterion("translation_check in", values, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckNotIn(List<Integer> values) {
            addCriterion("translation_check not in", values, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckBetween(Integer value1, Integer value2) {
            addCriterion("translation_check between", value1, value2, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("translation_check not between", value1, value2, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionIsNull() {
            addCriterion("translation_opinion is null");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionIsNotNull() {
            addCriterion("translation_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionEqualTo(String value) {
            addCriterion("translation_opinion =", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionNotEqualTo(String value) {
            addCriterion("translation_opinion <>", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionGreaterThan(String value) {
            addCriterion("translation_opinion >", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("translation_opinion >=", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionLessThan(String value) {
            addCriterion("translation_opinion <", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionLessThanOrEqualTo(String value) {
            addCriterion("translation_opinion <=", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionLike(String value) {
            addCriterion("translation_opinion like", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionNotLike(String value) {
            addCriterion("translation_opinion not like", value, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionIn(List<String> values) {
            addCriterion("translation_opinion in", values, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionNotIn(List<String> values) {
            addCriterion("translation_opinion not in", values, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionBetween(String value1, String value2) {
            addCriterion("translation_opinion between", value1, value2, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationOpinionNotBetween(String value1, String value2) {
            addCriterion("translation_opinion not between", value1, value2, "translationOpinion");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanIsNull() {
            addCriterion("translation_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanIsNotNull() {
            addCriterion("translation_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanEqualTo(Long value) {
            addCriterion("translation_checkMan =", value, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanNotEqualTo(Long value) {
            addCriterion("translation_checkMan <>", value, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanGreaterThan(Long value) {
            addCriterion("translation_checkMan >", value, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("translation_checkMan >=", value, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanLessThan(Long value) {
            addCriterion("translation_checkMan <", value, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("translation_checkMan <=", value, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanIn(List<Long> values) {
            addCriterion("translation_checkMan in", values, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanNotIn(List<Long> values) {
            addCriterion("translation_checkMan not in", values, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanBetween(Long value1, Long value2) {
            addCriterion("translation_checkMan between", value1, value2, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("translation_checkMan not between", value1, value2, "translationCheckman");
            return (Criteria) this;
        }

        public Criteria andTranslationYearIsNull() {
            addCriterion("translation_year is null");
            return (Criteria) this;
        }

        public Criteria andTranslationYearIsNotNull() {
            addCriterion("translation_year is not null");
            return (Criteria) this;
        }

        public Criteria andTranslationYearEqualTo(String value) {
            addCriterion("translation_year =", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearNotEqualTo(String value) {
            addCriterion("translation_year <>", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearGreaterThan(String value) {
            addCriterion("translation_year >", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearGreaterThanOrEqualTo(String value) {
            addCriterion("translation_year >=", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearLessThan(String value) {
            addCriterion("translation_year <", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearLessThanOrEqualTo(String value) {
            addCriterion("translation_year <=", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearLike(String value) {
            addCriterion("translation_year like", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearNotLike(String value) {
            addCriterion("translation_year not like", value, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearIn(List<String> values) {
            addCriterion("translation_year in", values, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearNotIn(List<String> values) {
            addCriterion("translation_year not in", values, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearBetween(String value1, String value2) {
            addCriterion("translation_year between", value1, value2, "translationYear");
            return (Criteria) this;
        }

        public Criteria andTranslationYearNotBetween(String value1, String value2) {
            addCriterion("translation_year not between", value1, value2, "translationYear");
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