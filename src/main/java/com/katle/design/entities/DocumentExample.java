package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class DocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentExample() {
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

        public Criteria andStartCheckEqualTo(Boolean value) {
            addCriterion("start_check =", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckNotEqualTo(Boolean value) {
            addCriterion("start_check <>", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckGreaterThan(Boolean value) {
            addCriterion("start_check >", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("start_check >=", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckLessThan(Boolean value) {
            addCriterion("start_check <", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("start_check <=", value, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckIn(List<Boolean> values) {
            addCriterion("start_check in", values, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckNotIn(List<Boolean> values) {
            addCriterion("start_check not in", values, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("start_check between", value1, value2, "startCheck");
            return (Criteria) this;
        }

        public Criteria andStartCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("start_check not between", value1, value2, "startCheck");
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

        public Criteria andMiddleCheckEqualTo(Boolean value) {
            addCriterion("middle_check =", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckNotEqualTo(Boolean value) {
            addCriterion("middle_check <>", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckGreaterThan(Boolean value) {
            addCriterion("middle_check >", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("middle_check >=", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckLessThan(Boolean value) {
            addCriterion("middle_check <", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("middle_check <=", value, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckIn(List<Boolean> values) {
            addCriterion("middle_check in", values, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckNotIn(List<Boolean> values) {
            addCriterion("middle_check not in", values, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("middle_check between", value1, value2, "middleCheck");
            return (Criteria) this;
        }

        public Criteria andMiddleCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("middle_check not between", value1, value2, "middleCheck");
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

        public Criteria andPlanCheckIsNull() {
            addCriterion("plan_check is null");
            return (Criteria) this;
        }

        public Criteria andPlanCheckIsNotNull() {
            addCriterion("plan_check is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCheckEqualTo(Boolean value) {
            addCriterion("plan_check =", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckNotEqualTo(Boolean value) {
            addCriterion("plan_check <>", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckGreaterThan(Boolean value) {
            addCriterion("plan_check >", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("plan_check >=", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckLessThan(Boolean value) {
            addCriterion("plan_check <", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("plan_check <=", value, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckIn(List<Boolean> values) {
            addCriterion("plan_check in", values, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckNotIn(List<Boolean> values) {
            addCriterion("plan_check not in", values, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("plan_check between", value1, value2, "planCheck");
            return (Criteria) this;
        }

        public Criteria andPlanCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("plan_check not between", value1, value2, "planCheck");
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

        public Criteria andGuidanceCheckIsNull() {
            addCriterion("guidance_check is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckIsNotNull() {
            addCriterion("guidance_check is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckEqualTo(Boolean value) {
            addCriterion("guidance_check =", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckNotEqualTo(Boolean value) {
            addCriterion("guidance_check <>", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckGreaterThan(Boolean value) {
            addCriterion("guidance_check >", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("guidance_check >=", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckLessThan(Boolean value) {
            addCriterion("guidance_check <", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("guidance_check <=", value, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckIn(List<Boolean> values) {
            addCriterion("guidance_check in", values, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckNotIn(List<Boolean> values) {
            addCriterion("guidance_check not in", values, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("guidance_check between", value1, value2, "guidanceCheck");
            return (Criteria) this;
        }

        public Criteria andGuidanceCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("guidance_check not between", value1, value2, "guidanceCheck");
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

        public Criteria andTranslationCheckEqualTo(Boolean value) {
            addCriterion("translation_check =", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckNotEqualTo(Boolean value) {
            addCriterion("translation_check <>", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckGreaterThan(Boolean value) {
            addCriterion("translation_check >", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("translation_check >=", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckLessThan(Boolean value) {
            addCriterion("translation_check <", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("translation_check <=", value, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckIn(List<Boolean> values) {
            addCriterion("translation_check in", values, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckNotIn(List<Boolean> values) {
            addCriterion("translation_check not in", values, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("translation_check between", value1, value2, "translationCheck");
            return (Criteria) this;
        }

        public Criteria andTranslationCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("translation_check not between", value1, value2, "translationCheck");
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

        public Criteria andOriginalCheckEqualTo(Boolean value) {
            addCriterion("original_check =", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckNotEqualTo(Boolean value) {
            addCriterion("original_check <>", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckGreaterThan(Boolean value) {
            addCriterion("original_check >", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("original_check >=", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckLessThan(Boolean value) {
            addCriterion("original_check <", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("original_check <=", value, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckIn(List<Boolean> values) {
            addCriterion("original_check in", values, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckNotIn(List<Boolean> values) {
            addCriterion("original_check not in", values, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("original_check between", value1, value2, "originalCheck");
            return (Criteria) this;
        }

        public Criteria andOriginalCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("original_check not between", value1, value2, "originalCheck");
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

        public Criteria andLiteratureCheckEqualTo(Boolean value) {
            addCriterion("literature_check =", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckNotEqualTo(Boolean value) {
            addCriterion("literature_check <>", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckGreaterThan(Boolean value) {
            addCriterion("literature_check >", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("literature_check >=", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckLessThan(Boolean value) {
            addCriterion("literature_check <", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("literature_check <=", value, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckIn(List<Boolean> values) {
            addCriterion("literature_check in", values, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckNotIn(List<Boolean> values) {
            addCriterion("literature_check not in", values, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("literature_check between", value1, value2, "literatureCheck");
            return (Criteria) this;
        }

        public Criteria andLiteratureCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("literature_check not between", value1, value2, "literatureCheck");
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

        public Criteria andThesisCheckEqualTo(Boolean value) {
            addCriterion("thesis_check =", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckNotEqualTo(Boolean value) {
            addCriterion("thesis_check <>", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckGreaterThan(Boolean value) {
            addCriterion("thesis_check >", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("thesis_check >=", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckLessThan(Boolean value) {
            addCriterion("thesis_check <", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("thesis_check <=", value, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckIn(List<Boolean> values) {
            addCriterion("thesis_check in", values, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckNotIn(List<Boolean> values) {
            addCriterion("thesis_check not in", values, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("thesis_check between", value1, value2, "thesisCheck");
            return (Criteria) this;
        }

        public Criteria andThesisCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("thesis_check not between", value1, value2, "thesisCheck");
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