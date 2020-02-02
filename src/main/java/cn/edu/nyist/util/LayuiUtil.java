package cn.edu.nyist.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname LayuiUtil
 * @Description TODO
 * @Date 2020/2/2 20:21
 * @Created by typ
 */
public class LayuiUtil extends HashMap<String,Object>{

    /**
     * Layui返回数据格式
     * @return
     */
    public static LayuiUtil backLayuiData(List<?> dataList,Long totals){
        LayuiUtil LayuiDataBack = new LayuiUtil();
        LayuiDataBack.put("code",0);
        LayuiDataBack.put("msg","成功");
        LayuiDataBack.put("count",totals);
        LayuiDataBack.put("data",dataList);
        return LayuiDataBack;
    }

    /**
     * Layui返回数据格式 失败
     * @return
     */
    public static LayuiUtil newFaild(String msg){
        LayuiUtil LayuiDataBack = new LayuiUtil();
        LayuiDataBack.put("code",1);
        LayuiDataBack.put("msg",msg);
        return LayuiDataBack;
    }

    /**
     * Layui 成功返回
     * @param msg
     * @return
     */
    public static LayuiUtil newSuccess(String msg) {
        LayuiUtil LayuiDataBack = new LayuiUtil();
        LayuiDataBack.put("code",0);
        LayuiDataBack.put("msg",msg);
        return LayuiDataBack;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
