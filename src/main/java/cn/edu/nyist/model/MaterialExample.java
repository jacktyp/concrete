package cn.edu.nyist.model;

import java.util.ArrayList;
import java.util.List;

public class MaterialExample {
    /**
     * material
     */
    protected String orderByClause;

    /**
     * material
     */
    protected boolean distinct;

    /**
     * material
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public MaterialExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * material null
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoneIsNull() {
            addCriterion("stone is null");
            return (Criteria) this;
        }

        public Criteria andStoneIsNotNull() {
            addCriterion("stone is not null");
            return (Criteria) this;
        }

        public Criteria andStoneEqualTo(Integer value) {
            addCriterion("stone =", value, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneNotEqualTo(Integer value) {
            addCriterion("stone <>", value, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneGreaterThan(Integer value) {
            addCriterion("stone >", value, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("stone >=", value, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneLessThan(Integer value) {
            addCriterion("stone <", value, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneLessThanOrEqualTo(Integer value) {
            addCriterion("stone <=", value, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneIn(List<Integer> values) {
            addCriterion("stone in", values, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneNotIn(List<Integer> values) {
            addCriterion("stone not in", values, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneBetween(Integer value1, Integer value2) {
            addCriterion("stone between", value1, value2, "stone");
            return (Criteria) this;
        }

        public Criteria andStoneNotBetween(Integer value1, Integer value2) {
            addCriterion("stone not between", value1, value2, "stone");
            return (Criteria) this;
        }

        public Criteria andSandIsNull() {
            addCriterion("sand is null");
            return (Criteria) this;
        }

        public Criteria andSandIsNotNull() {
            addCriterion("sand is not null");
            return (Criteria) this;
        }

        public Criteria andSandEqualTo(Integer value) {
            addCriterion("sand =", value, "sand");
            return (Criteria) this;
        }

        public Criteria andSandNotEqualTo(Integer value) {
            addCriterion("sand <>", value, "sand");
            return (Criteria) this;
        }

        public Criteria andSandGreaterThan(Integer value) {
            addCriterion("sand >", value, "sand");
            return (Criteria) this;
        }

        public Criteria andSandGreaterThanOrEqualTo(Integer value) {
            addCriterion("sand >=", value, "sand");
            return (Criteria) this;
        }

        public Criteria andSandLessThan(Integer value) {
            addCriterion("sand <", value, "sand");
            return (Criteria) this;
        }

        public Criteria andSandLessThanOrEqualTo(Integer value) {
            addCriterion("sand <=", value, "sand");
            return (Criteria) this;
        }

        public Criteria andSandIn(List<Integer> values) {
            addCriterion("sand in", values, "sand");
            return (Criteria) this;
        }

        public Criteria andSandNotIn(List<Integer> values) {
            addCriterion("sand not in", values, "sand");
            return (Criteria) this;
        }

        public Criteria andSandBetween(Integer value1, Integer value2) {
            addCriterion("sand between", value1, value2, "sand");
            return (Criteria) this;
        }

        public Criteria andSandNotBetween(Integer value1, Integer value2) {
            addCriterion("sand not between", value1, value2, "sand");
            return (Criteria) this;
        }

        public Criteria andCementIsNull() {
            addCriterion("cement is null");
            return (Criteria) this;
        }

        public Criteria andCementIsNotNull() {
            addCriterion("cement is not null");
            return (Criteria) this;
        }

        public Criteria andCementEqualTo(Integer value) {
            addCriterion("cement =", value, "cement");
            return (Criteria) this;
        }

        public Criteria andCementNotEqualTo(Integer value) {
            addCriterion("cement <>", value, "cement");
            return (Criteria) this;
        }

        public Criteria andCementGreaterThan(Integer value) {
            addCriterion("cement >", value, "cement");
            return (Criteria) this;
        }

        public Criteria andCementGreaterThanOrEqualTo(Integer value) {
            addCriterion("cement >=", value, "cement");
            return (Criteria) this;
        }

        public Criteria andCementLessThan(Integer value) {
            addCriterion("cement <", value, "cement");
            return (Criteria) this;
        }

        public Criteria andCementLessThanOrEqualTo(Integer value) {
            addCriterion("cement <=", value, "cement");
            return (Criteria) this;
        }

        public Criteria andCementIn(List<Integer> values) {
            addCriterion("cement in", values, "cement");
            return (Criteria) this;
        }

        public Criteria andCementNotIn(List<Integer> values) {
            addCriterion("cement not in", values, "cement");
            return (Criteria) this;
        }

        public Criteria andCementBetween(Integer value1, Integer value2) {
            addCriterion("cement between", value1, value2, "cement");
            return (Criteria) this;
        }

        public Criteria andCementNotBetween(Integer value1, Integer value2) {
            addCriterion("cement not between", value1, value2, "cement");
            return (Criteria) this;
        }

        public Criteria andAdditiveIsNull() {
            addCriterion("additive is null");
            return (Criteria) this;
        }

        public Criteria andAdditiveIsNotNull() {
            addCriterion("additive is not null");
            return (Criteria) this;
        }

        public Criteria andAdditiveEqualTo(Integer value) {
            addCriterion("additive =", value, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveNotEqualTo(Integer value) {
            addCriterion("additive <>", value, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveGreaterThan(Integer value) {
            addCriterion("additive >", value, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("additive >=", value, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveLessThan(Integer value) {
            addCriterion("additive <", value, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveLessThanOrEqualTo(Integer value) {
            addCriterion("additive <=", value, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveIn(List<Integer> values) {
            addCriterion("additive in", values, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveNotIn(List<Integer> values) {
            addCriterion("additive not in", values, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveBetween(Integer value1, Integer value2) {
            addCriterion("additive between", value1, value2, "additive");
            return (Criteria) this;
        }

        public Criteria andAdditiveNotBetween(Integer value1, Integer value2) {
            addCriterion("additive not between", value1, value2, "additive");
            return (Criteria) this;
        }
    }

    /**
     * material
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * material null
     */
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