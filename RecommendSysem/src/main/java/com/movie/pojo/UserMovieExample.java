package com.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserMovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserMovieExample() {
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

        public Criteria andUmIdIsNull() {
            addCriterion("um_id is null");
            return (Criteria) this;
        }

        public Criteria andUmIdIsNotNull() {
            addCriterion("um_id is not null");
            return (Criteria) this;
        }

        public Criteria andUmIdEqualTo(Integer value) {
            addCriterion("um_id =", value, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdNotEqualTo(Integer value) {
            addCriterion("um_id <>", value, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdGreaterThan(Integer value) {
            addCriterion("um_id >", value, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("um_id >=", value, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdLessThan(Integer value) {
            addCriterion("um_id <", value, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdLessThanOrEqualTo(Integer value) {
            addCriterion("um_id <=", value, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdIn(List<Integer> values) {
            addCriterion("um_id in", values, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdNotIn(List<Integer> values) {
            addCriterion("um_id not in", values, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdBetween(Integer value1, Integer value2) {
            addCriterion("um_id between", value1, value2, "umId");
            return (Criteria) this;
        }

        public Criteria andUmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("um_id not between", value1, value2, "umId");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMovGradeIsNull() {
            addCriterion("mov_grade is null");
            return (Criteria) this;
        }

        public Criteria andMovGradeIsNotNull() {
            addCriterion("mov_grade is not null");
            return (Criteria) this;
        }

        public Criteria andMovGradeEqualTo(Integer value) {
            addCriterion("mov_grade =", value, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeNotEqualTo(Integer value) {
            addCriterion("mov_grade <>", value, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeGreaterThan(Integer value) {
            addCriterion("mov_grade >", value, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mov_grade >=", value, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeLessThan(Integer value) {
            addCriterion("mov_grade <", value, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeLessThanOrEqualTo(Integer value) {
            addCriterion("mov_grade <=", value, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeIn(List<Integer> values) {
            addCriterion("mov_grade in", values, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeNotIn(List<Integer> values) {
            addCriterion("mov_grade not in", values, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeBetween(Integer value1, Integer value2) {
            addCriterion("mov_grade between", value1, value2, "movGrade");
            return (Criteria) this;
        }

        public Criteria andMovGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("mov_grade not between", value1, value2, "movGrade");
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