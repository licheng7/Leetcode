package org.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/5/20
 * Time:上午11:51
 **/
public class StreamTest {

    public static void main(String[] args) {

        String[] array = {"1", "2", "3"};

        List<String> newArray = Arrays.stream(array).map(a -> a+"-").collect(Collectors.toList());

        System.out.println(newArray.toString());
    }
}
