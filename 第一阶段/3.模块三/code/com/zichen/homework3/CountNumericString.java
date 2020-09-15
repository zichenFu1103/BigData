package com.zichen.homework3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountNumericString {

    public static void main(String[] mains) {
        Map<String, Integer> stringCounter = new HashMap<>();
        String string = "123,456,789,123,456";
        String[] arr = string.split(",");

        for (String s : arr) {
            if (stringCounter.containsKey(s)) {
                stringCounter.put(s, stringCounter.get(s) + 1);
            } else {
                stringCounter.put(s, 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = stringCounter.entrySet();
        for(Map.Entry<String, Integer> entry: entries){
            System.out.println(entry.getKey()+"出现了"+entry.getValue()+"次");
        }
    }
}
