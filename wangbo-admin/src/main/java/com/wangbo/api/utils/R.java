package com.wangbo.api.utils;

import java.util.HashMap;

/**
 * 返回数据
 *
 * @author : xingyu4j
 * @version : 1.0.0
 * @Date : 2019/1/11 13:45
 */
public class R  extends HashMap<String, Object> {
    /**
     * code
     * 200成功
     * 400失败
     *
     * 500系统内部错误
     *
     */
    public R() {
        put("code", "200");
        put("msg", "success");
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(String code,   String msg) {
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static R ok(String code,  String msg ,Object object){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        r.put("data",object);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R error(String msg) {
        R r = new R();
        r.put("code","400");
        r.put("msg", msg);
        return r;
    }
    public static R error(String code,String msg) {
        R r = new R();
        r.put("code",code);
        r.put("msg", msg);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
