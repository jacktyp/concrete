package cn.edu.nyist.model;

import cn.edu.nyist.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @Classname ContractDTO
 * @Description 合同工返回DTO
 * @Date 2020/2/10 9:28
 * @Created by typ
 */
public class ContractDTO {
    private final static Logger logger = LoggerFactory.getLogger(ContractDTO.class);

    /**
     *  id
     */
    private Integer id;

    /**
     * 客户名称 name
     */
    private String name;

    /**
     * 送货地址 address
     */
    private String address;

    /**
     * 混凝土需求量 amount
     */
    private Integer amount;

    /**
     * 混凝土单价 price
     */
    private Double price;

    /**
     * 混凝土强度 concretegrade
     */
    private String concretegrade;

    /**
     * 签订时间 time
     */
    private String time;

    /**
     * 联系人 contact
     */
    private String contact;

    /**
     * 联系电话 telephone
     */
    private String telephone;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 合同登记人 registrant
     */
    private String registrant;

    /**
     * 合同登记时间 registranttime
     */
    private String registranttime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getConcretegrade() {
        return concretegrade;
    }

    public void setConcretegrade(String concretegrade) {
        this.concretegrade = concretegrade;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "ContractDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", concretegrade='" + concretegrade + '\'' +
                ", time='" + time + '\'' +
                ", contact='" + contact + '\'' +
                ", telephone='" + telephone + '\'' +
                ", remark='" + remark + '\'' +
                ", registrant='" + registrant + '\'' +
                ", registranttime='" + registranttime + '\'' +
                '}';
    }

    /**
     * 转换成DTO
     * @param contract
     * @return
     */
    public ContractDTO transfer(Contract contract){
        try {
            Long time = contract.getTime();
            Long registranttime = contract.getRegistranttime();
            BeanUtils.copyProperties(contract, this , "time" , "registranttime");
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
     * @param contractDTO
     * @return
     */
    public Contract transferBack(ContractDTO contractDTO){
        Contract contract = new Contract();
        try {
            String time = contractDTO.getTime();
            String registranttime = contractDTO.getRegistranttime();
            BeanUtils.copyProperties(contractDTO, contract , "time" , "registranttime");
            //签订时间 登记时间设置
            time = DateUtil.addBackZero(time);
            registranttime = DateUtil.addBackZero(registranttime);
            Long timeToLong = DateUtil.convertTimeToLong(time);
            Long registranttimeToLong = DateUtil.convertTimeToLong(registranttime);
            contract.setTime(timeToLong);
            contract.setRegistranttime(registranttimeToLong);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return contract;
    }
}
