package cn.edu.nyist.model;

import cn.edu.nyist.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName TransportationDTO
 * @Description TODO
 * @Date 2020/3/8 15:22
 * @Created by typ
 */
public class TransportationDTO {

    private static final Logger logger = LoggerFactory.getLogger(TransportationDTO.class);
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
    private String time;

    /**
     * 运输表登记人 registrant
     */
    private String registrant;

    /**
     * 运输表登记时间 registranttime
     */
    private String registranttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        return "TransportationDTO{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", contractId=" + contractId +
                ", time=" + time +
                ", registrant='" + registrant + '\'' +
                ", registranttime='" + registranttime + '\'' +
                '}';
    }

    /**
     * 转换成DTO
     * @param transportation
     * @return
     */
    public TransportationDTO transfer(Transportation transportation){
        try {
            Long time = transportation.getTime();
            Long registranttime = transportation.getRegistranttime();
            BeanUtils.copyProperties(transportation, this , "time" , "registranttime");
            //签订时间 登记时间设置
            String timeToString = DateUtil.convertTimeToString(time);
            String registranttimeToString = DateUtil.convertTimeToString(registranttime);
            timeToString = DateUtil.cutBackZero(timeToString);
            registranttimeToString = DateUtil.cutBackZero(registranttimeToString);
            this.setTime(timeToString);
            this.setRegistranttime(registranttimeToString);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return this;
    }

    /**
     * 转换返回
     * @param transportationDTO
     * @return
     */
    public Transportation transferBack(TransportationDTO transportationDTO){
        Transportation transportation = new Transportation();
        try {
            String time = transportationDTO.getTime();
            String registranttime = transportationDTO.getRegistranttime();
            BeanUtils.copyProperties(transportationDTO, transportation , "time" , "registranttime");
            //签订时间 登记时间设置
            time = DateUtil.addBackZero(time);
            registranttime = DateUtil.addBackZero(registranttime);
            Long timeToLong = DateUtil.convertTimeToLong(time);
            Long registranttimeToLong = DateUtil.convertTimeToLong(registranttime);
            transportation.setTime(timeToLong);
            transportation.setRegistranttime(registranttimeToLong);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return transportation;
    }
}
