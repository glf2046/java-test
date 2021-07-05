package com.lefeng.lamda;

import java.util.HashMap;
import java.util.function.Supplier;

public class Lamda3 {
    public static void main(String[] args) {
        Supplier<HashMap<String, String>> supplier = HashMap::new;
        HashMap<String, String> hashMap = supplier.get();
        hashMap.put("1", "1");
        System.out.println(hashMap.entrySet());
    }
}
