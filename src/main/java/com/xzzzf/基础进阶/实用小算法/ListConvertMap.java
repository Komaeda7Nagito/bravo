package com.xzzzf.基础进阶.实用小算法;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListConvertMap {

    public static <K,V> Map<K,V> listToMap(List<V> list, Function<? super V, ? extends K> keyMapper) {
        return list.stream().collect(Collectors.toMap(keyMapper, Function.identity()));
    }

    public static <K,V> Map<K,V> listToMap2(List<V> list, Function<? super V, ? extends K> keyMapper) {
        if (list == null || list.isEmpty()) {
            return new HashMap<>();
        }
        Map<K, V> map = new HashMap<>(list.size());
        for (V element : list) {
            K key = keyMapper.apply(element);
            if (key == null) {
                continue;
            }
            map.put(key, element);
        }
        return map;
    }
}
