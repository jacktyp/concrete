package cn.edu.nyist.model;

/**
 * @ClassName ConcreteBackList
 * @Description TODO
 * @Date 2020/3/8 16:26
 * @Created by typ
 */
public class ConcreteBackList {

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
        return "ConcreteBackList{" +
                "date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
