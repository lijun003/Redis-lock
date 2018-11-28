package com.redis.dlock;

import org.junit.Assert;
import org.junit.Test;

public class RedisToolTest {
    @Test
    public void testJedis() {
        boolean lock = RedisLock.getLock("key1", "123", 3000);
        Assert.assertTrue(lock);
        boolean key1 = RedisLock.getLock("key1", "123", 3000);
        Assert.assertEquals(false, key1);
        boolean released = RedisLock.releaseLock("key1", "123");
        Assert.assertTrue(released);
        Assert.assertEquals(true, RedisLock.getLock("key1", "123", 3000));
    }
}