package com.xzzzf.基础进阶.实用小算法;

import java.util.*;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {

        ArrayList<Province> provinces = new ArrayList<>();
        ArrayList<City> cities = new ArrayList<>();

        // 初始化数据
        init(provinces, cities);


        long startTime1 = System.currentTimeMillis();
        forMethod(provinces, cities);
        long endTime1 = System.currentTimeMillis();
        System.out.println("forMethod: " + (endTime1 - startTime1) + "ms");

        System.out.println("=====================================");

        long startTime2 = System.currentTimeMillis();
        streamMethod(provinces, cities);
        long endTime2 = System.currentTimeMillis();
        System.out.println("streamMethod: " + (endTime2 - startTime2) + "ms");

    }

    public static void init(List<Province> provinces, List<City> cities) {
        provinces.add(new Province(1L, "江苏省"));
        provinces.add(new Province(2L, "上海市"));
        provinces.add(new Province(3L, "浙江省"));

        for (Long i = 4L; i <= 1000000; i++) {
            provinces.add(new Province(i, "default省"));
        }

        cities.add(new City(1L, "南京市", 1L));
        cities.add(new City(2L, "苏州市", 1L));
        cities.add(new City(3L, "南通市", 1L));
        cities.add(new City(4L, "徐州市", 1L));
        cities.add(new City(5L, "常州市", 1L));
        cities.add(new City(6L, "静安区", 2L));
        cities.add(new City(7L, "黄浦区", 2L));
        cities.add(new City(8L, "杭州市", 3L));
        cities.add(new City(9L, "宁波市", 3L));
        cities.add(new City(10L, "温州市", 3L));
        cities.add(new City(11L, "嘉兴市", 3L));
        cities.add(new City(12L, "湖州市", 3L));
        cities.add(new City(13L, "绍兴市", 3L));
        cities.add(new City(14L, "金华市", 3L));
        cities.add(new City(15L, "衢州市", 3L));
        cities.add(new City(16L, "舟山市", 3L));
        cities.add(new City(17L, "台州市", 3L));
        cities.add(new City(18L, "丽水市", 3L));
        cities.add(new City(19L, "临安市", 3L));
        cities.add(new City(20L, "余姚市", 3L));
        cities.add(new City(21L, "慈溪市", 3L));

        for (Long i = 22L; i < 1000000; i++) {
            cities.add(new City(i, "defaults市", new Random().nextLong(997) + 4L));
        }



    }

    public static void forMethod(List<Province> provinces, List<City> cities) {
        for (Province province : provinces) {
            for (City city : cities) {
                if (province.getId().equals(city.getParentId())) {
                    // System.out.println(province.getName() + " " + city.getName());
                }
            }
        }
    }

    public static void streamMethod(List<Province> provinces, List<City> cities) {
        Map<Long, Province> provinceMap = provinces.stream().collect(Collectors.toMap(Province::getId, value -> value, (key1, key2) -> key1));
        for (City city : cities) {
            // System.out.println(provinceMap.get(city.getParentId()).getName() + " " + city.getName());
        }
    }

}
