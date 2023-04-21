package com.xzzzf.基础进阶.实用小算法;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<Province> provinces = new ArrayList<>();
        ArrayList<City> cities = new ArrayList<>();
        Demo1.init(provinces, cities);


        long startTime1 = System.currentTimeMillis();
        Map<Long, Province> longProvinceMap = ListConvertMap.listToMap(provinces, Province::getId);
        long endTime1 = System.currentTimeMillis();
        System.out.println("listToMap: " + (endTime1 - startTime1) + "ms");


        long startTime2 = System.currentTimeMillis();
        Map<Long, Province> longProvinceMap1 = provinces.stream().collect(Collectors.toMap(Province::getId, province -> province));
        long endTime2 = System.currentTimeMillis();
        System.out.println("streamMethod: " + (endTime2 - startTime2) + "ms");

        long startTime3 = System.currentTimeMillis();
        Map<Long, Province> longProvinceMap2 = ListConvertMap.listToMap2(provinces, Province::getId);
        long endTime3 = System.currentTimeMillis();
        System.out.println("listToMap: " + (endTime3 - startTime3) + "ms");



    }
}
