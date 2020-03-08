package cn.edu.nyist.model;

public class Notification {
    /**
     *  id
     *  合同ID，混泥土强度（concretegrade），混凝土总量，  通过强度查询5  1000（配合比）*100（混凝土总量）
     */
    private Integer id;

    /**
     * 合同id contract_id
     */
    private Integer contractId;

    /**
     * 配合比id mixproportion_id
     */
    private Integer mixproportionId;

    /**
     * 石头总量 stoneamount
     */
    private Integer stoneamount;

    /**
     * 沙子总量 sandamount
     */
    private Integer sandamount;

    /**
     * 水泥总量 cementamount
     */
    private Integer cementamount;

    /**
     * 水总量 wateramount
     */
    private Integer wateramount;

    /**
     * 添加剂总量 additiveamount
     */
    private Integer additiveamount;

    /**
     * 混凝土总量 concreteamount
     */
    private Integer concreteamount;

    /**
     * 通知单登记人 registrant
     */
    private String registrant;

    /**
     * 通知单登记时间 registranttime
     */
    private Long registranttime;

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
     * 合同id
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return contract_id 合同id
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * 合同id
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param contractId 合同id
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * 配合比id
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return mixproportion_id 配合比id
     */
    public Integer getMixproportionId() {
        return mixproportionId;
    }

    /**
     * 配合比id
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param mixproportionId 配合比id
     */
    public void setMixproportionId(Integer mixproportionId) {
        this.mixproportionId = mixproportionId;
    }

    /**
     * 石头总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return stoneamount 石头总量
     */
    public Integer getStoneamount() {
        return stoneamount;
    }

    /**
     * 石头总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param stoneamount 石头总量
     */
    public void setStoneamount(Integer stoneamount) {
        this.stoneamount = stoneamount;
    }

    /**
     * 沙子总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return sandamount 沙子总量
     */
    public Integer getSandamount() {
        return sandamount;
    }

    /**
     * 沙子总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param sandamount 沙子总量
     */
    public void setSandamount(Integer sandamount) {
        this.sandamount = sandamount;
    }

    /**
     * 水泥总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return cementamount 水泥总量
     */
    public Integer getCementamount() {
        return cementamount;
    }

    /**
     * 水泥总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param cementamount 水泥总量
     */
    public void setCementamount(Integer cementamount) {
        this.cementamount = cementamount;
    }

    /**
     * 水总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return wateramount 水总量
     */
    public Integer getWateramount() {
        return wateramount;
    }

    /**
     * 水总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param wateramount 水总量
     */
    public void setWateramount(Integer wateramount) {
        this.wateramount = wateramount;
    }

    /**
     * 添加剂总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return additiveamount 添加剂总量
     */
    public Integer getAdditiveamount() {
        return additiveamount;
    }

    /**
     * 添加剂总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param additiveamount 添加剂总量
     */
    public void setAdditiveamount(Integer additiveamount) {
        this.additiveamount = additiveamount;
    }

    /**
     * 混凝土总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return concreteamount 混凝土总量
     */
    public Integer getConcreteamount() {
        return concreteamount;
    }

    /**
     * 混凝土总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param concreteamount 混凝土总量
     */
    public void setConcreteamount(Integer concreteamount) {
        this.concreteamount = concreteamount;
    }

    /**
     * 通知单登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registrant 通知单登记人
     */
    public String getRegistrant() {
        return registrant;
    }

    /**
     * 通知单登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registrant 通知单登记人
     */
    public void setRegistrant(String registrant) {
        this.registrant = registrant == null ? null : registrant.trim();
    }

    /**
     * 通知单登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registranttime 通知单登记时间
     */
    public Long getRegistranttime() {
        return registranttime;
    }

    /**
     * 通知单登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registranttime 通知单登记时间
     */
    public void setRegistranttime(Long registranttime) {
        this.registranttime = registranttime;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", mixproportionId=" + mixproportionId +
                ", stoneamount=" + stoneamount +
                ", sandamount=" + sandamount +
                ", cementamount=" + cementamount +
                ", wateramount=" + wateramount +
                ", additiveamount=" + additiveamount +
                ", concreteamount=" + concreteamount +
                ", registrant='" + registrant + '\'' +
                ", registranttime=" + registranttime +
                '}';
    }
}