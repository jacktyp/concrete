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
    private String time;

    /**
     * 实际生产开始时间 productiontime
     */
    private String productiontime;

    /**
     * 实际生产结束时间 endtiime
     */
    private String endtiime;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProductiontime() {
        return productiontime;
    }

    public void setProductiontime(String productiontime) {
        this.productiontime = productiontime;
    }

    public String getEndtiime() {
        return endtiime;
    }

    public void setEndtiime(String endtiime) {
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
            Long productiontime = actualpro.getProductiontime();
            Long endtiime = actualpro.getEndtiime();
            Long registranttime = actualpro.getRegistranttime();
            BeanUtils.copyProperties(actualpro, this ,  "productiontime","endtiime","registranttime");


            String timeToString1 = DateUtil.convertTimeToString(productiontime);
            timeToString1 = DateUtil.cutBackZero(timeToString1);
            this.setProductiontime(timeToString1);

            String timeToString2 = DateUtil.convertTimeToString(endtiime);
            timeToString2 = DateUtil.cutBackZero(timeToString2);
            this.setEndtiime(timeToString2);

            String timeToString3 = DateUtil.convertTimeToString(registranttime);
            timeToString3 = DateUtil.cutBackZero(timeToString3);
            this.setRegistranttime(timeToString3);

            this.setTime(String.valueOf(time));
        } catch (Exception e) {
            //logger.error("转换错误", e);
        }
        return this;
    }

    /**
     * 转换返回
     * @param actualproDTO
     * @return
     */
    public Actualpro transferBack(ActualproDTO actualproDTO){
        Actualpro actualpro = new Actualpro();
        try {
            String time = actualproDTO.getTime();
            String productiontime = actualproDTO.getProductiontime();
            String endtiime = actualproDTO.getEndtiime();
            String registranttime = actualproDTO.getRegistranttime();
            BeanUtils.copyProperties(actualproDTO, actualpro ,  "productiontime","endtiime","registranttime");


            productiontime = DateUtil.addBackZero(productiontime);
            Long productTime = DateUtil.convertTimeToLong(productiontime);
            actualpro.setProductiontime(productTime);

            endtiime = DateUtil.addBackZero(endtiime);
            Long endtiimeToLong = DateUtil.convertTimeToLong(endtiime);
            actualpro.setEndtiime(endtiimeToLong);

            registranttime = DateUtil.addBackZero(registranttime);
            Long registranttimeToLong = DateUtil.convertTimeToLong(registranttime);
            actualpro.setRegistranttime(registranttimeToLong);
            actualpro.setTime(Long.parseLong(time));
        } catch (Exception e) {
            //logger.error("转换错误", e);
        }
        return actualpro;
    }
}
