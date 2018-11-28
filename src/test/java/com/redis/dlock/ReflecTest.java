package com.redis.dlock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReflecTest {
    @Test
    public void testReflect() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list,"String");
        System.out.println(list.get(0));

    }
}
