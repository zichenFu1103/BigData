package com.zichen.homework1;

public class CountCharacters {

    public static void main(String[] args){

        String str = "ABCD1234!@#$%ab";
        int lowerCaseCounter = 0;
        int upperCaseCounter= 0;
        int specialCharacterCounter = 0;
        int numberCounter = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                upperCaseCounter++;
            }else if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
                lowerCaseCounter++;
            }else if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                numberCounter++;
            }else{
                specialCharacterCounter++;
            }
        }

        System.out.println("大写字母的个数是" + upperCaseCounter);
        System.out.println("小写字母的个数是" + lowerCaseCounter);
        System.out.println("数字的个数是" + numberCounter);
        System.out.println("其他字符的个数是" + specialCharacterCounter);
    }
}
