package cn.edu.nyist.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @ClassName HomePageDataDTO
 * @Description 首页数据集合
 * @Date 2020/2/28 13:42
 * @Created by typ
 */
public class HomePageDataDTO {
    /**
     * 当天当月生产量
     */
    private Integer dayOfProduction;
    private Integer monthOfProduction;

    /**
     * 当天当月未生产量
     */
    private Integer dayOfNoProduction;
    private Integer monthOfNoProduction;

    /**
     * 新增生产量
     */
    private Integer dayOfNewProduction;
    private Integer monthOfNewProduction;

    /**
     * 合同，计划，实际生产 近十天的和
     */
    private JSONArray contractOfTen;
    private JSONArray planOfTen;
    private JSONArray productOfTen;


    /**
     * 合同表地址百分比
     * @return
     */
    private Map<String,String> addressDistribution;

    /**
     * 同上期增
     * @return
     */
    private JSONObject increaseDistribution;

    public JSONObject getIncreaseDistribution() {
        return increaseDistribution;
    }

    public void setIncreaseDistribution(JSONObject increaseDistribution) {
        this.increaseDistribution = increaseDistribution;
    }

    public Map<String, String> getAddressDistribution() {
        return addressDistribution;
    }

    public void setAddressDistribution(Map<String, String> addressDistribution) {
        this.addressDistribution = addressDistribution;
    }

    public JSONArray getContractOfTen() {
        return contractOfTen;
    }

    public void setContractOfTen(JSONArray contractOfTen) {
        this.contractOfTen = contractOfTen;
    }

    public JSONArray getPlanOfTen() {
        return planOfTen;
    }

    public void setPlanOfTen(JSONArray planOfTen) {
        this.planOfTen = planOfTen;
    }

    public JSONArray getProductOfTen() {
        return productOfTen;
    }

    public void setProductOfTen(JSONArray productOfTen) {
        this.productOfTen = productOfTen;
    }

    public Integer getDayOfProduction() {
        return dayOfProduction;
    }

    public void setDayOfProduction(Integer dayOfProduction) {
        this.dayOfProduction = dayOfProduction;
    }

    public Integer getMonthOfProduction() {
        return monthOfProduction;
    }

    public void setMonthOfProduction(Integer monthOfProduction) {
        this.monthOfProduction = monthOfProduction;
    }

    public Integer getDayOfNoProduction() {
        return dayOfNoProduction;
    }

    public void setDayOfNoProduction(Integer dayOfNoProduction) {
        this.dayOfNoProduction = dayOfNoProduction;
    }

    public Integer getMonthOfNoProduction() {
        return monthOfNoProduction;
    }

    public void setMonthOfNoProduction(Integer monthOfNoProduction) {
        this.monthOfNoProduction = monthOfNoProduction;
    }

    public Integer getDayOfNewProduction() {
        return dayOfNewProduction;
    }

    public void setDayOfNewProduction(Integer dayOfNewProduction) {
        this.dayOfNewProduction = dayOfNewProduction;
    }

    public Integer getMonthOfNewProduction() {
        return monthOfNewProduction;
    }

    public void setMonthOfNewProduction(Integer monthOfNewProduction) {
        this.monthOfNewProduction = monthOfNewProduction;
    }

    @Override
    public String toString() {
        return "HomePageDataDTO{" +
                "dayOfProduction=" + dayOfProduction +
                ", monthOfProduction=" + monthOfProduction +
                ", dayOfNoProduction=" + dayOfNoProduction +
                ", monthOfNoProduction=" + monthOfNoProduction +
                ", dayOfNewProduction=" + dayOfNewProduction +
                ", monthOfNewProduction=" + monthOfNewProduction +
                ", contractOfTen=" + contractOfTen +
                ", planOfTen=" + planOfTen +
                ", productOfTen=" + productOfTen +
                ", addressDistribution=" + addressDistribution +
                ", increaseDistribution=" + increaseDistribution +
                '}';
    }
}
