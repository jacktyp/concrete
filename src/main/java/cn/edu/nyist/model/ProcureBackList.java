package cn.edu.nyist.model;

/**
 * @ClassName ProcureBackList
 * @Description 原材料返回
 * @Date 2020/3/8 13:49
 * @Created by typ
 */
public class ProcureBackList {
    private String date;
    private String state;
    private Double price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProcureBackList{" +
                "date='" + date + '\'' +
                ", state='" + state + '\'' +
                ", price=" + price +
                '}';
    }
}
