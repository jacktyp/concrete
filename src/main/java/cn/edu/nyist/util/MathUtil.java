package cn.edu.nyist.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @ClassName MathUtil
 * @Description TODO
 * @Date 2020/2/29 11:52
 * @Created by typ
 */
public class MathUtil {

    /**
     * 计算百分比
     * @param a
     * @param b
     * @return
     */
    public static String backPercent(Integer a,Integer b){
        BigDecimal numSize = new BigDecimal(a);
        BigDecimal allSize = new BigDecimal(b);
        BigDecimal divide = numSize.divide(allSize, 4, BigDecimal.ROUND_HALF_UP);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        // 33% 百分比
        return numberFormat.format(divide.doubleValue());
    }
}
