package cn.edu.nyist.util;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author: taoyunpeng
 * @Date: 2020/1/17 0017 14:03
 * Description:  通用返回
 */
public class Result<T> implements Serializable {
    public static final int SUCCESS = 0;
    public static final int FAILD = 1;
    private int rc;
    private T ret;
    private String err;

    public static boolean isSuccess(Result result) {
        return result.getRc() == 0;
    }

    public static <T> Result<T> newFaild() {
        return newResult(1, (T) null, (String)null);
    }

    public static <T> Result<T> newFaild(String err) {
        return newResult(1, (T) null, err);
    }

    public static <T> Result<T> newFaild(int rc, String err) {
        return newResult(rc, (T) null, err);
    }

    public static <T> Result<T> newSuccess() {
        return newResult(0, (T) null, (String)null);
    }

    public static <T> Result<T> newSuccess(T t) {
        return newResult(0, t, (String)null);
    }

    private static <T> Result<T> newResult(int rc, T t, String err) {
        return new Result(rc, t, err);
    }

    private Result() {
    }

    private Result(int rc, String err) {
        this(rc, (T) null, err);
    }

    private Result(int rc, T ret) {
        this(rc, ret, (String)null);
    }

    private Result(int rc, T ret, String err) {
        this.setRc(rc);
        this.setRet(ret);
        this.setErr(err);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getRc() {
        return this.rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public String getErr() {
        return this.err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public T getRet() {
        return this.ret;
    }

    public void setRet(T ret) {
        this.ret = ret;
    }
}
