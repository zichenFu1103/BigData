package com.zichen.homework2;

public class LargestCommonString {

    public static void main(String[] args){
        String largestCommonString = largestCommonString("asdafghjka","aaasdfg");
        System.out.println(largestCommonString);
    }

    public static String largestCommonString(String str1, String str2){
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        if(str1.equals("")  || str2.equals("")){
            return "";
        }
        if(str1.length() - str2.length() >= 0){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        for(int i = 0; i < str1.length() - 1; i++){
            for(int j = i+1; j < str1.length(); j++){
                if(str2.contains(str1.substring(i,j))){
                    if(j - i >= max){
                        max = j - i;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return str1.substring(left, right);
    }
}


