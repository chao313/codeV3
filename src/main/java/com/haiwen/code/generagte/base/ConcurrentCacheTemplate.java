package com.haiwen.code.generagte.base;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dumo
 * @version 1.0
 * @description: 专门存放并发缓存的
 * @date 2021/6/14 9:17 下午
 */
public abstract class ConcurrentCacheTemplate<P, R> {

    //缓存数据源
    private ConcurrentHashMap<String, R> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     * 获取缓存中的数据源信息(key就连接信息)
     * 1.存在就返回
     * 2.不存在就新建,放入缓存
     * 设计模式:单例模式,双重校验锁
     */
    public R getFromCache(P p) throws Exception {
        String key = this.getKey(p);
        if (null != concurrentHashMap.get(key)) {
            return concurrentHashMap.get(key);
        } else {
            synchronized (ConcurrentCacheTemplate.class) {
                /**
                 * 这里需要再判断一次，因为上一个线程执行完成后，就可能有值了
                 */
                if (null != concurrentHashMap.get(key)) {
                    return concurrentHashMap.get(key);
                }
                R r = this.getInstance(p);
                concurrentHashMap.put(key, r);
            }
        }
        return concurrentHashMap.get(key);
    }

    /**
     * 释放
     */
    public void release(P p) throws Exception {
        String key = this.getKey(p);
        R r = concurrentHashMap.get(key);
        this.close(r);
        concurrentHashMap.remove(key);
    }

    /**
     * 获取实例
     */
    protected abstract R getInstance(P p) throws Exception;

    /**
     * 获取key
     */
    protected abstract String getKey(P p);

    /**
     * 关闭资源
     *
     * @param r
     * @throws Exception
     */
    protected abstract void close(R r) throws Exception;

}
