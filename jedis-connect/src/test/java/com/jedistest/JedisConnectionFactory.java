package com.jedistest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

// jedis是线程不安全的，因此需要使用连接池
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(10);
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(10);
        // 最小空闲数
        jedisPoolConfig.setMinIdle(0);
        // 最大等待时间
        // jedisPoolConfig.setMaxWaitMillis(3000);
        // 选择库
        // 设置ip 端口
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
    }

    public static Jedis getJedisPool() {
        return jedisPool.getResource();
    }
}
