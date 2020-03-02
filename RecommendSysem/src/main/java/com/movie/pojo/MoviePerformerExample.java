package com.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class MoviePerformerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoviePerformerExample() {
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

        public Criteria andMpIdIsNull() {
            addCriterion("mp_id is null");
            return (Criteria) this;
        }

        public Criteria andMpIdIsNotNull() {
            addCriterion("mp_id is not null");
            return (Criteria) this;
        }

        public Criteria andMpIdEqualTo(Integer value) {
            addCriterion("mp_id =", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdNotEqualTo(Integer value) {
            addCriterion("mp_id <>", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdGreaterThan(Integer value) {
            addCriterion("mp_id >", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mp_id >=", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdLessThan(Integer value) {
            addCriterion("mp_id <", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdLessThanOrEqualTo(Integer value) {
            addCriterion("mp_id <=", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdIn(List<Integer> values) {
            addCriterion("mp_id in", values, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdNotIn(List<Integer> values) {
            addCriterion("mp_id not in", values, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdBetween(Integer value1, Integer value2) {
            addCriterion("mp_id between", value1, value2, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mp_id not between", value1, value2, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpNameIsNull() {
            addCriterion("mp_name is null");
            return (Criteria) this;
        }

        public Criteria andMpNameIsNotNull() {
            addCriterion("mp_name is not null");
            return (Criteria) this;
        }

        public Criteria andMpNameEqualTo(String value) {
            addCriterion("mp_name =", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotEqualTo(String value) {
            addCriterion("mp_name <>", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameGreaterThan(String value) {
            addCriterion("mp_name >", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameGreaterThanOrEqualTo(String value) {
            addCriterion("mp_name >=", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameLessThan(String value) {
            addCriterion("mp_name <", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameLessThanOrEqualTo(String value) {
            addCriterion("mp_name <=", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameLike(String value) {
            addCriterion("mp_name like", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotLike(String value) {
            addCriterion("mp_name not like", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameIn(List<String> values) {
            addCriterion("mp_name in", values, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotIn(List<String> values) {
            addCriterion("mp_name not in", values, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameBetween(String value1, String value2) {
            addCriterion("mp_name between", value1, value2, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotBetween(String value1, String value2) {
            addCriterion("mp_name not between", value1, value2, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpRoleIsNull() {
            addCriterion("mp_role is null");
            return (Criteria) this;
        }

        public Criteria andMpRoleIsNotNull() {
            addCriterion("mp_role is not null");
            return (Criteria) this;
        }

        public Criteria andMpRoleEqualTo(Integer value) {
            addCriterion("mp_role =", value, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleNotEqualTo(Integer value) {
            addCriterion("mp_role <>", value, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleGreaterThan(Integer value) {
            addCriterion("mp_role >", value, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("mp_role >=", value, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleLessThan(Integer value) {
            addCriterion("mp_role <", value, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleLessThanOrEqualTo(Integer value) {
            addCriterion("mp_role <=", value, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleIn(List<Integer> values) {
            addCriterion("mp_role in", values, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleNotIn(List<Integer> values) {
            addCriterion("mp_role not in", values, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleBetween(Integer value1, Integer value2) {
            addCriterion("mp_role between", value1, value2, "mpRole");
            return (Criteria) this;
        }

        public Criteria andMpRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("mp_role not between", value1, value2, "mpRole");
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