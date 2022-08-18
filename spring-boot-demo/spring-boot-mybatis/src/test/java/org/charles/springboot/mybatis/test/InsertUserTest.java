package org.charles.springboot.mybatis.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.LongStream;


public class InsertUserTest {
    @Test
    public void InsertUserList() {

        Random random = new Random();
        LongStream longs = random.longs(10000000, 80000000).limit(100);
        long[] array = longs.toArray();
//        long l =array[0];
//        System.out.println(l);
        Arrays.stream(array).limit(100).forEach(s -> System.out.println(s));


    }

}
