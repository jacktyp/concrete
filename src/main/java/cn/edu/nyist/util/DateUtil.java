package cn.edu.nyist.util;


import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @Classname DateUtil
 * @Description 时间工具类
 * @Date 2020/2/10 9:40
 * @Created by typ
 */
public class DateUtil {

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time){
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
    }

    /**
     * 时间后缀
     * @param time
     * @return
     */
    public static String addBackZero(String time){
        Assert.notNull(time, "time is null");
        time = time + " 00:00:00";
        return time;
    }
}
