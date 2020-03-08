package cn.edu.nyist.model;

public class Schedule {
    /**
     *  id
     *  车辆ID先不填写（多个）
     */
    private Integer id;

    /**
     * 通知表标识 notification_id
     */
    private Integer notificationId;

    /**
     * 合同id contract_id
     */
    private Integer contractId;

    /**
     * 车辆id vehicle_id
     */
    private Integer vehicleId;

    /**
     * 计划名称 name
     */
    private String name;

    /**
     * 计划状态，已完成还是未完成 state
     * 1 已完成
     * 0 未完成
     */
    private String state;

    /**
     * 计划生产需时间 time
     */
    private Long time;

    /**
     * 生产开始时间 productiontime
     */
    private Long productiontime;

    /**
     * 生产结束时间 endtiime
     */
    private Long endtiime;

    /**
     * 计划登记人 registrant
     */
    private String registrant;

    /**
     * 计划登记时间 registranttime
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
     * 车辆id
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return vehicle_id 车辆id
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * 车辆id
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param vehicleId 车辆id
     */
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * 计划名称
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return name 计划名称
     */
    public String getName() {
        return name;
    }

    /**
     * 计划名称
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param name 计划名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 计划状态，已完成还是未完成
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return state 计划状态，已完成还是未完成
     */
    public String getState() {
        return state;
    }

    /**
     * 计划状态，已完成还是未完成
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param state 计划状态，已完成还是未完成
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 计划生产需时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return time 计划生产需时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 计划生产需时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param time 计划生产需时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 生产开始时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return productiontime 生产开始时间
     */
    public Long getProductiontime() {
        return productiontime;
    }

    /**
     * 生产开始时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param productiontime 生产开始时间
     */
    public void setProductiontime(Long productiontime) {
        this.productiontime = productiontime;
    }

    /**
     * 生产结束时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return endtiime 生产结束时间
     */
    public Long getEndtiime() {
        return endtiime;
    }

    /**
     * 生产结束时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param endtiime 生产结束时间
     */
    public void setEndtiime(Long endtiime) {
        this.endtiime = endtiime;
    }

    /**
     * 计划登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registrant 计划登记人
     */
    public String getRegistrant() {
        return registrant;
    }

    /**
     * 计划登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registrant 计划登记人
     */
    public void setRegistrant(String registrant) {
        this.registrant = registrant == null ? null : registrant.trim();
    }

    /**
     * 计划登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registranttime 计划登记时间
     */
    public Long getRegistranttime() {
        return registranttime;
    }

    /**
     * 计划登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registranttime 计划登记时间
     */
    public void setRegistranttime(Long registranttime) {
        this.registranttime = registranttime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", notificationId=" + notificationId +
                ", contractId=" + contractId +
                ", vehicleId=" + vehicleId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", time=" + time +
                ", productiontime=" + productiontime +
                ", endtiime=" + endtiime +
                ", registrant='" + registrant + '\'' +
                ", registranttime=" + registranttime +
                '}';
    }
}