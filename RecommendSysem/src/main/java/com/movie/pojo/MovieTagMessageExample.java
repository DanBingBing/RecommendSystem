package com.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class MovieTagMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieTagMessageExample() {
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

        public Criteria andMtmIdIsNull() {
            addCriterion("mtm_id is null");
            return (Criteria) this;
        }

        public Criteria andMtmIdIsNotNull() {
            addCriterion("mtm_id is not null");
            return (Criteria) this;
        }

        public Criteria andMtmIdEqualTo(Integer value) {
            addCriterion("mtm_id =", value, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdNotEqualTo(Integer value) {
            addCriterion("mtm_id <>", value, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdGreaterThan(Integer value) {
            addCriterion("mtm_id >", value, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mtm_id >=", value, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdLessThan(Integer value) {
            addCriterion("mtm_id <", value, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdLessThanOrEqualTo(Integer value) {
            addCriterion("mtm_id <=", value, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdIn(List<Integer> values) {
            addCriterion("mtm_id in", values, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdNotIn(List<Integer> values) {
            addCriterion("mtm_id not in", values, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdBetween(Integer value1, Integer value2) {
            addCriterion("mtm_id between", value1, value2, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMtmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mtm_id not between", value1, value2, "mtmId");
            return (Criteria) this;
        }

        public Criteria andMovIdIsNull() {
            addCriterion("mov_id is null");
            return (Criteria) this;
        }

        public Criteria andMovIdIsNotNull() {
            addCriterion("mov_id is not null");
            return (Criteria) this;
        }

        public Criteria andMovIdEqualTo(Integer value) {
            addCriterion("mov_id =", value, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdNotEqualTo(Integer value) {
            addCriterion("mov_id <>", value, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdGreaterThan(Integer value) {
            addCriterion("mov_id >", value, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mov_id >=", value, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdLessThan(Integer value) {
            addCriterion("mov_id <", value, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdLessThanOrEqualTo(Integer value) {
            addCriterion("mov_id <=", value, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdIn(List<Integer> values) {
            addCriterion("mov_id in", values, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdNotIn(List<Integer> values) {
            addCriterion("mov_id not in", values, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdBetween(Integer value1, Integer value2) {
            addCriterion("mov_id between", value1, value2, "movId");
            return (Criteria) this;
        }

        public Criteria andMovIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mov_id not between", value1, value2, "movId");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Integer value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Integer value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Integer value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Integer value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Integer> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Integer> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Integer value1, Integer value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
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