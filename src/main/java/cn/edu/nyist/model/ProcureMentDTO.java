package cn.edu.nyist.model;

import cn.edu.nyist.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName ProcureMentDTO
 * @Description TODO
 * @Date 2020/3/8 13:13
 * @Created by typ
 */
public class ProcureMentDTO {
    private static final Logger logger = LoggerFactory.getLogger(ProcureMentDTO.class);

    /**
     *  id
     */
    private Integer id;

    /**
     * 采购人 name
     */
    private String name;

    /**
     * 采购时间 time
     */
    private String time;

    /**
     * 采购类型 type
     */
    private String type;

    /**
     * 采购数量 amount
     */
    private Integer amount;

    /**
     * 采购单价 price
     */
    private Double price;

    /**
     * 采购地点 address
     */
    private String address;

    /**
     * 采购总价 priceamount
     */
    private Integer priceamount;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPriceamount() {
        return priceamount;
    }

    public void setPriceamount(Integer priceamount) {
        this.priceamount = priceamount;
    }

    @Override
    public String toString() {
        return "ProcureMentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", priceamount=" + priceamount +
                '}';
    }
    /**
     * 转换成DTO
     * @param procureMent
     * @return
     */
    public ProcureMentDTO transfer(Procurement procureMent){
        try {
            Long time = procureMent.getTime();
            BeanUtils.copyProperties(procureMent, this , "time");
            //签订时间 登记时间设置
            String timeToString = DateUtil.convertTimeToString(time);
            timeToString = DateUtil.cutBackZero(timeToString);
            this.setTime(timeToString);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return this;
    }

    /**
     * 转换返回
     * @param procureMentDTO
     * @return
     */
    public Procurement transferBack(ProcureMentDTO procureMentDTO){
        Procurement procurement = new Procurement();
        try {
            String time = procureMentDTO.getTime();
            BeanUtils.copyProperties(procureMentDTO, procurement , "time" );
            //签订时间 登记时间设置
            time = DateUtil.addBackZero(time);
            Long timeToLong = DateUtil.convertTimeToLong(time);
            procurement.setTime(timeToLong);
        } catch (Exception e) {
            logger.error("转换错误", e);
        }
        return procurement;
    }

}
