package com.example.demo.cache;

import javax.validation.constraints.NotNull;

public class BasicCacheKey {
    /**
     * 过期时间，0为永久，单位：秒
     */
    @NotNull
    private Integer expire;
    /**
     * 返回值
     */
    @NotNull
    private Class<?> returnClazz;

    /**
     * 环境，日常=DAILY，预发=PRE，线上为空
     */
    private String environment;

    private String cacheKey;

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public Class<?> getReturnClazz() {
        return returnClazz;
    }

    public void setReturnClazz(Class<?> returnClazz) {
        this.returnClazz = returnClazz;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }
}
