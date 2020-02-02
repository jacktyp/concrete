package cn.edu.nyist.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleExample {
    /**
     * schedule
     */
    protected String orderByClause;

    /**
     * schedule
     */
    protected boolean distinct;

    /**
     * schedule
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public ScheduleExample() {
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
     * schedule null
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

        public Criteria andNotificationIdIsNull() {
            addCriterion("notification_id is null");
            return (Criteria) this;
        }

        public Criteria andNotificationIdIsNotNull() {
            addCriterion("notification_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationIdEqualTo(Integer value) {
            addCriterion("notification_id =", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotEqualTo(Integer value) {
            addCriterion("notification_id <>", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdGreaterThan(Integer value) {
            addCriterion("notification_id >", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notification_id >=", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdLessThan(Integer value) {
            addCriterion("notification_id <", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdLessThanOrEqualTo(Integer value) {
            addCriterion("notification_id <=", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdIn(List<Integer> values) {
            addCriterion("notification_id in", values, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotIn(List<Integer> values) {
            addCriterion("notification_id not in", values, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdBetween(Integer value1, Integer value2) {
            addCriterion("notification_id between", value1, value2, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notification_id not between", value1, value2, "notificationId");
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

        public Criteria andVehicleIdIsNull() {
            addCriterion("vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNotNull() {
            addCriterion("vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdEqualTo(Integer value) {
            addCriterion("vehicle_id =", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotEqualTo(Integer value) {
            addCriterion("vehicle_id <>", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThan(Integer value) {
            addCriterion("vehicle_id >", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id >=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThan(Integer value) {
            addCriterion("vehicle_id <", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id <=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIn(List<Integer> values) {
            addCriterion("vehicle_id in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotIn(List<Integer> values) {
            addCriterion("vehicle_id not in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id not between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andProductiontimeIsNull() {
            addCriterion("productiontime is null");
            return (Criteria) this;
        }

        public Criteria andProductiontimeIsNotNull() {
            addCriterion("productiontime is not null");
            return (Criteria) this;
        }

        public Criteria andProductiontimeEqualTo(Long value) {
            addCriterion("productiontime =", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeNotEqualTo(Long value) {
            addCriterion("productiontime <>", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeGreaterThan(Long value) {
            addCriterion("productiontime >", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeGreaterThanOrEqualTo(Long value) {
            addCriterion("productiontime >=", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeLessThan(Long value) {
            addCriterion("productiontime <", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeLessThanOrEqualTo(Long value) {
            addCriterion("productiontime <=", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeIn(List<Long> values) {
            addCriterion("productiontime in", values, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeNotIn(List<Long> values) {
            addCriterion("productiontime not in", values, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeBetween(Long value1, Long value2) {
            addCriterion("productiontime between", value1, value2, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeNotBetween(Long value1, Long value2) {
            addCriterion("productiontime not between", value1, value2, "productiontime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeIsNull() {
            addCriterion("endtiime is null");
            return (Criteria) this;
        }

        public Criteria andEndtiimeIsNotNull() {
            addCriterion("endtiime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtiimeEqualTo(Long value) {
            addCriterion("endtiime =", value, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeNotEqualTo(Long value) {
            addCriterion("endtiime <>", value, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeGreaterThan(Long value) {
            addCriterion("endtiime >", value, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeGreaterThanOrEqualTo(Long value) {
            addCriterion("endtiime >=", value, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeLessThan(Long value) {
            addCriterion("endtiime <", value, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeLessThanOrEqualTo(Long value) {
            addCriterion("endtiime <=", value, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeIn(List<Long> values) {
            addCriterion("endtiime in", values, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeNotIn(List<Long> values) {
            addCriterion("endtiime not in", values, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeBetween(Long value1, Long value2) {
            addCriterion("endtiime between", value1, value2, "endtiime");
            return (Criteria) this;
        }

        public Criteria andEndtiimeNotBetween(Long value1, Long value2) {
            addCriterion("endtiime not between", value1, value2, "endtiime");
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
     * schedule
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * schedule null
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