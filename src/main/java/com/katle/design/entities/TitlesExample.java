package com.katle.design.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TitlesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TitlesExample() {
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

        public Criteria andTitleIdIsNull() {
            addCriterion("title_id is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("title_id is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(Long value) {
            addCriterion("title_id =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(Long value) {
            addCriterion("title_id <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(Long value) {
            addCriterion("title_id >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("title_id >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(Long value) {
            addCriterion("title_id <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(Long value) {
            addCriterion("title_id <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<Long> values) {
            addCriterion("title_id in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<Long> values) {
            addCriterion("title_id not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(Long value1, Long value2) {
            addCriterion("title_id between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(Long value1, Long value2) {
            addCriterion("title_id not between", value1, value2, "titleId");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNull() {
            addCriterion("title_name is null");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNotNull() {
            addCriterion("title_name is not null");
            return (Criteria) this;
        }

        public Criteria andTitleNameEqualTo(String value) {
            addCriterion("title_name =", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotEqualTo(String value) {
            addCriterion("title_name <>", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThan(String value) {
            addCriterion("title_name >", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("title_name >=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThan(String value) {
            addCriterion("title_name <", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThanOrEqualTo(String value) {
            addCriterion("title_name <=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLike(String value) {
            addCriterion("title_name like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotLike(String value) {
            addCriterion("title_name not like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameIn(List<String> values) {
            addCriterion("title_name in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotIn(List<String> values) {
            addCriterion("title_name not in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameBetween(String value1, String value2) {
            addCriterion("title_name between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotBetween(String value1, String value2) {
            addCriterion("title_name not between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleKindIsNull() {
            addCriterion("title_kind is null");
            return (Criteria) this;
        }

        public Criteria andTitleKindIsNotNull() {
            addCriterion("title_kind is not null");
            return (Criteria) this;
        }

        public Criteria andTitleKindEqualTo(String value) {
            addCriterion("title_kind =", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindNotEqualTo(String value) {
            addCriterion("title_kind <>", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindGreaterThan(String value) {
            addCriterion("title_kind >", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindGreaterThanOrEqualTo(String value) {
            addCriterion("title_kind >=", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindLessThan(String value) {
            addCriterion("title_kind <", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindLessThanOrEqualTo(String value) {
            addCriterion("title_kind <=", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindLike(String value) {
            addCriterion("title_kind like", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindNotLike(String value) {
            addCriterion("title_kind not like", value, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindIn(List<String> values) {
            addCriterion("title_kind in", values, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindNotIn(List<String> values) {
            addCriterion("title_kind not in", values, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindBetween(String value1, String value2) {
            addCriterion("title_kind between", value1, value2, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleKindNotBetween(String value1, String value2) {
            addCriterion("title_kind not between", value1, value2, "titleKind");
            return (Criteria) this;
        }

        public Criteria andTitleSourceIsNull() {
            addCriterion("title_source is null");
            return (Criteria) this;
        }

        public Criteria andTitleSourceIsNotNull() {
            addCriterion("title_source is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSourceEqualTo(String value) {
            addCriterion("title_source =", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceNotEqualTo(String value) {
            addCriterion("title_source <>", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceGreaterThan(String value) {
            addCriterion("title_source >", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceGreaterThanOrEqualTo(String value) {
            addCriterion("title_source >=", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceLessThan(String value) {
            addCriterion("title_source <", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceLessThanOrEqualTo(String value) {
            addCriterion("title_source <=", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceLike(String value) {
            addCriterion("title_source like", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceNotLike(String value) {
            addCriterion("title_source not like", value, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceIn(List<String> values) {
            addCriterion("title_source in", values, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceNotIn(List<String> values) {
            addCriterion("title_source not in", values, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceBetween(String value1, String value2) {
            addCriterion("title_source between", value1, value2, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleSourceNotBetween(String value1, String value2) {
            addCriterion("title_source not between", value1, value2, "titleSource");
            return (Criteria) this;
        }

        public Criteria andTitleModelIsNull() {
            addCriterion("title_model is null");
            return (Criteria) this;
        }

        public Criteria andTitleModelIsNotNull() {
            addCriterion("title_model is not null");
            return (Criteria) this;
        }

        public Criteria andTitleModelEqualTo(String value) {
            addCriterion("title_model =", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelNotEqualTo(String value) {
            addCriterion("title_model <>", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelGreaterThan(String value) {
            addCriterion("title_model >", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelGreaterThanOrEqualTo(String value) {
            addCriterion("title_model >=", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelLessThan(String value) {
            addCriterion("title_model <", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelLessThanOrEqualTo(String value) {
            addCriterion("title_model <=", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelLike(String value) {
            addCriterion("title_model like", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelNotLike(String value) {
            addCriterion("title_model not like", value, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelIn(List<String> values) {
            addCriterion("title_model in", values, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelNotIn(List<String> values) {
            addCriterion("title_model not in", values, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelBetween(String value1, String value2) {
            addCriterion("title_model between", value1, value2, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleModelNotBetween(String value1, String value2) {
            addCriterion("title_model not between", value1, value2, "titleModel");
            return (Criteria) this;
        }

        public Criteria andTitleYearIsNull() {
            addCriterion("title_year is null");
            return (Criteria) this;
        }

        public Criteria andTitleYearIsNotNull() {
            addCriterion("title_year is not null");
            return (Criteria) this;
        }

        public Criteria andTitleYearEqualTo(Date value) {
            addCriterionForJDBCDate("title_year =", value, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("title_year <>", value, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearGreaterThan(Date value) {
            addCriterionForJDBCDate("title_year >", value, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("title_year >=", value, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearLessThan(Date value) {
            addCriterionForJDBCDate("title_year <", value, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("title_year <=", value, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearIn(List<Date> values) {
            addCriterionForJDBCDate("title_year in", values, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("title_year not in", values, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("title_year between", value1, value2, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("title_year not between", value1, value2, "titleYear");
            return (Criteria) this;
        }

        public Criteria andTitleTypeIsNull() {
            addCriterion("title_type is null");
            return (Criteria) this;
        }

        public Criteria andTitleTypeIsNotNull() {
            addCriterion("title_type is not null");
            return (Criteria) this;
        }

        public Criteria andTitleTypeEqualTo(String value) {
            addCriterion("title_type =", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotEqualTo(String value) {
            addCriterion("title_type <>", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeGreaterThan(String value) {
            addCriterion("title_type >", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("title_type >=", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeLessThan(String value) {
            addCriterion("title_type <", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeLessThanOrEqualTo(String value) {
            addCriterion("title_type <=", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeLike(String value) {
            addCriterion("title_type like", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotLike(String value) {
            addCriterion("title_type not like", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeIn(List<String> values) {
            addCriterion("title_type in", values, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotIn(List<String> values) {
            addCriterion("title_type not in", values, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeBetween(String value1, String value2) {
            addCriterion("title_type between", value1, value2, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotBetween(String value1, String value2) {
            addCriterion("title_type not between", value1, value2, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteIsNull() {
            addCriterion("title_complete is null");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteIsNotNull() {
            addCriterion("title_complete is not null");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteEqualTo(String value) {
            addCriterion("title_complete =", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteNotEqualTo(String value) {
            addCriterion("title_complete <>", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteGreaterThan(String value) {
            addCriterion("title_complete >", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteGreaterThanOrEqualTo(String value) {
            addCriterion("title_complete >=", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteLessThan(String value) {
            addCriterion("title_complete <", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteLessThanOrEqualTo(String value) {
            addCriterion("title_complete <=", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteLike(String value) {
            addCriterion("title_complete like", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteNotLike(String value) {
            addCriterion("title_complete not like", value, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteIn(List<String> values) {
            addCriterion("title_complete in", values, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteNotIn(List<String> values) {
            addCriterion("title_complete not in", values, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteBetween(String value1, String value2) {
            addCriterion("title_complete between", value1, value2, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleCompleteNotBetween(String value1, String value2) {
            addCriterion("title_complete not between", value1, value2, "titleComplete");
            return (Criteria) this;
        }

        public Criteria andTitleValueIsNull() {
            addCriterion("title_value is null");
            return (Criteria) this;
        }

        public Criteria andTitleValueIsNotNull() {
            addCriterion("title_value is not null");
            return (Criteria) this;
        }

        public Criteria andTitleValueEqualTo(String value) {
            addCriterion("title_value =", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueNotEqualTo(String value) {
            addCriterion("title_value <>", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueGreaterThan(String value) {
            addCriterion("title_value >", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueGreaterThanOrEqualTo(String value) {
            addCriterion("title_value >=", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueLessThan(String value) {
            addCriterion("title_value <", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueLessThanOrEqualTo(String value) {
            addCriterion("title_value <=", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueLike(String value) {
            addCriterion("title_value like", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueNotLike(String value) {
            addCriterion("title_value not like", value, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueIn(List<String> values) {
            addCriterion("title_value in", values, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueNotIn(List<String> values) {
            addCriterion("title_value not in", values, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueBetween(String value1, String value2) {
            addCriterion("title_value between", value1, value2, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleValueNotBetween(String value1, String value2) {
            addCriterion("title_value not between", value1, value2, "titleValue");
            return (Criteria) this;
        }

        public Criteria andTitleRequireIsNull() {
            addCriterion("title_require is null");
            return (Criteria) this;
        }

        public Criteria andTitleRequireIsNotNull() {
            addCriterion("title_require is not null");
            return (Criteria) this;
        }

        public Criteria andTitleRequireEqualTo(String value) {
            addCriterion("title_require =", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireNotEqualTo(String value) {
            addCriterion("title_require <>", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireGreaterThan(String value) {
            addCriterion("title_require >", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireGreaterThanOrEqualTo(String value) {
            addCriterion("title_require >=", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireLessThan(String value) {
            addCriterion("title_require <", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireLessThanOrEqualTo(String value) {
            addCriterion("title_require <=", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireLike(String value) {
            addCriterion("title_require like", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireNotLike(String value) {
            addCriterion("title_require not like", value, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireIn(List<String> values) {
            addCriterion("title_require in", values, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireNotIn(List<String> values) {
            addCriterion("title_require not in", values, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireBetween(String value1, String value2) {
            addCriterion("title_require between", value1, value2, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleRequireNotBetween(String value1, String value2) {
            addCriterion("title_require not between", value1, value2, "titleRequire");
            return (Criteria) this;
        }

        public Criteria andTitleResultIsNull() {
            addCriterion("title_result is null");
            return (Criteria) this;
        }

        public Criteria andTitleResultIsNotNull() {
            addCriterion("title_result is not null");
            return (Criteria) this;
        }

        public Criteria andTitleResultEqualTo(String value) {
            addCriterion("title_result =", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultNotEqualTo(String value) {
            addCriterion("title_result <>", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultGreaterThan(String value) {
            addCriterion("title_result >", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultGreaterThanOrEqualTo(String value) {
            addCriterion("title_result >=", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultLessThan(String value) {
            addCriterion("title_result <", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultLessThanOrEqualTo(String value) {
            addCriterion("title_result <=", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultLike(String value) {
            addCriterion("title_result like", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultNotLike(String value) {
            addCriterion("title_result not like", value, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultIn(List<String> values) {
            addCriterion("title_result in", values, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultNotIn(List<String> values) {
            addCriterion("title_result not in", values, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultBetween(String value1, String value2) {
            addCriterion("title_result between", value1, value2, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleResultNotBetween(String value1, String value2) {
            addCriterion("title_result not between", value1, value2, "titleResult");
            return (Criteria) this;
        }

        public Criteria andTitleStateIsNull() {
            addCriterion("title_state is null");
            return (Criteria) this;
        }

        public Criteria andTitleStateIsNotNull() {
            addCriterion("title_state is not null");
            return (Criteria) this;
        }

        public Criteria andTitleStateEqualTo(String value) {
            addCriterion("title_state =", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateNotEqualTo(String value) {
            addCriterion("title_state <>", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateGreaterThan(String value) {
            addCriterion("title_state >", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateGreaterThanOrEqualTo(String value) {
            addCriterion("title_state >=", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateLessThan(String value) {
            addCriterion("title_state <", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateLessThanOrEqualTo(String value) {
            addCriterion("title_state <=", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateLike(String value) {
            addCriterion("title_state like", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateNotLike(String value) {
            addCriterion("title_state not like", value, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateIn(List<String> values) {
            addCriterion("title_state in", values, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateNotIn(List<String> values) {
            addCriterion("title_state not in", values, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateBetween(String value1, String value2) {
            addCriterion("title_state between", value1, value2, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleStateNotBetween(String value1, String value2) {
            addCriterion("title_state not between", value1, value2, "titleState");
            return (Criteria) this;
        }

        public Criteria andTitleMajorIsNull() {
            addCriterion("title_major is null");
            return (Criteria) this;
        }

        public Criteria andTitleMajorIsNotNull() {
            addCriterion("title_major is not null");
            return (Criteria) this;
        }

        public Criteria andTitleMajorEqualTo(String value) {
            addCriterion("title_major =", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorNotEqualTo(String value) {
            addCriterion("title_major <>", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorGreaterThan(String value) {
            addCriterion("title_major >", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorGreaterThanOrEqualTo(String value) {
            addCriterion("title_major >=", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorLessThan(String value) {
            addCriterion("title_major <", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorLessThanOrEqualTo(String value) {
            addCriterion("title_major <=", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorLike(String value) {
            addCriterion("title_major like", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorNotLike(String value) {
            addCriterion("title_major not like", value, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorIn(List<String> values) {
            addCriterion("title_major in", values, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorNotIn(List<String> values) {
            addCriterion("title_major not in", values, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorBetween(String value1, String value2) {
            addCriterion("title_major between", value1, value2, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleMajorNotBetween(String value1, String value2) {
            addCriterion("title_major not between", value1, value2, "titleMajor");
            return (Criteria) this;
        }

        public Criteria andTitleSelectIsNull() {
            addCriterion("title_select is null");
            return (Criteria) this;
        }

        public Criteria andTitleSelectIsNotNull() {
            addCriterion("title_select is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSelectEqualTo(Boolean value) {
            addCriterion("title_select =", value, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectNotEqualTo(Boolean value) {
            addCriterion("title_select <>", value, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectGreaterThan(Boolean value) {
            addCriterion("title_select >", value, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectGreaterThanOrEqualTo(Boolean value) {
            addCriterion("title_select >=", value, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectLessThan(Boolean value) {
            addCriterion("title_select <", value, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectLessThanOrEqualTo(Boolean value) {
            addCriterion("title_select <=", value, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectIn(List<Boolean> values) {
            addCriterion("title_select in", values, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectNotIn(List<Boolean> values) {
            addCriterion("title_select not in", values, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectBetween(Boolean value1, Boolean value2) {
            addCriterion("title_select between", value1, value2, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSelectNotBetween(Boolean value1, Boolean value2) {
            addCriterion("title_select not between", value1, value2, "titleSelect");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterIsNull() {
            addCriterion("title_semester is null");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterIsNotNull() {
            addCriterion("title_semester is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterEqualTo(String value) {
            addCriterion("title_semester =", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterNotEqualTo(String value) {
            addCriterion("title_semester <>", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterGreaterThan(String value) {
            addCriterion("title_semester >", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterGreaterThanOrEqualTo(String value) {
            addCriterion("title_semester >=", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterLessThan(String value) {
            addCriterion("title_semester <", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterLessThanOrEqualTo(String value) {
            addCriterion("title_semester <=", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterLike(String value) {
            addCriterion("title_semester like", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterNotLike(String value) {
            addCriterion("title_semester not like", value, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterIn(List<String> values) {
            addCriterion("title_semester in", values, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterNotIn(List<String> values) {
            addCriterion("title_semester not in", values, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterBetween(String value1, String value2) {
            addCriterion("title_semester between", value1, value2, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleSemesterNotBetween(String value1, String value2) {
            addCriterion("title_semester not between", value1, value2, "titleSemester");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanIsNull() {
            addCriterion("title_checkMan is null");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanIsNotNull() {
            addCriterion("title_checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanEqualTo(Long value) {
            addCriterion("title_checkMan =", value, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanNotEqualTo(Long value) {
            addCriterion("title_checkMan <>", value, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanGreaterThan(Long value) {
            addCriterion("title_checkMan >", value, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("title_checkMan >=", value, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanLessThan(Long value) {
            addCriterion("title_checkMan <", value, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("title_checkMan <=", value, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanIn(List<Long> values) {
            addCriterion("title_checkMan in", values, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanNotIn(List<Long> values) {
            addCriterion("title_checkMan not in", values, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanBetween(Long value1, Long value2) {
            addCriterion("title_checkMan between", value1, value2, "titleCheckman");
            return (Criteria) this;
        }

        public Criteria andTitleCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("title_checkMan not between", value1, value2, "titleCheckman");
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