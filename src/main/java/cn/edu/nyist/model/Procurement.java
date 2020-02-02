package cn.edu.nyist.model;

public class Procurement {
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
    private Long time;

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
     * 采购人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return name 采购人
     */
    public String getName() {
        return name;
    }

    /**
     * 采购人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param name 采购人
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 采购时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return time 采购时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 采购时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param time 采购时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 采购类型
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return type 采购类型
     */
    public String getType() {
        return type;
    }

    /**
     * 采购类型
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param type 采购类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 采购数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return amount 采购数量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 采购数量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param amount 采购数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 采购单价
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return price 采购单价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 采购单价
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param price 采购单价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 采购地点
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return address 采购地点
     */
    public String getAddress() {
        return address;
    }

    /**
     * 采购地点
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param address 采购地点
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 采购总价
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return priceamount 采购总价
     */
    public Integer getPriceamount() {
        return priceamount;
    }

    /**
     * 采购总价
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param priceamount 采购总价
     */
    public void setPriceamount(Integer priceamount) {
        this.priceamount = priceamount;
    }

    @Override
    public String toString() {
        return "Procurement{" +
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
}