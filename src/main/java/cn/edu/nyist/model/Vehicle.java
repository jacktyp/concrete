package cn.edu.nyist.model;

public class Vehicle {
    /**
     *  id
     */
    private Integer id;

    /**
     * 车牌号 vehiclenumber
     */
    private Integer vehiclenumber;

    /**
     * 驾驶员 name
     */
    private String name;

    /**
     * 车的最大载量 maximumload
     */
    private Integer maximumload;

    /**
     * 运输价格 price
     */
    private Double price;

    /**
     * 车的状态 state
     */
    private String state;

    /**
     * 车辆类型 type
     */
    private String type;

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
     * 车牌号
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return vehiclenumber 车牌号
     */
    public Integer getVehiclenumber() {
        return vehiclenumber;
    }

    /**
     * 车牌号
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param vehiclenumber 车牌号
     */
    public void setVehiclenumber(Integer vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

    /**
     * 驾驶员
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return name 驾驶员
     */
    public String getName() {
        return name;
    }

    /**
     * 驾驶员
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param name 驾驶员
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 车的最大载量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return maximumload 车的最大载量
     */
    public Integer getMaximumload() {
        return maximumload;
    }

    /**
     * 车的最大载量
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param maximumload 车的最大载量
     */
    public void setMaximumload(Integer maximumload) {
        this.maximumload = maximumload;
    }

    /**
     * 运输价格
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return price 运输价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 运输价格
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param price 运输价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 车的状态
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return state 车的状态
     */
    public String getState() {
        return state;
    }

    /**
     * 车的状态
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param state 车的状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 车辆类型
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return type 车辆类型
     */
    public String getType() {
        return type;
    }

    /**
     * 车辆类型
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param type 车辆类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehiclenumber=" + vehiclenumber +
                ", name='" + name + '\'' +
                ", maximumload=" + maximumload +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}