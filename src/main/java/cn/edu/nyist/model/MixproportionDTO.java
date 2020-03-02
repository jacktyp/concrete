package cn.edu.nyist.model;

import cn.edu.nyist.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @Classname MixproportionDTO
 * @Description TODO
 * @Date 2020/2/10 10:37
 * @Created by typ
 */
public class MixproportionDTO {
    private static final Logger logger = LoggerFactory.getLogger(MixproportionDTO.class);

    /**
     *  id
     */
    private Integer id;

    /**
     * 配合比实验的名称 name
     */
    private String name;

    /**
     * 混凝土强度 concretegrade
     */
    private String concretegrade;

    /**
     * 配合比 mp
     */
    private String mp;

    /**
     * 每方混凝土的石头数量 stone
     */
    private Integer stone;

    /**
     * 每方混凝土的沙子数量 sand
     */
    private Integer sand;

    /**
     * 每方混凝土的水泥数量 cement
     */
    private Integer cement;

    /**
     * 每方混凝土的水数量 water
     */
    private Integer water;

    /**
     * 每方混凝土的添加剂数量 additive
     */
    private Integer additive;

    /**
     * 是否合格 state
     */
    private String state;

    /**
     * 实验人 experiment
     */
    private String experiment;

    /**
     * 实验时间 experimenttime
     */
    private String experimenttime;

    /**
     * 备注 remark
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcretegrade() {
        return concretegrade;
    }

    public void setConcretegrade(String concretegrade) {
        this.concretegrade = concretegrade;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public Integer getStone() {
        return stone;
    }

    public void setStone(Integer stone) {
        this.stone = stone;
    }

    public Integer getSand() {
        return sand;
    }

    public void setSand(Integer sand) {
        this.sand = sand;
    }

    public Integer getCement() {
        return cement;
    }

    public void setCement(Integer cement) {
        this.cement = cement;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getAdditive() {
        return additive;
    }

    public void setAdditive(Integer additive) {
        this.additive = additive;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExperiment() {
        return experiment;
    }

    public void setExperiment(String experiment) {
        this.experiment = experiment;
    }

    public String getExperimenttime() {
        return experimenttime;
    }

    public void setExperimenttime(String experimenttime) {
        this.experimenttime = experimenttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MixproportionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", concretegrade='" + concretegrade + '\'' +
                ", mp='" + mp + '\'' +
                ", stone=" + stone +
                ", sand=" + sand +
                ", cement=" + cement +
                ", water=" + water +
                ", additive=" + additive +
                ", state='" + state + '\'' +
                ", experiment='" + experiment + '\'' +
                ", experimenttime='" + experimenttime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    /**
     * 转换成DTO
     * @param mixproportion
     * @return
     */
    public MixproportionDTO transfer(Mixproportion mixproportion){
        try {
            Long experimenttime = mixproportion.getExperimenttime();
            BeanUtils.copyProperties(mixproportion, this , "experimenttime");
            //签订时间 登记时间设置
            String experimenttimeToString = DateUtil.convertTimeToString(experimenttime);
            experimenttimeToString = DateUtil.cutBackZero(experimenttimeToString);
            this.setExperimenttime(experimenttimeToString);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return this;
    }

    /**
     * 转换返回
     * @param mixproportionDTO
     * @return
     */
    public Mixproportion transferBack(MixproportionDTO mixproportionDTO){
        Mixproportion mixproportion = new Mixproportion();
        try {
            String experimenttime = mixproportionDTO.getExperimenttime();
            BeanUtils.copyProperties(mixproportionDTO, mixproportion , "experimenttime");
            //签订时间 登记时间设置
            experimenttime = DateUtil.addBackZero(experimenttime);
            Long experimenttimeToLong = DateUtil.convertTimeToLong(experimenttime);
            mixproportion.setExperimenttime(experimenttimeToLong);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return mixproportion;
    }
}
