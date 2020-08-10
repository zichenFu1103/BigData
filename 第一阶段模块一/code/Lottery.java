/*
    实现双色球抽奖游戏
    中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
    其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
    其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
 */

import java.util.Arrays;

public class Lottery {
    public static void main(String[] args){
        int[] arr = new int[7];
        arr[0] = (int)(Math.random()*33)+1;
        for(int i = 1; i < arr.length; i++){
            if(i != 6){
                int red = (int)(Math.random()*33)+1;
                while(checkRepeat(arr, red)){
                    red = (int)(Math.random()*33)+1;
                }
                arr[i] = red;
            }else{
                arr[i] = (int)(Math.random()*16)+1;
            }
        }
        System.out.println("双色球号码是："+Arrays.toString(arr));
    }

    //检查是否有重复
    public static boolean checkRepeat(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
}
