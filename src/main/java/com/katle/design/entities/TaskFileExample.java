package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class TaskFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskFileExample() {
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskPathIsNull() {
            addCriterion("task_path is null");
            return (Criteria) this;
        }

        public Criteria andTaskPathIsNotNull() {
            addCriterion("task_path is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPathEqualTo(String value) {
            addCriterion("task_path =", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathNotEqualTo(String value) {
            addCriterion("task_path <>", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathGreaterThan(String value) {
            addCriterion("task_path >", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathGreaterThanOrEqualTo(String value) {
            addCriterion("task_path >=", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathLessThan(String value) {
            addCriterion("task_path <", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathLessThanOrEqualTo(String value) {
            addCriterion("task_path <=", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathLike(String value) {
            addCriterion("task_path like", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathNotLike(String value) {
            addCriterion("task_path not like", value, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathIn(List<String> values) {
            addCriterion("task_path in", values, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathNotIn(List<String> values) {
            addCriterion("task_path not in", values, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathBetween(String value1, String value2) {
            addCriterion("task_path between", value1, value2, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskPathNotBetween(String value1, String value2) {
            addCriterion("task_path not between", value1, value2, "taskPath");
            return (Criteria) this;
        }

        public Criteria andTaskCheckIsNull() {
            addCriterion("task_check is null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckIsNotNull() {
            addCriterion("task_check is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckEqualTo(Integer value) {
            addCriterion("task_check =", value, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckNotEqualTo(Integer value) {
            addCriterion("task_check <>", value, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckGreaterThan(Integer value) {
            addCriterion("task_check >", value, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_check >=", value, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckLessThan(Integer value) {
            addCriterion("task_check <", value, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckLessThanOrEqualTo(Integer value) {
            addCriterion("task_check <=", value, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckIn(List<Integer> values) {
            addCriterion("task_check in", values, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckNotIn(List<Integer> values) {
            addCriterion("task_check not in", values, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckBetween(Integer value1, Integer value2) {
            addCriterion("task_check between", value1, value2, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("task_check not between", value1, value2, "taskCheck");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionIsNull() {
            addCriterion("task_opinion is null");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionIsNotNull() {
            addCriterion("task_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionEqualTo(String value) {
            addCriterion("task_opinion =", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionNotEqualTo(String value) {
            addCriterion("task_opinion <>", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionGreaterThan(String value) {
            addCriterion("task_opinion >", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("task_opinion >=", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionLessThan(String value) {
            addCriterion("task_opinion <", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionLessThanOrEqualTo(String value) {
            addCriterion("task_opinion <=", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionLike(String value) {
            addCriterion("task_opinion like", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionNotLike(String value) {
            addCriterion("task_opinion not like", value, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionIn(List<String> values) {
            addCriterion("task_opinion in", values, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionNotIn(List<String> values) {
            addCriterion("task_opinion not in", values, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionBetween(String value1, String value2) {
            addCriterion("task_opinion between", value1, value2, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskOpinionNotBetween(String value1, String value2) {
            addCriterion("task_opinion not between", value1, value2, "taskOpinion");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanIsNull() {
            addCriterion("task_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanIsNotNull() {
            addCriterion("task_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanEqualTo(Long value) {
            addCriterion("task_checkMan =", value, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanNotEqualTo(Long value) {
            addCriterion("task_checkMan <>", value, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanGreaterThan(Long value) {
            addCriterion("task_checkMan >", value, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("task_checkMan >=", value, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanLessThan(Long value) {
            addCriterion("task_checkMan <", value, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("task_checkMan <=", value, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanIn(List<Long> values) {
            addCriterion("task_checkMan in", values, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanNotIn(List<Long> values) {
            addCriterion("task_checkMan not in", values, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanBetween(Long value1, Long value2) {
            addCriterion("task_checkMan between", value1, value2, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("task_checkMan not between", value1, value2, "taskCheckman");
            return (Criteria) this;
        }

        public Criteria andTaskYearIsNull() {
            addCriterion("task_year is null");
            return (Criteria) this;
        }

        public Criteria andTaskYearIsNotNull() {
            addCriterion("task_year is not null");
            return (Criteria) this;
        }

        public Criteria andTaskYearEqualTo(String value) {
            addCriterion("task_year =", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearNotEqualTo(String value) {
            addCriterion("task_year <>", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearGreaterThan(String value) {
            addCriterion("task_year >", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearGreaterThanOrEqualTo(String value) {
            addCriterion("task_year >=", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearLessThan(String value) {
            addCriterion("task_year <", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearLessThanOrEqualTo(String value) {
            addCriterion("task_year <=", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearLike(String value) {
            addCriterion("task_year like", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearNotLike(String value) {
            addCriterion("task_year not like", value, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearIn(List<String> values) {
            addCriterion("task_year in", values, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearNotIn(List<String> values) {
            addCriterion("task_year not in", values, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearBetween(String value1, String value2) {
            addCriterion("task_year between", value1, value2, "taskYear");
            return (Criteria) this;
        }

        public Criteria andTaskYearNotBetween(String value1, String value2) {
            addCriterion("task_year not between", value1, value2, "taskYear");
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