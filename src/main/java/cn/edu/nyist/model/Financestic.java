package cn.edu.nyist.model;

public class Financestic {
    /**
     *  id
     */
    private Integer id;

    /**
     * 时间 time
     */
    private Long time;

    /**
     * 利润 profit
     */
    private Double profit;

    /**
     * 收入 income
     */
    private Double income;

    /**
     * 支出 expenditure
     */
    private Double expenditure;

    /**
     * 
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 时间
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return time 时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 时间
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param time 时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 利润
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return profit 利润
     */
    public Double getProfit() {
        return profit;
    }

    /**
     * 利润
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param profit 利润
     */
    public void setProfit(Double profit) {
        this.profit = profit;
    }

    /**
     * 收入
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return income 收入
     */
    public Double getIncome() {
        return income;
    }

    /**
     * 收入
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param income 收入
     */
    public void setIncome(Double income) {
        this.income = income;
    }

    /**
     * 支出
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return expenditure 支出
     */
    public Double getExpenditure() {
        return expenditure;
    }

    /**
     * 支出
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param expenditure 支出
     */
    public void setExpenditure(Double expenditure) {
        this.expenditure = expenditure;
    }

    @Override
    public String toString() {
        return "Financestic{" +
                "id=" + id +
                ", time=" + time +
                ", profit=" + profit +
                ", income=" + income +
                ", expenditure=" + expenditure +
                '}';
    }
}