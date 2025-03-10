package com.jedistest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedis = JedisConnectionFactory.getJedisPool();
    }

    @Test
    void test() {
        jedis.set("test-string", "zhangsan");
        jedis.hset("test-hash", "name", "zhangsan");
        jedis.hset("test-hash", "age", "18");
        jedis.lpush("test-list", "zhangsan", "lisi", "wangwu");
        jedis.sadd("test-set", "zhangsan", "lisi", "wangwu");
        jedis.zadd("test-zset", 1, "zhangsan");

        System.out.println(jedis.get("test-string"));
        System.out.println(jedis.hget("test-hash", "name"));
        System.out.println(jedis.hgetAll("test-hash"));
        System.out.println(jedis.lrange("test-list", 0, -1));
        System.out.println(jedis.smembers("test-set"));
        System.out.println(jedis.zrange("test-zset", 0, -1));
    }

    @AfterEach
    void close() {
        jedis.close();
    }
}
