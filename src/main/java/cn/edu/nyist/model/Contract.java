package cn.edu.nyist.model;

public class Contract {
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
    private Long time;

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
     * 客户名称
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return name 客户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 客户名称
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param name 客户名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 送货地址
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return address 送货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 送货地址
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param address 送货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 混凝土需求量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return amount 混凝土需求量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 混凝土需求量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param amount 混凝土需求量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 混凝土单价
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return price 混凝土单价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 混凝土单价
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param price 混凝土单价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 混凝土强度
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return concretegrade 混凝土强度
     */
    public String getConcretegrade() {
        return concretegrade;
    }

    /**
     * 混凝土强度
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param concretegrade 混凝土强度
     */
    public void setConcretegrade(String concretegrade) {
        this.concretegrade = concretegrade == null ? null : concretegrade.trim();
    }

    /**
     * 签订时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return time 签订时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 签订时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param time 签订时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 联系人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return contact 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 联系人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param contact 联系人
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 联系电话
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return telephone 联系电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 联系电话
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param telephone 联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 备注
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 合同登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registrant 合同登记人
     */
    public String getRegistrant() {
        return registrant;
    }

    /**
     * 合同登记人
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registrant 合同登记人
     */
    public void setRegistrant(String registrant) {
        this.registrant = registrant == null ? null : registrant.trim();
    }

    /**
     * 合同登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return registranttime 合同登记时间
     */
    public Long getRegistranttime() {
        return registranttime;
    }

    /**
     * 合同登记时间
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param registranttime 合同登记时间
     */
    public void setRegistranttime(Long registranttime) {
        this.registranttime = registranttime;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", concretegrade='" + concretegrade + '\'' +
                ", time=" + time +
                ", contact='" + contact + '\'' +
                ", telephone='" + telephone + '\'' +
                ", remark='" + remark + '\'' +
                ", registrant='" + registrant + '\'' +
                ", registranttime=" + registranttime +
                '}';
    }
}