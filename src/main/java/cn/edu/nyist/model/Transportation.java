package cn.edu.nyist.model;

public class Transportation {
    /**
     *  id
     */
    private Integer id;

    /**
     * 车辆表标识 vehicle_id
     */
    private Integer vehicleId;

    /**
     * 合同id, contract_id
     */
    private Integer contractId;

    /**
     * 发车时间 time
     */
    private Long time;

    /**
     * 运输表登记人 registrant
     */
    private String registrant;

    /**
     * 运输表登记时间 registranttime
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
     * 车辆表标识
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return vehicle_id 车辆表标识
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * 车辆表标识
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param vehicleId 车辆表标识
     */
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * 合同id,
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return contract_id 合同id,
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * 合同id,
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param contractId 合同id,
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * 发车时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return time 发车时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 发车时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param time 发车时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 运输表登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registrant 运输表登记人
     */
    public String getRegistrant() {
        return registrant;
    }

    /**
     * 运输表登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registrant 运输表登记人
     */
    public void setRegistrant(String registrant) {
        this.registrant = registrant == null ? null : registrant.trim();
    }

    /**
     * 运输表登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registranttime 运输表登记时间
     */
    public Long getRegistranttime() {
        return registranttime;
    }

    /**
     * 运输表登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registranttime 运输表登记时间
     */
    public void setRegistranttime(Long registranttime) {
        this.registranttime = registranttime;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", contractId=" + contractId +
                ", time=" + time +
                ", registrant='" + registrant + '\'' +
                ", registranttime=" + registranttime +
                '}';
    }
}