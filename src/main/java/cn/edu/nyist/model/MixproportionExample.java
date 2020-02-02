package cn.edu.nyist.model;

import java.util.ArrayList;
import java.util.List;

public class MixproportionExample {
    /**
     * mixproportion
     */
    protected String orderByClause;

    /**
     * mixproportion
     */
    protected boolean distinct;

    /**
     * mixproportion
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public MixproportionExample() {
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
     * mixproportion null
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

        public Criteria andConcretegradeIsNull() {
            addCriterion("concretegrade is null");
            return (Criteria) this;
        }

        public Criteria andConcretegradeIsNotNull() {
            addCriterion("concretegrade is not null");
            return (Criteria) this;
        }

        public Criteria andConcretegradeEqualTo(String value) {
            addCriterion("concretegrade =", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeNotEqualTo(String value) {
            addCriterion("concretegrade <>", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeGreaterThan(String value) {
            addCriterion("concretegrade >", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeGreaterThanOrEqualTo(String value) {
            addCriterion("concretegrade >=", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeLessThan(String value) {
            addCriterion("concretegrade <", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeLessThanOrEqualTo(String value) {
            addCriterion("concretegrade <=", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeLike(String value) {
            addCriterion("concretegrade like", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeNotLike(String value) {
            addCriterion("concretegrade not like", value, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeIn(List<String> values) {
            addCriterion("concretegrade in", values, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeNotIn(List<String> values) {
            addCriterion("concretegrade not in", values, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeBetween(String value1, String value2) {
            addCriterion("concretegrade between", value1, value2, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andConcretegradeNotBetween(String value1, String value2) {
            addCriterion("concretegrade not between", value1, value2, "concretegrade");
            return (Criteria) this;
        }

        public Criteria andMpIsNull() {
            addCriterion("mp is null");
            return (Criteria) this;
        }

        public Criteria andMpIsNotNull() {
            addCriterion("mp is not null");
            return (Criteria) this;
        }

        public Criteria andMpEqualTo(String value) {
            addCriterion("mp =", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotEqualTo(String value) {
            addCriterion("mp <>", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpGreaterThan(String value) {
            addCriterion("mp >", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpGreaterThanOrEqualTo(String value) {
            addCriterion("mp >=", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpLessThan(String value) {
            addCriterion("mp <", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpLessThanOrEqualTo(String value) {
            addCriterion("mp <=", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpLike(String value) {
            addCriterion("mp like", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotLike(String value) {
            addCriterion("mp not like", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpIn(List<String> values) {
            addCriterion("mp in", values, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotIn(List<String> values) {
            addCriterion("mp not in", values, "mp");
            return (Criteria) this;
        }

        public Criteria andMpBetween(String value1, String value2) {
            addCriterion("mp between", value1, value2, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotBetween(String value1, String value2) {
            addCriterion("mp not between", value1, value2, "mp");
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

        public Criteria andWaterIsNull() {
            addCriterion("water is null");
            return (Criteria) this;
        }

        public Criteria andWaterIsNotNull() {
            addCriterion("water is not null");
            return (Criteria) this;
        }

        public Criteria andWaterEqualTo(Integer value) {
            addCriterion("water =", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotEqualTo(Integer value) {
            addCriterion("water <>", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThan(Integer value) {
            addCriterion("water >", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("water >=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThan(Integer value) {
            addCriterion("water <", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThanOrEqualTo(Integer value) {
            addCriterion("water <=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterIn(List<Integer> values) {
            addCriterion("water in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotIn(List<Integer> values) {
            addCriterion("water not in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterBetween(Integer value1, Integer value2) {
            addCriterion("water between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotBetween(Integer value1, Integer value2) {
            addCriterion("water not between", value1, value2, "water");
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

        public Criteria andExperimentIsNull() {
            addCriterion("experiment is null");
            return (Criteria) this;
        }

        public Criteria andExperimentIsNotNull() {
            addCriterion("experiment is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentEqualTo(String value) {
            addCriterion("experiment =", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotEqualTo(String value) {
            addCriterion("experiment <>", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentGreaterThan(String value) {
            addCriterion("experiment >", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentGreaterThanOrEqualTo(String value) {
            addCriterion("experiment >=", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentLessThan(String value) {
            addCriterion("experiment <", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentLessThanOrEqualTo(String value) {
            addCriterion("experiment <=", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentLike(String value) {
            addCriterion("experiment like", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotLike(String value) {
            addCriterion("experiment not like", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentIn(List<String> values) {
            addCriterion("experiment in", values, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotIn(List<String> values) {
            addCriterion("experiment not in", values, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentBetween(String value1, String value2) {
            addCriterion("experiment between", value1, value2, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotBetween(String value1, String value2) {
            addCriterion("experiment not between", value1, value2, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeIsNull() {
            addCriterion("experimenttime is null");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeIsNotNull() {
            addCriterion("experimenttime is not null");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeEqualTo(Long value) {
            addCriterion("experimenttime =", value, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeNotEqualTo(Long value) {
            addCriterion("experimenttime <>", value, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeGreaterThan(Long value) {
            addCriterion("experimenttime >", value, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("experimenttime >=", value, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeLessThan(Long value) {
            addCriterion("experimenttime <", value, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeLessThanOrEqualTo(Long value) {
            addCriterion("experimenttime <=", value, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeIn(List<Long> values) {
            addCriterion("experimenttime in", values, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeNotIn(List<Long> values) {
            addCriterion("experimenttime not in", values, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeBetween(Long value1, Long value2) {
            addCriterion("experimenttime between", value1, value2, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andExperimenttimeNotBetween(Long value1, Long value2) {
            addCriterion("experimenttime not between", value1, value2, "experimenttime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * mixproportion
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * mixproportion null
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