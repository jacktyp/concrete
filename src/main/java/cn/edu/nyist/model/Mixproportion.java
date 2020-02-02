package cn.edu.nyist.model;

public class Mixproportion {
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
    private Long experimenttime;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 配合比实验的名称
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return name 配合比实验的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 配合比实验的名称
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param name 配合比实验的名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 混凝土强度
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return concretegrade 混凝土强度
     */
    public String getConcretegrade() {
        return concretegrade;
    }

    /**
     * 混凝土强度
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param concretegrade 混凝土强度
     */
    public void setConcretegrade(String concretegrade) {
        this.concretegrade = concretegrade == null ? null : concretegrade.trim();
    }

    /**
     * 配合比
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return mp 配合比
     */
    public String getMp() {
        return mp;
    }

    /**
     * 配合比
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param mp 配合比
     */
    public void setMp(String mp) {
        this.mp = mp == null ? null : mp.trim();
    }

    /**
     * 每方混凝土的石头数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return stone 每方混凝土的石头数量
     */
    public Integer getStone() {
        return stone;
    }

    /**
     * 每方混凝土的石头数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param stone 每方混凝土的石头数量
     */
    public void setStone(Integer stone) {
        this.stone = stone;
    }

    /**
     * 每方混凝土的沙子数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return sand 每方混凝土的沙子数量
     */
    public Integer getSand() {
        return sand;
    }

    /**
     * 每方混凝土的沙子数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param sand 每方混凝土的沙子数量
     */
    public void setSand(Integer sand) {
        this.sand = sand;
    }

    /**
     * 每方混凝土的水泥数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return cement 每方混凝土的水泥数量
     */
    public Integer getCement() {
        return cement;
    }

    /**
     * 每方混凝土的水泥数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param cement 每方混凝土的水泥数量
     */
    public void setCement(Integer cement) {
        this.cement = cement;
    }

    /**
     * 每方混凝土的水数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return water 每方混凝土的水数量
     */
    public Integer getWater() {
        return water;
    }

    /**
     * 每方混凝土的水数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param water 每方混凝土的水数量
     */
    public void setWater(Integer water) {
        this.water = water;
    }

    /**
     * 每方混凝土的添加剂数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return additive 每方混凝土的添加剂数量
     */
    public Integer getAdditive() {
        return additive;
    }

    /**
     * 每方混凝土的添加剂数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param additive 每方混凝土的添加剂数量
     */
    public void setAdditive(Integer additive) {
        this.additive = additive;
    }

    /**
     * 是否合格
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return state 是否合格
     */
    public String getState() {
        return state;
    }

    /**
     * 是否合格
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param state 是否合格
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 实验人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return experiment 实验人
     */
    public String getExperiment() {
        return experiment;
    }

    /**
     * 实验人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param experiment 实验人
     */
    public void setExperiment(String experiment) {
        this.experiment = experiment == null ? null : experiment.trim();
    }

    /**
     * 实验时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return experimenttime 实验时间
     */
    public Long getExperimenttime() {
        return experimenttime;
    }

    /**
     * 实验时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param experimenttime 实验时间
     */
    public void setExperimenttime(Long experimenttime) {
        this.experimenttime = experimenttime;
    }

    /**
     * 备注
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Mixproportion{" +
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
                ", experimenttime=" + experimenttime +
                ", remark='" + remark + '\'' +
                '}';
    }
}