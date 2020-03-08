package cn.edu.nyist.model;

/**
 * @ClassName TransportationDTO
 * @Description 运输车辆费用
 * @Date 2020/3/8 15:16
 * @Created by typ
 */
public class TransportationBackList {

    private String date;
    private String price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TransportationDTO{" +
                "date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
