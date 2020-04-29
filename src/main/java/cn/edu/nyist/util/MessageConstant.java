package cn.edu.nyist.util;

import java.text.MessageFormat;

/**
 * @Author: taoyunpeng
 * @Date: 2020/1/17 0017 13:58
 * Description:  通用返回信息
 */
public class MessageConstant {
    public static final String SAVEFAILED="保存失败!";
    public static final String SAVESUCCESS="保存成功!";
    public static final String UPDATEFAILED="更新失败!";
    public static final String UPDATESUCCESS="更新成功!";
    public static final String DELETEFAILED="删除失败!";
    public static final String DELETESUCCESS="删除成功!";
    public static final String QUERYFAILED="查询失败!";
    public static final String PARAMSMISS="参数缺失!";
    public static final String PARAMSMISS1="参数{0}缺失!";
    public static final String PARAMERROR = "参数错误！";
    public static final String NOPOWER = "该用户无权限！";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";

    public static String getMessage(String partten,Object... params){
        return MessageFormat.format(partten, params);
    }

}
