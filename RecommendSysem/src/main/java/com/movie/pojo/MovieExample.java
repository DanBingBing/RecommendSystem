package com.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class MovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieExample() {
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMNameIsNull() {
            addCriterion("m_name is null");
            return (Criteria) this;
        }

        public Criteria andMNameIsNotNull() {
            addCriterion("m_name is not null");
            return (Criteria) this;
        }

        public Criteria andMNameEqualTo(String value) {
            addCriterion("m_name =", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotEqualTo(String value) {
            addCriterion("m_name <>", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameGreaterThan(String value) {
            addCriterion("m_name >", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameGreaterThanOrEqualTo(String value) {
            addCriterion("m_name >=", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLessThan(String value) {
            addCriterion("m_name <", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLessThanOrEqualTo(String value) {
            addCriterion("m_name <=", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLike(String value) {
            addCriterion("m_name like", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotLike(String value) {
            addCriterion("m_name not like", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameIn(List<String> values) {
            addCriterion("m_name in", values, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotIn(List<String> values) {
            addCriterion("m_name not in", values, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameBetween(String value1, String value2) {
            addCriterion("m_name between", value1, value2, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotBetween(String value1, String value2) {
            addCriterion("m_name not between", value1, value2, "mName");
            return (Criteria) this;
        }

        public Criteria andMPosterIsNull() {
            addCriterion("m_poster is null");
            return (Criteria) this;
        }

        public Criteria andMPosterIsNotNull() {
            addCriterion("m_poster is not null");
            return (Criteria) this;
        }

        public Criteria andMPosterEqualTo(String value) {
            addCriterion("m_poster =", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterNotEqualTo(String value) {
            addCriterion("m_poster <>", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterGreaterThan(String value) {
            addCriterion("m_poster >", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterGreaterThanOrEqualTo(String value) {
            addCriterion("m_poster >=", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterLessThan(String value) {
            addCriterion("m_poster <", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterLessThanOrEqualTo(String value) {
            addCriterion("m_poster <=", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterLike(String value) {
            addCriterion("m_poster like", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterNotLike(String value) {
            addCriterion("m_poster not like", value, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterIn(List<String> values) {
            addCriterion("m_poster in", values, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterNotIn(List<String> values) {
            addCriterion("m_poster not in", values, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterBetween(String value1, String value2) {
            addCriterion("m_poster between", value1, value2, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMPosterNotBetween(String value1, String value2) {
            addCriterion("m_poster not between", value1, value2, "mPoster");
            return (Criteria) this;
        }

        public Criteria andMYearIsNull() {
            addCriterion("m_year is null");
            return (Criteria) this;
        }

        public Criteria andMYearIsNotNull() {
            addCriterion("m_year is not null");
            return (Criteria) this;
        }

        public Criteria andMYearEqualTo(String value) {
            addCriterion("m_year =", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearNotEqualTo(String value) {
            addCriterion("m_year <>", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearGreaterThan(String value) {
            addCriterion("m_year >", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearGreaterThanOrEqualTo(String value) {
            addCriterion("m_year >=", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearLessThan(String value) {
            addCriterion("m_year <", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearLessThanOrEqualTo(String value) {
            addCriterion("m_year <=", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearLike(String value) {
            addCriterion("m_year like", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearNotLike(String value) {
            addCriterion("m_year not like", value, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearIn(List<String> values) {
            addCriterion("m_year in", values, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearNotIn(List<String> values) {
            addCriterion("m_year not in", values, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearBetween(String value1, String value2) {
            addCriterion("m_year between", value1, value2, "mYear");
            return (Criteria) this;
        }

        public Criteria andMYearNotBetween(String value1, String value2) {
            addCriterion("m_year not between", value1, value2, "mYear");
            return (Criteria) this;
        }

        public Criteria andMTagIsNull() {
            addCriterion("m_tag is null");
            return (Criteria) this;
        }

        public Criteria andMTagIsNotNull() {
            addCriterion("m_tag is not null");
            return (Criteria) this;
        }

        public Criteria andMTagEqualTo(String value) {
            addCriterion("m_tag =", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagNotEqualTo(String value) {
            addCriterion("m_tag <>", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagGreaterThan(String value) {
            addCriterion("m_tag >", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagGreaterThanOrEqualTo(String value) {
            addCriterion("m_tag >=", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagLessThan(String value) {
            addCriterion("m_tag <", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagLessThanOrEqualTo(String value) {
            addCriterion("m_tag <=", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagLike(String value) {
            addCriterion("m_tag like", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagNotLike(String value) {
            addCriterion("m_tag not like", value, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagIn(List<String> values) {
            addCriterion("m_tag in", values, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagNotIn(List<String> values) {
            addCriterion("m_tag not in", values, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagBetween(String value1, String value2) {
            addCriterion("m_tag between", value1, value2, "mTag");
            return (Criteria) this;
        }

        public Criteria andMTagNotBetween(String value1, String value2) {
            addCriterion("m_tag not between", value1, value2, "mTag");
            return (Criteria) this;
        }

        public Criteria andMPerformerIsNull() {
            addCriterion("m_performer is null");
            return (Criteria) this;
        }

        public Criteria andMPerformerIsNotNull() {
            addCriterion("m_performer is not null");
            return (Criteria) this;
        }

        public Criteria andMPerformerEqualTo(String value) {
            addCriterion("m_performer =", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerNotEqualTo(String value) {
            addCriterion("m_performer <>", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerGreaterThan(String value) {
            addCriterion("m_performer >", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerGreaterThanOrEqualTo(String value) {
            addCriterion("m_performer >=", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerLessThan(String value) {
            addCriterion("m_performer <", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerLessThanOrEqualTo(String value) {
            addCriterion("m_performer <=", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerLike(String value) {
            addCriterion("m_performer like", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerNotLike(String value) {
            addCriterion("m_performer not like", value, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerIn(List<String> values) {
            addCriterion("m_performer in", values, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerNotIn(List<String> values) {
            addCriterion("m_performer not in", values, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerBetween(String value1, String value2) {
            addCriterion("m_performer between", value1, value2, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPerformerNotBetween(String value1, String value2) {
            addCriterion("m_performer not between", value1, value2, "mPerformer");
            return (Criteria) this;
        }

        public Criteria andMPictureIsNull() {
            addCriterion("m_picture is null");
            return (Criteria) this;
        }

        public Criteria andMPictureIsNotNull() {
            addCriterion("m_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMPictureEqualTo(String value) {
            addCriterion("m_picture =", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureNotEqualTo(String value) {
            addCriterion("m_picture <>", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureGreaterThan(String value) {
            addCriterion("m_picture >", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureGreaterThanOrEqualTo(String value) {
            addCriterion("m_picture >=", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureLessThan(String value) {
            addCriterion("m_picture <", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureLessThanOrEqualTo(String value) {
            addCriterion("m_picture <=", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureLike(String value) {
            addCriterion("m_picture like", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureNotLike(String value) {
            addCriterion("m_picture not like", value, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureIn(List<String> values) {
            addCriterion("m_picture in", values, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureNotIn(List<String> values) {
            addCriterion("m_picture not in", values, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureBetween(String value1, String value2) {
            addCriterion("m_picture between", value1, value2, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMPictureNotBetween(String value1, String value2) {
            addCriterion("m_picture not between", value1, value2, "mPicture");
            return (Criteria) this;
        }

        public Criteria andMGradeIsNull() {
            addCriterion("m_grade is null");
            return (Criteria) this;
        }

        public Criteria andMGradeIsNotNull() {
            addCriterion("m_grade is not null");
            return (Criteria) this;
        }

        public Criteria andMGradeEqualTo(Float value) {
            addCriterion("m_grade =", value, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeNotEqualTo(Float value) {
            addCriterion("m_grade <>", value, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeGreaterThan(Float value) {
            addCriterion("m_grade >", value, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeGreaterThanOrEqualTo(Float value) {
            addCriterion("m_grade >=", value, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeLessThan(Float value) {
            addCriterion("m_grade <", value, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeLessThanOrEqualTo(Float value) {
            addCriterion("m_grade <=", value, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeIn(List<Float> values) {
            addCriterion("m_grade in", values, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeNotIn(List<Float> values) {
            addCriterion("m_grade not in", values, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeBetween(Float value1, Float value2) {
            addCriterion("m_grade between", value1, value2, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMGradeNotBetween(Float value1, Float value2) {
            addCriterion("m_grade not between", value1, value2, "mGrade");
            return (Criteria) this;
        }

        public Criteria andMDescribeIsNull() {
            addCriterion("m_describe is null");
            return (Criteria) this;
        }

        public Criteria andMDescribeIsNotNull() {
            addCriterion("m_describe is not null");
            return (Criteria) this;
        }

        public Criteria andMDescribeEqualTo(String value) {
            addCriterion("m_describe =", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeNotEqualTo(String value) {
            addCriterion("m_describe <>", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeGreaterThan(String value) {
            addCriterion("m_describe >", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("m_describe >=", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeLessThan(String value) {
            addCriterion("m_describe <", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeLessThanOrEqualTo(String value) {
            addCriterion("m_describe <=", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeLike(String value) {
            addCriterion("m_describe like", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeNotLike(String value) {
            addCriterion("m_describe not like", value, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeIn(List<String> values) {
            addCriterion("m_describe in", values, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeNotIn(List<String> values) {
            addCriterion("m_describe not in", values, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeBetween(String value1, String value2) {
            addCriterion("m_describe between", value1, value2, "mDescribe");
            return (Criteria) this;
        }

        public Criteria andMDescribeNotBetween(String value1, String value2) {
            addCriterion("m_describe not between", value1, value2, "mDescribe");
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