package com.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class MoviePerformerMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoviePerformerMessageExample() {
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

        public Criteria andMpmIdIsNull() {
            addCriterion("mpm_id is null");
            return (Criteria) this;
        }

        public Criteria andMpmIdIsNotNull() {
            addCriterion("mpm_id is not null");
            return (Criteria) this;
        }

        public Criteria andMpmIdEqualTo(Integer value) {
            addCriterion("mpm_id =", value, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdNotEqualTo(Integer value) {
            addCriterion("mpm_id <>", value, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdGreaterThan(Integer value) {
            addCriterion("mpm_id >", value, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mpm_id >=", value, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdLessThan(Integer value) {
            addCriterion("mpm_id <", value, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdLessThanOrEqualTo(Integer value) {
            addCriterion("mpm_id <=", value, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdIn(List<Integer> values) {
            addCriterion("mpm_id in", values, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdNotIn(List<Integer> values) {
            addCriterion("mpm_id not in", values, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdBetween(Integer value1, Integer value2) {
            addCriterion("mpm_id between", value1, value2, "mpmId");
            return (Criteria) this;
        }

        public Criteria andMpmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mpm_id not between", value1, value2, "mpmId");
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

        public Criteria andPerIdIsNull() {
            addCriterion("per_id is null");
            return (Criteria) this;
        }

        public Criteria andPerIdIsNotNull() {
            addCriterion("per_id is not null");
            return (Criteria) this;
        }

        public Criteria andPerIdEqualTo(Integer value) {
            addCriterion("per_id =", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotEqualTo(Integer value) {
            addCriterion("per_id <>", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdGreaterThan(Integer value) {
            addCriterion("per_id >", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("per_id >=", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdLessThan(Integer value) {
            addCriterion("per_id <", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdLessThanOrEqualTo(Integer value) {
            addCriterion("per_id <=", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdIn(List<Integer> values) {
            addCriterion("per_id in", values, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotIn(List<Integer> values) {
            addCriterion("per_id not in", values, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdBetween(Integer value1, Integer value2) {
            addCriterion("per_id between", value1, value2, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("per_id not between", value1, value2, "perId");
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