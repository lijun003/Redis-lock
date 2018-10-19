package com.redis.dlock;

import org.junit.Assert;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisToolTest {
    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("localhost", 6379);
        boolean lock = RedisLock.getLock(jedis, "key1", "123", 3000);
        Assert.assertTrue(lock);
        boolean released = RedisLock.releaseLock(jedis, "key1", "123");
        Assert.assertTrue(released);
    }
}