package cn.edu.nyist.model;

import java.util.ArrayList;
import java.util.List;

public class NotificationExample {
    /**
     * notification
     */
    protected String orderByClause;

    /**
     * notification
     */
    protected boolean distinct;

    /**
     * notification
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public NotificationExample() {
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
     * notification null
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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Integer value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Integer value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Integer value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Integer value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Integer> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Integer> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdIsNull() {
            addCriterion("mixproportion_id is null");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdIsNotNull() {
            addCriterion("mixproportion_id is not null");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdEqualTo(Integer value) {
            addCriterion("mixproportion_id =", value, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdNotEqualTo(Integer value) {
            addCriterion("mixproportion_id <>", value, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdGreaterThan(Integer value) {
            addCriterion("mixproportion_id >", value, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mixproportion_id >=", value, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdLessThan(Integer value) {
            addCriterion("mixproportion_id <", value, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdLessThanOrEqualTo(Integer value) {
            addCriterion("mixproportion_id <=", value, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdIn(List<Integer> values) {
            addCriterion("mixproportion_id in", values, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdNotIn(List<Integer> values) {
            addCriterion("mixproportion_id not in", values, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdBetween(Integer value1, Integer value2) {
            addCriterion("mixproportion_id between", value1, value2, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andMixproportionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mixproportion_id not between", value1, value2, "mixproportionId");
            return (Criteria) this;
        }

        public Criteria andStoneamountIsNull() {
            addCriterion("stoneamount is null");
            return (Criteria) this;
        }

        public Criteria andStoneamountIsNotNull() {
            addCriterion("stoneamount is not null");
            return (Criteria) this;
        }

        public Criteria andStoneamountEqualTo(Integer value) {
            addCriterion("stoneamount =", value, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountNotEqualTo(Integer value) {
            addCriterion("stoneamount <>", value, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountGreaterThan(Integer value) {
            addCriterion("stoneamount >", value, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stoneamount >=", value, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountLessThan(Integer value) {
            addCriterion("stoneamount <", value, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountLessThanOrEqualTo(Integer value) {
            addCriterion("stoneamount <=", value, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountIn(List<Integer> values) {
            addCriterion("stoneamount in", values, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountNotIn(List<Integer> values) {
            addCriterion("stoneamount not in", values, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountBetween(Integer value1, Integer value2) {
            addCriterion("stoneamount between", value1, value2, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andStoneamountNotBetween(Integer value1, Integer value2) {
            addCriterion("stoneamount not between", value1, value2, "stoneamount");
            return (Criteria) this;
        }

        public Criteria andSandamountIsNull() {
            addCriterion("sandamount is null");
            return (Criteria) this;
        }

        public Criteria andSandamountIsNotNull() {
            addCriterion("sandamount is not null");
            return (Criteria) this;
        }

        public Criteria andSandamountEqualTo(Integer value) {
            addCriterion("sandamount =", value, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountNotEqualTo(Integer value) {
            addCriterion("sandamount <>", value, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountGreaterThan(Integer value) {
            addCriterion("sandamount >", value, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sandamount >=", value, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountLessThan(Integer value) {
            addCriterion("sandamount <", value, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountLessThanOrEqualTo(Integer value) {
            addCriterion("sandamount <=", value, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountIn(List<Integer> values) {
            addCriterion("sandamount in", values, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountNotIn(List<Integer> values) {
            addCriterion("sandamount not in", values, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountBetween(Integer value1, Integer value2) {
            addCriterion("sandamount between", value1, value2, "sandamount");
            return (Criteria) this;
        }

        public Criteria andSandamountNotBetween(Integer value1, Integer value2) {
            addCriterion("sandamount not between", value1, value2, "sandamount");
            return (Criteria) this;
        }

        public Criteria andCementamountIsNull() {
            addCriterion("cementamount is null");
            return (Criteria) this;
        }

        public Criteria andCementamountIsNotNull() {
            addCriterion("cementamount is not null");
            return (Criteria) this;
        }

        public Criteria andCementamountEqualTo(Integer value) {
            addCriterion("cementamount =", value, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountNotEqualTo(Integer value) {
            addCriterion("cementamount <>", value, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountGreaterThan(Integer value) {
            addCriterion("cementamount >", value, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("cementamount >=", value, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountLessThan(Integer value) {
            addCriterion("cementamount <", value, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountLessThanOrEqualTo(Integer value) {
            addCriterion("cementamount <=", value, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountIn(List<Integer> values) {
            addCriterion("cementamount in", values, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountNotIn(List<Integer> values) {
            addCriterion("cementamount not in", values, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountBetween(Integer value1, Integer value2) {
            addCriterion("cementamount between", value1, value2, "cementamount");
            return (Criteria) this;
        }

        public Criteria andCementamountNotBetween(Integer value1, Integer value2) {
            addCriterion("cementamount not between", value1, value2, "cementamount");
            return (Criteria) this;
        }

        public Criteria andWateramountIsNull() {
            addCriterion("wateramount is null");
            return (Criteria) this;
        }

        public Criteria andWateramountIsNotNull() {
            addCriterion("wateramount is not null");
            return (Criteria) this;
        }

        public Criteria andWateramountEqualTo(Integer value) {
            addCriterion("wateramount =", value, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountNotEqualTo(Integer value) {
            addCriterion("wateramount <>", value, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountGreaterThan(Integer value) {
            addCriterion("wateramount >", value, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wateramount >=", value, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountLessThan(Integer value) {
            addCriterion("wateramount <", value, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountLessThanOrEqualTo(Integer value) {
            addCriterion("wateramount <=", value, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountIn(List<Integer> values) {
            addCriterion("wateramount in", values, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountNotIn(List<Integer> values) {
            addCriterion("wateramount not in", values, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountBetween(Integer value1, Integer value2) {
            addCriterion("wateramount between", value1, value2, "wateramount");
            return (Criteria) this;
        }

        public Criteria andWateramountNotBetween(Integer value1, Integer value2) {
            addCriterion("wateramount not between", value1, value2, "wateramount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountIsNull() {
            addCriterion("additiveamount is null");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountIsNotNull() {
            addCriterion("additiveamount is not null");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountEqualTo(Integer value) {
            addCriterion("additiveamount =", value, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountNotEqualTo(Integer value) {
            addCriterion("additiveamount <>", value, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountGreaterThan(Integer value) {
            addCriterion("additiveamount >", value, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("additiveamount >=", value, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountLessThan(Integer value) {
            addCriterion("additiveamount <", value, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountLessThanOrEqualTo(Integer value) {
            addCriterion("additiveamount <=", value, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountIn(List<Integer> values) {
            addCriterion("additiveamount in", values, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountNotIn(List<Integer> values) {
            addCriterion("additiveamount not in", values, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountBetween(Integer value1, Integer value2) {
            addCriterion("additiveamount between", value1, value2, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andAdditiveamountNotBetween(Integer value1, Integer value2) {
            addCriterion("additiveamount not between", value1, value2, "additiveamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountIsNull() {
            addCriterion("concreteamount is null");
            return (Criteria) this;
        }

        public Criteria andConcreteamountIsNotNull() {
            addCriterion("concreteamount is not null");
            return (Criteria) this;
        }

        public Criteria andConcreteamountEqualTo(Integer value) {
            addCriterion("concreteamount =", value, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountNotEqualTo(Integer value) {
            addCriterion("concreteamount <>", value, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountGreaterThan(Integer value) {
            addCriterion("concreteamount >", value, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("concreteamount >=", value, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountLessThan(Integer value) {
            addCriterion("concreteamount <", value, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountLessThanOrEqualTo(Integer value) {
            addCriterion("concreteamount <=", value, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountIn(List<Integer> values) {
            addCriterion("concreteamount in", values, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountNotIn(List<Integer> values) {
            addCriterion("concreteamount not in", values, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountBetween(Integer value1, Integer value2) {
            addCriterion("concreteamount between", value1, value2, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andConcreteamountNotBetween(Integer value1, Integer value2) {
            addCriterion("concreteamount not between", value1, value2, "concreteamount");
            return (Criteria) this;
        }

        public Criteria andRegistrantIsNull() {
            addCriterion("registrant is null");
            return (Criteria) this;
        }

        public Criteria andRegistrantIsNotNull() {
            addCriterion("registrant is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrantEqualTo(String value) {
            addCriterion("registrant =", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotEqualTo(String value) {
            addCriterion("registrant <>", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantGreaterThan(String value) {
            addCriterion("registrant >", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantGreaterThanOrEqualTo(String value) {
            addCriterion("registrant >=", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantLessThan(String value) {
            addCriterion("registrant <", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantLessThanOrEqualTo(String value) {
            addCriterion("registrant <=", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantLike(String value) {
            addCriterion("registrant like", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotLike(String value) {
            addCriterion("registrant not like", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantIn(List<String> values) {
            addCriterion("registrant in", values, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotIn(List<String> values) {
            addCriterion("registrant not in", values, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantBetween(String value1, String value2) {
            addCriterion("registrant between", value1, value2, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotBetween(String value1, String value2) {
            addCriterion("registrant not between", value1, value2, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeIsNull() {
            addCriterion("registranttime is null");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeIsNotNull() {
            addCriterion("registranttime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeEqualTo(Long value) {
            addCriterion("registranttime =", value, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeNotEqualTo(Long value) {
            addCriterion("registranttime <>", value, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeGreaterThan(Long value) {
            addCriterion("registranttime >", value, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("registranttime >=", value, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeLessThan(Long value) {
            addCriterion("registranttime <", value, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeLessThanOrEqualTo(Long value) {
            addCriterion("registranttime <=", value, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeIn(List<Long> values) {
            addCriterion("registranttime in", values, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeNotIn(List<Long> values) {
            addCriterion("registranttime not in", values, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeBetween(Long value1, Long value2) {
            addCriterion("registranttime between", value1, value2, "registranttime");
            return (Criteria) this;
        }

        public Criteria andRegistranttimeNotBetween(Long value1, Long value2) {
            addCriterion("registranttime not between", value1, value2, "registranttime");
            return (Criteria) this;
        }
    }

    /**
     * notification
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * notification null
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