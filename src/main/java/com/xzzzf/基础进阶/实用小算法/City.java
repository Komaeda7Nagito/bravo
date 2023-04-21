package com.xzzzf.基础进阶.实用小算法;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {

    private Long id;

    private String name;

    private Long parentId;
}
