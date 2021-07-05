package com.lefeng.TypeReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guff
 * @since 2019-06-12:55 AM
 */
public class FieldGenericKest {

    public Map<String,Integer> map = new HashMap<>();
    public List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        FieldGenericKest kest = new FieldGenericKest();

        Field map = kest.getClass().getField("map");
        Field list = kest.getClass().getField("list");

        System.out.println("=====map=====");
        System.out.println("map.getType=" + map.getType());
        System.out.println("map.getGenericType=" + map.getGenericType());

        System.out.println("=====list=====");
        System.out.println("list.getType=" + list.getType());
        System.out.println("list.getGenericType=" + list.getGenericType());

        Object mapVal = map.get(kest);
        if(mapVal != null){
            Class<?> clz = mapVal.getClass();
            System.out.println(clz.getCanonicalName());
            System.out.println(mapVal.getClass().getName());
        }
    }
}
