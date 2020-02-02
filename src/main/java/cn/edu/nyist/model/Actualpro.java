package cn.edu.nyist.model;

public class Actualpro {
    /**
     *  id
     */
    private Integer id;

    /**
     * 计划标识 schedule_id
     */
    private Integer scheduleId;

    /**
     * 通知表标识 notification_id
     */
    private Integer notificationId;

    /**
     * 合同id contract_id
     */
    private Integer contractId;

    /**
     * 运输ID vehicle_id
     */
    private Integer vehicleId;

    /**
     * 实际石头总量 stoneamount
     */
    private Integer stoneamount;

    /**
     * 实际沙子总量 sandamount
     */
    private Integer sandamount;

    /**
     * 实际水泥总量 cementamount
     */
    private Integer cementamount;

    /**
     * 实际水总量 wateramount
     */
    private Integer wateramount;

    /**
     * 实际添加剂总量 additiveamount
     */
    private Integer additiveamount;

    /**
     * 实际混凝土总量 concreteamount
     */
    private Integer concreteamount;

    /**
     * 实际生产需时间 time
     */
    private Long time;

    /**
     * 实际生产开始时间 productiontime
     */
    private Long productiontime;

    /**
     * 实际生产结束时间 endtiime
     */
    private Long endtiime;

    /**
     * 实际生产登记人 registrant
     */
    private String registrant;

    /**
     * 实际生产登记时间 registranttime
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
     * 计划标识
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return schedule_id 计划标识
     */
    public Integer getScheduleId() {
        return scheduleId;
    }

    /**
     * 计划标识
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param scheduleId 计划标识
     */
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * 通知表标识
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return notification_id 通知表标识
     */
    public Integer getNotificationId() {
        return notificationId;
    }

    /**
     * 通知表标识
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param notificationId 通知表标识
     */
    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
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
     * 运输ID
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return vehicle_id 运输ID
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * 运输ID
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param vehicleId 运输ID
     */
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * 实际石头总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return stoneamount 实际石头总量
     */
    public Integer getStoneamount() {
        return stoneamount;
    }

    /**
     * 实际石头总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param stoneamount 实际石头总量
     */
    public void setStoneamount(Integer stoneamount) {
        this.stoneamount = stoneamount;
    }

    /**
     * 实际沙子总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return sandamount 实际沙子总量
     */
    public Integer getSandamount() {
        return sandamount;
    }

    /**
     * 实际沙子总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param sandamount 实际沙子总量
     */
    public void setSandamount(Integer sandamount) {
        this.sandamount = sandamount;
    }

    /**
     * 实际水泥总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return cementamount 实际水泥总量
     */
    public Integer getCementamount() {
        return cementamount;
    }

    /**
     * 实际水泥总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param cementamount 实际水泥总量
     */
    public void setCementamount(Integer cementamount) {
        this.cementamount = cementamount;
    }

    /**
     * 实际水总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return wateramount 实际水总量
     */
    public Integer getWateramount() {
        return wateramount;
    }

    /**
     * 实际水总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param wateramount 实际水总量
     */
    public void setWateramount(Integer wateramount) {
        this.wateramount = wateramount;
    }

    /**
     * 实际添加剂总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return additiveamount 实际添加剂总量
     */
    public Integer getAdditiveamount() {
        return additiveamount;
    }

    /**
     * 实际添加剂总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param additiveamount 实际添加剂总量
     */
    public void setAdditiveamount(Integer additiveamount) {
        this.additiveamount = additiveamount;
    }

    /**
     * 实际混凝土总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return concreteamount 实际混凝土总量
     */
    public Integer getConcreteamount() {
        return concreteamount;
    }

    /**
     * 实际混凝土总量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param concreteamount 实际混凝土总量
     */
    public void setConcreteamount(Integer concreteamount) {
        this.concreteamount = concreteamount;
    }

    /**
     * 实际生产需时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return time 实际生产需时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 实际生产需时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param time 实际生产需时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 实际生产开始时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return productiontime 实际生产开始时间
     */
    public Long getProductiontime() {
        return productiontime;
    }

    /**
     * 实际生产开始时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param productiontime 实际生产开始时间
     */
    public void setProductiontime(Long productiontime) {
        this.productiontime = productiontime;
    }

    /**
     * 实际生产结束时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return endtiime 实际生产结束时间
     */
    public Long getEndtiime() {
        return endtiime;
    }

    /**
     * 实际生产结束时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param endtiime 实际生产结束时间
     */
    public void setEndtiime(Long endtiime) {
        this.endtiime = endtiime;
    }

    /**
     * 实际生产登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registrant 实际生产登记人
     */
    public String getRegistrant() {
        return registrant;
    }

    /**
     * 实际生产登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registrant 实际生产登记人
     */
    public void setRegistrant(String registrant) {
        this.registrant = registrant == null ? null : registrant.trim();
    }

    /**
     * 实际生产登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registranttime 实际生产登记时间
     */
    public Long getRegistranttime() {
        return registranttime;
    }

    /**
     * 实际生产登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registranttime 实际生产登记时间
     */
    public void setRegistranttime(Long registranttime) {
        this.registranttime = registranttime;
    }

    @Override
    public String toString() {
        return "Actualpro{" +
                "id=" + id +
                ", scheduleId=" + scheduleId +
                ", notificationId=" + notificationId +
                ", contractId=" + contractId +
                ", vehicleId=" + vehicleId +
                ", stoneamount=" + stoneamount +
                ", sandamount=" + sandamount +
                ", cementamount=" + cementamount +
                ", wateramount=" + wateramount +
                ", additiveamount=" + additiveamount +
                ", concreteamount=" + concreteamount +
                ", time=" + time +
                ", productiontime=" + productiontime +
                ", endtiime=" + endtiime +
                ", registrant='" + registrant + '\'' +
                ", registranttime=" + registranttime +
                '}';
    }
}