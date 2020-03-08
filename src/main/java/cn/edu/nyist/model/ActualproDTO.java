package cn.edu.nyist.model;

import cn.edu.nyist.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName ActualproDTO
 * @Description TODO
 * @Date 2020/3/8 16:31
 * @Created by typ
 */
public class ActualproDTO {
    private final static Logger logger = LoggerFactory.getLogger(ActualproDTO.class);

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
    private String registranttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getStoneamount() {
        return stoneamount;
    }

    public void setStoneamount(Integer stoneamount) {
        this.stoneamount = stoneamount;
    }

    public Integer getSandamount() {
        return sandamount;
    }

    public void setSandamount(Integer sandamount) {
        this.sandamount = sandamount;
    }

    public Integer getCementamount() {
        return cementamount;
    }

    public void setCementamount(Integer cementamount) {
        this.cementamount = cementamount;
    }

    public Integer getWateramount() {
        return wateramount;
    }

    public void setWateramount(Integer wateramount) {
        this.wateramount = wateramount;
    }

    public Integer getAdditiveamount() {
        return additiveamount;
    }

    public void setAdditiveamount(Integer additiveamount) {
        this.additiveamount = additiveamount;
    }

    public Integer getConcreteamount() {
        return concreteamount;
    }

    public void setConcreteamount(Integer concreteamount) {
        this.concreteamount = concreteamount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getProductiontime() {
        return productiontime;
    }

    public void setProductiontime(Long productiontime) {
        this.productiontime = productiontime;
    }

    public Long getEndtiime() {
        return endtiime;
    }

    public void setEndtiime(Long endtiime) {
        this.endtiime = endtiime;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistranttime() {
        return registranttime;
    }

    public void setRegistranttime(String registranttime) {
        this.registranttime = registranttime;
    }

    @Override
    public String toString() {
        return "ActualproDTO{" +
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
                ", registranttime='" + registranttime + '\'' +
                '}';
    }

    /**
     * 转换成DTO
     * @param actualpro
     * @return
     */
    public ActualproDTO transfer(Actualpro actualpro){
        try {
            Long time = actualpro.getRegistranttime();
            BeanUtils.copyProperties(actualpro, this , "registranttime");
            //签订时间 登记时间设置
            String timeToString = DateUtil.convertTimeToString(time);
            timeToString = DateUtil.cutBackZero(timeToString);
            this.setRegistranttime(timeToString);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return this;
    }
}
