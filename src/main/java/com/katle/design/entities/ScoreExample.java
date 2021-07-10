package com.katle.design.entities;

import java.util.ArrayList;
import java.util.List;

public class ScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreExample() {
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

        public Criteria andGuidanceScoreIsNull() {
            addCriterion("guidance_score is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreIsNotNull() {
            addCriterion("guidance_score is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreEqualTo(Float value) {
            addCriterion("guidance_score =", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreNotEqualTo(Float value) {
            addCriterion("guidance_score <>", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreGreaterThan(Float value) {
            addCriterion("guidance_score >", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("guidance_score >=", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreLessThan(Float value) {
            addCriterion("guidance_score <", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreLessThanOrEqualTo(Float value) {
            addCriterion("guidance_score <=", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreIn(List<Float> values) {
            addCriterion("guidance_score in", values, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreNotIn(List<Float> values) {
            addCriterion("guidance_score not in", values, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreBetween(Float value1, Float value2) {
            addCriterion("guidance_score between", value1, value2, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreNotBetween(Float value1, Float value2) {
            addCriterion("guidance_score not between", value1, value2, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueIsNull() {
            addCriterion("guidancd_value is null");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueIsNotNull() {
            addCriterion("guidancd_value is not null");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueEqualTo(String value) {
            addCriterion("guidancd_value =", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueNotEqualTo(String value) {
            addCriterion("guidancd_value <>", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueGreaterThan(String value) {
            addCriterion("guidancd_value >", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueGreaterThanOrEqualTo(String value) {
            addCriterion("guidancd_value >=", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueLessThan(String value) {
            addCriterion("guidancd_value <", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueLessThanOrEqualTo(String value) {
            addCriterion("guidancd_value <=", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueLike(String value) {
            addCriterion("guidancd_value like", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueNotLike(String value) {
            addCriterion("guidancd_value not like", value, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueIn(List<String> values) {
            addCriterion("guidancd_value in", values, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueNotIn(List<String> values) {
            addCriterion("guidancd_value not in", values, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueBetween(String value1, String value2) {
            addCriterion("guidancd_value between", value1, value2, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidancdValueNotBetween(String value1, String value2) {
            addCriterion("guidancd_value not between", value1, value2, "guidancdValue");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorIsNull() {
            addCriterion("guidance_editor is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorIsNotNull() {
            addCriterion("guidance_editor is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorEqualTo(String value) {
            addCriterion("guidance_editor =", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorNotEqualTo(String value) {
            addCriterion("guidance_editor <>", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorGreaterThan(String value) {
            addCriterion("guidance_editor >", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_editor >=", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorLessThan(String value) {
            addCriterion("guidance_editor <", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorLessThanOrEqualTo(String value) {
            addCriterion("guidance_editor <=", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorLike(String value) {
            addCriterion("guidance_editor like", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorNotLike(String value) {
            addCriterion("guidance_editor not like", value, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorIn(List<String> values) {
            addCriterion("guidance_editor in", values, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorNotIn(List<String> values) {
            addCriterion("guidance_editor not in", values, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorBetween(String value1, String value2) {
            addCriterion("guidance_editor between", value1, value2, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceEditorNotBetween(String value1, String value2) {
            addCriterion("guidance_editor not between", value1, value2, "guidanceEditor");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureIsNull() {
            addCriterion("guidance_signature is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureIsNotNull() {
            addCriterion("guidance_signature is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureEqualTo(String value) {
            addCriterion("guidance_signature =", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureNotEqualTo(String value) {
            addCriterion("guidance_signature <>", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureGreaterThan(String value) {
            addCriterion("guidance_signature >", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("guidance_signature >=", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureLessThan(String value) {
            addCriterion("guidance_signature <", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureLessThanOrEqualTo(String value) {
            addCriterion("guidance_signature <=", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureLike(String value) {
            addCriterion("guidance_signature like", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureNotLike(String value) {
            addCriterion("guidance_signature not like", value, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureIn(List<String> values) {
            addCriterion("guidance_signature in", values, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureNotIn(List<String> values) {
            addCriterion("guidance_signature not in", values, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureBetween(String value1, String value2) {
            addCriterion("guidance_signature between", value1, value2, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andGuidanceSignatureNotBetween(String value1, String value2) {
            addCriterion("guidance_signature not between", value1, value2, "guidanceSignature");
            return (Criteria) this;
        }

        public Criteria andReadScoreIsNull() {
            addCriterion("read_score is null");
            return (Criteria) this;
        }

        public Criteria andReadScoreIsNotNull() {
            addCriterion("read_score is not null");
            return (Criteria) this;
        }

        public Criteria andReadScoreEqualTo(Float value) {
            addCriterion("read_score =", value, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreNotEqualTo(Float value) {
            addCriterion("read_score <>", value, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreGreaterThan(Float value) {
            addCriterion("read_score >", value, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("read_score >=", value, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreLessThan(Float value) {
            addCriterion("read_score <", value, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreLessThanOrEqualTo(Float value) {
            addCriterion("read_score <=", value, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreIn(List<Float> values) {
            addCriterion("read_score in", values, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreNotIn(List<Float> values) {
            addCriterion("read_score not in", values, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreBetween(Float value1, Float value2) {
            addCriterion("read_score between", value1, value2, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadScoreNotBetween(Float value1, Float value2) {
            addCriterion("read_score not between", value1, value2, "readScore");
            return (Criteria) this;
        }

        public Criteria andReadValueIsNull() {
            addCriterion("read_value is null");
            return (Criteria) this;
        }

        public Criteria andReadValueIsNotNull() {
            addCriterion("read_value is not null");
            return (Criteria) this;
        }

        public Criteria andReadValueEqualTo(String value) {
            addCriterion("read_value =", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueNotEqualTo(String value) {
            addCriterion("read_value <>", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueGreaterThan(String value) {
            addCriterion("read_value >", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueGreaterThanOrEqualTo(String value) {
            addCriterion("read_value >=", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueLessThan(String value) {
            addCriterion("read_value <", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueLessThanOrEqualTo(String value) {
            addCriterion("read_value <=", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueLike(String value) {
            addCriterion("read_value like", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueNotLike(String value) {
            addCriterion("read_value not like", value, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueIn(List<String> values) {
            addCriterion("read_value in", values, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueNotIn(List<String> values) {
            addCriterion("read_value not in", values, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueBetween(String value1, String value2) {
            addCriterion("read_value between", value1, value2, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadValueNotBetween(String value1, String value2) {
            addCriterion("read_value not between", value1, value2, "readValue");
            return (Criteria) this;
        }

        public Criteria andReadEditorIsNull() {
            addCriterion("read_editor is null");
            return (Criteria) this;
        }

        public Criteria andReadEditorIsNotNull() {
            addCriterion("read_editor is not null");
            return (Criteria) this;
        }

        public Criteria andReadEditorEqualTo(String value) {
            addCriterion("read_editor =", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorNotEqualTo(String value) {
            addCriterion("read_editor <>", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorGreaterThan(String value) {
            addCriterion("read_editor >", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorGreaterThanOrEqualTo(String value) {
            addCriterion("read_editor >=", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorLessThan(String value) {
            addCriterion("read_editor <", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorLessThanOrEqualTo(String value) {
            addCriterion("read_editor <=", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorLike(String value) {
            addCriterion("read_editor like", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorNotLike(String value) {
            addCriterion("read_editor not like", value, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorIn(List<String> values) {
            addCriterion("read_editor in", values, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorNotIn(List<String> values) {
            addCriterion("read_editor not in", values, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorBetween(String value1, String value2) {
            addCriterion("read_editor between", value1, value2, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadEditorNotBetween(String value1, String value2) {
            addCriterion("read_editor not between", value1, value2, "readEditor");
            return (Criteria) this;
        }

        public Criteria andReadSignatureIsNull() {
            addCriterion("read_signature is null");
            return (Criteria) this;
        }

        public Criteria andReadSignatureIsNotNull() {
            addCriterion("read_signature is not null");
            return (Criteria) this;
        }

        public Criteria andReadSignatureEqualTo(String value) {
            addCriterion("read_signature =", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureNotEqualTo(String value) {
            addCriterion("read_signature <>", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureGreaterThan(String value) {
            addCriterion("read_signature >", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("read_signature >=", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureLessThan(String value) {
            addCriterion("read_signature <", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureLessThanOrEqualTo(String value) {
            addCriterion("read_signature <=", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureLike(String value) {
            addCriterion("read_signature like", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureNotLike(String value) {
            addCriterion("read_signature not like", value, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureIn(List<String> values) {
            addCriterion("read_signature in", values, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureNotIn(List<String> values) {
            addCriterion("read_signature not in", values, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureBetween(String value1, String value2) {
            addCriterion("read_signature between", value1, value2, "readSignature");
            return (Criteria) this;
        }

        public Criteria andReadSignatureNotBetween(String value1, String value2) {
            addCriterion("read_signature not between", value1, value2, "readSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreIsNull() {
            addCriterion("defence_score is null");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreIsNotNull() {
            addCriterion("defence_score is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreEqualTo(Float value) {
            addCriterion("defence_score =", value, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreNotEqualTo(Float value) {
            addCriterion("defence_score <>", value, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreGreaterThan(Float value) {
            addCriterion("defence_score >", value, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("defence_score >=", value, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreLessThan(Float value) {
            addCriterion("defence_score <", value, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreLessThanOrEqualTo(Float value) {
            addCriterion("defence_score <=", value, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreIn(List<Float> values) {
            addCriterion("defence_score in", values, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreNotIn(List<Float> values) {
            addCriterion("defence_score not in", values, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreBetween(Float value1, Float value2) {
            addCriterion("defence_score between", value1, value2, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceScoreNotBetween(Float value1, Float value2) {
            addCriterion("defence_score not between", value1, value2, "defenceScore");
            return (Criteria) this;
        }

        public Criteria andDefenceValueIsNull() {
            addCriterion("defence_value is null");
            return (Criteria) this;
        }

        public Criteria andDefenceValueIsNotNull() {
            addCriterion("defence_value is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceValueEqualTo(String value) {
            addCriterion("defence_value =", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueNotEqualTo(String value) {
            addCriterion("defence_value <>", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueGreaterThan(String value) {
            addCriterion("defence_value >", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueGreaterThanOrEqualTo(String value) {
            addCriterion("defence_value >=", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueLessThan(String value) {
            addCriterion("defence_value <", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueLessThanOrEqualTo(String value) {
            addCriterion("defence_value <=", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueLike(String value) {
            addCriterion("defence_value like", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueNotLike(String value) {
            addCriterion("defence_value not like", value, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueIn(List<String> values) {
            addCriterion("defence_value in", values, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueNotIn(List<String> values) {
            addCriterion("defence_value not in", values, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueBetween(String value1, String value2) {
            addCriterion("defence_value between", value1, value2, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceValueNotBetween(String value1, String value2) {
            addCriterion("defence_value not between", value1, value2, "defenceValue");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureIsNull() {
            addCriterion("defence_signature is null");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureIsNotNull() {
            addCriterion("defence_signature is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureEqualTo(String value) {
            addCriterion("defence_signature =", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureNotEqualTo(String value) {
            addCriterion("defence_signature <>", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureGreaterThan(String value) {
            addCriterion("defence_signature >", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("defence_signature >=", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureLessThan(String value) {
            addCriterion("defence_signature <", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureLessThanOrEqualTo(String value) {
            addCriterion("defence_signature <=", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureLike(String value) {
            addCriterion("defence_signature like", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureNotLike(String value) {
            addCriterion("defence_signature not like", value, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureIn(List<String> values) {
            addCriterion("defence_signature in", values, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureNotIn(List<String> values) {
            addCriterion("defence_signature not in", values, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureBetween(String value1, String value2) {
            addCriterion("defence_signature between", value1, value2, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andDefenceSignatureNotBetween(String value1, String value2) {
            addCriterion("defence_signature not between", value1, value2, "defenceSignature");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Float value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Float value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Float value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Float value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Float value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Float> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Float> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Float value1, Float value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Float value1, Float value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorIsNull() {
            addCriterion("defence_editor is null");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorIsNotNull() {
            addCriterion("defence_editor is not null");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorEqualTo(String value) {
            addCriterion("defence_editor =", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorNotEqualTo(String value) {
            addCriterion("defence_editor <>", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorGreaterThan(String value) {
            addCriterion("defence_editor >", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorGreaterThanOrEqualTo(String value) {
            addCriterion("defence_editor >=", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorLessThan(String value) {
            addCriterion("defence_editor <", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorLessThanOrEqualTo(String value) {
            addCriterion("defence_editor <=", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorLike(String value) {
            addCriterion("defence_editor like", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorNotLike(String value) {
            addCriterion("defence_editor not like", value, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorIn(List<String> values) {
            addCriterion("defence_editor in", values, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorNotIn(List<String> values) {
            addCriterion("defence_editor not in", values, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorBetween(String value1, String value2) {
            addCriterion("defence_editor between", value1, value2, "defenceEditor");
            return (Criteria) this;
        }

        public Criteria andDefenceEditorNotBetween(String value1, String value2) {
            addCriterion("defence_editor not between", value1, value2, "defenceEditor");
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